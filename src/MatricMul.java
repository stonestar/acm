
public class MatricMul {

	/**
	 * @param args
	 */
	private int data[][];
	private int[] length;
	public MatricMul(int [] input)
	{
		this.length=input;
		this.data=new int[input.length-1][input.length-1];
		for(int i=0;i<input.length-1;i++)
		{
			for(int j=0;j<input.length-1;j++)
			{
				this.data[i][j]=-1;
			}
		}
		
	}
	private int getMin(int [] a)
	{
		int temp=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i]<temp)
			{
				temp=a[i];
			}
		}
		return temp;
	}
	public int getMinOp(int i,int j)
	{  
		
		if(data[i][j]!=-1)
	    {
		  return data[i][j];
	    }
		if(i==j)
		{
			this.data[i][j]=0;
			return 0;
		}
		else
		{
			int[] sep=new int[j-i];
			for(int n=0;n<j-i;n++)
			{
				sep[n]=this.getMinOp(i, i+n)+this.getMinOp(i+n+1, j)+length[i]*length[i+n+1]*length[j+1];
				
			}
			int min=this.getMin(sep);
		
			this.data[i][j]=min;
			
			return min;
			
			
		}
		
		
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int[] input={30,35,15,5,10,20,25};
		MatricMul mm=new MatricMul(input);
		int x=mm.getMinOp(0, 5);
		System.out.println(x);
     
	}

}
