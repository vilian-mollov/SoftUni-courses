package AssociativeArraysLambdaAndStreamAPI.exercise;

import java.util.*;

public class N9ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,List<String>> sidesAndUsers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while(!input.equals("Lumpawaroo")){
            boolean sideCheck;
            sideCheck = checkCommand(input);
            String[] inputData;
            String command;
            String side = "";
            String user = "";
            if(sideCheck){
                inputData = input.split("\\s+\\|\\s+");
                command = "|";
                side = inputData[0];
                user = inputData[1];
            }else{
                inputData = input.split("\\s+->\\s+");
                command = "->";
                user = inputData[0];
                side = inputData[1];
            }


        switch(command){
            case "|":
                List<String> value = sidesAndUsers.get(side);
                List<String> checkUser = new ArrayList<>(Arrays.asList(user));
                boolean itHasAUser= false;
                itHasAUser = checkForUser(sidesAndUsers, user, itHasAUser);

                if(value==null && !itHasAUser){
                    sidesAndUsers.put(side,checkUser);
                }else if(!itHasAUser){
                    sidesAndUsers.get(side).add(user);
                }

                break;
            case "->":
                List<String> valueIs = sidesAndUsers.get(side);
                List<String> checkForUser = new ArrayList<>(Arrays.asList(user));
                boolean itHasThisUser= false;
                itHasThisUser = checkForUser(sidesAndUsers, user, itHasThisUser);

                 if(itHasThisUser && valueIs != null){
                   //change their side
                     int indexOfUser =0;
                     String keyOfUser = "";
                     for (Map.Entry<String, List<String>> entry : sidesAndUsers.entrySet()) {
                         for (int i = 0; i < entry.getValue().size(); i++) {
                             if(entry.getValue().get(i).equals(user)){
                                 indexOfUser=i;
                                 keyOfUser=entry.getKey();
                                 break;
                             }
                         }
                     }
                     sidesAndUsers.get(keyOfUser).remove(indexOfUser);
                     sidesAndUsers.get(side).add(user);
                     System.out.printf("%s joins the %s side!%n",user,side);
                }else if(valueIs != null) {
                     sidesAndUsers.get(side).add(user);
                     System.out.printf("%s joins the %s side!%n",user,side);
                     //add the force user to the corresponding force side.
                 }
                 if(!itHasThisUser && valueIs ==null){
                     //create new force side and add the force user to the corresponding side.
                     sidesAndUsers.put(side,checkForUser);
                     System.out.printf("%s joins the %s side!%n",user,side);
                 }
                break;

        }
//If you receive a "force_user -> force_side":
//If there is such force user already -> change their side.
//If there is no such force user in any force side -> add the force user to the corresponding force side.
//If there is no such force user and no such force side -> create new force side and add the force user to the corresponding side.

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : sidesAndUsers.entrySet()) {
            if(entry.getValue().size()>0) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.printf("! %s%n", entry.getValue().get(i));
                }
            }
        }


    }

    private static boolean checkForUser(Map<String, List<String>> sidesAndUsers, String user, boolean itHasAUser) {
        for (Map.Entry<String, List<String>> entry : sidesAndUsers.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if(entry.getValue().get(i).equals(user)){
                                itHasAUser =true;
                    return itHasAUser;
                }
            }
        }
        return itHasAUser;
    }

    private static boolean checkCommand(String input) {
        boolean commandCheck = false;
        if(input.contains(" | ")){
            commandCheck = true;
        }else if(input.contains(" -> ")){
            commandCheck=false;
        }
        return commandCheck;
    }

}
