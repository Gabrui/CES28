package view;

import java.util.Observer;
import presenter.Presenter;

public interface IView extends Observer {
	public void setMetodoInterpolacao(String interpolacao);
	public void setPontoInterpolacao(double valor);
	public void setArquivoDados(String arquivoDados);
	public void init(Presenter presenter);
}
