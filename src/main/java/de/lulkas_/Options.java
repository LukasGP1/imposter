package de.lulkas_;

import java.util.*;

public record Options(List<Player> players, int imposterCount, Map.Entry<String, String> word) {
    public static Options getOptions(Scanner scanner) {
        List<Player> players = getPlayers(scanner);
        int imposterCount = getImposterCount(scanner, players.size() - 1);
        Map.Entry<String, String> word = getWord();

        Options toReturn = new Options(players, imposterCount, word);
        toReturn.setImposters();

        return toReturn;
    }

    private void setImposters() {
        List<Player> players = this.players;
        int imposterCount = this.imposterCount;
        List<Integer> imposters = new ArrayList<>();
        Random random = new Random();

        while(imposters.size() < imposterCount) {
            int index = random.nextInt(0, players.size());
            if(!imposters.contains(index)) {
                imposters.add(index);
                players.get(index).makeImposter();
            }
        }
    }

    public static final Map<String, String> wordToTipMap = Map.of("cat", "animal", "dog", "animal", "tnt", "minecraft");
    private static Map.Entry<String, String> getWord() {
        Random random = new Random();
        int index = random.nextInt(0, wordToTipMap.size());
        return new ArrayList<>(wordToTipMap.entrySet()).get(index);
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

    private static List<Player> askForPlayers(Scanner scanner) {
        List<Player> toReturn = new ArrayList<>();
        while(true) {
            String input = scanner.nextLine();
            if(input.isBlank()) {
                break;
            } else {
                toReturn.add(new Player(input));
            }
        }

        return toReturn;
    }

    private static List<Player> getPlayers(Scanner scanner) {
        System.out.println("input player names (press enter if you are done)");
        List<Player> toReturn = new ArrayList<>();
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

    private static boolean containsDuplicates(List<Player> input) {
        for(int i = 0; i < input.size(); i++) {
            String firstElement = input.get(i).getName();
            for(int j = i + 1; j < input.size(); j++) {
                String secondElement = input.get(j).getName();
                if(Objects.equals(firstElement, secondElement)) {
                    return true;
                }
            }
        }

        return false;
    }
}
