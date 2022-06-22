package AssociativeArraysLambdaAndStreamAPI.exercise;

import java.util.*;

public class N8CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> companyEmployees = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("End")){
            String[] inputData = input.split(" -> ");
            String company = inputData[0];
            String employeeId = inputData[1];
            List<String> value = companyEmployees.get(company);
            if(value==null){
                companyEmployees.put(company,new ArrayList<>());
            }
            if(!companyEmployees.get(company).contains(employeeId)){
                companyEmployees.get(company).add(employeeId);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : companyEmployees.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println("-- "+entry.getValue().get(i));
            }
        }

    }
}
