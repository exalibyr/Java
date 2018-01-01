package Logic;

public class CellsCreator {
	
	public static Cell[][] createAndSet(int rowCount, int columnCount){
		Cell[][] cells = new Cell[rowCount][columnCount];
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j] = new Cell();
				cells[i][j].setState(false);
			}
		}
		return cells;
	}

	public static Cell[][] createEmpty(int rowCount, int columnCount){
		Cell[][] cells = new Cell[rowCount][columnCount];
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j] = new Cell();
			}
		}
		return cells;
	}
}
