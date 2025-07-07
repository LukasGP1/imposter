package de.lulkas_;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            Options options = Options.getOptions(scanner);
            Utils.clearScreen();
            for(Player player : options.players()) {
                System.out.println(player.getName());
                scanner.nextLine();
                if(player.isImposter()) {
                    System.out.println("IMPOSTER");
                    System.out.println("tip: " + options.word().getValue());
                } else {
                    System.out.println(options.word().getKey());
                }
                scanner.nextLine();
                Utils.clearScreen();
            }
            System.out.println(Utils.getRandom(options.players()).getName() + " begins");
            System.out.println();
            System.out.println("press enter to play again, type \"stop\" to stop");
            if(scanner.nextLine().equals("stop")) {
                break;
            }
        }
    }
}