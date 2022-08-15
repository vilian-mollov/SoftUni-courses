package Exam;

import java.util.*;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, List<Integer>> soldiersHealthEnergyMap = new LinkedHashMap<>();

        while (!input.equals("Results")){
            String[] commandsData = input.split(":");
            String command = commandsData[0];
            String username = commandsData[1];

            switch (command){
                case  "Add":
                    int healthToAdd = Integer.parseInt(commandsData[2]);
                    int energyToAdd = Integer.parseInt(commandsData[3]);

                    if(soldiersHealthEnergyMap.containsKey(username)){
                        int totalHealth = soldiersHealthEnergyMap.get(username).get(0) + healthToAdd;
                        soldiersHealthEnergyMap.get(username).set(0,totalHealth);


                    }else{
                        soldiersHealthEnergyMap.put(username,new ArrayList<>());
                        soldiersHealthEnergyMap.get(username).add(healthToAdd);
                        soldiersHealthEnergyMap.get(username).add(energyToAdd);
                    }

                    break;
                case  "Attack":
                    String defender = commandsData[2];
                    int damage = Integer.parseInt(commandsData[3]);
                    boolean alive = soldiersHealthEnergyMap.containsKey(username) && soldiersHealthEnergyMap.containsKey(defender);

                    if(alive){
                        int defenderHealth = soldiersHealthEnergyMap.get(defender).get(0);
                        defenderHealth = defenderHealth - damage;
                        if(defenderHealth <= 0){
                            System.out.println(defender+" was disqualified!");
                            soldiersHealthEnergyMap.remove(defender);
                        }else{
                            soldiersHealthEnergyMap.get(defender).set(0,defenderHealth);
                        }

                        int attackersEnergy = soldiersHealthEnergyMap.get(username).get(1);
                        attackersEnergy = attackersEnergy - 1;
                        if(attackersEnergy<=0){
                            System.out.println(username+" was disqualified!");
                            soldiersHealthEnergyMap.remove(username);
                        }else{
                            soldiersHealthEnergyMap.get(username).set(1,attackersEnergy);
                        }

                    }

                    break;
                case  "Delete":

                        if(username.equals("All")){
                            soldiersHealthEnergyMap.clear();
                        }

                            soldiersHealthEnergyMap.remove(username);
                    break;
            }


            input = scanner.nextLine();
        }

            int count = soldiersHealthEnergyMap.size();
            System.out.println("People count: "+count);

        for (Map.Entry<String, List<Integer>> entry : soldiersHealthEnergyMap.entrySet()) {
            System.out.println(entry.getKey()+" - " + entry.getValue().get(0) + " - " + entry.getValue().get(1));
        }




    }
}
