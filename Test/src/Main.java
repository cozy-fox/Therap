/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/27/14
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
      int data[] = {32, 12, 18, 0, -5, 72, 424};
        bubbleSort(data);
        printData(data);
    }

    private static void printData(int[] data) {
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
    }

    public static void bubbleSort(int a[]) {
        int n = a.length;
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (a[j - 1] > a[j]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
