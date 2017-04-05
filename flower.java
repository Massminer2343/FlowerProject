

package prATICE;
import java.util.Scanner;
public class flower extends Thread
{
	static Scanner input = new Scanner(System.in);
	static int time;
	public static void main(String[] args) 
	{
		CreateFlowers newFlower= new CreateFlowers();
		DerpalArt f1 = new DerpalArt();
		f1.setTitle("Pick a flower");
		f1.setBounds(100,100,500,500);
		f1.setVisible(true);
		GreenHouse();
		time= newFlower.getTime();
	}
	public static void GreenHouse()
	{
		int Event=0;
		double growth=0;
		System.out.println("start");
		for(int i=time; i>0; i--)
		{
			System.out.println("Your plant is "+growth+" grown out of "+time);
			System.out.print(i+" What will you do 0 to do nothing, 1 to water, 2 to fertlize 3 to kill>> ");
			Event=input.nextInt();
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{
					System.out.println("deryp");
				}

			if(Event == 0)
			{
				growth= growth+0.5;
			}
			if(Event == 1)
			{
				growth=growth+1;
			}
			if(Event == 2)
			{
				growth=growth+1.5;
			}
			if(Event == 3)
			{
				growth=growth-20000;
				System.out.println("YOU KILED YOUR FLOWER YOU EVIL PERSON!!!!!!");
				return;
			}
			if(growth >= time)
			{
				System.out.println("Congrats Your plant is grown!!!");
				return;
			}
			if(i==1)
			{
				if( growth<time)
				{
					System.out.println("taco");
				}
			}
		}
	}
}
