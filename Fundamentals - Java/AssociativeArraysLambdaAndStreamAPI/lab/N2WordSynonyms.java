package AssociativeArraysLambdaAndStreamAPI.lab;

import java.util.*;

public class N2WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> wordsSynonymsMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            List<String> listOfValues  = wordsSynonymsMap.get(word);
            if(listOfValues==null){
                listOfValues=new ArrayList<>();
                wordsSynonymsMap.put(word,listOfValues);
            }
                listOfValues.add(synonym);

        }
        for (Map.Entry<String, List<String>> entry : wordsSynonymsMap.entrySet()) {
            System.out.print(entry.getKey()+" - ");
            for (int i =0;i< entry.getValue().size();i++) {
                if(i==entry.getValue().size()-1){
                    System.out.print(entry.getValue().get(i));
                }else{
                    System.out.print(entry.getValue().get(i)+", ");
                }
            }
            System.out.println();
        }

    }
}
