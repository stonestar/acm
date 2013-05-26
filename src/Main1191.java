import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class Main1191 {

   //需要分割的次数
	private int lineOfNum=0;
	/**
	 * @param args
	 */
	private int[][] inputdata;
	//输入数据的平均值
	private double arevage=10;
	//表示（x1,y1）,(x2,y2)构成的矩形分割n的最小平方差值；
	private double[][][][][] vardata;
	//num为切割的次数
	public Main1191(int[][] input,int num)
	{
		this.inputdata=input;
		this.lineOfNum=num;
		int xl=input[0].length;
		int yl=input.length;
		int sum=0;
		for(int r=0;r<yl;r++)
		{
			for(int n=0;n<xl;n++)
			{
				sum+=this.inputdata[r][n];
			}
		}
		this.arevage=sum/(double)(num+1);
		this.vardata=new double[xl][yl][xl][yl][num+1];
		for(int i=0;i<xl;i++)
		{
			for(int j=0;j<yl;j++)
			{
				for(int k=0;k<xl;k++)
				{
					for(int l=0;l<yl;l++)
					{
						for(int m=0;m<num+1;m++)
						{
							this.vardata[i][j][k][l][m]=-2;
						}
					}
				}
			}
		}
	
	}
	
   /*
    * 测试当前矩形是否可以分割n次，
    * 0<=x1<=x2;0<=y1<=y2;
    */
	private boolean isCanPartion(int x1,int y1,int x2,int y2,int n)
	{  //当前矩形可以分割的最大次数
		int num=x2-x1+y2-y1;
		if(num>=n)
			return true;
		else
		{
			return false;	
		}
		
		
	}
	private double getSquerValue(int x1,int y1,int x2,int y2)
	{
		int sum=0;
		for(int i=x1;i<=x2;i++)
		{
			for(int j=y1;j<=y2;j++)
			{
				sum+=this.inputdata[i][j];
			}
		}
		return (sum-this.arevage)*(sum-this.arevage);
		
	}
	public double getValue(int x1,int y1,int x2,int y2,int n)
	{
		double value=this.vardata[x1][y1][x1][x2][n];
		if(value!=-2)
		{
			return this.vardata[x1][y1][x1][x2][n];
		}
		if(n==0)
		{   
		
			this.vardata[x1][y1][x1][x2][n]=this.getSquerValue(x1, y1, x2, y2);
			return this.getSquerValue(x1, y1, x2, y2);
		}
		double min=0;
		ArrayList<Double> res=new ArrayList<Double>();
		for(int i=y1+1;i<=y2;i++)
		{
			double sum=this.getSquerValue(x1, y1, x2, i-1);
			boolean b1=this.isCanPartion(x1, i, x2, y2,n-1);
			if(b1)
			{   
				double re=sum+this.getValue(x1, i, x2, y2, n-1);
				res.add(re);
			}
			double sum2=this.getSquerValue(x1, i, x2, y2);
			boolean b2=this.isCanPartion(x1, y1, x2, i-1,n-1);
			if(b2)
			{
				double re2=sum2+this.getValue(x1, y1, x2, i-1, n-1);
				res.add(re2);
			}
		
		
		}
		for(int i=x1+1;i<=x2;i++)
		{
			double sum=this.getSquerValue(x1, y1, i-1, y2);
			boolean b1=this.isCanPartion(i, y1, x2, y2,n-1);
			if(b1)
			{
				double re=sum+this.getValue(i, y1, x2, y2, n-1);
				res.add(re);
			}
			double sum2=this.getSquerValue(i, y1, x2, y2);
			boolean b2=this.isCanPartion(x1, y1, i-1, y2,n-1);
			if(b2)
			{
				double re2=sum2+this.getValue(x1, y1, i-1, y2, n-1);
				res.add(re2);
			}
		
		
		}
		
		for(int i=0;i<res.size();i++)
		{
			if(i==0)
			{
				min=res.get(i);
				continue;
			}
			else if(res.get(i)<min)
				min=res.get(i);
		}
		
		this.vardata[x1][y1][x1][x2][n]=min;
		return min;
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		
//		int[][] input=new int[][]{
//				{1 ,1 ,1 ,1 ,1 ,1 ,1 ,3},
//				{1, 1 ,1, 1, 1, 1, 1 ,1},
//				{1, 1 ,1, 1, 1, 1, 1 ,1},
//				{1, 1 ,1, 1, 1, 1, 1 ,1},
//				{1, 1 ,1, 1, 1, 1, 1 ,1},
//				{1, 1 ,1, 1, 1, 1, 1 ,1},
//				{1, 1 ,1, 1, 1, 1, 1 ,0},
//				{1, 1 ,1, 1, 1, 1, 0 ,3}
//		};
     
      
      Scanner sc=new Scanner(System.in);
      int num=sc.nextInt();
      int [][] input = new int[8][8];
     
      for(int k=0;k<8;k++)
      {    
     	  for(int l=0;l<8;l++)
     	  {
     		  input[k][l]=sc.nextInt();
     	  }
      }
      Main1191 m=new Main1191(input,num-1);  
      double x=m.getValue(0, 0, 7, 7, num-1);
      double   res   = Math.sqrt(x/num) ;
  
      System.out.printf("%.3f", res);
  
	}

}
