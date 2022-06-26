package TextProcessing.exercise;

import java.util.*;

public class N1ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        List<String> usernames = new ArrayList<>(Arrays.asList(text.split(", ")));
        boolean isValid = true;
        for (String username : usernames) {
            if(username.length()>=3 && username.length()<=16){
                char[] chars = username.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if(chars[i]>=65 && chars[i]<=90 || chars[i]>=97 && chars[i]<=122 || chars[i]==95 || chars[i]==45 || chars[i]>=48 && chars[i]<=57 ){
                    }else{
                        isValid=false;
                    }
                }
                if(isValid) {
                    System.out.println(username);
                }
            }
            isValid=true;
        }


    }
}
