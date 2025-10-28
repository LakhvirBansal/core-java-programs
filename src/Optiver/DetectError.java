package Optiver;

import java.util.*;
import java.util.regex.*;

public class DetectError {

    static class Node {
        char val;
        List<Node> kids = new ArrayList<>(2);
        Node(char v){this.val=v;}
    }

    public static void main(String[] args) throws Exception {
        String line = "(A,B) (B,C) (A,E) (B,D)";
        if (line == null || line.isEmpty()) { System.out.println("E1"); return; }
        Pattern whole = Pattern.compile("^\\([A-Z],[A-Z]\\)( \\([A-Z],[A-Z]\\))*$");
        if (!whole.matcher(line).matches()) { System.out.println("E1"); return; }
        Pattern pair = Pattern.compile("\\(([A-Z]),([A-Z])\\)");
        Matcher m = pair.matcher(line);
        Map<Character, Node> nodes = new HashMap<>();
        Map<Character, Integer> indeg = new HashMap<>();
        Set<String> seenEdges = new HashSet<>();
        while (m.find()) {
            char p = m.group(1).charAt(0);
            char c = m.group(2).charAt(0);
            String key = "" + p + "," + c;
            if (!seenEdges.add(key)) { System.out.println("E2"); return; }
            Node pn = nodes.computeIfAbsent(p, Node::new);
            Node cn = nodes.computeIfAbsent(c, Node::new);
            pn.kids.add(cn);
            if (pn.kids.size() > 2) { System.out.println("E3"); return; }
            indeg.put(c, indeg.getOrDefault(c, 0) + 1);
            indeg.putIfAbsent(p, indeg.getOrDefault(p, 0));
        }
        List<Node> roots = new ArrayList<>();
        for (Map.Entry<Character, Node> e : nodes.entrySet()) {
            int d = indeg.getOrDefault(e.getKey(), 0);
            if (d == 0) roots.add(e.getValue());
        }
        if (roots.size() > 1) { System.out.println("E4"); return; }
        if (roots.size() == 0) { System.out.println("E5"); return; }
        Node root = roots.get(0);
        Set<Character> visited = new HashSet<>();
        Set<Character> onStack = new HashSet<>();
        if (hasCycle(root, visited, onStack)) { System.out.println("E5"); return; }
        if (visited.size() != nodes.size()) {
            System.out.println("E4");
            return;
        }
        for (Node n : nodes.values())
            n.kids.sort(Comparator.comparing(a -> a.val));
        System.out.println(sExpr(root));
    }
    private static boolean hasCycle(Node cur, Set<Character> vis, Set<Character> st) {
        if (st.contains(cur.val)) return true;
        if (vis.contains(cur.val)) return false;
        st.add(cur.val);
        for (Node k : cur.kids)
            if (hasCycle(k, vis, st)) return true;
        st.remove(cur.val);
        vis.add(cur.val);
        return false;
    }
    private static String sExpr(Node n) {
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(n.val);
        if (!n.kids.isEmpty()) sb.append(sExpr(n.kids.get(0)));
        if (n.kids.size() == 2) sb.append(sExpr(n.kids.get(1)));
        sb.append(')');
        return sb.toString();
    }
}
