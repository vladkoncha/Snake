package view;

import proto.SnakeProto;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class SettingsForm extends JFrame {
    private JPanel mainPanel;
    private JLabel widthLabel;
    private JLabel heightLabel;
    private JLabel foodStaticLabel;
    private JLabel foodPerPlayerLabel;
    private JLabel stateDelayMsLabel;
    private JLabel deadFoodProbabilityLabel;
    private JLabel pingDelayMsLabel;
    private JLabel nodeTimeoutMsLabel;
    private JButton saveSettingsButton;
    private JTextField nameField;
    private JLabel nameLabel;
    private JSpinner width;
    private JSpinner height;
    private JSpinner foodStatic;
    private JSpinner foodPerPlayer;
    private JSpinner stateDelay;
    private JSpinner deadFoodProb;
    private JSpinner pingDelay;
    private JSpinner nodeTimeout;
    private SnakeProto.GameConfig.Builder gameConfig;
    private SnakeProto.GameMessage.JoinMsg.Builder playerName;

    public SettingsForm() {
        $$$setupUI$$$();
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        saveSettingsButton.addActionListener(actionEvent -> setSettings());
    }

    public void setGameConfig(SnakeProto.GameConfig.Builder gameConfig) {
        this.gameConfig = gameConfig;
    }

    public SnakeProto.GameConfig.Builder getGameConfig() {
        return gameConfig;
    }

    public void setPlayerName(SnakeProto.GameMessage.JoinMsg.Builder playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName.getName();
    }

    public void saveSettings() {
        setSettings();
    }

    private void checkName() throws InvalidSettingsException {
        if (nameField.getText().length() > 40) {
            nameField.setText(nameField.getText().substring(0, 40));
            throw new InvalidSettingsException("Name must be less than 40 characters.");
        }
    }

    private void setSettings() {
        try {
            checkName();
            width.commitEdit();
            height.commitEdit();
            foodStatic.commitEdit();
            foodPerPlayer.commitEdit();
            stateDelay.commitEdit();
            deadFoodProb.commitEdit();
            pingDelay.commitEdit();
            nodeTimeout.commitEdit();
        } catch (InvalidSettingsException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Settings error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ignored) {
        }
        playerName.setName(nameField.getText());
        gameConfig
                .setWidth((Integer) width.getValue())
                .setHeight((Integer) height.getValue())
                .setFoodStatic((Integer) foodStatic.getValue())
                .setFoodPerPlayer(((Double) foodPerPlayer.getValue()).floatValue())
                .setStateDelayMs((Integer) stateDelay.getValue())
                .setDeadFoodProb(((Double) deadFoodProb.getValue()).floatValue())
                .setPingDelayMs((Integer) pingDelay.getValue())
                .setNodeTimeoutMs((Integer) nodeTimeout.getValue());
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 2, new Insets(0, 0, 0, 0), -1, -1));
        widthLabel = new JLabel();
        widthLabel.setHorizontalAlignment(4);
        widthLabel.setText("Width");
        mainPanel.add(widthLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        heightLabel = new JLabel();
        heightLabel.setHorizontalAlignment(4);
        heightLabel.setText("Height");
        mainPanel.add(heightLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 34), null, 0, false));
        foodStaticLabel = new JLabel();
        foodStaticLabel.setHorizontalAlignment(4);
        foodStaticLabel.setText("Food Static");
        mainPanel.add(foodStaticLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        foodPerPlayerLabel = new JLabel();
        foodPerPlayerLabel.setHorizontalAlignment(4);
        foodPerPlayerLabel.setText("Food Per Player");
        mainPanel.add(foodPerPlayerLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        stateDelayMsLabel = new JLabel();
        stateDelayMsLabel.setHorizontalAlignment(4);
        stateDelayMsLabel.setText("State Delay Ms");
        mainPanel.add(stateDelayMsLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        deadFoodProbabilityLabel = new JLabel();
        deadFoodProbabilityLabel.setHorizontalAlignment(4);
        deadFoodProbabilityLabel.setText("Dead Food Probability");
        mainPanel.add(deadFoodProbabilityLabel, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        pingDelayMsLabel = new JLabel();
        pingDelayMsLabel.setHorizontalAlignment(4);
        pingDelayMsLabel.setText("Ping Delay Ms");
        mainPanel.add(pingDelayMsLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        nodeTimeoutMsLabel = new JLabel();
        nodeTimeoutMsLabel.setHorizontalAlignment(4);
        nodeTimeoutMsLabel.setText("Node Timeout Ms");
        mainPanel.add(nodeTimeoutMsLabel, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        saveSettingsButton = new JButton();
        saveSettingsButton.setText("Save Settings");
        mainPanel.add(saveSettingsButton, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        nameField.setText("Player");
        mainPanel.add(nameField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(4);
        nameLabel.setHorizontalTextPosition(11);
        nameLabel.setText("Name");
        mainPanel.add(nameLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        mainPanel.add(height, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(88, 34), null, 0, false));
        mainPanel.add(foodStatic, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mainPanel.add(foodPerPlayer, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mainPanel.add(stateDelay, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mainPanel.add(deadFoodProb, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mainPanel.add(pingDelay, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mainPanel.add(nodeTimeout, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mainPanel.add(width, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        width = new JSpinner(new SpinnerNumberModel(40, 10, 100, 1));
        height = new JSpinner(new SpinnerNumberModel(30, 10, 100, 1));
        foodStatic = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1));
        foodPerPlayer = new JSpinner(new SpinnerNumberModel(1.0, 0, 100, 1));
        stateDelay = new JSpinner(new SpinnerNumberModel(1000, 1, 10_000, 50));
        deadFoodProb = new JSpinner(new SpinnerNumberModel(0.1, 0, 1, 0.05));
        pingDelay = new JSpinner(new SpinnerNumberModel(100, 1, 10_000, 50));
        nodeTimeout = new JSpinner(new SpinnerNumberModel(1800, 1, 10_000, 50));
    }
}
