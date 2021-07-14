package br.edu.infnet.appmanutencao.model.domain;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solicitacao {


	private String descricao;
	private LocalDateTime data;
	private Solicitante solicitante;
		
	public Solicitacao() {
		data = LocalDateTime.now();
	}
		
	public Solicitacao(String descricao) {
		this();
		this.descricao = descricao;
	}
	
	public Solicitante getSolicitante() {
		return solicitante;	
	
	}
	public String getSolicitacao() {
		return java.lang.String.format("Solicitação de Manutenção realizada em %s para o solicitante %s.", this.solicitante);
				
		
	}
		
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		return java.lang.String.format("%s;%s;%s", 
				this.descricao, 
				this.data.format(formato),
				this.solicitante);
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getData() {
		return data;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	//public String getSolicitante() {
		//return solicitante;
	//}
	public void setSolicitante(Solicitante solicitante2) {
		this.solicitante = solicitante2;
	}

	public char[] obterSolicitacao() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


