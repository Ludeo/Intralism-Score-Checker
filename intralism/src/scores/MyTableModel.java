package scores;

import java.io.IOException;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    transient Object[][] rows;
    String[] columns = { "Map Name", "Score", "Acc", "Miss", "MyPoints", "MaxPoints", "Difference", "Broken?" };

    public MyTableModel(String link) throws IOException {
	rows = Allscores.getAllScores(link);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
	switch (columnIndex) {
	case 0:
	    return String.class;
	case 1:
	    return Integer.class;
	case 2:
	    return Double.class;
	case 3:
	    return Integer.class;
	case 4:
	    return Double.class;
	case 5:
	    return Double.class;
	case 6:
	    return Double.class;
	case 7:
	    return String.class;
	default:
	    return Object.class;
	}
    }

    @Override
    public int getRowCount() {
	return rows.length;
    }

    @Override
    public int getColumnCount() {
	return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	return rows[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int col) {
	return columns[col];
    }

}
