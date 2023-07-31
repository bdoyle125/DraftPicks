import java.util.Scanner;

public class draftOrder {

    private static void oneUserStandardDraft(int rounds, int participants, int originalPick) {
        int userPick;
        int totalPicks = 0;
        for (int i = 1; i <= rounds; i++) {
            System.out.println("Round " + i);
            userPick = totalPicks + originalPick;
            for (int j = 1; j <= participants; j++) {
                totalPicks++;
                if (totalPicks == userPick) {
                    System.out.println("This user picks at pick " + totalPicks);
                }
            }
        }
    }

    private static void oneUserSnakeDraft(int rounds, int participants, int originalPick) {
        int userPick;
        int totalPicks = 0;
        for (int i = 1; i <= rounds; i++) {
            System.out.println("Round " + i);
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
                    System.out.println("This user picks at pick " + totalPicks);
                }
            }
        }
    } 
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("This program tells you all your draft picks in a draft");
    System.out.println("What kind of draft is it? Type either Standard or Snake.");
    String draftType = scan.nextLine();

    System.out.println("How many rounds is your draft?");
    int rounds = scan.nextInt();

    System.out.println("How many participants are in your draft?");
    int participants = scan.nextInt();

    System.out.println("What is the number of your first pick?");
    int originalPick = scan.nextInt();

    switch(draftType) {
        case "Standard":
            oneUserStandardDraft(rounds, participants, originalPick);
            break;
        case "Snake":
            oneUserSnakeDraft(rounds, participants, originalPick);
            break;
        default:
            System.out.println("That was not one of the options. Please restart the program to try again.");
            break;
    }

    scan.close();
    
  }
}