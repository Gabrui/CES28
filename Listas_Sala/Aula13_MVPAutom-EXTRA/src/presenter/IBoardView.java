package presenter;

import java.util.Observer;

public interface IBoardView extends Observer {

	// binds the view to the Presenter p
	public abstract void init(Presenter p);

	// the view must change its board size
	public abstract void resizeBoardSizeInCellsTo(int xCells, int yCells);

	// the view must change the state of a cell
	public abstract void changeCell(int x, int y, int state);

}