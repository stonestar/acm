
public class MinHeap {
   public static void makeMinHeap(int[] input,int n)
   {
	   for(int i=0;i<n;i++)
	   {
		   int temp=i;
		   int in=input[i];
		   while(temp>0)
		   {
			 
			   if(input[(temp-1)/2]>input[i])
			   {
				   input[temp]=input[(temp-1)/2];
				   temp=(temp-1)/2;
			   }
			   else
			   {
				 
				   break;
			   }
			  
		   }
		   input[temp]=in;
		  
	   }
   }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] input={1,0};
      makeMinHeap(input,2);
      for(int i=0;i<2;i++)
      {
    	  System.out.println(input[i]+" ");
      }
	}

}
