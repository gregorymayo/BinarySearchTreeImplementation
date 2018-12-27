import java.util.*;
import java.lang.*;

public class BucketSort {
	public void swapNumber(int A[],int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j]=temp;
	}
	//To get the domain name, in this function I am using sub string
	//For example: https://google.com, it will become google.com
	//The substring is from 0 until the counter hit '/' in the line 24
	public void domainName(String[] input)
	{
		int length = input.length;
		int count =0;
		for(int i=0;i<length;i++)
		{
			String sentences ;
			sentences = input[i];
			for(int j=0;j<sentences.length();j++)
			{
				if(sentences.charAt(j)=='/')
				{
					count = j;
					count++;
					sentences.substring(0,count);
				}
				break;
			}
			
			//sentences.substring(count+2,sentences.length());
			input[i]=sentences;
		}
		
	}
	
	public void bucketSort(String[] input)
	{
		InsertionSort sort = new InsertionSort();
		int n = input.length;
		String[] B = new String[n];
		
		//Make sure that the B array is empty
		for(int i=0;i<=n-1;i++)
			B[i] = "";
		
		for(int i=0;i<n;i++)
		{
			//int number = Integer.parseInt(input[i]);
			char c = input[i].charAt(1);
			int number = Character.getNumericValue(c);
			B[Math.floorDiv(number,n)] = input[i];
		}
		
		//Doing the insertion sort
		for(int i=0;i<=n-1;i++)
		{
			sort.insertionSort(B);
		}
		//Doing the concatenate for array B
		int index=0;
	      for (int i=0; i<input.length; i++) {
	         for (int j=0; j<B.length; j++) {
	            input[index++]=B[i];
	         }
	      }
		
		
		
	}
}
