
import java.util.Scanner;
import javax.swing.JOptionPane;
public class FlowerMain extends Thread{
	static Scanner input=new Scanner(System.in);
	static FlowerPicker flower1;
	static GreenHouse greenPanel;
	static FightClub fightPanel;
	
	static boolean evilMonster=false;
	
	
	public static double humanHealth=150;
	public static void main(String[] args)
	{
		Picker();
	}
	public static void Picker()
	{
		flower1=new FlowerPicker();	
		flower1.setFlowerButtonPanel("Daisy","Tulip","Sunflower","Rose",null,null,null);
		flower1.setTitle("Pick your flower");
		flower1.setBounds(200,200,1000,1000);
		flower1.setVisible(true);
	}
	public static void greenHouse()
	{
		
			if (GreenHouse.useTime >=0)
			{
				JOptionPane.showMessageDialog(null,"Your plant is "+(GreenHouse.growth/FlowerPicker.time)*100+"% grown");
				greenPanel=new GreenHouse();
				greenPanel.setGreenButtonPanel("Do nothing","Water","Use fertlizer","KIll","Use magic fairy dust",null,null);
				greenPanel.setTitle("What Will you do to your plant");
				greenPanel.setBounds(200,200,1000,1000);
				greenPanel.setVisible(true);
			}
	}
	public static void fightClub()
	{
		JOptionPane.showMessageDialog(null,String.format("your health is %.1f",humanHealth+" and your plant's health is "+FightClub.monsterHealth));
		fightPanel=new FightClub();
		fightPanel.setFightButtonPanel("Give up","Punch","Use weed killer","BURN!","Dig up","Eat an apple",null);
		fightPanel.setTitle("What Will you do to your plant");
		fightPanel.setBounds(200,200,1000,1000);
		fightPanel.setVisible(true);
	}
	public static void monsterAtack()
	{
		
			if (fightPanel.fightSlection==1  && flower1.flowerSlection==3){
					JOptionPane.showMessageDialog(null,"You punched a rose what did you expect -5 health");
					humanHealth=humanHealth-5;}
		
		double rand = (1+(int)(Math.random()*8));	

		if(rand==1||rand==6||rand==7){
			JOptionPane.showMessageDialog(null,"You dun got punched in the face by a plant! -5 health");
			humanHealth = humanHealth - 5;}
		
		if(rand==2 || rand==8){
			JOptionPane.showMessageDialog(null,"The plant monster used vine wip -10 health");
			humanHealth=humanHealth-10;}
		
		if(rand==3||rand==9){
			JOptionPane.showMessageDialog(null,"It bit you! that meanie -10 health");
			humanHealth=humanHealth-10;}

		if(rand==4){
			JOptionPane.showMessageDialog(null,"Your plant cut you with its leaves -15 health");
			humanHealth=humanHealth-15;}
		if(rand==5){
			JOptionPane.showMessageDialog(null,"Plant Monster used acid pollen spray -20 health");
			humanHealth=humanHealth-20;}
	}
}
