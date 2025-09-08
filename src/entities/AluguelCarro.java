package entities;


import java.time.LocalDateTime;

public class AluguelCarro {

	private LocalDateTime chegada;
	private LocalDateTime saida;
	
	private Veiculo veiculo;
	private Fatura fatura;

	public AluguelCarro() {
	}

	public AluguelCarro(LocalDateTime chegada, LocalDateTime saida, Veiculo veiculo) {
		this.chegada = chegada;
		this.saida = saida;
		this.veiculo = veiculo;
	}

	public LocalDateTime getChegada() {
		return chegada;
	}

	public void setChegada(LocalDateTime chegada) {
		this.chegada = chegada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

}