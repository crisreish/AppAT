package br.edu.infnet.appmanutencao.model.domain;

import br.edu.infnet.appmanutencao.model.exceptions.EquipEmGarantiaException;

public class Tanque extends Equipamento {

	public Tanque(String descricao, float valor, boolean garantia, int numserie, int ciclo) {
		super(descricao, numserie, ciclo, valor, garantia);

	}

	private boolean garantia;
	private int numserie;
	private int ciclo;

	public Tanque(String nome, boolean garantia, int valor, int numserie, int ciclo) {
		super(garantia, numserie, ciclo);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.garantia ? "S" : "N");
		sb.append(";");
		sb.append(this.numserie);
		sb.append(";");
		sb.append(this.ciclo);

		return sb.toString();
	}

	@Override
	public float calcularValorBruto() throws EquipEmGarantiaException {

		if(this.numserie == 0) {
			throw new EquipEmGarantiaException(" [Tanque] O Número de Série não foi adicionado! ");
		}
		
		float valorGarantia = 0;
		if(this.garantia) {
			valorGarantia = 10;
		}

		float valorNumserie = this.numserie * 1;

		float valorCiclo = this.ciclo * 1;
		
		return this.getValor() + valorNumserie + valorGarantia + valorCiclo;
	}

	private float getValor() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isGarantia() {
		return garantia;
	}

	public void setGarantia(boolean garantia) {
		this.garantia = garantia;
	}

	public int getNumserie() {
		return numserie;
	}

	public void setNumserie(int numserie) {
		this.numserie = numserie;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
}