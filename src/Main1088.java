import java.util.Scanner;


public class Main1088 {
	private int[][] data;
	private int[][] sum;
	private int[][] getExtendData(int [][] input)
	{   this.sum=new int[input.length][input[0].length];
	    for(int m=0;m<input.length;m++)
	    {
	    	for(int n=0;n<input[0].length;n++)
	    	{
	    		sum[m][n]=-1;
	    	}
	    }
		int[][] tdata=new int[input.length+2][input[0].length+2];
		for(int i=0;i<tdata.length;i++)
		{
			for(int j=0;j<tdata[0].length;j++)
			{
				if(i==0||i==tdata.length-1)
				{
					tdata[i][j]=-1;
				}
				else if(j==0||j==tdata[0].length-1)
				{
					tdata[i][j]=-1;
				}
				else if(i!=0&&i!=(tdata.length-1)&&j!=0&&j!=tdata[0].length-1)
				{
					tdata[i][j]=input[i-1][j-1];
				}
			}
		}
		return tdata;
	}
	public int getMaxValueForOne(int i,int j)
	{ // 1<=i,1<=j
//		if(sum[i-1][j-1]!=-1)
//		{
//			//System.out.println(i+" "+j);
//			return sum[i-1][j-j];
//		}
//		else
		{   
			int [] all=new int[4];
			boolean isOver=true;
			if(this.data[i-1][j]!=-1&&this.data[i-1][j]<this.data[i][j])
			{
				all[0]=this.data[i][j]-this.data[i-1][j]+this.getMaxValueForOne(i-1, j);
			    isOver=false;
			 //   System.out.println(i+" "+j+" ÉÏ£º"+all[0]+"  ="+(this.data[i][j]-this.data[i-1][j])); 
			}
			if(this.data[i+1][j]!=-1&&this.data[i+1][j]<this.data[i][j])
			{
				all[1]=this.data[i][j]-this.data[i+1][j]+this.getMaxValueForOne(i+1, j);
				// System.out.println(i+" "+j+" ÏÂ£º"+all[1]+"  ="+(this.data[i][j]-this.data[i+1][j])); 
				isOver=false;
			}
			if(this.data[i][j-1]!=-1&&this.data[i][j-1]<this.data[i][j])
			{
				all[2]=this.data[i][j]-this.data[i][j-1]+this.getMaxValueForOne(i, j-1);
				 isOver=false;
				// System.out.println(i+" "+j+" ×ó£º"+all[2]+"  ="+(this.data[i][j]-this.data[i][j-1])); 
			}
			if(this.data[i][j+1]!=-1&&this.data[i][j+1]<this.data[i][j])
			{
				all[3]=this.data[i][j]-this.data[i][j+1]+this.getMaxValueForOne(i, j+1);
				 isOver=false;
				// System.out.println(i+" "+j+" ÓÒ£º"+all[3]+"  ="+(this.data[i][j]-this.data[i][j+1])); 
			}
			
			int value=Math.max(Math.max(all[0], all[1]),Math.max(all[2],all[3]));
			if(sum[i-1][j-1]==-1)
			 sum[i-1][j-1]=value;
			return value;
			
		}
	}
	public Main1088(int [][] input)
	{
		this.data=this.getExtendData(input);
		
	}
   public void printdata()
   {
	   for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[0].length;j++)
			{
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		} 
   }
   public void printm()
   {
	   for(int i=0;i<sum.length;i++)
		{
			for(int j=0;j<sum[0].length;j++)
			{
				System.out.print(sum[i][j]+" ");
			}
			System.out.println();
		} 
   }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
    
     Scanner sc=new Scanner(System.in);
     int i=sc.nextInt(),j=sc.nextInt();
     int [][] input = new int[i][j];
     int max=0;
     for(int k=0;k<i;k++)
     {    
    	  for(int l=0;l<j;l++)
    	  {
    		  input[k][l]=sc.nextInt();
    	  }
     }
     Main1088 m=new Main1088(input);
//     for(int k=1;k<=i;k++)
//     {    
//    	  for(int l=1;l<=j;l++)
//    	  {
//    		 int a=m.getMaxValueForOne(k, l);
//    		 if(a>max)
//    			 max=a;
//    	  }
//     }
     m.printdata();
     int a=m.getMaxValueForOne(2,3 );
     System.out.println(a+1);
     m.printm();
     
	}
   
}
