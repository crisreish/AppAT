package br.edu.infnet.appmanutencao.model.domain;

import br.edu.infnet.appmanutencao.model.exceptions.CentroTrabalhoInvalidoException;
import br.edu.infnet.appmanutencao.model.exceptions.CentroCustoInvalidoException;
import br.edu.infnet.appmanutencao.model.exceptions.NumSerieNuloException;
import br.edu.infnet.appmanutencao.model.exceptions.EquipEmGarantiaException;

public abstract class Equipamento {
	private int numserie;
	private int ciclo;
	private boolean garantia;
	
	public Equipamento(String descricao, int numserie, int ciclo, float valor, boolean garantia) {
		this.numserie = numserie;
		this.ciclo = ciclo;
		this.garantia = garantia;
	}
	
	public Equipamento(boolean garantia2, int numserie2, int ciclo2) {
		// TODO Auto-generated constructor stub
	}

	public String obterEquipamento() throws CentroTrabalhoInvalidoException, CentroCustoInvalidoException, NumSerieNuloException, EquipEmGarantiaException {

		StringBuilder sb = new StringBuilder();
		sb.append(this.numserie);
		sb.append(";");
		sb.append(this.calcularValorBruto());
		sb.append("\r\n");
		
		return sb.toString();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.numserie);
		sb.append(";");
		sb.append(this.ciclo);
		sb.append(";");
		sb.append(this.garantia ? "S" : "N");
		
		return sb.toString();
	}
	
	public abstract float calcularValorBruto() throws CentroTrabalhoInvalidoException, CentroCustoInvalidoException, NumSerieNuloException, EquipEmGarantiaException;
	
	public int getDescricao() {
		return numserie;
	}
	public int getCiclo() {
		return ciclo;
	}

	public boolean isGarantia() {
		return garantia;
	}

}
