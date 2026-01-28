package br.com.brunootavio.desafios_spring;

import br.com.brunootavio.desafios_spring.model.Tarefa;
import br.com.brunootavio.desafios_spring.service.ConverterDados;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class DesafiosSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafiosSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tarefa tarefa = new Tarefa("Curso Java", true, "Bruno Otavio");

		ObjectMapper mapper = new ObjectMapper();

		try {
			//Converter o objeto Java em JSON e grava no arquivo tarefa.json
			mapper.writeValue(new File("Tarefa.json"), tarefa);

			System.out.println("Arquivo tarefa.json criado com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ConverterDados converter = new ConverterDados();

		Tarefa dados = converter.obterDados(new File("Tarefa.json"), Tarefa.class);
		System.out.println(dados);

	}
}
