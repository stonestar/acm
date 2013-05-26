package Reverse;

import java.util.ArrayList;

public class Perm {

	public static void allperm(String pre,ArrayList<Integer> input)
	{   System.out.println(input.size());
		ArrayList<Integer> list=input;
		if(list.size()==1) 
		{
			System.out.println(pre+list.get(0));
			
		}
		else
		{
			
			for(int i=0;i<list.size();i++)
			{  
				
				String s=pre+list.get(i);
				ArrayList<Integer> a=list;
				a.remove(i);
			     allperm(s,a);
			    System.out.println("pre:"+pre+"  "+i);
			}
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   ArrayList<Integer> input=new ArrayList<Integer>();
   for(int i=0;i<9;i++)
   {
   input.add(i);
   }
	allperm("" ,input);
	}

}
