
import java.util.Scanner;
import javax.swing.JOptionPane;
public class FlowerMain extends Thread{
	static Scanner input=new Scanner(System.in);
	static FlowerPicker flower1;
	static GreenHouse greenPanel;
	static FightClub fightPanel;
	static plantTypePicker typePicker;
	static WoodedPicker  WoodPicker;
	static DisplayMessages messages = new DisplayMessages();
	
	static boolean evilMonster=false;
	public static boolean bound=false;
	
	
	public static double humanHealth=150;
	public static int time;
	static double numAtacks=1;
	static float plantExtDmg=3;
	static int weeds=35;
	static int weedAmount=0;
	public static double leafCutDmgMod=1;
	public static double pollenSprayDmgMod=1;
	public static String plantAttackMessage;
	public static String extraMessage;
	public static int numAttacks=10;
	
	
	public static void main(String[] args)
	{
		typePicker();
	}
	
	public static void typePicker()
	{
		typePicker=new plantTypePicker();
		typePicker.setTypePickerButtonPanel("perenials","treeLike","carniverous",null,null,null,null);
		typePicker.setTitle("What type of plant do you want");
		typePicker.setBounds(0,0,1000,100);
		typePicker.setVisible(true);
	}
	
	public static void woodPicker()
	{
		WoodPicker=new WoodedPicker();
		WoodPicker.setWoodedButtonPanel("Sagebrush","Bonsai","Lilacs","poision ivy","Burning bush",null,null);
		WoodPicker.setBounds(0,0,1000,100);
		WoodPicker.setVisible(true);
	}
	
	public static void Picker()
	{
		flower1=new FlowerPicker();	
		flower1.setFlowerButtonPanel("Daisy","Tulip","Sunflower","Rose","Water lily","carnation","snapdragon");
		flower1.setTitle("Pick your flower");
		flower1.setBounds(0,0,1000,100);
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
				
				if(GreenHouse.water<=50)
				{
					JOptionPane.showMessageDialog(null,"Your plant isn't growing as fast, consider watering.");
					GreenHouse.growthMod=.5;
				}
				greenPanel=new GreenHouse();
				greenPanel.setGreenButtonPanel("Do nothing","Water","Use fertlizer","KIll","Use magic fairy dust","Sing to plant","De-weed");
				greenPanel.setTitle("What Will you do to your plant");
				greenPanel.setBounds(0,0,1000,100);
				greenPanel.setVisible(true);
				
				double rand = (1+(int)(Math.random()*10));
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
		
		if(humanHealth <0 && FightClub.monsterHealth>0)
		{
			JOptionPane.showMessageDialog(null,"your plant ate you. you are dead. \n failure");
			System.exit(0);
		}
		if(FightClub.humanAttackMessage!=null && plantAttackMessage!=null && extraMessage !=null)
			messages.DisplayMessages(FightClub.humanAttackMessage,plantAttackMessage, extraMessage);
		else if(FightClub.humanAttackMessage!=null && plantAttackMessage!=null)
			messages.DisplayMessages(FightClub.humanAttackMessage,plantAttackMessage);
		else if(FightClub.humanAttackMessage!=null)
			messages.DisplayMessages(FightClub.humanAttackMessage);
		else if(FightClub.humanAttackMessage==null)
			messages.DisplayMessages();
		fightPanel=new FightClub();
		fightPanel.setFightButtonPanel("Give up","Punch","Use weed killer","BURN!","Dig up","Eat an apple","Use plant shears");
		fightPanel.setTitle("What Will you do to your plant");
		fightPanel.setBounds(0,0,1000,100);
		fightPanel.setVisible(true);
		extraMessage=null;
		plantAttackMessage=null;
	}
	
	public static void monsterAtack()
	{
		
		if (fightPanel.fightSlection==1  && flower1.flowerSlection==3 || fightPanel.fightSlection==1  && WoodPicker.woodedSlection==3 || fightPanel.fightSlection==1 && WoodedPicker.woodedSlection==4){
			extraMessage="You punched a deadly plant what did you expect -5 health";
			humanHealth=humanHealth-5;
			plantExtDmg=5;}
		if(WoodPicker.woodedSlection==4)
			numAttacks=11;
			
			while(numAtacks>=1)
			{
				numAtacks=numAtacks-1;
				
				double rand = (1+(int)(Math.random()*numAttacks));	

				if((rand==1||rand==6||rand==7) && bound==false){
					plantAttackMessage="You dun got punched in the face by a plant! -5 health.";
					humanHealth = humanHealth - 5;
					bound=false;}
			
				if((rand==2 && bound==false) || (rand==8 && bound==false)){
					plantAttackMessage="The plant monster used vine wip -10 health.";
					humanHealth=humanHealth-10;
					bound=false;}
			
				if((rand==3 && bound==false)||(rand==9 && bound==false)){
					plantAttackMessage="It bit you! that meanie -10 health.";
					humanHealth=humanHealth-10;
					bound=false;}
				if(rand==4 && bound==false){
					plantAttackMessage="Your plant cut you with its leaves -15 health.";
					humanHealth=humanHealth-(15*leafCutDmgMod);
					bound=false;}
				if(rand==5 && bound==false){
					plantAttackMessage="Plant Monster used acid pollen spray -20 health.";
					humanHealth=humanHealth-(20*pollenSprayDmgMod);
					bound=false;}
				if(rand==10 && bound==false){
					plantAttackMessage="The monster has encased you in roots and you can't attack.";
					humanHealth=humanHealth-(5);
					bound=true;}
				if(rand==11 && bound==false)
					plantAttackMessage="Your bush is on fire!!!!! 25 damage.";
					humanHealth=humanHealth-25;
				if(WoodPicker.woodedSlection==3){
					humanHealth=humanHealth-plantExtDmg;
					extraMessage="Due to poision ivy being poisionous you take "+plantExtDmg+" extra damage per turn";}
				
				if(bound=true && rand==10){
					numAtacks=numAtacks+1;
					bound=false;}
			}
			if(numAtacks<1)
			{
				if(typePicker.typeSlection==1)
					numAtacks=numAtacks+.5;
				else
				{
					numAtacks=numAtacks+1;
					if(FlowerPicker.flowerSlection==6)
					{
						numAtacks=numAtacks+1;
					}
				}
			}
		}
	}
