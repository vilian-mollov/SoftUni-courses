package List.exercise;

import java.math.BigInteger;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N9PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputOfPokemonDistances = scanner.nextLine();
        List<BigInteger> pokemonList = Arrays.stream(inputOfPokemonDistances.split("\\s+"))
                .map(BigInteger::new).collect(Collectors.toList());

        BigInteger removedElement = new BigInteger("0");
        BigInteger sum = new BigInteger("0");
        while (!pokemonList.isEmpty()) {
            int theIndex = Integer.parseInt(scanner.nextLine());
            if (theIndex >= 0 && theIndex < pokemonList.size()) {
                removedElement = pokemonList.get(theIndex);
                sum = sum.add(removedElement);
                pokemonList.remove(theIndex);
                for (int i = 0; i < pokemonList.size(); i++) {
                    movePokemonPositions(pokemonList, removedElement, i);

                }
            }else if(theIndex <0){
                removedElement= pokemonList.get(0);
                sum = sum.add(removedElement);
                pokemonList.remove(0);
                pokemonList.add(0,pokemonList.get(pokemonList.size()-1));
                for (int i = 0; i < pokemonList.size(); i++) {
                    movePokemonPositions(pokemonList, removedElement, i);
                }
            }else{
                removedElement= pokemonList.get(pokemonList.size()-1);
                sum = sum.add(removedElement);
                pokemonList.remove(pokemonList.size()-1);
                pokemonList.add(pokemonList.get(0));
                for (int i = 0; i < pokemonList.size(); i++) {
                    movePokemonPositions(pokemonList, removedElement, i);
                }

            }


        }

        System.out.println(sum);
    }

    private static void movePokemonPositions(List<BigInteger> pokemonList, BigInteger removedElement, int i) {
        if(pokemonList.get(i).compareTo(removedElement) <= 0){
            pokemonList.set(i, pokemonList.get(i).add(removedElement));
        }else{
            pokemonList.set(i, pokemonList.get(i).subtract(removedElement));
        }
    }


}
