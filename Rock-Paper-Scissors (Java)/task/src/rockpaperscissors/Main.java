package rockpaperscissors;
import rockpaperscissors.core.ProcessInput;

import java.util.*;

import static rockpaperscissors.core.ProcessInput.computeInput;
import static rockpaperscissors.core.ProcessInput.getRandom;

public class Main {

    private static final String[] options = {"paper", "scissors", "rock"};

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        String input;

        while(true) {
            input = scan.nextLine();
            if (input.equals("!exit")) {
                break;
            } else if (!ProcessInput.checkInput(input, options)) {
                System.out.println("Invalid input");
            } else {
                System.out.println(computeInput(input, options[getRandom(options.length)]));
            }
        }

        System.out.println("Bye!");
        scan.close();
    }
}
