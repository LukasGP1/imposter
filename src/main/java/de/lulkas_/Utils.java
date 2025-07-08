package de.lulkas_;

import java.util.List;
import java.util.Random;

public class Utils {
    public static <T> T getRandom(List<T> list) {
        Random random = new Random();
        int index = random.nextInt(0, list.size());
        return list.get(index);
    }

    public static String[] toArray(List<String> list) {
        String[] toReturn = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            toReturn[i] = list.get(i);
        }
        return toReturn;
    }
}
