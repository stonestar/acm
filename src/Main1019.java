
public class Main1019 {
	private  static int  TWOOF14=16384;
    public static int getNumOfN(int n)
    {
    	int i=1;
    	while(n>=10)
    	{
    		n=n/10;
    		i++;
    	}
    	return i;
    }

    public static int getAllSumNumOfN(int n)
    {
    	int result = 0;
    	if(n==0)
    	{
    		return 0;
    	}
    	else
    	{
    		for(int i=1;i<=n;i++)
    		{
    			result+=(n+1-i)*getNumOfN(i);
    		}
    		return result;
    	}
    }
    public static int getSqurOFTwo(int sum)
    {
    	int i=0;
    	while(sum>=2)
    	{
    		sum/=2;
    		i++;
    	}
    	return i;
    }
    public static int getNOfSum(int sum)
    {
	   if(sum>getSumNumOfN(Main1019.TWOOF14))
	   {
	    int first=Main1019.TWOOF14;
	    int two=0;
	    int add=(first+two)/2;
	    boolean b=true;
	    while(b)
	    {
	    if(two==0)
	    {
	    	int temp=first+add;
	    	int res=getSumNumOfN(temp);
	    	if(sum>res)
	    	{
	    		first=temp;
	    		add/=2;
	    	}
	    	else
	    	{
	    		if(sum==res)
	    		{
	    			return temp;
	    		}
	    		else
	    		{
	    			two=temp;
	    		}
	    	}
	    }
	    else
	    {
	    	int temp=(first+two)/2;
	    	int res=getSumNumOfN(temp);
	    	if(sum>res)
	    	{
	    		first=temp;
	    		
	    	}
	    	else
	    	{
	    		if(sum==res)
	    		{
	    			return temp;
	    		}
	    		else
	    		{
	    			two=temp;
	    		}
	    	}
	    }
	    }
	   }
	   else
	   {
		   
	   }
    	return sum;
    	
    }
    public static int getSumNumOfN(int n)
    {
    
    	if(n==1)
    	{
    		return 1;
    	}
    	else if(n>1)
    	{
    		
    		return getAllSumNumOfN(n)-getAllSumNumOfN(n-1);
    	}
		return 0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(Main1019.getNumOfN(11));
      System.out.println(Main1019.getAllSumNumOfN(31267));
      System.out.println(Main1019.getSumNumOfN(31267));
      System.out.println(Main1019.getSqurOFTwo(31267));
	}

}
