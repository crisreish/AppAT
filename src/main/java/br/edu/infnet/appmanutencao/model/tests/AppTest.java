package br.edu.infnet.appmanutencao.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.io.ClassPathResource;

import br.edu.infnet.appmanutencao.model.domain.Caldeira;
import br.edu.infnet.appmanutencao.model.domain.Condensador;
import br.edu.infnet.appmanutencao.model.domain.Solicitacao;
import br.edu.infnet.appmanutencao.model.domain.Solicitante;
import br.edu.infnet.appmanutencao.model.domain.Tanque;
import br.edu.infnet.appmanutencao.model.exceptions.CentroCustoInvalidoException;
import br.edu.infnet.appmanutencao.model.exceptions.CentroTrabalhoInvalidoException;
import br.edu.infnet.appmanutencao.model.exceptions.EquipEmGarantiaException;
import br.edu.infnet.appmanutencao.model.exceptions.NumSerieNuloException;

public class AppTest {
	
	
	public static void main(String[] args) throws CentroCustoInvalidoException {

		String dir = System.getProperty("C:\\Users\\usuário\\Documents\\Infnet\\2021\\Fundamentos JAVA\\appmanutencao");
		String arq = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".txt";

		try {		
			try {
				InputStream resource = new ClassPathResource("static/solicitacao.txt").getInputStream();

				FileWriter fileW = new FileWriter(dir + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				BufferedReader leitura = new BufferedReader(new InputStreamReader(resource));

				String linha = leitura.readLine();

				while (linha != null) {

					String[] campos = linha.split(";");

					switch (campos[0].toUpperCase()) {
					case "0":
						Solicitante solicitantep1 = new Solicitante(campos[2], campos[3], Integer.valueOf(campos[4]));

						Solicitacao p1 = new Solicitacao();
						p1.setDescricao(campos[1]);
						p1.setSolicitante(solicitantep1);

						escrita.write(p1.obterSolicitacao());
						
						break;

					case "A":
						Caldeira a1 = new Caldeira(campos[1], Integer.valueOf(campos[2]), "S".equalsIgnoreCase(campos[4]), Integer.valueOf(campos[5]), Integer.valueOf(campos[6]));
						a1.setCritico("S".equalsIgnoreCase(campos[4]));
						a1.setNumserie(Integer.valueOf(campos[2]));
						a1.setCiclo(Integer.valueOf(campos[6]));

						escrita.write(a1.obterEquipamento());

						break;

					case "C":
						Condensador c1 = new Condensador(campos[1], Integer.valueOf(campos[2]), "S".equalsIgnoreCase(campos[4]), Integer.valueOf(campos[5]), Integer.valueOf(campos[6]));
						c1.setNumserie(Integer.valueOf(campos[5]));
						c1.setCentrocusto(Integer.valueOf(campos[6]));
						c1.setCritico("N".equalsIgnoreCase(campos[4]));

						escrita.write(c1.obterEquipamento());

						break;

					case "T":
						Tanque t1 = new Tanque(campos[1], "S".equalsIgnoreCase(campos[2]), Integer.valueOf(campos[3]), Integer.valueOf(campos[4]), Integer.valueOf(campos[6]));
						t1.setCiclo(Integer.valueOf(campos[4]));
						t1.setGarantia("S".equalsIgnoreCase(campos[5]));
						t1.setNumserie(Integer.valueOf(campos[6]));
						
	
						escrita.write(t1.obterEquipamento());

						break;

					default:
						System.out.println("Entrada inválida!!!");
						break;
					}

					linha = leitura.readLine();
				}

				leitura.close();
				escrita.close();
				fileW.close();
			} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException | IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Processamento finalizado: "+(dir + arq)+"!!!");
		}
	}
}