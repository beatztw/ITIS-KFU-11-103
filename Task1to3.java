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
// Task 3 ( Прошу прощения за не чистый код, мог сделать через методы , но мы их еще не прошли , поэтому сдедал все на if-ах. )
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