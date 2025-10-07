package Accenture;

import java.util.*;
class Chat {

    List<String> members;
    List<Integer> files;
    HashMap<Integer, String> messages;

    // Constructor
    Chat() {
        members = new ArrayList<>();
        files = new ArrayList<>();
        messages = new HashMap<>();
    }

    // ---- Overloaded add() methods ----
    void add(String[] names) {
        members.addAll(Arrays.asList(names));
    }

    void add(int[] ids) {
        for (int id : ids)
            files.add(id);
    }

    void add(int id, String newMessage) {
        messages.put(id, newMessage);
    }

    // ---- Overloaded remove() methods ----
    void remove(String[] names) {
        for (String name : names) {
            if (members.contains(name))
                members.remove(name);
            else
                System.out.println("Member with name " + name + " does not exist");
        }
    }

    void remove(int[] ids) {
        for (int id : ids) {
            if (files.contains(id))
                files.remove(Integer.valueOf(id));
            else
                System.out.println("File with id " + id + " does not exist");
        }
    }

    void remove(int id) {
        if (messages.containsKey(id))
            messages.remove(id);
        else
            System.out.println("Message with id " + id + " does not exist");
    }

    // ---- Print final chat summary ----
    void printConversation() {
        System.out.println("Total number of members in the conversation are " + members.size());
        System.out.print("The names of these members are ");
        System.out.println(String.join(" ", members));

        System.out.println("Total number of files in the conversation are " + files.size());
        System.out.print("The messages in the conversation are ");
        List<String> msgList = new ArrayList<>();
        for (String msg : messages.values()) {
            msgList.add("'" + msg + "'");
        }
        System.out.println(String.join(" ", msgList));
    }
}

// ---- Main driver class ----
public class ChatOverloading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Chat chat = new Chat();

        // Read members
        String[] members = sc.nextLine().trim().split(" ");
        chat.add(members);

        // Read files
        String[] fileTokens = sc.nextLine().trim().split(" ");
        int[] fileIds = new int[fileTokens.length];
        for (int i = 0; i < fileTokens.length; i++) {
            fileIds[i] = Integer.parseInt(fileTokens[i]);
        }
        chat.add(fileIds);

        // Number of messages
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 1; i <= n; i++) {
            String msg = sc.nextLine();
            chat.add(i, msg);
        }

        // Remove members
        String[] membersToRemove = sc.nextLine().trim().split(" ");
        chat.remove(membersToRemove);

        // Remove files
        String[] fileRemoveTokens = sc.nextLine().trim().split(" ");
        int[] fileRemoveIds = new int[fileRemoveTokens.length];
        for (int i = 0; i < fileRemoveTokens.length; i++) {
            fileRemoveIds[i] = Integer.parseInt(fileRemoveTokens[i]);
        }
        chat.remove(fileRemoveIds);

        // Remove messages
        String[] msgRemoveTokens = sc.nextLine().trim().split(" ");
        for (String token : msgRemoveTokens) {
            if (!token.isEmpty())
                chat.remove(Integer.parseInt(token));
        }

        chat.printConversation();
        sc.close();
    }
}
