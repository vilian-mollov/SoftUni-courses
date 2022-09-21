package StackAndQueue.lab;

import java.util.*;

public class N5HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(children));
        int position = 0;
        while (queue.size() != 1) {
            position++;
            if (position == n) {
                position = 0;
                System.out.println("Removed " + queue.poll());
                continue;
            }

            String child = queue.poll();
            queue.add(child);
        }

        System.out.println("Last is " + queue.poll());


    }

}
