package rockpaperscissors;
import java.util.*;
import java.lang.Math;

public class Main {
    private static final String[] options = {"paper", "scissors", "rock"};

    public static int getRandom() {
        return (int) (options.length * Math.random());
    }

    public static String computeInput(String input, String computerOption) {
        String res = null;
        switch(computerOption) {
            case "paper":
                if (input.equals("rock")) {
                    res = "Sorry, but the computer chose " + computerOption ;
                } else if (input.equals(computerOption)) {
                    res = "Draw: There is a draw (" + computerOption + ")";
                } else {
                    res = "Well done. The computer chose " + computerOption + " and failed";
                }
                break;
            case "scissors":
                if (input.equals("paper")) {
                    res = "Sorry, but the computer chose " + computerOption;
                } else if (input.equals(computerOption)) {
                    res = "Draw: There is a draw (" + computerOption + ")";
                } else {
                    res = "Well done. The computer chose " + computerOption + " and failed";
                }
                break;
            case "rock":
                if (input.equals("scissors")) {
                    res = "Sorry, but the computer chose " + computerOption;
                } else if (input.equals(computerOption)) {
                    res = "Draw: There is a draw (" + computerOption + ")";
                } else {
                    res = "Well done. The computer chose " + computerOption + " and failed";
                }
                break;
        }
        return res;
    }


    private static  boolean checkInput(String input) {
        for (String val: options) {
            if (val.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        String input;

        while(true) {
            input = scan.nextLine();
            if (input.equals("!exit")) {
                break;
            } else if (!checkInput(input)) {
                System.out.println("Invalid input");
            } else {
                System.out.println(computeInput(input, options[getRandom()]));
            }
        }

        System.out.println("Bye!");
    }
}
