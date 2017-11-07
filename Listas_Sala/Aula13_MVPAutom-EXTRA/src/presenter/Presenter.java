package presenter;

import java.util.Observable;

import model.Automat;
import model.Automat.Cell;

public class Presenter extends Observable {
	
	Automat currentAutomat;
	
	public Presenter(Automat automat) {
		currentAutomat = automat;
	}

	public void nextClicked() {
		currentAutomat = currentAutomat.nextState();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void changeAutomatCellState(int xCell,int yCell,int state) {
		currentAutomat.changeCellState(xCell,yCell,state);
		this.setChanged();
		this.notifyObservers();
	}

	// Primeira sugestão de observer que pede para o presenter modificá-lo
	public void updateView(IBoardView view) {
		view.resizeBoardSizeInCellsTo(currentAutomat.width(), currentAutomat.height());
		for(Cell c : currentAutomat) {
			view.changeCell(c.x,c.y,c.state);
		}
	}
	
	// Método opcional para a implementação da segunda sugestão
	public int[][] getEstados() {
		int[][] estados = new int[currentAutomat.width()][currentAutomat.height()];
		for(Cell c : currentAutomat)
			estados[c.x][c.y] = c.state;
		return estados;
	}

}
