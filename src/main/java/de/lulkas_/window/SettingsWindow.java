package de.lulkas_.window;

import de.lulkas_.options.Options;
import de.lulkas_.Utils;
import de.lulkas_.options.Words;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SettingsWindow extends JFrame {
    private JList<String> playerList;
    private JTextField playerNameTextField;
    private JLabel playerAddErrorLabel;
    private JTextField imposterCountTextField;
    private JLabel startGameErrorLabel;
    private JComboBox<Words.Category> categorySelector;
    private JPanel mainPanel;

    private final List<String> players = new ArrayList<>();

    public SettingsWindow() {
        createUIComponents();
        setContentPane(mainPanel);
        setResizable(false);
        setTitle("Imposter Settings");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void clearPlayers() {
        players.clear();
        playerList.setListData(Utils.toArray(players));
    }

    private void addPlayer() {
        String name = playerNameTextField.getText();
        if(players.contains(name)) {
            playerAddErrorLabel.setText("You have already added this player");
        } else if(name.isBlank()) {
            playerAddErrorLabel.setText("You have to put in a name");
        } else {
            playerAddErrorLabel.setText("");
            players.add(name);
            playerList.setListData(Utils.toArray(players));
        }
    }

    private void tryStartGame() {
        try {
            int imposterCount = Integer.parseInt(imposterCountTextField.getText());

            if(players.size() < 3) {
                startGameErrorLabel.setText("You have to put in at least 3 players");
                return;
            }

            if(imposterCount > players.size() - 2) {
                startGameErrorLabel.setText("You put in too many imposters");
                return;
            }

            startGameErrorLabel.setText("");
            Options options = Options.createFromPlayerNames(players, imposterCount, ((Words.Category) categorySelector.getSelectedItem()));
            new GameWindow(options, this);
            this.setVisible(false);
        } catch (NumberFormatException e) {
            startGameErrorLabel.setText("You have to put in a valid number");
        }
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        playerNameTextField = new JTextField();
        playerNameTextField.setSize(100, 20);
        playerNameTextField.setLocation(100, 75);
        mainPanel.add(playerNameTextField);

        JLabel playerNameLabel = new JLabel("Name");
        playerNameLabel.setSize(100, 20);
        playerNameLabel.setLocation(100, 50);
        mainPanel.add(playerNameLabel);

        JButton addPlayerButton = new JButton("Add Player");
        addPlayerButton.setSize(100, 20);
        addPlayerButton.setLocation(300, 50);
        addPlayerButton.addActionListener((e) -> addPlayer());
        mainPanel.add(addPlayerButton);

        playerAddErrorLabel = new JLabel();
        playerAddErrorLabel.setSize(200, 20);
        playerAddErrorLabel.setLocation(300, 50);
        mainPanel.add(playerAddErrorLabel);

        JButton clearPlayersButton = new JButton("Clear");
        clearPlayersButton.setSize(100, 20);
        clearPlayersButton.setLocation(300, 100);
        clearPlayersButton.addActionListener((e) -> clearPlayers());
        mainPanel.add(clearPlayersButton);

        playerList = new JList<>();
        JScrollPane playerListScrollPane = new JScrollPane(playerList);
        playerListScrollPane.setSize(200, 150);
        playerListScrollPane.setLocation(500, 10);
        mainPanel.add(playerListScrollPane);

        imposterCountTextField = new JTextField();
        imposterCountTextField.setSize(100, 20);
        imposterCountTextField.setLocation(200, 200);
        mainPanel.add(imposterCountTextField);

        JLabel imposterCountLabel = new JLabel("Imposter Count");
        imposterCountLabel.setSize(100, 20);
        imposterCountLabel.setLocation(200, 175);
        mainPanel.add(imposterCountLabel);

        categorySelector = new JComboBox<>(Words.Category.values());
        categorySelector.setSize(100, 20);
        categorySelector.setLocation(400, 200);
        mainPanel.add(categorySelector);

        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setSize(100, 20);
        categoryLabel.setLocation(400, 175);
        mainPanel.add(categoryLabel);

        JButton startGameButton = new JButton();
        startGameButton.setText("Start Game");
        startGameButton.setSize(100, 20);
        startGameButton.setLocation(300, 300);
        startGameButton.addActionListener(e -> tryStartGame());
        mainPanel.add(startGameButton);

        startGameErrorLabel = new JLabel();
        startGameErrorLabel.setSize(200, 20);
        startGameErrorLabel.setLocation(300, 275);
        mainPanel.add(startGameErrorLabel);
    }
}
