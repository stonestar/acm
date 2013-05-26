import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static int TYPE_EMPTYORMain_M=0;
	private static int TYPE_EMPTYORMain_N=1;
	private static int TYPE_MOVE_FULL_M=2;
	private static int TYPE_MOVE_ZERO_M=3;
	private static int TYPE_MOVE_FULL_N=4;
	private static int TYPE_MOVE_ZERO_N=5;
    public class Data
    {
 
	 private int m,n;
     private int type;
     public Data(int m,int n,int tyep) {
    	 this.m=m;
    	 this.n=n;
    	 this.type=tyep;
     
     }
     public int getM() {
 			return m;
 		}
 		public void setM(int m) {
 			this.m = m;
 		}
 		public int getN() {
 			return n;
 		}
 		public void setN(int n) {
 			this.n = n;
 		}
 		public int getType() {
 			return type;
 		}
 		public void setType(int type) {
 			this.type = type;
 		}
 		public String toString() 
 		{
 		 return m+"  "+n+" type:"+type;	
 		}
    }
    public  Data getInstanceData(int m,int n,int type) {
    	Data data=new Data(m,n,type);
    	return data;
    }
	private ArrayList<Data> emptyStartList=new ArrayList<Data>();
	public ArrayList<Data> getEmptyStartList() {
		return emptyStartList;
	}
	public void setEmptyStartList(ArrayList<Data> emptyStartList) {
		this.emptyStartList = emptyStartList;
	}
	public ArrayList<Data> getMoveStartList() {
		return moveStartList;
	}
	public void setMoveStartList(ArrayList<Data> moveStartList) {
		this.moveStartList = moveStartList;
	}
	private ArrayList<Data> moveStartList=new ArrayList<Data>();
	private Data getPreData(Data data,int MMAX,int NMAX) 
	{   
		if(data.getType()==Main.TYPE_EMPTYORMain_M) 
		{   
			int m=data.getM();
			int n=data.getN();
			if(m==MMAX)
			{
				if(n+m>=NMAX) 
				{
					Data d=new Data(n+m-NMAX,NMAX,Main.TYPE_MOVE_FULL_N);
					return d;
				}
				else 
				{
					Data d=new Data(0,n+m,Main.TYPE_MOVE_ZERO_M);
					return d;	
				}
		    }
			else if(m==0)
			{
				if(n>=MMAX) 
				{
					Data d=new Data(MMAX,n-MMAX,Main.TYPE_MOVE_FULL_M);
					return d;
				}
				else 
				{
					Data d=new Data(n,0,Main.TYPE_MOVE_ZERO_N);
					return d;	
				}
			}
			
		}
		else if(data.getType()==Main.TYPE_EMPTYORMain_N)
		{
			int m=data.getM();
		    int n=data.getN();
			if(n==NMAX)
			{
				if(n+m>=MMAX) 
				{
					Data d=new Data(MMAX,n+m-MMAX,Main.TYPE_MOVE_FULL_M);
					return d;
				}
				else 
				{
					Data d=new Data(n+m,0,Main.TYPE_MOVE_ZERO_N);
					return d;	
				}
		    }
			else if(n==0)
			{
				if(m>=NMAX) 
				{
					Data d=new Data(m-NMAX,NMAX,Main.TYPE_MOVE_FULL_N);
					return d;
				}
				else 
				{
					Data d=new Data(0,m,Main.TYPE_MOVE_ZERO_M);
					return d;	
				}
			}
		}
		else if(data.getType()==Main.TYPE_MOVE_FULL_M) 
		{   
			
			int n=data.getN();
			Data d=new Data(0,n,Main.TYPE_EMPTYORMain_M);
		   return d;
		}
		else if(data.getType()==Main.TYPE_MOVE_FULL_N) 
		{   
			int m=data.getM();
			
			Data d=new Data(m,0,Main.TYPE_EMPTYORMain_N);
		   return d;
		}
		else if(data.getType()==Main.TYPE_MOVE_ZERO_M) 
		{   
			
			int n=data.getN();
			Data d=new Data(MMAX,n,Main.TYPE_EMPTYORMain_M);
		   return d;
		}
		else if(data.getType()==Main.TYPE_MOVE_ZERO_N) 
		{   
			int m=data.getM();
						
			Data d=new Data(m,NMAX,Main.TYPE_EMPTYORMain_N);
		   return d;
		}
		
		 
		
		
		return data;
		
	}
	private void reverseempty(Data data,int MMAX,int NMAX)
	{  
		Data d=getPreData(data,MMAX,NMAX);
	
		if(d.getM()==0&&d.getN()==0)
		{
			this.emptyStartList.add(d);
			return ;
		}
		else 
		{
			this.emptyStartList.add(d);
			reverseempty(d,MMAX,NMAX);
		}
	}
	private void reversemove(Data data,int MMAX,int NMAX)
	{
		Data d=getPreData(data,MMAX,NMAX);
		if(d.getM()==0&&d.getN()==0)
		{
			
		
			this.moveStartList.add(d);
			return ;
		}
		else 
		{
			this.moveStartList.add(0, d);
			reversemove(d,MMAX,NMAX);
		}
	}
	public void emptyout()
	{
		for(int i=0;i<this.emptyStartList.size();i++)
		{
			Data d=this.emptyStartList.get(i);
			System.out.println(d.toString());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner sc=new Scanner(System.in);
      while(sc.hasNext()) {
	  int MMAX=sc.nextInt();
      int NMAX=sc.nextInt();
      int re=sc.nextInt();
      Main Main=new Main();
      Data data=Main.getInstanceData(MMAX, re, Main.TYPE_EMPTYORMain_M);
      Main.reverseempty(data, MMAX, NMAX);
   
      ArrayList<Data> datalist=Main.getEmptyStartList();
      for(int i=datalist.size()-1;i>=0;i--)
      {
       Data d=datalist.get(i);
       int type=d.getType();
       switch(type) 
       {
       case 0:
    	   int m=d.getM();
    	   if(m==0)
    	   {
    		   System.out.println("fill A");
    	   }
    	   else 
    	   {
    		   System.out.println("empty A");   
    	   }
    	   break;
       case 1:
    	   int n=d.getN();
    	   if(n==0)
    	   {
    		   System.out.println("fill B");
    	   }
    	   else 
    	   {
    		   System.out.println("empty B");   
    	   }
    	   break;
       case 2:
    	  
    	  
    	System.out.println("pour A B");
    	 break;
    	 
       case 3:
    	     System.out.println("pour B A");
    	     break;
       case 4:
    	   System.out.println("pour B A"); 
    	   break;
       case 5:
    	   System.out.println("pour A B");
    	   break;
       }
       
      }
      System.out.println("success");
	}
	}
}