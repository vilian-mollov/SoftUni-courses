package List.lab;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N4ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();
        List<Integer> listArr = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    String commands = scanner.nextLine();
        while(!commands.equals("end")){
            String[] commandsSplitted = commands.split(" ");
            switch(commandsSplitted[0]){
                case "Add":
                    listArr.add(Integer.parseInt(commandsSplitted[1]));
                    break;
                case "Remove":
                    listArr.remove((Integer) Integer.parseInt(commandsSplitted[1]));
                    break;
                case "RemoveAt":
                    listArr.remove(Integer.parseInt(commandsSplitted[1]));
                    break;
                case "Insert":
                    listArr.add(Integer.parseInt(commandsSplitted[2]),Integer.parseInt(commandsSplitted[1]));
                    break;
            }
            commands = scanner.nextLine();
        }
        for (Integer integer : listArr) {
            System.out.print(integer+" ");
        }

    }
}
