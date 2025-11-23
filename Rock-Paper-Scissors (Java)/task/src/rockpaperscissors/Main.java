package rockpaperscissors;
import rockpaperscissors.core.ProcessInput;
import rockpaperscissors.core.ProcessRating;

import java.util.*;

import static rockpaperscissors.core.ProcessInput.*;

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
        HashMap<Integer, String> resbis;

        System.out.print("Enter your name: ");
        String username = scan.nextLine();
        System.out.println("Hello, " + username);

        input = scan.nextLine();
        initOptions(input);

        while(true) {
            input = scan.nextLine();

            if (input.equals("!exit")) {
                break;
            } else if (input.equals("!rating")) {
                System.out.println("Your rating: " + ProcessRating.getRating(username));
            } else if (!ProcessInput.checkInput(input, options)) {
                System.out.println("Invalid input");
            } else {
                resbis = processInput(input, username, options);
                for (Map.Entry<Integer, String> obj : resbis.entrySet()) {
                    System.out.println(obj.getValue());
                }
            }
        }

        System.out.println("Bye!");
        scan.close();
    }
}
