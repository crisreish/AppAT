package br.edu.infnet.appmanutencao.model.domain;

public class Solicitante {

	private String solicitante;
	private String centrotrabalho;
	private int centrocusto;

	public Solicitante(String solicitante, String centrotrabalho, int centrocusto) {
		this.solicitante = solicitante;
		this.centrotrabalho = centrotrabalho;
		this.centrocusto = centrocusto;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.solicitante);
		sb.append(";");
		sb.append(this.centrotrabalho);
		sb.append(";");
		sb.append(this.centrocusto);

		return sb.toString();
	}

	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String nome) {
		this.solicitante = nome;
	}

	public String getCentrotrabalho() {
		return centrotrabalho;
	}

	public void setCentrotrabalho(String centrotrabalho) {
		this.centrotrabalho = centrotrabalho;
	}

	public int getCentrocusto() {
		return centrocusto;
	}

	public void setCentrocusto(int centrocusto) {
		this.centrocusto = centrocusto;
	}
}

