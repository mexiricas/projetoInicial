package com.example.projetoInicial.resquest;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class AcessoPostRequestBody {

	@NotNull(message = "nome da pagina acessada nao pode ser null")
	private String pagina;
	private String name;
	private  Long idade;
	private Long countAcessso;
/*	@URL(message = "url not valid")//Teste mais de um field no retorno do handler
	@NotEmpty(message = "a url nao pode ser vazia")
	private String url;*/
}
