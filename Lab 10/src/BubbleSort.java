
public class BubbleSort {

	public void ascending(int array[]){//bubble sort ascending
		int temp;
		for(int i=0; i<array.length-1; i++)//dont have to do last index
		{
		        for(int j=0; j<array.length-1; j++)//''
			{
				if(array[j] > array[j+1])//actual sorting
				{
					temp=array[j];//storage
					array[j] = array[j+1];
					array[j+1]=temp;
				}
			}
		}
	}
	
	public void descending(int array[]){//bubble fort descending
		int temp;
		for(int i=0; i<array.length-1; i++)//''
		{
		        for(int j=0; j<array.length-1; j++)//''
			{
				if(array[j] < array[j+1])//actual sorting
				{
					temp=array[j];//storage
					array[j] = array[j+1];
					array[j+1]=temp;
				}
			}
		}
	}
}

