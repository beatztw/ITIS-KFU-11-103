import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

// Task 1
//public class Task1to3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        boolean is5 = false;
//        while (true) {
//            int num = sc.nextInt();
//            if (num == 0){
//                break;
//            }
//            if (num == 5) {
//                is5 = true;
//            }
//
//        }
//        System.out.println(is5);
//    }
//}
// ===================================================
// Task 2
//
//public class Task1to3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int sum = 0;
//        while (true) {
//            int num = sc.nextInt();
//            sum += num;
//            if (num == 0) {
//                break;
//            }
//        }
//        System.out.println(sum);
//    }
//}
// ===================================================
// Task 3
//public class Task1to3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int prev;
//        Boolean theSame = true;
//        int result = 0;
//        int count = 1;
//        while (true){
//            prev = num;
//            num = sc.nextInt();
//            if(num == 0){
//                break;
//            }
//            count +=1;
//            if(num > prev){
//                result +=1;
//            }
//            if(num < prev){
//                result-=1;
//            }
//            if (num != prev){
//                theSame = false;
//            }
//        }
//
//        if(result == count-1){
//            System.out.println(">");
//        }else {
//            if(result*(-1) == count-1){
//                System.out.println("<");
//            }else {
//                if(theSame){
//                    System.out.println("=");
//                }else {
//                    System.out.println("!");
//                }
//            }
//        }
//    }
//}
//====================================================
// DeadLine 30.09.2021
//====================================================
// Task 1
//public class Task1to3 {
//    static boolean isPrime(int c) {
//        boolean primeBoolean = true;
//        for (int i = 2; i < c; i++) {
//            if (c % i == 0) {
//                primeBoolean = false;
//                break;
//            }
//        }
//        return primeBoolean;
//    }
//    public static void main(String[] args) {
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("Проверка числа на простоту (от 1 до 1000): ");
//        int num = input.nextInt();
//        if (0 < num && num < 1000) {
//            System.out.println(isPrime(num));
//        } else {
//            System.out.println("OutOfRange");
//        }
//
//    }
//}
//====================================================
// Task 2
//public class Task1to3 {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String alph = "qwertyuiopasdfghjklzxcvbnm";
//        String word = input.nextLine();
//        char chWord = word.charAt(0);
//        for (int i = 0; i < alph.length(); i++) {
//            char sym = alph.charAt(i);
//            char nextSym = alph.charAt(i+1);
//            if (chWord == sym) {
//                System.out.println(nextSym);
//                break;
//            }
//        }
//    }
//}
//======================================================
// Task 3
//public class Task1to3 {
//    static void triangle(int x, int y, int z) {
//        if (x + y >= z){
//            if (x + z >= y) {
//                if (y + z >= x) {
//                    System.out.println("  Треугольник существует");
//                }
//                }
//            } else {
//            System.out.println("Треугольник не существует");
//        }
//    }
//    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        int x = input.nextInt();
//        int y = input.nextInt();
//        int z = input.nextInt();
//        int rectangle = 12;
//        for (int i = 0; i <= rectangle; i++){
//            if (i == 8) {
//                triangle(x,y,z);
//            }
//            for (int j = rectangle; j > i; j--){
//                System.out.print(" ");
//            }
//
//            for (int j1 = 0; j1 <= i; j1++){
//                System.out.print("*");
//            }
//
//            for (int j = 0; j < i; j++){
//                System.out.print("*");
//            }
//
//            for (int j = rectangle; j > i; j--){
//                System.out.print(" ");
//            }
//            System.out.println(" ");
//        }
//
//    }
//}
