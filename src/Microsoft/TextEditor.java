package Microsoft;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TextEditor {

    public static void main(String[] args) {
        List<String> input = List.of("1 abc", "3 3", "2 3", "1 xy", "3 2", "4", "4", "3 1");
        solveEditor(input);
    }

    public static void solveEditor(List<String> operations) {
        StringBuilder current = new StringBuilder();
        Deque<String> history = new ArrayDeque<>(); // for storing previous states

        for (String op : operations) {
            String[] parts = op.split(" ");
            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1: // Append
                    history.push(current.toString());
                    current.append(parts[1]);
                    break;

                case 2: // Delete last k characters
                    history.push(current.toString());
                    int k = Integer.parseInt(parts[1]);
                    current.delete(current.length() - k, current.length());
                    break;

                case 3: // Print kth character
                    int index = Integer.parseInt(parts[1]);
                    if (index > 0 && index <= current.length()) {
                        System.out.println(current.charAt(index - 1));
                    }
                    break;

                case 4: // Undo
                    if (!history.isEmpty()) {
                        current = new StringBuilder(history.pop());
                    }
                    break;
            }
        }
    }
}
