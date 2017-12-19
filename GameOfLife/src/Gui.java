

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Gui(){
		super("Game of life");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		MyTableModel gameFieldData = new MyTableModel();
		GuiCreator guiCreator = new GuiCreator();
		JTable gameFieldTable = guiCreator.initGameFieldTable(gameFieldData);
		GameLogic gameLogic = new GameLogic(gameFieldTable, gameFieldData);

		JButton stopGameButton = guiCreator.initStopGameButton();
		JButton oneStepButton = guiCreator.initOneStepButton();
		JButton startGameButton = guiCreator.initStartGameButton();
		JButton cleanCellsButton = guiCreator.initCleanCellsButton();
		JLabel infoLabel = guiCreator.initInfoLabel();
		JCheckBox unlimitedBordersCheckBox = new JCheckBox("Unlimited borders", false);
		JCheckBox drawingModeCheckBox = new JCheckBox("Drawing mode", false);

		JPanel panel = new JPanel();
		JPanel checkBoxesPanel = guiCreator.initCheckBoxesPanel();
		checkBoxesPanel.add(unlimitedBordersCheckBox);
		checkBoxesPanel.add(drawingModeCheckBox);
		panel.add(gameFieldTable);
		panel.add(cleanCellsButton);
		panel.add(startGameButton);
		panel.add(stopGameButton);
		panel.add(oneStepButton);
		panel.add(infoLabel);
		panel.setBackground(Color.ORANGE);

		getContentPane().add(BorderLayout.WEST, panel);
		getContentPane().add(checkBoxesPanel);
		setPreferredSize(new Dimension(1920, 1080));
		pack();
		setVisible(true);

		drawingModeCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(gameLogic.isDrawingMode()){
					gameLogic.setDrawingMode(false);
					drawingModeCheckBox.setBorderPaintedFlat(false);
				}
				else{
					gameLogic.setDrawingMode(true);
					drawingModeCheckBox.setBorderPaintedFlat(true);
				}
			}
		});

		unlimitedBordersCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(gameLogic.isUnlimitedBorders()){
					gameLogic.setUnlimitedBorders(false);
					unlimitedBordersCheckBox.setBorderPaintedFlat(false);
				}
				else{
					gameLogic.setUnlimitedBorders(true);
					unlimitedBordersCheckBox.setBorderPaintedFlat(true);
				}
			}
		});

		gameFieldTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				gameLogic.setMouseReleased();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(gameLogic.isGameRunning()){
					infoLabel.setText("Stop the game first!");
				}
				else{
					if(gameLogic.isDrawingMode()){
						gameLogic.press();
					}
					else{
						int row = e.getY() / gameFieldTable.getRowHeight();
						int column = e.getX() / gameFieldTable.getColumnModel().getTotalColumnWidth();
						gameLogic.changeCellState(row, column);
					}
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) { }
			
			@Override
			public void mouseEntered(MouseEvent e) { }
			
			@Override
			public void mouseClicked(MouseEvent e) { }
		});

		stopGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameLogic.stopGame();
				startGameButton.setEnabled(true);
				cleanCellsButton.setEnabled(true);
				oneStepButton.setEnabled(true);
				unlimitedBordersCheckBox.setEnabled(true);
				drawingModeCheckBox.setEnabled(true);
				stopGameButton.setEnabled(false);
				infoLabel.setText("Stopped!");
			}
		});

		startGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(gameLogic.isGameFieldEmpty()){
					infoLabel.setText("Cells are empty!");
				}
				else {
					infoLabel.setText("");
					gameLogic.startGame(infoLabel, startGameButton, stopGameButton, oneStepButton,
										cleanCellsButton, unlimitedBordersCheckBox, drawingModeCheckBox);
				}
			}
		});

		cleanCellsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!gameLogic.isGameFieldEmpty()){
					gameLogic.cleanCells();
					infoLabel.setText("Cleaned!");
				}
			}
		});

		oneStepButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(gameLogic.isGameFieldEmpty()){
					infoLabel.setText("Cells are empty!");
				}
				else {
					gameLogic.performOneStep();
					infoLabel.setText("Performed!");
				}
			}
		});
	}



}
