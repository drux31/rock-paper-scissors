package rockpaperscissors.core;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
     * @param username the username entered at the beginning of the game
     * @param options the option list created at the begining of the game
     * @return
     *      the corespondig result based on user and computer selected values
     */
    public static HashMap<Integer, String> processInput(String input, String username, String[] options)
    {
        int optionIndex = getRandom(options.length);
        String computeOption = options[optionIndex];

        HashMap<Integer, String> res = new HashMap<>();
        ArrayList<String> orderedOptions = new ArrayList<>();

        if (computeOption.equals(input)) {
            res.put(1, "Draw: There is a draw (" + computeOption + ")");
            ProcessRating.setRating(username, ProcessRating.DRAW);
        } else {
            int i = 0;
            int j = Arrays.asList(options).indexOf(input) + 1;

            while (i < options.length - 1) {
                 if (j == options.length) {
                     j = 0;
                 }
                 orderedOptions.add(options[j]);
                 j++;
                 i++;
            }
            //System.out.println(orderedOptions);
            // Check if the user input is in the first half
            if (orderedOptions.subList(0, orderedOptions.size()/2).contains(computeOption)) {
                res.put(2, "Sorry, but the computer chose " + computeOption);
            } else {
                res.put(3, "Well done. The computer chose " + computeOption + " and failed");
                ProcessRating.setRating(username, ProcessRating.USER_WIN);
            }
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
