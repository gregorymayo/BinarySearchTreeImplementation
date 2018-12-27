import java.util.HashMap;
import java.util.Scanner; 
import java.util.*;

public class Main {
	
	public static void copyArray(String[] output, String[] input)
	{	
		for(int i=0;i<input.length;i++)
		{
			output[i]=input[i];
		}
	}
	
	public static void showMenuScore()
	{
		System.out.println("\nThis is the menu: ");
		System.out.println("1. Quick Sort the score");
		System.out.println("2. Make a binary tree");
		System.out.println("3. Search based on Page Rank ");
		System.out.println("4. Insert a URL");
		System.out.println("5. Delete a URL based on Page Rank");
		System.out.println("6. Bucket Sort the URL");
		System.out.println("7. Exit \n");
	}
	
	public static void printArray(int A[])
	{
		for(int i=0;i<A.length;i++)
    	{
    		System.out.println("Page "+ (i+1) + ": " + A[i]);
    	}
	}
	
	public static void main(String[] args)
    {
		
		String[] pageURL = new String[30];
		String[] copyURL = new String[30];
		
		
        Spider spider = new Spider();

        String s; 
		Scanner sc = new Scanner(System.in);
 		System.out.println("Enter a string = "); 
 		s = sc.nextLine();  
		
        spider.search("http://arstechnica.com/", s, pageURL);
        
        /*
        for (int i=0;i<30;i++)
        {
        	int number = 0;
        	number = i + 1;
            System.out.println(number + " " + pageURL[i]);
        }
        */
        
		int page = 30;
        HashMap<Integer,Integer> totalScoreHash = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> manipulationScore = new HashMap<Integer,Integer>();
		HashMap<Integer,String> PageScoreandURL = new HashMap<Integer,String>();
		HashMap<String,Integer> URLandPageScore = new HashMap<String,Integer>();
		HashMap<Integer,Integer> PageRankandPageScore = new HashMap<Integer,Integer>();

		
		int frequencyScore[] = new int[30];
		int timeScore[] = new int[30];
		int numberScore[] = new int[30];
		int paidScore[] = new int[30];
		int totalScore[] = new int[30];
		
		ScorePage score = new ScorePage();
		score.totalScore(frequencyScore,timeScore,numberScore,paidScore, totalScore,totalScoreHash,manipulationScore);
		
		int countThePage = 1;
		for (int i=0;i<30;i++)
        {
            System.out.println(" The page rank = " + countThePage + "\tPage " + totalScoreHash.get(totalScore[i]) + " = " + totalScore[i] + " \tLink = " + pageURL[i]);
            PageScoreandURL.put(totalScore[i], pageURL[i]);
            URLandPageScore.put(pageURL[i], totalScore[i]);
            countThePage++;
        }
		copyArray(copyURL,pageURL);
		int scoreDelete = 0;
		boolean x = true;
		
		int totalScoreQS[] = new int[30];
		score.copyArray(totalScoreQS, totalScore);
		
		QuickSort quickSort = new QuickSort();
		BinarySearchTree BSTtree = new BinarySearchTree();
		quickSort.sort(totalScoreQS, 0, 29);
		
		int pageRankInput = 0;
		for(int i=29;i >=0;i--)
		{
			PageRankandPageScore.put(pageRankInput, totalScoreQS[i]);
			pageRankInput++;
		}
		
		for(int i=0;i<30;i++)
		{
			BSTtree.insert(BSTtree.root,totalScore[i]);
			
		}
		
		
		while(x)
		{
			showMenuScore();
			System.out.print("Choose menu you want = ");
	    	Scanner input = new Scanner(System.in);
	    	int inputMenu = input.nextInt();
	    	
	    	
		    switch(inputMenu){
		    
			    case 1:
				{
					//PROBLEM 1, QUICKSORT (DONE)
					//quickSort.sort(totalScoreQS, 0, 29);
					int count = 1;
					System.out.println("\nAfter Sorting =");
					for (int i=29;i>=0;i--)
			        {
			            System.out.println("Page Rank = "+ count + "\tPage " + totalScoreHash.get(totalScoreQS[i]) + " = " + totalScoreQS[i] + " \tLink = " + PageScoreandURL.get(totalScoreQS[i]));
			            count++;
			        }
					break;
				}//case 1
			
				//PROBLEM 2, BST 
				//PROBLEM 2, BST INSERT (DONE)
			    case 2:
			    {
					
					System.out.println("\nThe tree looks like based on inorder =");
					
					
					//PROBLEM 2, BST INSERT (DONE)
					
					BSTtree.inOrder(BSTtree.root);
					System.out.println("\n");
			
					break;
			    }//case 2
		    
				//PROBLEM 2, BST 
			    //PROBLEM 2, BST SEARCH (DONE)
			    case 3:
			    {
					//Hashmap for search
					
					System.out.print("\nChoose page rank you want to get = ");
			    	Scanner inputNext = new Scanner(System.in);
			    	int inputPage = inputNext.nextInt();
			    	inputPage--;
			    	//int inputFromBehind = 30 - inputPage;
			    	int pageScore = PageRankandPageScore.get(inputPage);
			    	//System.out.print("This is the score  = " + pageScore);
			
			    	pageScore = BSTtree.search(BSTtree.root, pageScore);
			    	System.out.print("\nThis is the score = " + pageScore);
			
			    	if(PageScoreandURL.containsKey(pageScore))
			    	{
			    		//int pagerank = PageRankandPageScore.get(PageRank);
			   			System.out.print(" The page rank " + (inputPage+1) + "\t URL = "+ PageScoreandURL.get(pageScore) + "\n");
			   		}

			    	break;
			    }//case 3
			    //PROBLEM 2, BST INSERT
			    case 4 :
			    {
			    	if(page == 30)
				    	System.out.print("\nThe page is full");
			    	else {
			    	String URL; 
					Scanner scan = new Scanner(System.in);
			 		System.out.println("Insert the URL = "); 
			 		URL = scan.nextLine();  

			 		PageScoreandURL.put(scoreDelete,URL);
			    	}
			    	break;
			    }//case 4
			    //PROBLEM 2, BST DELETE
			    case 5:
			    {
			    	if(page!=0)
			    	{
			    		System.out.print("\nChoose page rank you want to delete = ");
			    		Scanner inputDelete = new Scanner(System.in);
			    		int inputPageDelete = inputDelete.nextInt();
			    		
			    		inputPageDelete--;
			    		scoreDelete = PageRankandPageScore.get(inputPageDelete);
			    		page--;
			    		//totalScoreHash.put(scoreDelete,0);
			    		//manipulationScore.remove(inputPageDelete);
			    		PageScoreandURL.put(scoreDelete,"");
			    		PageRankandPageScore.put(inputPageDelete,0);
			    		
			    		
			    		System.out.print("\nScore page you want to delete = " + scoreDelete + "\n");
			    		BSTtree.delete(BSTtree.root, scoreDelete);
						/*
			    		for(int i=0;i<=29;i++)
			    		{
			    			if(totalScoreQS[i]==scoreDelete)
			    				totalScoreQS[i]=0;
			    		}
			    		*/

			    		
			    	}
			    	
			    	break;
			    }//case 5
			    
			    case 6 :
			    {
			    	BucketSort bucketsort = new BucketSort();
			    	//bucketsort.bucketSort(copyURL);
			    	int countThePageSort = 1;
					for (int i=0;i<30;i++)
			        {
			            System.out.println(" The page rank = " + countThePageSort + "\tPage " + totalScoreHash.get(totalScore[i]) + " = " + URLandPageScore.get(copyURL[i]) + " \tLink = " + copyURL[i]);
			            PageScoreandURL.put(totalScore[i], pageURL[i]);
			            URLandPageScore.put(pageURL[i], totalScore[i]);
			            countThePageSort++;
			        }
			    	break;
			    }
			    case 7:
			    {
			    	x = false;
			    	break;
			    }//case 7
		    }//switch
	    
		}//while
    	
    }
}
