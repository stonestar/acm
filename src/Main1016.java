import java.util.ArrayList;
import java.util.Scanner;


public class Main1016 {
  public static String getInventory( String input)
  {
	  ArrayList<Integer> list=new ArrayList<Integer>();
	  for(int j=0;j<10;j++)
	  {
		  list.add(0);
	  }
	  for(int i=0;i<input.length();i++)
	  {
		  list.set(input.charAt(i)-48, list.get(input.charAt(i)-48)+1);
	  }
	  String s="";
	  for(int k=0;k<10;k++)
	  {
		  if(list.get(k)!=0)
		  {
			  s+=list.get(k)+""+k;
		  }
	  }
	  return s;
  }
  public static String getResult(String input)
  {
	  ArrayList<String> list=new ArrayList<String>();
	  list.add(input);
	  for(int i=0;i<15;i++)
	  {
		  String next=getInventory(list.get(i));
		  if(next.equals(list.get(i))&&i==0)
		  {
			return list.get(0)+" is self-inventorying";
		  }
		  else if(next.equals(list.get(i))&&i!=0)
		  {
			return list.get(0)+" is self-inventorying after "+i+" steps";  
		  }
		  else if(!next.equals(list.get(i)))
		  {
			  if(list.contains(next))
			  {
				
				  int pre=list.indexOf(next);
				  return list.get(0)+" enters an inventory loop of length "+(i-pre+1);   
			  }
			  else
			  {
				 
				  list.add(next);
			  }
		  }
		  
	  }
	  return list.get(0)+" can not be classified after 15 iterations";
	  
  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
		 ArrayList<String> list=new ArrayList<String>();
	     while(true)
	     {   String s=sc.next();
	     if(s.equals("-1"))
	    	  break;
	    	String re=getResult(s);
	    	list.add(re); 
	    	
	     }
	     for(int i=0;i<list.size();i++)
	     {
	    	 System.out.println(list.get(i));
	     }
    
	}

}
