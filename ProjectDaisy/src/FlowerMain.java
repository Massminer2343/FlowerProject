
import java.util.Scanner;
import javax.swing.JOptionPane;
public class FlowerMain extends Thread{
	static Scanner input=new Scanner(System.in);
	static FlowerPicker flower1;
	static GreenHouse greenPanel;
	static FightClub fightPanel;
	static plantTypePicker typePicker;
	static WoodedPicker  WoodPicker;
	
	
	static boolean evilMonster=false;
	
	
	public static double humanHealth=150;
	public static int time;
	static float atackSpeed=1;
	static float plantExtDmg=3;
	static double cutDmgMod=1;
	static int weeds=35;
	static int weedAmount=0;
	
	public static void main(String[] args)
	{
		typePicker();
	}
	
	public static void typePicker()
	{
		typePicker=new plantTypePicker();
		typePicker.setTypePickerButtonPanel("perenials","treeLike","carniverous",null,null,null,null);
		typePicker.setTitle("What type of plant do you want");
		typePicker.setBounds(200,200,1000,1000);
		typePicker.setVisible(true);
	}
	
	public static void woodPicker()
	{
		WoodPicker=new WoodedPicker();
		WoodPicker.setWoodedButtonPanel("Sagebrush","Bonsai","Lilacs","poision ivy",null,null,null);
		WoodPicker.setBounds(200,200,1000,1000);
		WoodPicker.setVisible(true);
	}
	
	public static void Picker()
	{
		flower1=new FlowerPicker();	
		flower1.setFlowerButtonPanel("Daisy","Tulip","Sunflower","Rose","lilli","carnation","snapdragon");
		flower1.setTitle("Pick your flower");
		flower1.setBounds(200,200,1000,1000);
		flower1.setVisible(true);
	}
	public static void weedAmountCalc()
	{
		switch(weeds)
		{
		case 30:
			weedAmount=1;
		break;
		case 25:
			weedAmount=2;
		break;
		case 20:
			weedAmount=3;
		break;
		case 15:
			weedAmount=3;
		break;
		case 10:
			weedAmount=4;
		break;
		case 5:
			weedAmount=5;
		break;
		default:
			weedAmount=0;
		}
		}
	public static void greenHouse()
	{
		
			if (GreenHouse.useTime >=0)
			{
				weedAmountCalc();
				
				if (weeds<35)
					JOptionPane.showMessageDialog(null,"Your plant is "+String.format("%.2f",(GreenHouse.growth/time)*100)+"% grown\n"
							+ "Also there are "+weedAmount+" weeds that have grown in your garden consider de-weedeing");
				else
					JOptionPane.showMessageDialog(null,"Your plant is "+String.format("%.2f",(GreenHouse.growth/time)*100)+"% grown");
				greenPanel=new GreenHouse();
				greenPanel.setGreenButtonPanel("Do nothing","Water","Use fertlizer","KIll","Use magic fairy dust","Sing to plant","De-weed");
				greenPanel.setTitle("What Will you do to your plant");
				greenPanel.setBounds(200,200,1000,1000);
				greenPanel.setVisible(true);
				
				double rand = (1+(int)(Math.random()*10));
				System.out.println(rand+""+weeds);
				if(rand >= 7.5)
				{
					weeds=weeds-5;
				}
				if(weeds<=0)
				{
					JOptionPane.showMessageDialog(null,"Your plant got eaten by weeds and died");
					System.exit(0);
				}
			}
	}
	
	public static void fightClub()
	{
		JOptionPane.showMessageDialog(null,("your health is "+String.format("%.2f",humanHealth)+" and your plant's health is "+String.format("%.2f",FightClub.monsterHealth)));
		fightPanel=new FightClub();
		fightPanel.setFightButtonPanel("Give up","Punch","Use weed killer","BURN!","Dig up","Eat an apple","Use plant shears");
		fightPanel.setTitle("What Will you do to your plant");
		fightPanel.setBounds(200,200,1000,1000);
		fightPanel.setVisible(true);
	}
	
	public static void monsterAtack()
	{
		
		if (fightPanel.fightSlection==1  && flower1.flowerSlection==3 || fightPanel.fightSlection==1  && WoodPicker.woodedSlection==3){
			JOptionPane.showMessageDialog(null,"You punched a deadly plant what did you expect -5 health");
			humanHealth=humanHealth-5;
			plantExtDmg=5;}
		
		if(atackSpeed==1)
		{
			switch(plantTypePicker.typeSlection){
			case(0):
				atackSpeed=1;
			break;
			case(1):
				atackSpeed=2;
			break;
			default:
				atackSpeed=1;}
			
			if(plantTypePicker.typeSlection==0 && FlowerPicker.flowerSlection==4){
				cutDmgMod=1.5;}
			
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
				humanHealth=humanHealth-(15*cutDmgMod);}
			if(rand==5){
				JOptionPane.showMessageDialog(null,"Plant Monster used acid pollen spray -20 health");
				humanHealth=humanHealth-20;}
			if(WoodPicker.woodedSlection==3){
				humanHealth=humanHealth-plantExtDmg;
				JOptionPane.showMessageDialog(null,"Due to poision ivy being poisionous you take "+plantExtDmg+" extra damage per turn");}
		}
		else if(atackSpeed>=2)
		{
			atackSpeed=atackSpeed-1;
		}
		
		
	}
}
