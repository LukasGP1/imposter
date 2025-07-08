package de.lulkas_.options;

import java.util.*;

public record Options(List<Player> players, Map.Entry<String, String> word, Words.Category category) {
    public static Options createFromPlayerNames(List<String> playerNames, int imposterCount, Words.Category category) {
        Map.Entry<String, String> word = Words.getWord(category);
        List<Player> players = new ArrayList<>();
        for(String name : playerNames) {
            players.add(new Player(name));
        }

        Options toReturn = new Options(players, word, category);
        toReturn.setImposters(imposterCount);

        return toReturn;
    }

    private void setImposters(int imposterCount) {
        List<Player> players = this.players;
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
}
