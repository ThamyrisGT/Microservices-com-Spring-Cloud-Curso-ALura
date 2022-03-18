package br.com.alura.microservice.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;

public class CompraService {

	public void realizaCompra(CompraDTO compra) {

		RestTemplate client = new RestTemplate(); // permite fazer requisições do tipo get, post, etc, através de métodos
													
		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
				"http://localhost:8081/info/${compra.getEndereco().getEstado()}", HttpMethod.GET, null,
				InfoFornecedorDTO.class);
		
		System.out.println(exchange.getBody().getEndereco());

	}

}
