package com.generation.org.br.acoli.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springblogPessoalOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Projeto Acoli")
				.description("Criação de uma rede social que conecta doadores (empresas, pessoas físicas) a pessoas carentes em situação de miséria, usando como base a ODS 2 – Erradicação da Fome.")
				.version("v0.01")
				.license(new License()
						.name("Acoli")
						.url("http://brazil.generation.org/"))
				.contact(new Contact()
						.name("\nCrislania Soares,\nGuilherme de Aquino,\nLiliam da Silva Oliveira,\nMarco Antônio Lima,\nMarcos Vinicius,\nMayara Amorim Moreira\n")
						.url("https://github.com/g5Project")
						.email("liliamsoliver@gmail.com")))
				.externalDocs(new ExternalDocumentation()
						.description("Github")
						.url("https://github.com/g5Project/projeto_acoli"));
	}

	@Bean
	public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto não encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));
			}));
		};
	}

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);
	}
}
