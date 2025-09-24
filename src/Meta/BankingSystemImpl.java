package Meta;

import java.util.*;
import java.util.Map.Entry;
public class BankingSystemImpl {

    private final Map<String, Account> accounts;
    private final Map<String, Payment> paymentsById;
    private final PriorityQueue<Payment> dueQ = new PriorityQueue<>(
            Comparator.<Payment>comparingLong(p -> p.executeAt)
                    .thenComparingLong(p -> p.seq)
    );

    private long nextPaymentSeq = 1;
    private long paymentCounter = 0;

    private void processDue(int timestamp){
        while(!dueQ.isEmpty()){
            Payment p = dueQ.peek();
            if(p.executeAt > timestamp)
                break;
            dueQ.poll();
            if(p.status != PStatus.PENDING)
                continue;
            Account account = accounts.get(p.accountId);
            if(account != null && account.balance >= p.amount){
                account.balance -= p.amount;
                account.totalOutgoing += p.amount;
                account.record(p.executeAt);
                p.status = PStatus.EXECUTED;
            } else {
                p.status = PStatus.SKIPPED;
            }
        }
    }

    private enum PStatus {
        PENDING, EXECUTED, CANCELED, SKIPPED
    }

    private static final class Payment {
        final String id;
        String accountId;
        final int amount, executeAt;
        final long seq;
        PStatus status = PStatus.PENDING;

        Payment(String id, String accountId, int amount, int executeAt, long seq){
            this.id = id;
            this.accountId = accountId;
            this.amount = amount;
            this.executeAt = executeAt;
            this.seq = seq;
        }
    }
    private static final class Account {
        int balance;
        long totalOutgoing;
        final TreeMap<Integer, Integer> hist = new TreeMap<>();
        void record(int t){
            hist.put(t, balance);
        }
    }


    public BankingSystemImpl() {
        // TODO: implement
        accounts = new HashMap<>();
        paymentsById  = new HashMap<>();
    }

    // TODO: implement interface methods here
   // @Override
    public boolean createAccount(int timestamp, String accountId){
        processDue(timestamp);
        if(accountId == null || accountId.isEmpty())
            return false;
        if(accounts.containsKey(accountId))
            return false;
        Account account = new Account();
        accounts.put(accountId, account);
        account.record(timestamp);
        return true;
    }

   // @Override
    public Optional<Integer> deposit(int timestamp, String accountId, int amount){
        processDue(timestamp);
        Account account = accounts.get(accountId);
        if(account == null || amount < 0)
            return Optional.empty();
        account.balance += amount;
        account.record(timestamp);
        return Optional.of(account.balance);
    }

   // @Override
    public Optional<Integer> transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount) {
        processDue(timestamp);
        Account source = accounts.get(sourceAccountId);
        Account target = accounts.get(targetAccountId);
        if(source == null || target == null)
            return Optional.empty();
        if(Objects.equals(sourceAccountId, targetAccountId))
            return Optional.empty();
        if(amount < 0 || source.balance < amount)
            return Optional.empty();
        source.balance -= amount;
        source.totalOutgoing += amount;
        target.balance += amount;
        source.record(timestamp);
        target.record(timestamp);
        return Optional.of(source.balance);
    }

    //@Override
    public List<String> topSpenders(int timestamp, int n) {
        processDue(timestamp);
        if(n <= 0 || accounts.isEmpty())
            return Collections.emptyList();
        PriorityQueue<Entry<String, Account>> heap = new PriorityQueue<>(
                (e1, e2) -> {
                    int comp = Long.compare(e1.getValue().totalOutgoing, e2.getValue().totalOutgoing);
                    if(comp != 0)
                        return comp;
                    return e2.getKey().compareTo(e1.getKey());
                }
        );
        for(Entry<String, Account> e : accounts.entrySet()){
            heap.offer(e);
            if(heap.size() > n)
                heap.poll();
        }
        List<Entry<String, Account>> chosen = new ArrayList<>(heap);
        chosen.sort((a, b) -> {
            int comp = Long.compare(b.getValue().totalOutgoing, a.getValue().totalOutgoing);
            return(comp != 0) ? comp : a.getKey().compareTo(b.getKey());
        });
        List<String> ans = new ArrayList<>(chosen.size());
        for(Entry<String, Account> e : chosen){
            ans.add(e.getKey() + "(" + e.getValue().totalOutgoing + ")");
        }
        return ans;
    }

    //@Override
    public Optional<String> schedulePayment(int timestamp, String accountId, int amount, int delay) {
        processDue(timestamp);
        Account account = accounts.get(accountId);
        if(account == null || amount < 0 || delay < 0)
            return Optional.empty();
        long seq = ++paymentCounter;
        String id = "payment" + seq;
        int execAt = timestamp + delay;
        Payment p = new Payment(id, accountId, amount, execAt, nextPaymentSeq);
        paymentsById.put(id, p);
        dueQ.offer(p);
        return Optional.of(id);
    }

    //@Override
    public boolean cancelPayment(int timestamp, String accountId, String paymentId) {
        processDue(timestamp);
        Payment p = paymentsById.get(paymentId);
        if(p == null)
            return false;
        if(!p.accountId.equals(accountId))
            return false;
        if(p.status != PStatus.PENDING)
            return false;
        p.status = PStatus.CANCELED;
        return true;
    }
    private static int balAt(TreeMap<Integer, Integer> hist, int t){
        Map.Entry<Integer, Integer> e = hist.floorEntry(t);
        return (e == null) ? 0 : e.getValue();
    }

   // @Override
    public boolean mergeAccounts(int timestamp, String accountId1, String accountId2) {
        processDue(timestamp);
        if(accountId1.equals(accountId2))
            return false;
        Account account1 = accounts.get(accountId1);
        Account account2 = accounts.get(accountId2);
        if(account1 == null || account2 == null)
            return false;
        for(Payment p : paymentsById.values()){
            if(p.status == PStatus.PENDING && p.accountId.equals(accountId2))
                p.accountId = accountId1;
        }
        //account1.balance += account2.balance;
        //account1.record(timestamp);
        account1.totalOutgoing += account2.totalOutgoing;
        TreeSet<Integer> times = new TreeSet<>();
        times.addAll(account1.hist.keySet());
        times.addAll(account2.hist.keySet());
        times.add(timestamp);
        TreeMap<Integer, Integer> merged = new TreeMap<>();
        Integer lastVal = null;
        for(int t : times){
            int v = balAt(account1.hist, t) + (balAt(account2.hist, t));
            //if(merged.isEmpty() || !merged.lastEntry().getValue().equals(v)){
            if(!Objects.equals(lastVal, v) || t == timestamp){
                merged.put(t, v);
                lastVal = v;
            }
        }
        Map.Entry<Integer, Integer> fe = merged.floorEntry(timestamp);
        int current = (fe == null) ? 0 : fe.getValue();
        account1.balance = current;
        account1.hist.clear();
        account1.hist.putAll(merged);
        // account1.record(timestamp);
        // for(Payment p : paymentsById.values()){
        //   if(p.status == PStatus.PENDING && p.accountId.equals(accountId2))
        //     p.accountId = accountId1;
        // }
        accounts.remove(accountId2);
        return true;
    }

    //@Override
    public Optional<Integer> getBalance(int timestamp, String accountId, int timeAt) {
        processDue(timestamp);
        Account account = accounts.get(accountId);
        if(account == null)
            return Optional.empty();
        Map.Entry<Integer, Integer> e = account.hist.floorEntry(timeAt);
        if(e == null)
            return Optional.empty();
        return Optional.of(e.getValue());
    }
}
