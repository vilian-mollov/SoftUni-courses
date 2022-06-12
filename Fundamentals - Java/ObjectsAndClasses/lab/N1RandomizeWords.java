package ObjectsAndClasses.lab;
import java.util.*;
import java.util.stream.Collectors;

public class N1RandomizeWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listOfWords = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        Random rnd = new Random();
        List<Integer> numbers = new ArrayList<>();
        int countTo = listOfWords.size();
        int count =0;
        for (int i = 0; i < listOfWords.size(); i++) {
            int temp = rnd.nextInt(listOfWords.size());
            if(i==0 && numbers.isEmpty()){
                System.out.println(listOfWords.get(temp));
                count++;
                numbers.add(temp);
            }
            if(!numbers.contains(Integer.valueOf(temp))) {
                System.out.println(listOfWords.get(temp));
                numbers.add(temp);
                count++;
            }else{
                i= count-1;
            }
            if(count==countTo){
                break;
            }
        }


    }
}
