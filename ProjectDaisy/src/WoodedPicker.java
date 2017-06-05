
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class WoodedPicker extends Frame implements ActionListener{

	Button[][] canvas;
	public static int woodedSlection;
	
	public void setWoodedButtonPanel( String l1,String l2,String l3,String l4,String l5,String l6,String l7)
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
				canvas[i][j].setBackground(new Color(150,80,1));
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
					canvas[i][j].setBackground(new Color(234,165,86));
					woodedSlection=i+j;
					if(woodedSlection == 0 || woodedSlection == 4 || woodedSlection == 5 || woodedSlection == 6){
						JOptionPane.showMessageDialog(null,"Sagebrush slected!");
						FlowerMain.time=30;
					}
					if(woodedSlection == 1){
						JOptionPane.showMessageDialog(null,"Bonsai selected!");
						FlowerMain.time=35;
					}
					if(woodedSlection == 2){
						JOptionPane.showMessageDialog(null,"Lilac selected");
						FlowerMain.time=40;
					}
					if(woodedSlection == 3){
						JOptionPane.showMessageDialog(null,"Poision ivy  selected");
						FlowerMain.time=35;
					}
				}
			}
		}
		FlowerMain.WoodPicker.setVisible(false);
		FlowerMain.greenHouse();
	}

}


