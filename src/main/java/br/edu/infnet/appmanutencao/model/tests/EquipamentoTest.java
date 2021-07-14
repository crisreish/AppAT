package br.edu.infnet.appmanutencao.model.tests;

import br.edu.infnet.appmanutencao.model.domain.Caldeira;
import br.edu.infnet.appmanutencao.model.domain.Condensador;
import br.edu.infnet.appmanutencao.model.domain.Tanque;
import br.edu.infnet.appmanutencao.model.exceptions.CentroCustoInvalidoException;
import br.edu.infnet.appmanutencao.model.exceptions.CentroTrabalhoInvalidoException;
import br.edu.infnet.appmanutencao.model.exceptions.EquipEmGarantiaException;
import br.edu.infnet.appmanutencao.model.exceptions.NumSerieNuloException;

public class EquipamentoTest {

	public static void main(int[] args) throws CentroCustoInvalidoException {
		try {
			Caldeira a1 = new Caldeira (" Caldeira Aço Inox ", 1000, true, 5561, 3);
			a1.setCritico(true);
			a1.setNumserie(1000);
			a1.setCiclo(3);
			System.out.printf("CALDEIRA >>> %s", a1.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Caldeira a2 = new Caldeira(" Caldeira Aço Inox ", 1000, false, 5561, 3);
			a2.setCritico(false);
			a2.setNumserie(200);
			a2.setCiclo(2);
			System.out.printf("CALDEIRA >>> %s", a2.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Caldeira a3 = new Caldeira(" Caldeira Aço Inox ", 1000, true, 5561, 3);
			a3.setCritico(true);
			a3.setNumserie(500);
			a3.setCiclo(3);
			System.out.printf("CALDEIRA >>> %s", a3.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Condensador c1 = new Condensador(" Condensador Vapor Super Aquecido ",1000, false, 5561, 2);
			c1.setNumserie(5561);
			c1.setCentrocusto(2);
			c1.setCritico(false);
			System.out.printf("CONDENSADO >>> %s", c1.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Condensador c2 = new Condensador(" Condensador Vapor Super Aquecido ",1000,true, 8085, 4);
			c2.setNumserie(8085);
			c2.setCentrocusto(4);
			c2.setCritico(true);
			System.out.printf("CONDENSADO >>> %s", c2.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Condensador c3 = new Condensador(" Condensador Vapor Super Aquecido ",1000,true, 9707, 6);
			c3.setNumserie(9707);
			c3.setCentrocusto(6);
			c3.setCritico(true);
			System.out.printf("CONDENSADO >>> %s", c3.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Condensador c4 = new Condensador(" Condensador Vapor Super Aquecido ",1000,true, 0216, 5);
			c4.setNumserie(0216);
			c4.setCentrocusto(5);
			c4.setCritico(true);
			System.out.printf("CONDENSADO >>> %s", c4.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Tanque t1 = new Tanque(" Tanque 10000L ", true, 800, 6155, 1);
			t1.setGarantia(true);
			t1.setNumserie(6155);
			t1.setCiclo(1);
			System.out.printf("TANQUE >>> %s", t1.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Tanque t2 = new Tanque(" Tanque 20000L ", false, 1000, 8580, 2);
			t2.setGarantia(false);
			t2.setNumserie(8580);
			t2.setCiclo(2);
			System.out.printf("TANQUE >>> %s", t2.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Tanque t3 = new Tanque(" Tanque 30000L ", false, 1000, 2797, 3);
			t3.setGarantia(false);
			t3.setNumserie(2797);
			t3.setCiclo(3);
			System.out.printf("TANQUE >>> %s", t3.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException e) {
			System.out.println(e.getMessage());
			}
	}
}
