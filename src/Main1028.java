import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Main1028 {
    private static Stack<String> forwardStack=new Stack<String>();
    private static Stack<String> backStack=new Stack<String>();
    private static ArrayList<String> reslist=new ArrayList<String>();
    private static String COM_BACK="BACK";
    private static String COM_FORWARD="FORWARD";
    private static String COM_VISTT="VISIT";
    private static String COM_QUIT="QUIT";
    private static String IGNORED="Ignored";
    private static String CurrentPage="http://www.acm.org/";
    public static String getResBack()
    {
		if(backStack.isEmpty())
		{
			reslist.add(IGNORED);
			return IGNORED;
		}
		else
		{
			forwardStack.push(CurrentPage);
			String res=backStack.pop();
			CurrentPage=res;
			reslist.add(res);
			return res;
		}
    	
    
    }
    public static String getResForward()
    {
    	if(forwardStack.isEmpty())
    	{
    		reslist.add(IGNORED);
    		return IGNORED;
    	}
		else
		{
			backStack.push(CurrentPage);
			String res=forwardStack.pop();
			CurrentPage=res;
			reslist.add(res);
			return res;
		}
    
    }
    public static String getResVisit(String url)
    {
		
    	forwardStack.clear();
    	if(!CurrentPage.equals(""))
    	backStack.push(CurrentPage);
    
    	CurrentPage=url;
    	reslist.add(url);
    	return url;
    
    }
    public static void quit()
    {
    	forwardStack.clear();
    	backStack.clear();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
      Scanner sc=new Scanner(System.in);
    
      while(true)
      {     String curcmd=sc.next();
    	  if(curcmd.equals(COM_VISTT))
    	  {
    		  String url=sc.next();
    		 getResVisit(url);
    	  }
    	  else if(curcmd.equals(COM_BACK))
    	  {
    		 getResBack();
    	  }
    	  else if(curcmd.equals(COM_FORWARD))
    	  {
    		getResForward();
    	  }
    	  else if(curcmd.equals(COM_QUIT))
    	  {
    		  quit();
    		  break;
    	  }
    	  else
    	  {
    		  break;
    	  }
      }
      for(int i=0;i<reslist.size();i++)
      {
    	  System.out.println(reslist.get(i));
      }
	}

}
