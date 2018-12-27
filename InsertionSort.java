import java.util.*;

public class InsertionSort {

	public void insertionSort (String[] input)
	{
		String temp ;
		for(int i=1;i<input.length;i++)
		{
			temp = input[i];
			int j=0;
			for(j=i;j>0;j--)
				if(temp.compareTo(input[j-1])<0)
					input[j] = input[j-1];
				else
					break;
			input[j]=temp;
		}
		
	}
}
