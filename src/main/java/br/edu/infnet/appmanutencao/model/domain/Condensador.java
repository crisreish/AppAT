package br.edu.infnet.appmanutencao.model.domain;

import br.edu.infnet.appmanutencao.model.exceptions.NumSerieNuloException;
import br.edu.infnet.appmanutencao.model.exceptions.CentroCustoInvalidoException;

public class Condensador extends Equipamento {

	
	private int numserie;
	private boolean critico;
	private int centrocusto;
		
	public Condensador(String nome, int valor, boolean critico, int numserie, int centrocusto) {
		super(critico, numserie, centrocusto);
	
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.numserie);
		sb.append(";");
		sb.append(this.critico ? "S" : "N");
		sb.append(";");
		sb.append(this.centrocusto);

		return sb.toString();
	}

	@Override
	
	public float calcularValorBruto() throws NumSerieNuloException, CentroCustoInvalidoException {
		
		if(this.numserie <= 0) {
			throw new NumSerieNuloException(" [Condensador] O número de série é inválido: " + this.numserie);
		}
		
		if(this.centrocusto == 0) {
			throw new CentroCustoInvalidoException("[Condensador] Nenhum Centro de Custo válido foi adicionado: ");
		}
		
		float valorNumserie = this.numserie * 1;
		
		float valorCritico = 100;
		if(this.critico) {
			valorCritico = 180;
		}
		
		int valorCentrocusto = this.centrocusto * 1;

		return this.getValor() + valorNumserie + valorCritico + valorCentrocusto;
	}

	private float getValor() {
		
		return 0;
	}

	public int getNumserie() {
		return numserie;
	}
	public void setNumserie(int numserie) {		
		this.numserie = numserie;			
	}

	public boolean isCritico() {
		return critico;
	}

	public void setCritico(boolean critico) {
		this.critico = critico;
	}

	public int getCentrocusto() {
		return centrocusto;
	}

	public void setCentrocusto(int centrocusto) {
		this.centrocusto = centrocusto;
	}
}	
					