package de.lulkas_;

import java.util.List;
import java.util.Random;

public class Utils {
    public static void clearScreen() {
        for (int i = 0; i < 99999; i++) {
            System.out.println();
        }
    }

    public static <T> T getRandom(List<T> list) {
        Random random = new Random();
        int index = random.nextInt(0, list.size());
        return list.get(index);
    }
}
