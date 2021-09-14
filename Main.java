public class Main{
	public static void main (String args[]){
		if(args.length < 4){
			System.out.println("4 args reqired");
			return;
		}
		//float[] x = {1.f,2.f,3.f};
		//float sum = 0.f;
		//for(int i = 0; i<3; i++){
		//	sum += x[i];
		//}
		//System.out.println(sum);
		float x1 = Float.value0(args[0]);
		float y1 = Float.value0(args[1]);
		float x2 = Float.value0(args[2]);
		float y2 = Float.value0(args[3]);
		
		float distance = (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * ( y1 - y2));
		System.out.println(distance);
	}
}