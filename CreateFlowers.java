package prATICE;

public class CreateFlowers
{
	private int time;
	private int Slection;
	public void runPicker()
	{
	DerpalArt f1 = new DerpalArt();
	f1.setTitle("Pick a flower");
	f1.setBounds(100,100,500,500);
	f1.setVisible(true);
	Slection=f1.getSlection();
	}
	public void setTime()
	{
		if(Slection==0);
		{
			time=10;
			System.out.println(time+"");
		}
		if(Slection==1);
		{
			time=15;
		}
		if(Slection==2);
		{
			time=20;
		}
	}
	public int getTime()
	{
		return time;
	}
}
