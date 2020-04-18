import java.util.Arrays;
import java.util.Random;

public class ParallelSortingArray {
	
	public static void main(String[] args) {
		
		//define the size of the int array
		int size = 10000;
		
		//creating the arrays or normal sorting and parallel sorting
		int[] normalSortArray = new int[size];
		int[] parallelSortArray = new int[size]; 
		
		//call the gen method to generate random numbers for the array
		normalSortArray = generateRandomNum(size);
		
		//we are performing a deep copy of the array using for loop
		for(int i = 0; i < size; i++) {
			//copies the value in the normalSortArray into the parallelSort Array
			parallelSortArray[i] = normalSortArray[i];
		}//end for loop
		
		System.out.println("Finished creating identical arrays.\n");
		
		//defines the variable to store our time
		double parallelSortTime = 0;
		double serialSortTime = 0;
		System.out.println("Please weait while starting the linear bubble sort...");
		
		//sorting and storing the start and end time of before and after of serial sort
		long startTime = System.currentTimeMillis();
		bubbleSort(normalSortArray);
		long endTime = System.currentTimeMillis();
		System.out.println("Finished linear bubble sort.\n");
		//storing the difference of the start and ending time of the serial sort
		serialSortTime = endTime - startTime;
		
		System.out.println("Please wait while starting the parallel bubble sort...");
		//sorting and storing the start and end time of before and after of serial sort
		startTime = System.currentTimeMillis();
		Arrays.parallelSort(parallelSortArray);
		endTime = System.currentTimeMillis();
		System.out.println("Finished parallel sorting.\n");
		//storing the difference of the start and ending time of the serial sort
		parallelSortTime = endTime - startTime;
		
		//printing to the console the time taken in seconds, since it is in milliseconds, we will divide it by 1000
		System.out.println("Time for linear bubble sort: " + serialSortTime/1000 + " seconds.");
		System.out.println("Time for parallel bubble sort: " + parallelSortTime/1000 + " seconds.");
		

	}//end main method
	
	//this method generates numbers between 0 - 9999 fo
	public static int[] generateRandomNum(int size) {
		
		//defining an array and add random class variable to generate random numbers
		int [] array = new int[size];
		Random rand = new Random();
		
		//We will use a loop to generate and store the random numbers
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10000);
		}//end for loop
		
		//returns the array
		return array;
		
	}//end generateRandomNum method
	
	//this method will be used to sorts the arra using bubble sorts
	public static void bubbleSort(int[] array) {
		
		//we will use two for loops to iterate through all the elements in the array and sorting them
		for(int i = 0; i < array.length; i++) {
			
			for(int j = 1; j < array.length-i; j++) {
				
				if(array[j-1] < array[j]) {
					
					//temporarily stores the value of array[j-1]
					int temp = array[j-1];
					//swaps elements
					array[j-1] = array[j];
					array[j] = temp;
					
				}//end if statement
				
			}//end inner for loop
			
		}//end outer for loop
		
	}//end bubbleSort method

}//end class