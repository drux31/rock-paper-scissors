package rockpaperscissors.core;
import java.lang.Math;

public class ProcessInput {

    /**
     * Generate a random number to select
     * an option for the computer
     * @param optionLength the number of options available
     * @return
     *        the index of the option selected by the computer
     */
    public static int getRandom(int optionLength) {
        return (int) (optionLength * Math.random());
    }

    /**
     * Generate the result for the selected option
     * from the user and the computer
     * @param input input from the user
     * @param computerOption option chosen by the computer
     * @return
     *      the corespondig result based on user and computer selected values
     */
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

    /**+
     * Make sure the input is in the list of options
     * @param input  user input
     * @param options table with the available options
     * @return
     *      true or false whether the option exists or not
     */
    public static  boolean checkInput(String input, String[] options) {
        for (String val: options) {
            if (val.equals(input)) {
                return true;
            }
        }
        return false;
    }
}
