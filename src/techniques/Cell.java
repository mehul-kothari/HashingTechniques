package techniques;

public class Cell {
	int cellKey;
	int cellValue;
	Cell next;
	public Cell(int key,int value)
	{
		cellKey=key;
		cellValue=value;
		next=null;
	}
	public Cell getNext() {
		return next;
	}
	public void setNext(Cell next) {
		this.next = next;
	}
	public int getCellKey() {
		return cellKey;
	}
	public void setCellKey(int cellKey) {
		this.cellKey = cellKey;
	}
	public int getCellValue() {
		return cellValue;
	}
	public void setCellValue(int cellValue) {
		this.cellValue = cellValue;
	}

}
