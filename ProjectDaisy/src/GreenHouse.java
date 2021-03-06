import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class GreenHouse extends Frame implements ActionListener
{

	Button[][] canvas;
	private int greenSlection;
	private int greenTime=FlowerPicker.time;
	public static int useTime=FlowerPicker.time;
	public static double growth;
	public static boolean isMonster=false;
	
	public void setGreenButtonPanel( String l1,String l2,String l3,String l4,String l5,String l6,String l7)
	{
		List <String>listNum = new ArrayList<String>();
		listNum.add(l1);
		listNum.add(l2);
		listNum.add(l3);
		listNum.add(l4);
		listNum.add(l5);
		listNum.add(l6);
		listNum.add(l7);
		
		int rows=1;
		int colums=7;
		canvas=new Button[rows][colums];
		this.setLayout(new GridLayout(rows,colums));
		
		for(int i=0; i<canvas.length; i++)
		{
			for(int j=0; j<canvas[0].length;j++)
			{
				canvas[i][j]=new Button();
				canvas[i][j].addActionListener(this);
				canvas[i][j].setBackground(Color.green);
				canvas[i][j].setLabel(listNum.get(j));
				add(canvas[i][j]);
			}
		}
	}
	public void actionPerformed(ActionEvent b) 
	{
		for(int i=0; i<canvas.length; i++)
		{
			for(int j=0; j<canvas[0].length; j++)
			{
				if(b.getSource()==canvas[i][j])
				{
					useTime=useTime-1;
					canvas[i][j].setBackground(Color.yellow);
					greenSlection=i+j;
					if(greenSlection == 0 || greenSlection == 5 || greenSlection == 6){
						JOptionPane.showMessageDialog(null,"You did nothing to your plant.\nTake care of it!");
						growth=growth+0;}

					if(greenSlection == 1){
						JOptionPane.showMessageDialog(null,"Your plant seems happy that you watered it!\n Good Job!");
						growth=growth+1;}
					if(greenSlection == 2){
						JOptionPane.showMessageDialog(null,"You gave planty fertlizer it seems greener!\n Keep it up!");
						growth=growth+1.5;}
					if(greenSlection == 3){
						JOptionPane.showMessageDialog(null,"YOU KILLED YOUR PLANT!!!!\nYOU LUNATIC!!!!!!");
						growth=growth-1000000;
						System.exit(0);}
					if(greenSlection == 4){
						JOptionPane.showMessageDialog(null,"You sprinkle magic fairy dust on your plant.\n It begins to grow rapidly before your eyes.");
						growth=growth+0;
						isMonster=true;}
					if(growth >= greenTime){
						JOptionPane.showMessageDialog(null,"Congrats Your plant is grown!!!");
						System.exit(0);}
					if(useTime <=1 && growth < greenTime){
						JOptionPane.showMessageDialog(null,"Your plant didn't survive\n failure");
						System.exit(0);}
				}
			}
		}
	if(isMonster==true){
		FlowerMain.fightClub();
		FlowerMain.greenPanel.setVisible(false);}
	else{
		FlowerMain.greenPanel.setVisible(false);
		FlowerMain.greenHouse();}
	}
}
