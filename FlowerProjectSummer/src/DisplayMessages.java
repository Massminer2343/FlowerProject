import javax.swing.JOptionPane;

public class DisplayMessages
{
	public void DisplayMessages()
	{
		JOptionPane.showMessageDialog(null,"Your health is "+String.format("%.2f",FlowerMain.humanHealth)+" and your plant's health is "+String.format("%.2f",FightClub.monsterHealth));
	}
	public void DisplayMessages(String humanMessage)
	{
		JOptionPane.showMessageDialog(null,FightClub.humanAttackMessage+"\n Your health is "+String.format("%.2f",FlowerMain.humanHealth)+" and your plant's health is "+String.format("%.2f",FightClub.monsterHealth));
	}
	public void DisplayMessages(String humanMessage, String plantMessage)
	{
		JOptionPane.showMessageDialog(null,FightClub.humanAttackMessage+ "\n"+FlowerMain.plantAttackMessage+"\n Your health is "+String.format("%.2f",FlowerMain.humanHealth)+" and your plant's health is "+String.format("%.2f",FightClub.monsterHealth));
	}
	public void DisplayMessages(String humanMessahe, String plantMessage, String extraMessage)
	{
		JOptionPane.showMessageDialog(null,FightClub.humanAttackMessage+ "\n"+FlowerMain.plantAttackMessage+"\n"+extraMessage+"\n"+" Your health is "+String.format("%.2f",FlowerMain.humanHealth)+" and your plant's health is "+String.format("%.2f",FightClub.monsterHealth));
	}
}
