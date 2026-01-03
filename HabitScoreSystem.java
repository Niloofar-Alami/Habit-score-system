import java.util.Scanner;

public class HabitScoreSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        printHeader();

        String[] habits = getHabits(input);
        int[] scores = getScores(input, habits);

        int total = calculateTotal(scores);
        double average = calculateAverage(scores);
        String level = evaluateLevel(average);

        printReport(habits, scores, total, average, level);

        input.close();
    }

    // ------------------ METHODS ------------------

    public static void printHeader() {
        System.out.println("====================================");
        System.out.println("        SMART HABIT SCORE SYSTEM");
        System.out.println("====================================");
    }

    public static String[] getHabits(Scanner input) {
        System.out.print("How many daily habits do you want to track? ");
        int count = input.nextInt();
        input.nextLine(); // Clear buffer

        String[] habits = new String[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter habit " + (i + 1) + ": ");
            habits[i] = input.nextLine();
        }

        return habits;
    }

    public static int[] getScores(Scanner input, String[] habits) {
        int[] scores = new int[habits.length];

        System.out.println("\nRate each habit from 0 to 10:");

        for (int i = 0; i < habits.length; i++) {
            System.out.print(habits[i] + ": ");
            scores[i] = input.nextInt();
        }

        return scores;
    }

    public static int calculateTotal(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }

    public static double calculateAverage(int[] scores) {
        return (double) calculateTotal(scores) / scores.length;
    }

    public static String evaluateLevel(double avg) {
        if (avg >= 8) return "🔥 Excellent";
        if (avg >= 5) return "🙂 Moderate";
        return "⚠️ Needs Improvement";
    }

    public static void printReport(String[] habits, int[] scores, int total, double avg, String level) {
        System.out.println("\n========== FINAL REPORT ==========");
        for (int i = 0; i < habits.length; i++) {
            System.out.println(habits[i] + " → " + scores[i]);
        }

        System.out.println("---------------------------------");
        System.out.println("Total Score: " + total);
        System.out.println("Average: " + avg);
        System.out.println("Performance Level: " + level);
        System.out.println("=================================");
    }
}
