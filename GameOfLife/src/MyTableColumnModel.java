import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class MyTableColumnModel extends DefaultTableColumnModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int COLUMN_COUNT = 50;
	
	public MyTableColumnModel() {
		// TODO Auto-generated constructor stub
		super();
		totalColumnWidth = 700 / COLUMN_COUNT;
		for(int i = 0; i < COLUMN_COUNT; i++) {
			tableColumns.add(new TableColumn(i, getTotalColumnWidth()));
		}
		
	}
	
}
