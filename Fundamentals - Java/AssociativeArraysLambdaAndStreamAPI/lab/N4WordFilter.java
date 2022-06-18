package AssociativeArraysLambdaAndStreamAPI.lab;
import java.util.*;
import java.util.stream.Collectors;

public class N4WordFilter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(new Scanner(System.in).nextLine().split("\\s+"));

        List<String> result = words.stream()
                .filter(s-> s.length()%2==0)
                .collect(Collectors.toList());

        for (String s : result) {
            System.out.println(s);
        }

    }
}
