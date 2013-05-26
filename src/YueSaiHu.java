import java.util.ArrayList;


public class YueSaiHu {
    
	public static int getWinner(int n,int read)
	{
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=1;i<=n;i++)
		{
			list.add(i);
		}
		int start=0;
		for(int j=0;j<n-1;j++)
		{   
			int mod=read%list.size();
			int index=(start+mod-1+list.size())%list.size();
			
			if(index!=list.size()-1)
			{
				start=index;
			}
			else
			{
				start=0;
			}
			
			list.remove(index);
		}
		
		return list.get(0);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int re=getWinner(8,3);
      System.out.println("Answer:"+re);
	}

}
