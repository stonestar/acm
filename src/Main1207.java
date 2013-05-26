import java.util.ArrayList;
import java.util.Scanner;


public class Main1207 {

	/**
	 * @param args
	 */
	int getNumber(int input)
	{
	
		if(input==1)
		return 1;
		else
		{
			int isOdd=input%2;
			if(isOdd==1)
			{
				return 1+getNumber(3*input+1);
			}
			else
			{
				return 1+getNumber(input/2);
			}
		}
		
	}
	int getMax(int x,int y)
	{  
		int result=1;
		ArrayList<Integer> alread=new ArrayList<Integer>();
		for(int i=y;i>=x;i--)
		{
			if(!alread.contains(i))
			{
				int rs=getNumber(i);
				if(rs>result)
				{
					result=rs;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Main1207 m=new Main1207();
     Scanner sc=new Scanner(System.in);
     while(sc.hasNext())
     {
    	 int x=sc.nextInt();
    	 int y=sc.nextInt();
    	 
    	 int re=m.getMax(Math.min(x, y), Math.max(x, y));
    	 System.out.println(x+" "+y+" "+re);
     }
	}

}
