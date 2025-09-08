package services;

import java.time.Duration;

import entities.AluguelCarro;
import entities.Fatura;

public class ServicoDeAluguel {
	private Double precoHora;
	private Double precoDia;

	private TaxaDeServico taxaServico;

	public ServicoDeAluguel(Double precoHora, Double precoDia, TaxaDeServico taxaServico) {
		this.precoHora = precoHora;
		this.precoDia = precoDia;
		this.taxaServico = taxaServico;
	}

	public void processoFatura(AluguelCarro aluguelCarro) {

		double minutos = Duration.between(aluguelCarro.getChegada(), aluguelCarro.getSaida()).toMinutes();
		double horas = minutos / 60.0;

		double pagamentoBasico;
		if (horas <= 12.0) {
			pagamentoBasico = precoHora * Math.ceil(horas);
		} else {
			pagamentoBasico = precoDia * Math.ceil(horas / 24);
		}

		double taxa = taxaServico.taxa(pagamentoBasico);
		aluguelCarro.setFatura(new Fatura(pagamentoBasico, taxa));
	}

}
