package br.com.alura.microservice.loja.controller.dto;

public class InfoPedidoDTO {

	private long id;
	private Integer tempoDePreparo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}
	public void setTempo(Integer tempo) {
		this.tempoDePreparo = tempo;
	}
	
	
}
