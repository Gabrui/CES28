package view;

import java.util.Observable;
import java.util.Scanner;

import presenter.IBoardView;
import presenter.Presenter;

public class ViewConsole implements IBoardView {
	private int[][] celulas;
	
	public ViewConsole() {
	}

	@Override
	public void update(Observable o, Object arg) {
		//((Presenter) o).updateView(this);
		// Novo método para não ficar repetindo
		celulas = ((Presenter) o).getEstados();
		imprimeCelulas();
	}

	@Override
	public void init(final Presenter p) {
		p.addObserver(this);

		new Thread(new Runnable() {
			@Override
			
			public void run() {
			    Scanner in = new Scanner(System.in);
			    System.out.println("Instruções: comandos reconheciveis 'next', 'mudar x y estado' ou CTRL+Z");
				while(in.hasNextLine()) {
					String entrada = in.nextLine();
					if (entrada.equals("next"))
						p.nextClicked();
					else if (entrada.startsWith("mudar")) {
						String[] valores = entrada.split(" ");
						if (valores.length != 4)
							System.out.println("Entrada não reconhecida, digite devem ser separados por um espaço");
						else
							p.changeAutomatCellState(Integer.valueOf(valores[1]), Integer.valueOf(valores[2]), Integer.valueOf(valores[3]));
					} else {
						System.out.println("Comando não reconhecido");
					}
				}
				System.out.println("Fim do programa");
				in.close();
			}
		}).start();
	}

	@Override
	public void resizeBoardSizeInCellsTo(int xCells, int yCells) {
		celulas = new int[xCells][yCells];
	}

	@Override
	public void changeCell(int x, int y, int state) {
		celulas[x][y] = state;
		imprimeCelulas();
	}
	
	private void imprimeCelulas() {
		System.out.println("-----------------------------");
		for (int[] linha : celulas) {
			String saida = "";
			for (int i:linha)
				saida += i + " ";
			System.out.println(saida);
		}
		System.out.println("-----------------------------");
	}

}
