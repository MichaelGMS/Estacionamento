package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.AluguelCarro;
import entities.Veiculo;
import services.ServicoDeAluguel;
import services.TaxaServicoBr;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Entre com os dados do aluguel: ");
		System.out.println("Modelo do carro: ");
		String carModelo = sc.nextLine();
		System.out.println("Entrada do veículo (dd/MM/yyyy hh:mm): ");
		LocalDateTime entrada = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("Saída do veículo (dd/MM/yyyy hh:mm): ");
		LocalDateTime saida = LocalDateTime.parse(sc.nextLine(), fmt);

		AluguelCarro ac = new AluguelCarro(entrada, saida, new Veiculo(carModelo));

		System.out.println("Entre com o preço por hora: ");
		double precoHora = sc.nextDouble();
		System.out.println("Entre com o preço por dia: ");
		double precoDia = sc.nextDouble();
		
		ServicoDeAluguel servicoDeAluguel = new ServicoDeAluguel(precoHora, precoDia, new TaxaServicoBr());
		
		servicoDeAluguel.processoFatura(ac);
		
		System.out.println("FATURA: ");
		System.out.println("Pagamento básico: " + String.format("%.2f", ac.getFatura().getPagamentoBasico()));
		System.out.println("Imposto: " + String.format("%.2f", ac.getFatura().getTaxa()));
		System.out.println("Pagamento total: " + String.format("%.2f", ac.getFatura().getPamentoTotal()));
		
		
		sc.close();

	}

}