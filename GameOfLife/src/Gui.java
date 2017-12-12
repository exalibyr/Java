

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Gui(){
		super("Game of life");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		MyTableModel gameFieldData = new MyTableModel();
		JTable gameFieldTable = new JTable(gameFieldData, new MyTableColumnModel());
		GameLogic gameLogic = new GameLogic(gameFieldTable, gameFieldData);

		JPanel panel = new JPanel();
		JButton stopGameButton = new JButton("Stop");
		JButton oneStepButton = new JButton("One step");
		JButton startGameButton = new JButton("Start game");
		JButton cleanCellsButton = new JButton("Clean cells");
		JLabel infoLabel = new JLabel();

		JPanel checkBoxesPanel = new JPanel();
		JCheckBox unlimitedBordersCheckBox = new JCheckBox("Unlimited borders", false);
		JCheckBox drawingModeCheckBox = new JCheckBox("Drawing mode", false);
		checkBoxesPanel.add(unlimitedBordersCheckBox);
		checkBoxesPanel.add(drawingModeCheckBox);
		checkBoxesPanel.setBorder(BorderFactory.createTitledBorder("Options"));
		checkBoxesPanel.setBackground(Color.ORANGE);
		checkBoxesPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		checkBoxesPanel.setAlignmentY(Component.TOP_ALIGNMENT);

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

		gameFieldTable.setPreferredSize(new Dimension(700, 700));
		gameFieldTable.setDefaultRenderer(Cell.class, new MyTableCellRenderer());
		gameFieldTable.setCellSelectionEnabled(false);
		gameFieldTable.setFocusable(false);
		gameFieldTable.setGridColor(Color.RED);
		gameFieldTable.setRowHeight(700 / gameFieldTable.getModel().getRowCount());
		panel.add(gameFieldTable);

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

		stopGameButton.setPreferredSize(new Dimension(100, 50));
		stopGameButton.setEnabled(false);
		startGameButton.setPreferredSize(new Dimension(100, 50));
		cleanCellsButton.setPreferredSize(new Dimension(100, 50));
		oneStepButton.setPreferredSize(new Dimension(100, 50));
		infoLabel.setPreferredSize(new Dimension(150, 50));
		infoLabel.setForeground(Color.RED);
		panel.add(cleanCellsButton);
		panel.add(startGameButton);
		panel.add(stopGameButton);
		panel.add(oneStepButton);
		panel.add(infoLabel);
		panel.setBackground(Color.ORANGE);


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

		getContentPane().add(BorderLayout.WEST, panel);
		getContentPane().add(checkBoxesPanel);
		setPreferredSize(new Dimension(1920, 1080));
		pack();
		setVisible(true);
	}
}
