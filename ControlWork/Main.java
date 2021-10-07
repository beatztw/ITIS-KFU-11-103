package ControlWork;


import java.util.Scanner;

// Task 1
//public class Main {
//    static int pow(int a, int n){
//        int res = a;
//        for (int i = n; i > 1 ; i--) {
//            res *= a;
//        }
//        System.out.println(res);
//        return res;
//    }
//    public static void main(String[] args) {
//        pow(5,3);
//    }
//}
//================================================
// Task 2
//public class Main {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        while(true) {
//            boolean even = true;
//            int num = input.nextInt();
//            if (num == 0) {
//                break;
//            }
//            while (num != 0) {
//                if ((num % 10) % 2 != 0) {
//                    even = false;
//                    break;
//                }
//                num = num / 10;
//            }
//
//            if (even) {
//                System.out.println("Yes");
//                break;
//            }
//        }
//    }
//}
//================================================
// Task 3
//
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        int c6 = 0;
        int c7 = 0;
        int c8 = 0;
        int c9 = 0;
        int c10 = 0;
        System.out.println("Введите размер последовательности");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Введите последовательность");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
            if (arr[i] == 0){
                c0++;
            }
            if (arr[i] == 1){
                c1++;
            }
            if (arr[i] == 2){
                c2++;
            }
            if (arr[i] == 3){
                c3++;
            }
            if (arr[i] == 4){
                c4++;
            }
            if (arr[i] == 5){
                c5++;
            }
            if (arr[i] == 6){
                c6++;
            }
            if (arr[i] == 7){
                c7++;
            }
            if (arr[i] == 8){
                c8++;
            }
            if (arr[i] == 9){
                c9++;
            }
            if (arr[i] == 10){
                c10++;
            }
        }
        System.out.println("0:" + c0);
        System.out.println("1:" + c1);
        System.out.println("2:" + c2);
        System.out.println("3:" + c3);
        System.out.println("4:" + c4);
        System.out.println("5:" + c5);
        System.out.println("6:" + c6);
        System.out.println("7:" + c7);
        System.out.println("8:" + c8);
        System.out.println("9:" + c9);
        System.out.println("10:" + c10);


    }
}
