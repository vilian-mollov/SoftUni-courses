package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class A12TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
String city =scanner.nextLine();
double volumeOfSales = Double.parseDouble(scanner.nextLine());
switch (city){
    case "Sofia":
    case "Varna":
    case "Plovdiv":
    case "Kaspichan":
    case "Bourgas":
        break;
    default:
        System.out.println("error");
        break;

}



if(city.equals("Sofia")){
if(volumeOfSales >=0 && volumeOfSales<=500){
    System.out.printf("%.2f", volumeOfSales * 0.05);
}else if(volumeOfSales >500 && volumeOfSales<=1000){
    System.out.printf("%.2f", volumeOfSales * 0.07);

}else if(volumeOfSales >1000 && volumeOfSales<=10000){
    System.out.printf("%.2f", volumeOfSales * 0.08);

}else if (volumeOfSales >10000){
    System.out.printf("%.2f", volumeOfSales * 0.12);

}else {
    System.out.println("error");
}

}else if (city.equals("Varna")){
    if(volumeOfSales >=0 && volumeOfSales<=500){
        System.out.printf("%.2f", volumeOfSales * 0.045);
    }else if(volumeOfSales >500 && volumeOfSales<=1000){
        System.out.printf("%.2f", volumeOfSales * 0.075);

    }else if(volumeOfSales >1000 && volumeOfSales<=10000){
        System.out.printf("%.2f", volumeOfSales * 0.10);

    }else if (volumeOfSales >10000){
        System.out.printf("%.2f", volumeOfSales * 0.13);

    }else {
        System.out.println("error");
    }



}else if (city.equals("Plovdiv")){

    if(volumeOfSales >=0 && volumeOfSales<=500){
        System.out.printf("%.2f", volumeOfSales * 0.055);
    }else if(volumeOfSales >500 && volumeOfSales<=1000){
        System.out.printf("%.2f", volumeOfSales * 0.08);

    }else if(volumeOfSales >1000 && volumeOfSales<=10000){
        System.out.printf("%.2f", volumeOfSales * 0.12);

    }else if (volumeOfSales >10000){
        System.out.printf("%.2f", volumeOfSales * 0.145);

    }else {
        System.out.println("error");
    }


}
//else if(city.equals("Kaspichan") || city.equals("Bourgas")){}
//
else {
    System.out.println("error");
}






    }

}
