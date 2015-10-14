
public class ArrayHelper {
//print each value of 2DArray in given format
	public void print2DArray(int[][] array){
		for (int i = 0;i < array.length; i++){
			for(int j = 0;j < array[i].length; j++){
				System.out.print(array[i][j]);
				if(j == array[i].length - 1){
					System.out.println();
				}	
				else{	
					System.out.print(", ");//formatting
				}
			}
		}
	}
//sum each row value
	public int arraySum(int[] array){
		int sum = 0;
		for (int i = 0;i < array.length; i++){
			sum = sum + array[i];
		}
		return sum;
	}
//find row sum then divide by row length to find row avg
	public double arrayAvg(int[] array){
		double avg = 0;
		avg = arraySum(array)/(double)array.length;
		return avg;
	}
	//add each value in 2DArray separately to find sum
	public int arraySum2D(int[][] array){
		int sum = 0;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				sum = sum + array[i][j];
			}
		}
		return sum;
	}
	//take 2DArray sum and divide by all total number of value in 2DArray
	public double arrayAvg2D(int[][] array){
		double avgSum = 0;
		for(int i = 0; i < array.length; i++){
			avgSum = avgSum + arrayAvg(array[i]);
		}
		double avg = avgSum/(double)array.length;
		return avg;
	}
	//transpose method
	public void transpose(int[][] array){
		if(array.length == array[0].length){//check length, if square then these are equal
			int[][] tranArray = new int[array.length][array.length];
			System.out.println("Here is your transpose:");
			for(int i = 0; i < array.length; i++){
				for(int j = 0; j < array[i].length; j++){
					int x = array[i][j];
					tranArray[j][i] = x;
				}
			}
			print2DArray(tranArray);//print transpose array to user
		}
		else{
			System.out.println("Cannot transpose this array!");//error method to user if not square matrix
		}
	}
}
