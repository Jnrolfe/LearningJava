import java.util.Scanner;//doesn't work

public class ListSubtractor {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How big is your first list?");
		int size = input.nextInt();
		double[] array = new double[size];
		System.out.println("How big is your second list?");
		int size2 = input.nextInt();
		double[] arrayTwo = new double[size];
		System.out.println("Populate your first list:");
		for(int i = 0; i < size; i++){
			System.out.println("enter a value for your first array");
			array[i] = input.nextDouble();
		}
		for(int i = 0; i < size2; i++){
			System.out.println("enter a value for your second array");
			arrayTwo[i] = input.nextDouble();
		}
		int finalArraySize = 0;
		for(int i = 0; i < size; i++){
			if (array[i] != arrayTwo[i]){
				finalArraySize++;
			}
		}
		double[] finalArray = new double[finalArraySize];
		for(int i = 0; i < finalArraySize; i++){
			if (array[i] != arrayTwo[i]){
				finalArray[i] = array[i];
			}
			else{
				finalArray[i] = array[i+1];
			}
		}
		System.out.print("[");
		for(int i = 0; i < finalArraySize; i++){
			System.out.print(finalArray[i]+", ");
		}
		System.out.print("]");
	}

}
