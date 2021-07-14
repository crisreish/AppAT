package br.edu.infnet.appmanutencao.model.tests;

import br.edu.infnet.appmanutencao.model.domain.Solicitacao;
import br.edu.infnet.appmanutencao.model.domain.Solicitante;

public class SolicitacaoTest {

	public static void main(String[] args) {
		
		Solicitante solicitante = new Solicitante("COMPERJ", "REF5561", 13565001);
		
		Solicitacao p1 = new Solicitacao();
		p1.setDescricao("Outro pedido");
		p1.setSolicitante(solicitante);
		System.out.println("Pedido: " + p1);

		Solicitacao p2 = new Solicitacao("Solicitacao COMPEERJ");
		p2.setSolicitante(null);
		System.out.println("Solicitacao: " + p2);
	}


}
