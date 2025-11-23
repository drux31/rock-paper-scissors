package rockpaperscissors.core;

import java.io.*;
import java.util.HashMap;

public class ProcessRating {

    private static HashMap<String, Integer> ratings;
    public final static int DRAW = 50;
    public final static int USER_WIN = 100;

    public static void initRating() {
        ratings = extractRatingFromFile();
    }

    public static int getRating(String name) {
        if (!ratings.containsKey(name)) {
            return 0;
        }
        return ratings.get(name);
    }

    public static void setRating(String name, int val) {
        if (ratings.containsKey(name)) {
            int temp = ratings.get(name);
            ratings.put(name, temp + val);
        } else {
            ratings.put(name, val);
        }
    }

    private static HashMap<String, Integer> extractRatingFromFile() {
        HashMap<String, Integer> ratings = new HashMap<>();
        try {
            String file_path = "rating.txt";
            BufferedReader reader = new BufferedReader(new FileReader(file_path));

            String line;
            while((line = reader.readLine()) != null) {

                ratings.put(
                        line.strip().split(" ")[0],
                        Integer.parseInt(line.strip().split(" ")[1])
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ratings;
    }
}
