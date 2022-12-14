package MyExam;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String[]> mou = new ArrayDeque<>();
       String[] viuhren = {"Viuhren","80"};
       String[] kutelo = {"Kutelo","90"};
       String[] banskiSuhodol = {"Banski Suhodol","100"};
       String[] polezhan = {"Polezhan","60"};
       String[] kamenitza = {"Kamenitza","70"};
        mou.offer(viuhren);
        mou.offer(kutelo);
        mou.offer(banskiSuhodol);
        mou.offer(polezhan);
        mou.offer(kamenitza);

        ArrayDeque<Integer> food = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(food::push);

        ArrayDeque<Integer> stamina = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        List<String> mountains = new ArrayList<>();


        while (!food.isEmpty() && !stamina.isEmpty()) {

            int theSum = food.peek() + stamina.peek();
            assert mou.peek() != null;
            int mountainHigh = Integer.parseInt(mou.peek()[1]);
            String theMountain = mou.peek()[0];

            if(theSum >= mountainHigh){
                mountains.add(theMountain);
                mou.poll();
            }
            food.pop();
            stamina.poll();
            if(mou.isEmpty()){
                break;
            }
        }

        if (mountains.size() == 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (mountains.size() > 0) {
            System.out.println("Conquered peaks:");
            for (String mountain : mountains) {
                System.out.println(mountain);
            }
        }


    }
}
