package br.edu.infnet.appmanutencao.model.tests;

import br.edu.infnet.appmanutencao.model.domain.Solicitante;

public class SolicitanteTest {

	public static void main(String[] args) {
		
		Solicitante s1 = new Solicitante("COMPEERJ","REF5561",13565001);
		System.out.println("Solicitante: " + s1);
	}
}
