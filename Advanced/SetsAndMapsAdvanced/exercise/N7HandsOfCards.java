package SetsAndMapsAdvanced.exercise;

import java.util.*;

public class N7HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> playersDecksMap = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] userData = input.split(": ");
            String name = userData[0];
            String cardsInLine = userData[1];
            String[] cards = cardsInLine.split(", ");

            playersDecksMap.putIfAbsent(name,new HashSet<>());

            addCardsToPlayersDecksMap(playersDecksMap, name, cards);

            input = scanner.nextLine();
        }

        for (var entry : playersDecksMap.entrySet()) {
            System.out.print(entry.getKey()+": ");
            int sum = 0;
            sum = calculateSum(entry.getValue());
            System.out.println(sum);
        }


    }

    private static void addCardsToPlayersDecksMap(Map<String, Set<String>> playersDecksMap, String name, String[] cards) {
        for (int i = 0; i < cards.length; i++) {
            playersDecksMap.get(name).add(cards[i]);
        }
    }
    public static int calculateSum(Set<String> cards){
        int sum =0;
        for (String card : cards) {
            StringBuilder sb = new StringBuilder(card);
            String color = sb.substring(sb.length()-1);
            String theCard = sb.substring(0,sb.length()-1);

            switch(theCard){
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "10":
                    if(color.equals("S")){
                        sum+= Integer.parseInt(theCard) * 4;
                    }else if(color.equals("H")){
                        sum+= Integer.parseInt(theCard) * 3;
                    }else if(color.equals("D")){
                        sum+= Integer.parseInt(theCard) * 2;
                    }else if(color.equals("C")){
                        sum+= Integer.parseInt(theCard);
                    }
                    break;
                case "J":
                    if(color.equals("S")){
                        sum+= 11 * 4;
                    }else if(color.equals("H")){
                        sum+= 11 * 3;
                    }else if(color.equals("D")){
                        sum+= 11 * 2;
                    }else if(color.equals("C")){
                        sum+= 11;
                    }
                    break;
                case "Q":
                    if(color.equals("S")){
                        sum+= 12 * 4;
                    }else if(color.equals("H")){
                        sum+= 12 * 3;
                    }else if(color.equals("D")){
                        sum+= 12 * 2;
                    }else if(color.equals("C")){
                        sum+= 12;
                    }
                    break;
                case "K":
                    if(color.equals("S")){
                        sum+= 13 * 4;
                    }else if(color.equals("H")){
                        sum+= 13 * 3;
                    }else if(color.equals("D")){
                        sum+= 13 * 2;
                    }else if(color.equals("C")){
                        sum+= 13;
                    }
                    break;
                case "A":
                    if(color.equals("S")){
                        sum+= 14 * 4;
                    }else if(color.equals("H")){
                        sum+= 14 * 3;
                    }else if(color.equals("D")){
                        sum+= 14 * 2;
                    }else if(color.equals("C")){
                        sum+= 14;
                    }
                    break;
            }
        }
        return sum;
    }
}
