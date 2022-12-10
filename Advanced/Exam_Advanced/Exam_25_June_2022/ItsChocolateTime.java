package Exam_25_June_2022;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    private static ArrayDeque<Double> milkQueue = new ArrayDeque<>();
    private static ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
    private static Map<String, Integer> chocolatesProduced;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        milkQueue = getMilkQueue(scanner);
        cacaoStack = getCacaoStack(scanner);
        chocolatesProduced = new LinkedHashMap<>();


        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double firstMilk = milkQueue.peek();
            double lastCacao = cacaoStack.peek();
            double cacaoPercentage = lastCacao / (firstMilk + lastCacao);
            int percentage = (int)(cacaoPercentage * 100);

            switch (percentage) {

                case 30:
                    makeChocolate("Milk Chocolate");
                    //milk chocolate == 30%
                    break;
                case 50:
                    makeChocolate("Dark Chocolate");
                    //dark chocolate == 50%
                    break;
                case 100:
                    makeChocolate("Baking Chocolate");
                    //baking chocolate == 100%
                    break;
                default:
                    cacaoStack.pop();
                    milkQueue.poll();
                    milkQueue.add(firstMilk + 10);
            }

        }

        // print if successful task to cook chocolate
        if(chocolatesProduced.size() >= 3){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else{
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }


        for (Map.Entry<String, Integer> entry : chocolatesProduced.entrySet()) {
            System.out.printf("# %s --> %d%n",entry.getKey(),entry.getValue());
        }

    }

    private static void makeChocolate(String chocolate) {
        int value;
        chocolatesProduced.putIfAbsent(chocolate, 0);
        value  = chocolatesProduced.get(chocolate);
        chocolatesProduced.put(chocolate,value + 1);
        milkQueue.poll();
        cacaoStack.pop();
    }

    private static ArrayDeque<Double> getMilkQueue(Scanner scanner) {
        ArrayDeque<Double> milkQueue;
        milkQueue = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));
        return milkQueue;
    }

    private static ArrayDeque<Double> getCacaoStack(Scanner scanner) {
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoStack::push);
        return cacaoStack;
    }

}
