package sort;

import java.util.ArrayList;

public class QuickSort {
    private ArrayList<Integer> list=new ArrayList<Integer>();
    public ArrayList<Integer> getList() {
		return list;
	}
    public String toString()
    {   String s ="";
    	for(int i=0;i<list.size();i++)
    	{
    		s+=list.get(i)+" ";
    	}
    	return s;
    }
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
	public QuickSort()
    {
    	list.add(6);
    	list.add(7);
    	list.add(5);
    	list.add(2);
    	list.add(5);
    	list.add(8);
    	
    }
	private int  partition(int start,int end)
	{
		int i=start;
		int x=list.get(start);
		int j=end+1;
		while(true)
		{ 
			while(list.get(--j)>x);
			while(list.get(++i)<x);
			if(i>=j)
		    break;
			else
			{
				int temp=list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		list.set(start, list.get(j));
		list.set(j, x);
		return j;
	}
public   void qSort(int p, int r)
	{

	if (p<r) {
	int q=partition(p,r); 
	qSort (p,q-1); //¶Ô×ó°ë¶ÎÅÅĞò
	qSort (q+1,r); //¶ÔÓÒ°ë¶ÎÅÅĞò
	}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       QuickSort qs=new QuickSort();
       qs.qSort(0, qs.getList().size()-1);
       System.out.println(qs.toString());
	}

}
