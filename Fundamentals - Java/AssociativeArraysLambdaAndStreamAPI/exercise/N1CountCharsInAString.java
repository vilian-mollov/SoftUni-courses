package AssociativeArraysLambdaAndStreamAPI.exercise;
import  java.util.*;
public class N1CountCharsInAString {
    public static void main(String[] args) {
       List< String> text = Arrays.asList(new Scanner(System.in).nextLine().split("\\s+"));
       List<String> sequenceOfChars =new ArrayList<>();

        collectCharsInList(text, sequenceOfChars);

        Map<String, Integer> myMap = new LinkedHashMap<>();
        for (String aChar : sequenceOfChars) {
            if(!myMap.containsKey(aChar)){
                myMap.put(aChar,0);
            }
            myMap.put(aChar,myMap.get(aChar)+1);
        }

        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }


    }

    private static void collectCharsInList(List<String> text, List<String> sequenceOfChars) {
        for (String s : text) {
            for (int i = 0; i < s.length(); i++) {
                sequenceOfChars.add(s.charAt(i)+"");
            }
        }
    }
}
