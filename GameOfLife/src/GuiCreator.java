import javax.swing.*;
import java.awt.*;

public class GuiCreator {
    public JButton initStopGameButton() {
        JButton stopGameButton = new JButton("Stop");
        stopGameButton.setPreferredSize(new Dimension(100, 50));
        stopGameButton.setEnabled(false);
        return stopGameButton;
    }

    public JButton initStartGameButton(){
        JButton startGameButton = new JButton("Start game");
        startGameButton.setPreferredSize(new Dimension(100, 50));
        return startGameButton;
    }

    public JButton initOneStepButton(){
        JButton oneStepButton = new JButton("One step");
        oneStepButton.setPreferredSize(new Dimension(100, 50));
        return oneStepButton;
    }

    public JButton initCleanCellsButton(){
        JButton cleanCellsButton = new JButton("Clean cells");
        cleanCellsButton.setPreferredSize(new Dimension(100, 50));
        return cleanCellsButton;
    }

    public JLabel initInfoLabel(){
        JLabel infoLabel = new JLabel();
        infoLabel.setPreferredSize(new Dimension(150, 50));
        infoLabel.setForeground(Color.RED);
        return infoLabel;
    }

    public JTable initGameFieldTable(MyTableModel gameFieldData){
        JTable gameFieldTable = new JTable(gameFieldData, new MyTableColumnModel());
        gameFieldTable.setPreferredSize(new Dimension(700, 700));
        gameFieldTable.setDefaultRenderer(Cell.class, new MyTableCellRenderer());
        gameFieldTable.setCellSelectionEnabled(false);
        gameFieldTable.setFocusable(false);
        gameFieldTable.setGridColor(Color.RED);
        gameFieldTable.setRowHeight(700 / gameFieldTable.getModel().getRowCount());
        return gameFieldTable;
    }

    public JPanel initCheckBoxesPanel(){
        JPanel checkBoxesPanel = new JPanel();
        checkBoxesPanel.setBorder(BorderFactory.createTitledBorder("Options"));
        checkBoxesPanel.setBackground(Color.ORANGE);
        checkBoxesPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        checkBoxesPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        return checkBoxesPanel;
    }

}
