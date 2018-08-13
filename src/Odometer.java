import java.util.*;

	public class Odometer {
	static ArrayList<Integer> ValidNumbers=new ArrayList<Integer>();
	static int[] startNumber={1,12, 123,1234,12345,123456, 1234567,12345678, 123456789};
	public static int numberOfDigits(int n){
		int count=0;
		while(n>0)
		{
			count++;
			n=n/10;
		}
		return count;
	}
	
	public static int nthPreviousNumber(int n, int input)
	{
		int i=ValidNumbers.lastIndexOf(input);
		n=n%ValidNumbers.size();
		//System.out.println(i);
		return ValidNumbers.get(Math.abs(i-n));
	}
	public static int nthNextNumber(int n, int input){
		int i=ValidNumbers.lastIndexOf(input);
		n=n%ValidNumbers.size();
		return ValidNumbers.get((i+n)%ValidNumbers.size());
	}
	
	public static int difference(int input1, int input2)
	{
		int diff= Math.abs(ValidNumbers.indexOf(input1)-ValidNumbers.indexOf(input2));
		return diff;
	}
	
	public static int next(int presentNumber,int digits)
		    {
		    	int nextNumber=0;
		    	int i=digits;
		    	int max=9;
		    	if(presentNumber%10!=max)
		    	{
		    		return presentNumber+1;
		    	}
		    	while(i!=0)
		    	{
		    		if(presentNumber%10==max)
		    		{
		    			i--;
		    			max--;
		    			presentNumber=presentNumber/10;
		    		}
		    		else
		    		{
		    		nextNumber=presentNumber+1;
		    		break;
		    		}
		    	}
		    	while(i!=digits)
		    	{
		    		nextNumber=((nextNumber%10)+1)+nextNumber*10;
		    		i++;
		    	}
		    	return nextNumber;
		    } 
		 

	public static void generateList(int digits)
	{
		int present=startNumber[digits-1];
		while(next(present,digits)!=startNumber[digits-1])
		{
			ValidNumbers.add(present);
			present=next(present, digits);
		}
		ValidNumbers.add(present);
		//ValidNumbers.add(startNumber[digits-1]);
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		int digits=numberOfDigits(input);
		generateList(digits);
//		for(int i:ValidNumbers)
//			System.out.println(i);
		//7System.out.println(ValidNumbers.size());
		System.out.println(nthPreviousNumber(3,input));
		System.out.println(nthNextNumber(14,input));
		System.out.println(difference(input, 456));
	}

}
