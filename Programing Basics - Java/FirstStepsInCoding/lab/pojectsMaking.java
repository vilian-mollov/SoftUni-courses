import java.util.Scanner;

public class pojectsMaking {
    public static void main(String[] args) {

        // колко часа ще отнеме на един ахрхитект да изготви проектите на няколко строителни обекта
        //Един проект отнема 3 часа
        // От конзолата се четат 2 реда - име на аргитект и брой
        // на проектите които трябва да изготви
        // в цяло число от интервал от 0 до 100.

        Scanner scanner = new Scanner(System.in);
String nameArchitect = scanner.nextLine();
int numberOfProjects = Integer.parseInt(scanner.nextLine());
int neededHours = numberOfProjects * 3;

        System.out.println("The architect " + nameArchitect + " will need " + neededHours + " hours to complete " +numberOfProjects+ " project/s.");

    }

}