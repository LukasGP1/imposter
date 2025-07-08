package de.lulkas_.window;

import de.lulkas_.options.Options;
import de.lulkas_.options.Player;
import de.lulkas_.Utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameWindow extends JFrame {
    private JButton continueButton;
    private JLabel playerNameLabel;
    private JLabel wordLabel;
    private JLabel tipLabel;
    private JPanel mainPanel;

    private final Options options;
    private final SettingsWindow settingsWindow;

    private State state = State.NEXT_PLAYER;

    private Player player;
    private final List<Player> chosenPlayers = new ArrayList<>();

    public GameWindow(Options options, SettingsWindow settingsWindow) {
        this.options = options;
        this.settingsWindow = settingsWindow;
        createUIComponents();
        initializeLogic();
        setContentPane(mainPanel);
        setResizable(false);
        setTitle("Imposter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeLogic() {
        continueButton.setText(State.NEXT_PLAYER.buttonText);
        player = Utils.getRandom(options.players());
        chosenPlayers.add(player);
        playerNameLabel.setText(player.getName());
    }

    private void onClickContinueButton() {
        if(state == State.NEXT_PLAYER) {
            String text;
            if(player.isImposter()) {
                text = "IMPOSTER";
                tipLabel.setText("tip: " + options.word().getValue());
            } else {
                text = options.word().getKey();
            }
            wordLabel.setText(text);
            continueButton.setText(State.REVEALED.buttonText);
            state = State.REVEALED;
        } else if(state == State.REVEALED) {
            if(chosenPlayers.size() < options.players().size()) {
                while(chosenPlayers.contains(player)) {
                    player = Utils.getRandom(options.players());
                }
                chosenPlayers.add(player);
                playerNameLabel.setText(player.getName());
                wordLabel.setText("");
                tipLabel.setText("");
                continueButton.setText(State.NEXT_PLAYER.buttonText);
                state = State.NEXT_PLAYER;
            } else {
                wordLabel.setText(Utils.getRandom(options.players()).getName() + " begins");
                playerNameLabel.setText("");
                tipLabel.setText("");
                continueButton.setText(State.DONE.buttonText);
                state = State.DONE;
            }
        } else if(state == State.DONE) {
            settingsWindow.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        continueButton = new JButton();
        continueButton.setSize(100, 20);
        continueButton.setLocation(350, 300);
        continueButton.addActionListener((e) -> onClickContinueButton());
        mainPanel.add(continueButton);

        playerNameLabel = new JLabel();
        playerNameLabel.setSize(100, 20);
        playerNameLabel.setLocation(350, 100);
        mainPanel.add(playerNameLabel);

        wordLabel = new JLabel();
        wordLabel.setSize(100, 20);
        wordLabel.setLocation(350, 200);
        mainPanel.add(wordLabel);

        tipLabel = new JLabel();
        tipLabel.setSize(100, 20);
        tipLabel.setLocation(350, 225);
        mainPanel.add(tipLabel);
    }

    enum State {
        REVEALED("Next"),
        NEXT_PLAYER("Reveal"),
        DONE("Quit");

        public final String buttonText;

        State(String buttonText) {
            this.buttonText = buttonText;
        }
    }
}
