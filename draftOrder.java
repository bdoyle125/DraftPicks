import java.util.Scanner;

public class draftOrder {

    private static void oneUserStandardDraft() {
        Scanner scan = new Scanner(System.in);
        int rounds = inputValidation("How many rounds is your draft?");
        int participants = inputValidation("How many participants are in your draft?");
        int originalPick = inputValidation("What is the number of your first pick?");

        scan.close();

        int userPick;
        int totalPicks = 0;
        for (int i = 1; i <= rounds; i++) {
            userPick = totalPicks + originalPick;
            for (int j = 1; j <= participants; j++) {
                totalPicks++;
                if (totalPicks == userPick) {
                    System.out.println("Round " + i + ": \tOverall Pick: " + totalPicks);
                }
            }
        }
    }

    private static void oneUserSnakeDraft() {
        Scanner scan = new Scanner(System.in);
        int rounds = inputValidation("How many rounds is your draft?");
        int participants = inputValidation("How many participants are in your draft?");
        int originalPick = inputValidation("What is the number of your first pick?");

        scan.close();

        int userPick;
        int totalPicks = 0;
        for (int i = 1; i <= rounds; i++) {
            // Odd Round Number
            if (i % 2 != 0) {
                userPick = totalPicks + originalPick;
            }
            // Even Round Number
            else {
                userPick = totalPicks + participants - originalPick + 1;
            }
            for (int j = 1; j <= participants; j++) {
                totalPicks++;
                if (totalPicks == userPick) {
                    System.out.println("Round " + i + ": \tOverall Pick: " + totalPicks);
                }
            }
        }
    }

    public static int inputValidation(String prompt) {
        int value = 0;
        Scanner scan = new Scanner(System.in);
        boolean flag = false;

        System.out.println(prompt);
        // Making sure the input is an integer.
        while (!(flag)) {
            if (scan.hasNextInt()) {
                value = scan.nextInt();
                flag = true;
            } else {
                scan.next();
                System.out.println("Input value must be a non-decimal number.");
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("This program tells you all your draft picks in a draft");
        System.out.println("What kind of draft is it? Type either Standard or Snake.");
        String draftType = scan.nextLine();

        switch (draftType) {
            case "Standard":
                oneUserStandardDraft();
                break;
            case "Snake":
                oneUserSnakeDraft();
                break;
            default:
                System.out.println("That was not one of the options. Please restart the program to try again.");
                break;
        }

        scan.close();

    }
}