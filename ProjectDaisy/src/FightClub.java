import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class FightClub extends Frame implements ActionListener
{

	Button[][] canvas;
	public static int fightSlection;
	public static int monsterHealth = FlowerPicker.time*10;
	private static int damage;
	private static int fireUse;
	private static int appleUse=30;
	
	static FlowerDininishingReturns appleReturns=new FlowerDininishingReturns();
	
	public void setFightButtonPanel( String l1,String l2,String l3,String l4,String l5,String l6,String l7)
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
				canvas[i][j].setBackground(Color.red);
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
					canvas[i][j].setBackground(Color.orange);
					fightSlection=i+j;
					if(fightSlection==0||fightSlection==6){
						JOptionPane.showMessageDialog(null,"You gave up and your flower ate you. You are dead");
						System.exit(0);}
					if(fightSlection==1){
						monsterHealth=monsterHealth-5;
						JOptionPane.showMessageDialog(null,"5 damage. It seems punching a giant plant monster dosen't do much");}
					if(fightSlection==2){
						monsterHealth=monsterHealth+15;
						JOptionPane.showMessageDialog(null,"HOLY CRAP WEED KILLER HEALED IT!!!!! +15 health");}
					if(fightSlection==3){
						monsterHealth=monsterHealth-25;
						JOptionPane.showMessageDialog(null,"25 damage. Fire type atacks are super effective against plant types");}
					if(fightSlection==4){
						monsterHealth=monsterHealth-15;
						JOptionPane.showMessageDialog(null,"15 damage. I mean at least you tried. Right?");}
					if(fightSlection==5&&appleUse>0){
						FlowerMain.humanHealth=FlowerMain.humanHealth+appleReturns.diminishing_returns(damage,appleUse);
						damage=25; appleUse=appleUse-5;
						JOptionPane.showMessageDialog(null,"you ate an apple to gain health");}
					else{
						JOptionPane.showMessageDialog(null,"You dont like apples anymore and they dont seem to do anything now");}
					
					if(monsterHealth <= 0){
						JOptionPane.showMessageDialog(null,"Congrats Your defeated your plant... monster... thing... Wooo!!!");
						System.exit(0);}
					if(FlowerMain.humanHealth<=1 && monsterHealth>0){
							JOptionPane.showMessageDialog(null,"your plant ate you. you are dead. \n failure");}
				}
			}
		}
		FlowerMain.fightPanel.setVisible(false);
		//FlowerMain.monsterAtack();
		FlowerMain.fightClub();
	}
}