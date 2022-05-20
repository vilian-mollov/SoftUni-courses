package Arrays.Exercise;
import java.util.regex.*;
import java.util.Scanner;

public class N10TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Gold|Silver|Bronze|Medallion|Cup
        String[] treasureChest = scanner.nextLine().split("\\|");
        //Gold Silver Bronze Medallion Cup
        String input = scanner.nextLine();
        boolean isEmpty = false;
        while(!input.equals("Yohoho!")){
            String[] stringInputArr = input.split("\\s+");
            // Loot Wood Gold Coins
            switch(stringInputArr[0]){
                case "Loot":
                    String[] stuffs = new String[stringInputArr.length-1];
                    // Wood Gold Coins
                    for (int i = 1; i < stringInputArr.length; i++) {
                        stuffs[i-1]=stringInputArr[i];
                    }
                    for (int lootedItem = 0; lootedItem < stuffs.length; lootedItem++) {
                        boolean isNewItem = true;
                        for (int indexOfItemsInTheChest = 0; indexOfItemsInTheChest < treasureChest.length; indexOfItemsInTheChest++) {
                            if(stuffs[lootedItem].equals(treasureChest[indexOfItemsInTheChest])){
                                isNewItem=false;
                            }
                        }
                        if(isNewItem){
                            String[] newLootChest = new String[treasureChest.length+1];
                            newLootChest[0] = stuffs[lootedItem];
                            for (int i = 1; i < newLootChest.length; i++) {

                                newLootChest[i]=treasureChest[i-1];
                            }
                            treasureChest=newLootChest;
                        }
                    }
                    break;
                // Loot algorithm is working // Nice
                case "Drop":
                    int index = Integer.parseInt(stringInputArr[1]);
                    if(index>=0 && index<treasureChest.length-1){
                        String item = treasureChest[index];
                        String[] newStringDroppedItem = new String[treasureChest.length];
                        newStringDroppedItem[newStringDroppedItem.length-1]= item;
                        int indexOfNewDroppedChest=0;
                        for (int i = 0; i < treasureChest.length; i++) {
                            if(i!=index){
                                newStringDroppedItem[indexOfNewDroppedChest] = treasureChest[i];
                            }else{
                                newStringDroppedItem[indexOfNewDroppedChest] = treasureChest[i+1];
                                i++;
                            }
                            indexOfNewDroppedChest++;
                        }
                        treasureChest=newStringDroppedItem;
                    }
                    break;
                case "Steal":
                    int numberOfStolenItems = Integer.parseInt(stringInputArr[1]);
                    if(numberOfStolenItems>= treasureChest.length){
                        for (int i =0;i< treasureChest.length;i++ ) {
                            if(i==treasureChest.length-1) {
                                System.out.print(treasureChest[i]);
                            }else{
                                System.out.print(treasureChest[i] + ", ");
                            }
                        }
                        System.out.println();
                        isEmpty=true;
                    }else{
                        for (int i =treasureChest.length-numberOfStolenItems ; i <= treasureChest.length-1 ; i++) {
                            if(i==treasureChest.length-1){
                                System.out.print(treasureChest[i]);
                            }else {
                                System.out.print(treasureChest[i] + ", ");
                            }
                        }
                        System.out.println();
                        String[] treasureWithoutStolenItems = new String[treasureChest.length-numberOfStolenItems];
                        for (int i = 0; i < treasureWithoutStolenItems.length ; i++) {
                            treasureWithoutStolenItems[i]=treasureChest[i];
                        }
                        treasureChest=treasureWithoutStolenItems;
                    }

                    break;

            }

input=scanner.nextLine();
        }
        int theSumOfAllTreasureItemsLength =0;
        for (int i = 0; i < treasureChest.length; i++) {
            theSumOfAllTreasureItemsLength += treasureChest[i].length();
        }
        if(!isEmpty){
            System.out.printf("Average treasure gain: %.2f pirate credits.",1.0*theSumOfAllTreasureItemsLength/treasureChest.length);
        }else{
            System.out.println("Failed treasure hunt.");
        }

    }
}
