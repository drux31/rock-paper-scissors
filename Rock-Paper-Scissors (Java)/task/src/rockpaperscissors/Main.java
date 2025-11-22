package rockpaperscissors;
import rockpaperscissors.core.ProcessInput;
import rockpaperscissors.core.ProcessRating;

import java.util.*;

import static rockpaperscissors.core.ProcessInput.computeInput;
import static rockpaperscissors.core.ProcessInput.getRandom;

public class Main {

    private static String[] options = {"paper", "scissors", "rock"};

    private static void initOptions(String input) {
        if (!input.isEmpty()) {
            options = input.split(",");
        }
        System.out.println("Okay, let's start");
    }

    public static void main(String[] args) {
        // write your code here
        ProcessRating.initRating();
        Scanner scan = new Scanner(System.in);
        String input;
        String computerOption;
        int res;

        System.out.print("Enter your name: ");
        String username = scan.nextLine();
        System.out.println("Hello, " + username);

        input = scan.nextLine();
        initOptions(input);

        while(true) {
            input = scan.nextLine();
            computerOption = options[getRandom(options.length)];
            if (input.equals("!exit")) {
                break;
            } else if (input.equals("!rating")) {
                System.out.println("Your rating: " + ProcessRating.getRating(username));
            } else if (!ProcessInput.checkInput(input, options)) {
                System.out.println("Invalid input");
            } else {
                res = computeInput(input, computerOption);
                switch (res) {
                    case 1:
                        System.out.println("Sorry, but the computer chose " + computerOption);
                        ProcessRating.setRating(username, 0);
                        break;
                    case 2:
                        System.out.println("Draw: There is a draw (" + computerOption + ")");
                        ProcessRating.setRating(username, 50);
                        break;
                    case 3:
                        System.out.println("Well done. The computer chose " + computerOption + " and failed");
                        ProcessRating.setRating(username, 100);
                        break;
                }
            }
        }

        System.out.println("Bye!");
        scan.close();
    }
}
