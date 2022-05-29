package List.lab;

import java.util.*;

public class N7ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
List<String> listArr = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            String input = scanner.nextLine();
            listArr.add(input);
        }
        Collections.sort(listArr);

        for (int i = 1; i <= listArr.size(); i++) {
            System.out.println(i+"."+listArr.get(i-1));
        }

    }
}
