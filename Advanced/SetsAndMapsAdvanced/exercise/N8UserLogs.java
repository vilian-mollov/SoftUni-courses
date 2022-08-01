package SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class N8UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> usersIpsMap = new TreeMap<>();
        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            String[] ipInfo = data[0].split("=");
            String[] userInfo = data[2].split("=");
            String ip = ipInfo[1];
            String user = userInfo[1];

            usersIpsMap.putIfAbsent(user,new LinkedHashMap<>());
            usersIpsMap.get(user).putIfAbsent(ip,0);
            usersIpsMap.get(user).put(ip,usersIpsMap.get(user).get(ip)+1);


            input = scanner.nextLine();
        }

        for (var entry : usersIpsMap.entrySet()) {
            System.out.println(entry.getKey()+":");
            int count = 1;
            for (Map.Entry<String, Integer> ipCountEtr : entry.getValue().entrySet()) {
                int size = entry.getValue().size();
                if(count < size) {
                    System.out.print(ipCountEtr.getKey() + " => " + ipCountEtr.getValue() + ", ");
                    count++;
                }else{
                    System.out.print(ipCountEtr.getKey() + " => " + ipCountEtr.getValue() + ".");
                }
            }
            System.out.println();
        }


    }
}
