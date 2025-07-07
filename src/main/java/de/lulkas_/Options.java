package de.lulkas_;

import java.util.*;

public record Options(List<String> players, int imposterCount, String word) {
    public static Options getOptions(Scanner scanner) {
        List<String> players = getPlayers(scanner);
        int imposterCount = getImposterCount(scanner, players.size() - 1);
        String word = getWord();

        return new Options(players, imposterCount, word);
    }

    private static final List<String> words = List.of("cat", "dog", "tnt");
    private static String getWord() {
        Random random = new Random();
        int index = random.nextInt(0, words.size());
        return words.get(index);
    }

    private static int getImposterCount(Scanner scanner, int max) {
        System.out.println("input imposter count");
        while(true) {
            String input = scanner.nextLine();
            try {
                int toReturn = Integer.parseInt(input);
                if(toReturn > max) {
                    System.out.println("that's too many");
                } else {
                    return toReturn;
                }
            } catch (NumberFormatException e) {
                System.out.println("please input a valid number, try again");
            }
        }
    }

    private static List<String> askForPlayers(Scanner scanner) {
        List<String> toReturn = new ArrayList<>();
        while(true) {
            String input = scanner.nextLine();
            if(input.isBlank()) {
                break;
            } else {
                toReturn.add(input);
            }
        }

        return toReturn;
    }

    private static List<String> getPlayers(Scanner scanner) {
        System.out.println("input player names (press enter if you are done)");
        List<String> toReturn = new ArrayList<>();
        boolean loop = true;
        while(loop) {
            toReturn = askForPlayers(scanner);
            if(toReturn.size() < 3) {
                System.out.println("you have to specify at least 3 players, try again");
            } else if(containsDuplicates(toReturn)) {
                System.out.println("all names have to be different, try again");
            } else {
                loop = false;
            }
        }
        return toReturn;
    }

    private static boolean containsDuplicates(List<String> input) {
        for(int i = 0; i < input.size(); i++) {
            String firstElement = input.get(i);
            for(int j = i + 1; j < input.size(); j++) {
                String secondElement = input.get(j);
                if(Objects.equals(firstElement, secondElement)) {
                    return true;
                }
            }
        }

        return false;
    }
}
