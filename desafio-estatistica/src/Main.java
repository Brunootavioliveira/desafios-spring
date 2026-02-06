import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

        IntSummaryStatistics est = numeros.stream()
                .mapToInt(n -> n) //Ele transforma o Stream normal (Stream<Integer>) em um Stream primitivo de int (IntStream)
                .summaryStatistics();
        System.out.println("Maior número: " + est.getMax());

        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");

        Map<Integer, List<String>> resultado = palavras.stream()
                .collect(Collectors.groupingBy(p -> p.length()));
        System.out.println(resultado);

        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");

        String resultado2 = nomes.stream()
                .collect(Collectors.joining(", ")); //joining: Junta tudo e coloca ", " entre as Strings
        System.out.println(resultado2);

        List<Integer> numeros3 = Arrays.asList(1, 2, 3, 4, 5, 6);

        int soma = numeros3.stream()
                .filter(q -> q % 2 == 0)
                .mapToInt(q -> q * q)
                .sum();
        System.out.println(soma);

        List<Integer> numerosSeparar = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> separou = numerosSeparar.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 ==0));
        System.out.println(separou);
    }
}