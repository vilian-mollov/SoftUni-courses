import java.util.Random;

public class quickSort {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
                arr[i] = rnd.nextInt(100);
        }

        System.out.println("Before:");
        printArr(arr);

        quickSort(arr,0, arr.length - 1);

        System.out.println("After:");
        printArr(arr);

    }
    private static void quickSort(int[] numbers, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = numbers[highIndex];

        int lp = lowIndex;
        int rp = highIndex;

        while (lp < rp) {

            while (numbers[lp] <= pivot && lp < rp) {
                lp++;
            }
            while (numbers[rp] >= pivot && lp < rp) {
                rp--;
            }

            int temp = numbers[lp];
            numbers[lp] = numbers[rp];
            numbers[rp] = temp;
        }

        int tempPivot = numbers[highIndex];
        numbers[highIndex] = numbers[rp];
        numbers[rp] = tempPivot;

        quickSort(numbers, lowIndex, lp - 1);
        quickSort(numbers, lp + 1, highIndex);

    }



    private static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
