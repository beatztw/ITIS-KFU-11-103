import java.util.Scanner;
public class Main{
	public static void main (String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vvedite koord");
		double x = scanner.nextDouble();
		double y = scanner.nextDouble();
		if( x >= 0 && x <= 1 && y >= 0 & y <= 1) {
			System.out.println("Ne vhodit");
		} else {
			System.out.println("Vhodit");
		}
		
	}
}




//double sum = 0;
	//	double number = -1;
		//int count = 0;
		//while (true) {
			//number = scanner.nextDouble();
			//if (number == 0) {
				//break;
			//}
			//count++;
			//sum += number;
			//System.out.println("Average: " + sum / count);