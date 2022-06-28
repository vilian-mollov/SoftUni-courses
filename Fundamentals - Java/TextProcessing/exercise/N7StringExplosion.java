package TextProcessing.exercise;

import java.util.*;

public class N7StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        List<String> list = new ArrayList<>(Arrays.asList(string.split("")));
        int power = 0;
        int start =0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(">")){
                power+=Integer.parseInt(list.get(i+1));
                start = i+1;
                continue;
            }
            if(power >0){
                list.remove(start);
                power--;
                i--;
            }
        }
        for (String s : list) {
            System.out.print(s);
        }

    }
}
