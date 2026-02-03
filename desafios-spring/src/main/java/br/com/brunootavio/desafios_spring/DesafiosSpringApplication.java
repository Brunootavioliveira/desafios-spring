package br.com.brunootavio.desafios_spring;

import br.com.brunootavio.desafios_spring.model.Tarefa;
import br.com.brunootavio.desafios_spring.service.ConverterDados;
import br.com.brunootavio.desafios_spring.service.Pessoa;
import br.com.brunootavio.desafios_spring.service.PrimoConta;
import br.com.brunootavio.desafios_spring.service.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class DesafiosSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafiosSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Tarefa tarefa = new Tarefa("Curso Java", true, "Bruno Otavio");
//
//		ObjectMapper mapper = new ObjectMapper();
//
//		try {
//			//Converter o objeto Java em JSON e grava no arquivo tarefa.json
//			mapper.writeValue(new File("Tarefa.json"), tarefa);
//
//			System.out.println("Arquivo tarefa.json criado com sucesso!");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		ConverterDados converter = new ConverterDados();
//
//		Tarefa dados = converter.obterDados(new File("Tarefa.json"), Tarefa.class);
//		System.out.println(dados);

		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);

		nums.stream()
				.filter(n -> n % 2 == 0)
				.forEach(System.out::println);

		List<String> palavras = Arrays.asList("java", "lambda", "java","stream", "lambda");

		palavras.stream()
				.map(p -> p.toUpperCase())
				.forEach(System.out::println);

		List<Integer> resultado = nums.stream()
				.filter(n -> n % 2 == 1)
				.map(n -> n * 2)
				.collect(Collectors.toList());

		System.out.println(resultado);

		palavras.stream()
				.distinct() //remove palavras iguais e deixa uma
				.forEach(System.out::println);

		List<List<Integer>> listaNums = Arrays.asList(
				Arrays.asList(1,2,3,4),
				Arrays.asList(5,6,7,8),
				Arrays.asList(9,10,11,12)
		);

		PrimoConta ehPrimo = new PrimoConta();

		List<Integer> listaNova = listaNums.stream()
				.flatMap(l -> l.stream())
				.filter(l -> ehPrimo.isPrimo(l))
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		System.out.println(listaNova);

		List<Pessoa> pessoas = Arrays.asList(
				new Pessoa("Fernando", 20),
				new Pessoa("Julia", 17),
				new Pessoa("Bruno", 19)
		);

		List<String> pessoaNova = pessoas.stream()
				.filter(p -> p.getIdade() >= 18)
				.map(p -> p.getName())
				.sorted()
				.toList();

		System.out.println(pessoaNova);

		List<Produto> produtos = Arrays.asList(
				new Produto("Smartphone", 800.0, "Eletrônicos"),
				new Produto("Notebook", 1500.0, "Eletrônicos"),
				new Produto("Teclado", 200.0, "Eletrônicos"),
				new Produto("Cadeira", 300.0, "Móveis"),
				new Produto("Monitor", 900.0, "Eletrônicos"),
				new Produto("Mesa", 700.0, "Móveis")
		);

		List<Produto> produtoList = produtos.stream()
				.filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos") && p.getPreco() <= 1000.0)
				.sorted(Comparator.comparing(Produto::getPreco))
				.limit(2)
				.toList();
		System.out.println(produtoList);


	}
}
