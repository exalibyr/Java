

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private final int ROW_COUNT = 50;
	private final int COLUMN_COUNT = 50;
	
	private Cell[][] cells;
	
	public MyTableModel() {
		// TODO Auto-generated constructor stub
		super();
		setColumnCount(COLUMN_COUNT);
		setRowCount(ROW_COUNT);
		cells = CellsCreator.createAndSet(ROW_COUNT, COLUMN_COUNT);
	}

	@Override
	public Cell getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return cells[rowIndex][columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int column){
		return Cell.class;
	}

	public boolean getCellState(int rowIndex, int columnIndex){
		return cells[rowIndex][columnIndex].isAlive();
	}

	public void setCellState(boolean state, int rowIndex, int columnIndex){
		cells[rowIndex][columnIndex].setState(state);
	}
	
}
