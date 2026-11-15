import java.util.ArrayList;
import java.util.Scanner;

public class OnlineQuizApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Question> questions = new ArrayList<>();

        // Adding questions
        questions.add(new Question(
            "Which language is used for Android development?",
            new String[]{"HTML", "Java", "CSS", "SQL"},
            2
        ));

        questions.add(new Question(
            "Which keyword is used to inherit a class in Java?",
            new String[]{"this", "super", "extends", "implements"},
            3
        ));

        questions.add(new Question(
            "Which method is the entry point of a Java program?",
            new String[]{"start()", "main()", "run()", "execute()"},
            2
        ));

        questions.add(new Question(
            "Which collection allows duplicate elements in Java?",
            new String[]{"Set", "ArrayList", "Map", "TreeSet"},
            2
        ));

        questions.add(new Question(
            "Which keyword is used to create an object in Java?",
            new String[]{"class", "static", "new", "void"},
            3
        ));

        System.out.println("================================");
        System.out.println("       ONLINE QUIZ APPLICATION");
        System.out.println("================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\nWelcome, " + name + "!");
        System.out.println("Let's start the quiz.\n");

        // Display questions and capture answers
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {

            Question q = questions.get(i);

            System.out.println("\nQ" + (i + 1) + ". " + q.getQuestionText());

            String[] options = q.getOptions();

            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            // Validate user input
            while (answer < 1 || answer > 4) {
                System.out.print("Invalid choice! Enter a number between 1 and 4: ");
                answer = sc.nextInt();
            }

            // Check the answer
            if (answer == q.getCorrectAnswer()) {
                System.out.println("Correct Answer!");
                score++;
            } else {
                System.out.println("Wrong Answer!");
            }
        }

        // Calculate final result
        int totalQuestions = questions.size();
        int wrongAnswers = totalQuestions - score;

        double percentage = (score * 100.0) / totalQuestions;

        // Display final result
        System.out.println("\n================================");
        System.out.println("           QUIZ RESULT");
        System.out.println("================================");

        System.out.println("Player Name: " + name);
        System.out.println("Total Questions: " + totalQuestions);
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + wrongAnswers);
        System.out.println("Final Score: " + score + "/" + totalQuestions);
        System.out.printf("Percentage: %.2f%%\n", percentage);

        if (percentage >= 60) {
            System.out.println("Result: Congratulations! You passed.");
        } else {
            System.out.println("Result: Keep practicing. Better luck next time!");
        }

        System.out.println("================================");

        sc.close();

    }
}