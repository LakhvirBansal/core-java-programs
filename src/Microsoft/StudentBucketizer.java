package Microsoft;

import java.util.ArrayList;
import java.util.List;

public class StudentBucketizer {

    public static void bucketizeByGrades(List<Student> students, int n) {
        if (n <= 0) {
            System.out.println("Number of buckets must be greater than 0.");
            return;
        }

        // Step size for each bucket range
        int bucketRange = 100 / n;

        // Initialize n empty buckets
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Place students into respective buckets
        for (Student student : students) {
            int grade = student.getGrade();
            String name = student.getName();

            int bucketIndex = Math.min(grade / bucketRange, n - 1);  // Ensure last grade 100 goes into last bucket
            buckets.get(bucketIndex).add(name);
        }

        // Print the results
        for (int i = 0; i < n; i++) {
            int lower = i * bucketRange;
            int upper = (i == n - 1) ? 100 : (i + 1) * bucketRange - 1;

            System.out.println("Grade bucket " + (i + 1) + " [" + lower + "-" + upper + "]: " +
                    String.join(", ", buckets.get(i)));
        }
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", 85),
                new Student("Bob", 45),
                new Student("Charlie", 20),
                new Student("Diana", 70),
                new Student("Eve", 30),
                new Student("Frank", 95),
                new Student("Grace", 55),
                new Student("Hank", 10),
                new Student("Ivy", 65),
                new Student("Jack", 40)
        );

        int n = 5; // You can change n to any positive integer
        bucketizeByGrades(students, n);
    }
}
