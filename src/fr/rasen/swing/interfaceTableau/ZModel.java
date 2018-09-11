package fr.rasen.swing.interfaceTableau;

import javax.swing.table.AbstractTableModel;

class ZModel extends AbstractTableModel{

	private Object[][] data;
	private String[] title;

	public ZModel(Object[][] data, String[] title){
		this.data = data;
		this.title = title;
	}

	public String getColumnName(int col) {
		return this.title[col];
	}

	public int getColumnCount() {
		return this.title.length;
	}

	public int getRowCount() {
		return this.data.length;
	}

	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}

	public void setValueAt(Object value, int row, int col) {
		if(!this.getColumnName(col).equals("Age")
				&& !this.getColumnName(col).equals("Suppression"))
			this.data[row][col] = value;
	}

	public Class getColumnClass(int col){
		return this.data[0][col].getClass();
	}

	public void removeRow(int position){
		int indice = 0, indice2 = 0;
		nbRow = this.getRowCount()-1, nbCol = this.getColumnCount();
		Object temp[][] = new Object[nbRow][nbCol];

		for(Object[] value : this.data){
			if(indice != position){
				temp[indice2++] = value;
			}
			System.out.println("Indice = " + indice);
			indice++;
		}
		this.data = temp;
		temp = null;
		this.fireTableDataChanged();
	}

	public void addRow(Object[] data){
		int indice = 0, nbRow = this.getRowCount(), nbCol = this.getColumnCount();

		Object temp[][] = this.data;
		this.data = new Object[nbRow+1][nbCol];

		for(Object[] value : temp)
			this.data[indice++] = value;


		this.data[indice] = data;
		temp = null;
		this.fireTableDataChanged();
	}


	public boolean isCellEditable(int row, int col){
		return true;
	}
}
