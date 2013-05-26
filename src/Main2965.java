import java.util.ArrayList;
import java.util.Scanner;


public class Main2965 {
	
	private class Node
	{
	 public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
		public int getJ() {
			return j;
		}
		public void setJ(int j) {
			this.j = j;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
		}
	private int i,j,state;
	  public Node(int i,int j,int state)
	  {
		  this.i=i;
		  this.j=j;
		  this.state=state;
	  }
	}
	//eg :beformessage[25609]=12345,1,2��ʾ״̬25609����״̬12345����1,2�����ģ�
	private Node[] beformessage=new Node[65536];
	private int[] step=new int[65536];
	//eg:hasOpeare[12345]=true;��ʾ״̬12345�Ѿ��仯����
	
	private boolean[] hasOperare=new boolean[65536];
	//�����״̬���ϣ���ʼʱֻ�п�ʼ״̬
	private int[] list=new int[65536];
	//��ʾ������Ҫ�����list�����λ�ã�С��index���Ѿ������
	private int index=0;
	//���״̬��λ��
	private int addindex=0;
	//��ʼ��״ֵ̬
	private int beginstate=0;
	//��ȡ��ʼ״̬
	private void Init()
	{
		for(int i=0;i<65536;i++)
		{
			this.hasOperare[i]=false;
			this.step[i]=-1;
		}
		//-1��ʾΪ��ʼλ��
		this.beformessage[this.beginstate]=new Node(0,0,-1);
		this.step[this.beginstate]=0;
	}
   private ArrayList<Integer> getSteps()
   {  
	   ArrayList<Integer> list=new ArrayList<Integer>();
	   int x=65535;
	  while(x!=this.beginstate)
	  {
		list.add(this.beformessage[x].getI()*4+this.beformessage[x].getJ());
		x=this.beformessage[x].getState();
	  }
	return list;
	   
   }
   private void BSF()
   {
	    this.list[addindex]=this.beginstate;
	    addindex++;
	   
	    while(this.addindex>=this.index)
	    {
	    	int curstate=this.list[index];
	    	if(curstate==65535)
	    	{
	    		System.out.println(this.step[65535]);
	    		return ;
	    	}
	    	else
	    	{
	    		for(int i=0;i<4;i++)
	    		{
	    			for(int j=0;j<4;j++)
	    			{
	    			 int afterstate=this.getAfterState(curstate, i, j);
	    			 if(!this.hasOperare[afterstate])
	    			 {
	    				 this.hasOperare[afterstate]=true;
	    				 this.beformessage[afterstate]=new Node(i,j,curstate);
	    				 this.step[afterstate]=this.step[curstate]+1;
	    				 this.list[addindex]=afterstate;
	    			//	 System.out.println("beforstate:"+curstate+"  afterstate:"+afterstate);
	    				 addindex++;
	    			 }
	    			}
	    		}
	    		index++;
	    		
	    	
	    	}
	    }
   }
   public int getBeginState()
   {
	   //65535��ʾ����ȫ����������+����ʾΪ0����-����ʾ1
	   int temp=0;
	   Scanner sc=new Scanner(System.in);
	   for(int i=0;i<4;i++)
	   {
	    String str=sc.next();
	    for(int j=0;j<4;j++)
	    {
	    	if(str.charAt(j)=='-')
	    	{
	    		temp|=(1<<((3-i)*4+3-j));
	    	}
	    }
	   }
	   this.beginstate=temp;
	   return temp;
	   
   }
	//���ض�״̬��ת�ض�λ�ú��״̬,i��ʾ�У�j��ʾ��
   public  int getAfterState(int state,int i,int j)
   {
	   int temp=0;
	   
	   for(int k=0;k<4;k++)
	   {
		   temp|=(1<<((3-k)*4+3-j));
		   temp|=(1<<((3-i)*4+3-k));
	   }
	   
	   return state^temp;
   
   }

	
   
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Main2965 m=new Main2965();
	  int x=m.getBeginState();
	 // System.out.println("State:"+x);

	   m.BSF();
	   ArrayList<Integer> list=m.getSteps();
	   for(int i=list.size()-1;i>=0;i--)
	   {
		   int a=list.get(i)/4+1;
		   int b=list.get(i)%4+1;
		   System.out.println(a+" "+b);
	   }
	}

}
