import java.util.ArrayList;


public class Package0_1 {
   
	
	/**
	 * @param args
	 */
	private int numofObect;
	private int capacityOfPackage;
	private int[] capacityList;
	private int[] valueList;
	private int[][] m;//m[i][j]表示背包为j时，可用i,i+1...,n的物品填充的最大值
	private ArrayList<Integer> alist=new ArrayList<Integer>();
	public Package0_1(int[] cap,int[] val,int capp)
	{
     this.capacityList=cap;
     this.valueList=val;
     this.numofObect=cap.length;
     this.capacityOfPackage=capp;
     this.m=new int[cap.length][capp+1];
     for(int i=0;i<cap.length;i++)
     {
    	 for(int j=0;j<=capp;j++)
    	 {
    		 this.m[i][j]=-1;
    	 }
     }
     
	}
	public int getValue(int i,int j)
	{
		if(this.m[i][j]!=-1)
		{
			return this.m[i][j];
					
		}
		if(i==(this.numofObect-1))
		{
			if(j<this.capacityList[i])
				
			{
				this.m[i][j]=0;
				
				return  0;
			}
			else
			{
				this.m[i][j]=this.valueList[i];
				//if(!alist.contains(i))alist.add(i);
				return this.valueList[i];
			}
		}
		else{
			if(j<this.capacityList[i])
		
		{      int x=this.getValue(i+1, j);
				this.m[i][j]=x;
				return x;
		}
		else
		{
			int y= Math.max(this.getValue(i+1, j),this.getValue(i+1, j-this.capacityList[i])+this.valueList[i]);
			if((this.getValue(i+1, j-this.capacityList[i])+this.valueList[i])==y)
			{
				//if(!alist.contains(i))alist.add(i);
			}
			this.m[i][j]=y;
			return y;
		}
		}
		
		
	}
   public void printList()
   {
	   for(int i=0;i<alist.size();i++)
	   {
		   System.out.println(alist.get(i));
	   }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cap={2,2,6,5,4};
		int[] val={6,3,5,4,6};
		int capacityOfBag=10;
     Package0_1 p=new Package0_1(cap,val,capacityOfBag);
     int x=p.getValue(0, 10);
     System.out.println(x);
     p.printList();
     
	}

}
