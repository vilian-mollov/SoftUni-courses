package AssociativeArraysLambdaAndStreamAPI.exercise;

import java.util.*;

public class N5SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> paringLot = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputData = input.split("\\s+");
            switch (inputData[0]){
                case "register":
                    String username = inputData[1];
                    String licensePlateNumber = inputData[2];
                    if(!paringLot.containsKey(username)){
                        paringLot.put(username,licensePlateNumber);
                        System.out.println(username+" registered " + paringLot.get(username)+" successfully");
                    }else{
                        System.out.println("ERROR: already registered with plate number "+ paringLot.get(username));
                    }
                    break;
                case "unregister":
                    String usernameToRemove = inputData[1];
                    String plate = paringLot.get(usernameToRemove);
                    if(plate==null){
                        System.out.println("ERROR: user "+ usernameToRemove +" not found");
                    }else{
                        paringLot.remove(usernameToRemove);
                        System.out.println(usernameToRemove +" unregistered successfully");
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> entry : paringLot.entrySet()) {
            System.out.println(entry.getKey()+" => "+entry.getValue());
        }


    }
}

