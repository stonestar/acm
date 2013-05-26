import java.util.ArrayList;
import java.util.Scanner;


public class Main1182 {
	
	private class Group
	{
		private ArrayList<Integer> aList=new ArrayList<Integer>();
		public ArrayList<Integer> getaList() {
			return aList;
		}
		public void setaList(ArrayList<Integer> aList) {
			this.aList = aList;
		}
		public ArrayList<Integer> getbList() {
			return bList;
		}
		public void setbList(ArrayList<Integer> bList) {
			this.bList = bList;
		}
		public ArrayList<Integer> getcList() {
			return cList;
		}
		public void setcList(ArrayList<Integer> cList) {
			this.cList = cList;
		}
		private ArrayList<Integer> bList=new ArrayList<Integer>();
		private ArrayList<Integer> cList=new ArrayList<Integer>();	
		
	}
	//a,b,c具有轮回性 ，股假设第一个是a对结果也无影响
	private static int BELONG_A=1;
	private static int BELONG_B=2;
	private static int BELONG_C=4;
	private static int BELONG_NONE=0;
	private ArrayList<Group> gList=new ArrayList<Group>();
	private int size=0;
    public Main1182(int num)
    {
    	this.size=num;
    }
	public int isHaveOcur(int x)
	{
	   if(gList.size()==0)
		   return Main1182.BELONG_NONE;
	   else
	   {
		   for(int j=0;j<gList.size();j++)
		   {
		if(gList.get(j).getaList().contains(x))
		{
			return j*10+Main1182.BELONG_A;
		}
		if(gList.get(j).getbList().contains(x))
		{
			return j*10+Main1182.BELONG_B;
		}
		if(gList.get(j).getcList().contains(x))
		{
			return j*10+Main1182.BELONG_C;
		}
		   }
		return Main1182.BELONG_NONE;
	   }
		
	}
    public boolean isTrueWord(int i,int x,int y)
    {
		if(x>this.size||y>this.size)
			return false;
		if(i==1)
		{
			if(x==y)
			{   
				int result=this.isHaveOcur(x);
				
				if(result==0)
				{  Group g=new Group();
				   g.getaList().add(x);
				  
					
					gList.add(g);
				}
				return true;
			}
			else
			{
            int xres=this.isHaveOcur(x);
            int yres=this.isHaveOcur(y);	
				if(xres==0&&yres==0)
				{  Group g=new Group();
				   g.getaList().add(x);
				   g.getaList().add(y);
					
					 gList.add(g);
					 return true;
				}
				else if(xres!=0&&yres==0)
				{
					int index=xres/10;
					int kind=xres%10;
					 Group g=gList.get(index);
					 switch(kind)
					 {
					 case 1:
						 g.getaList().add(y);
						 break;
					 case 2:
						 g.getbList().add(y);
						 break;
					 case 4:
						 g.getcList().add(y);
						 break;
					 }
					 gList.remove(index);
					 gList.add(index, g);
					 return true;
				}
				else if(xres==0&&yres!=0)
				{
					int index=yres/10;
					int kind=yres%10;
					 Group g=gList.get(index);
					 switch(kind)
					 {
					 case 1:
						 g.getaList().add(x);
						 break;
					 case 2:
						 g.getbList().add(x);
						 break;
					 case 4:
						 g.getcList().add(x);
						 break;
					 }
					 gList.remove(index);
					 gList.add(index, g);
					 return true;
				}
				else if(xres!=0&&yres!=0)
				{
					if(xres==yres)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				
			}
		}
		else if(i==2)
		{
			if(x==y)
			{
				return false;
			}
			else
			{
				    int xres=this.isHaveOcur(x);
		            int yres=this.isHaveOcur(y);	
						if(xres==0&&yres==0)
						{  Group g=new Group();
						   g.getaList().add(x);
						   g.getbList().add(y);
							
							 gList.add(g);
							 return true;
						}
						else if(xres!=0&&yres==0)
						{
							int index=xres/10;
							int kind=xres%10;
							 Group g=gList.get(index);
							 switch(kind)
							 {
							 case 1:
								 g.getbList().add(y);
								 break;
							 case 2:
								 g.getcList().add(y);
								 break;
							 case 4:
								 g.getaList().add(y);
								 break;
							 }
							 gList.remove(index);
							 gList.add(index, g);
							 return true;
						}
						else if(xres==0&&yres!=0)
						{
							int index=yres/10;
							int kind=yres%10;
							 Group g=gList.get(index);
							 switch(kind)
							 {
							 case 1:
								 g.getbList().add(x);
								 break;
							 case 2:
								 g.getcList().add(x);
								 break;
							 case 4:
								 g.getaList().add(x);
								 break;
							 }
							 gList.remove(index);
							 gList.add(index, g);
							 return true;
						}
						else if(xres!=0&&yres!=0)
						{
							int xindex=xres/10;
							int xkind=xres%10;
							int yindex=yres/10;
							int ykind=yres%10;
							if(xindex==yindex)
							{
								
								switch(xkind)
								{
								case 1:
									if(ykind==2)
									{
										return true;
									}
									else
									{
										return false;
									}
								case 2:
									if(ykind==4)
									{
										return true;
									}
									else
									{
										return false;
									}
								case 4:
									if(ykind==1)
									{
										return true;
									}
									else
									{
										return false;
									}
								}
							}
							else
							{
								  
									Group xg=gList.get(xindex);
								 	Group yg=gList.get(yindex);
								 	switch(xres)
								 	{
								 	case 1:
								 		if(yres==1)
								 		{  
								 			for(int k=0;k<yg.getaList().size();k++)
								 			{
								 				xg.getbList().add(yg.getaList().get(k));
								 			}
								 			for(int k=0;k<yg.getbList().size();k++)
								 			{
								 				xg.getcList().add(yg.getbList().get(k));
								 			}
								 			for(int k=0;k<yg.getcList().size();k++)
								 			{
								 				xg.getaList().add(yg.getcList().get(k));
								 			}
								 		}
								 		else if(yres==2)
								 		{
								 			for(int k=0;k<yg.getbList().size();k++)
								 			{
								 				xg.getbList().add(yg.getbList().get(k));
								 			}
								 			for(int k=0;k<yg.getcList().size();k++)
								 			{
								 				xg.getcList().add(yg.getcList().get(k));
								 			}
								 			for(int k=0;k<yg.getaList().size();k++)
								 			{
								 				xg.getaList().add(yg.getaList().get(k));
								 			}
								 		}
								 		else if(yres==4)
								 		{
								 			for(int k=0;k<yg.getcList().size();k++)
								 			{
								 				xg.getbList().add(yg.getcList().get(k));
								 			}
								 			for(int k=0;k<yg.getaList().size();k++)
								 			{
								 				xg.getcList().add(yg.getaList().get(k));
								 			}
								 			for(int k=0;k<yg.getbList().size();k++)
								 			{
								 				xg.getaList().add(yg.getbList().get(k));
								 			}
								 		}
								 	}
								 	gList.remove(xindex);
								 	gList.add(xg);
								 	gList.remove(yindex);
								
								   return true;
							}
							
						}
			}
		}
		
    	
    	return false;
    	
    }
	/**
	 * @param args
	 */
	public static void Main1182(String[] args) {
		// TODO Auto-generated method stub
		
     Scanner sc =new Scanner(System.in);
     int num=sc.nextInt();
     int k=sc.nextInt();
     Main1182 m=new Main1182(num);
     int res=0;
     for(int i=0;i<k;i++)
     {
    	 int j=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
    	 if(!m.isTrueWord(j, x, y))
    	 {
    	//	 System.out.println("False:kind:"+j+"Ｘ："+x+"  y:"+y);
    		 res++;
    	 }
     }
     System.out.println(res);
	}

}
