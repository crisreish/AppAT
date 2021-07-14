package br.edu.infnet.appmanutencao.model.domain;

import br.edu.infnet.appmanutencao.model.exceptions.NumSerieNuloException;

public class Caldeira extends Equipamento {

	private int numserie;
	private boolean critico;
	private int ciclo;

	public Caldeira(String nome, int valor, boolean garantia, int numserie, int ciclo) {
		super(garantia, numserie, ciclo);
		
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
		sb.append(this.ciclo);

		return sb.toString();
	}

	@Override
	public float calcularValorBruto() throws NumSerieNuloException {
		
		if(this.numserie == 0) {
			throw new NumSerieNuloException(" [Caldeira] O número de série está inválido: " + this.numserie);
		}
				
		float valorCritico = 10;
		if(this.critico) {
			valorCritico = 500;
		}
		
		int valorCiclo = this.ciclo * 2;
		
		return this.getValor() + getNumserie() + valorCritico + valorCiclo;
	}

	private int getValor() {
		// TODO Auto-generated method stub
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

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
}

