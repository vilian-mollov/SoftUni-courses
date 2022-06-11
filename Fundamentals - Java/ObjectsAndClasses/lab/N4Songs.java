package ObjectsAndClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N4Songs {
    static class Song{
        String type;
        String name;
        String time;
        void setType(String type){
            this.type=type;
        }
        void setName(String name){
            this.name=name;
        }
        void setTime(String time){
            this.time=time;
        }
        void setAll(String type,String name, String time){
            this.type=type;
            this.name=name;
            this.time=time;
        }
        String getInfo(){
            return String.format(this.name);
        }

    }

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

        List<Song> listOfSongs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            //"{typeList}_{name}_{time}"
            String[] input = scanner.nextLine().split("_");
            String type = input[0];
            String name = input[1];
            String time = input[2];
            listOfSongs.add(new Song());
//            listOfSongs.get(i).setType(type);
//            listOfSongs.get(i).setName(name);
//            listOfSongs.get(i).setTime(time);
            listOfSongs.get(i).setAll(type,name,time);
        }
        String typeToPrint = scanner.nextLine();
        if(!typeToPrint.equals("all")) {
            for (Song listOfSong : listOfSongs) {
                if (typeToPrint.equals(listOfSong.type)) {
                    System.out.println(listOfSong.getInfo());
                }
            }
        }else{
            for (Song listOfSong : listOfSongs) {
                    System.out.println(listOfSong.getInfo());
            }
        }
    }
}
