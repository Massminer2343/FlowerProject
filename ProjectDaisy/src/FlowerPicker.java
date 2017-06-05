import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class FlowerPicker extends Frame implements ActionListener{

	Button[][] canvas;
	public static int flowerSlection;
	
	public void setFlowerButtonPanel( String l1,String l2,String l3,String l4,String l5,String l6,String l7)
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
					canvas[i][j].setBackground(Color.yellow);
					flowerSlection=i+j;
					if(flowerSlection == 0){
						JOptionPane.showMessageDialog(null,"Daisy selected!");
						FlowerMain.time=10;
					}
					if(flowerSlection == 1){
						JOptionPane.showMessageDialog(null,"Tulip selected!");
						FlowerMain.time=15;
					}
					if(flowerSlection == 2){
						JOptionPane.showMessageDialog(null,"Sunflower selected");
						FlowerMain.time=20;
					}
					if(flowerSlection == 3){
						JOptionPane.showMessageDialog(null,"Rose selected");
						FlowerMain.time=25;
					}
					if(flowerSlection == 4){
						JOptionPane.showMessageDialog(null,"");
						FlowerMain.time=25;
					}
					if(flowerSlection == 5){
						JOptionPane.showMessageDialog(null,"");
						FlowerMain.time=25;
					}
					if(flowerSlection == 6){
						JOptionPane.showMessageDialog(null,"");
						FlowerMain.time=25;
					}
				}
			}
		}
		FlowerMain.flower1.setVisible(false);
		FlowerMain.greenHouse();
	}

}
