
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class plantTypePicker extends Frame implements ActionListener{

	Button[][] canvas;
	public static int typeSlection;
	
	public void setTypePickerButtonPanel( String l1,String l2,String l3,String l4,String l5,String l6,String l7)
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
				canvas[i][j].setBackground(Color.pink);
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
					canvas[i][j].setBackground(new Color(188,101,1));
					typeSlection=i+j;
					if (typeSlection==0)
					{
						FlowerMain.typePicker.setVisible(false);
						FlowerMain.Picker();
					}
					if (typeSlection==1)
					{
						FlowerMain.typePicker.setVisible(false);
						FlowerMain.woodPicker();
					}
					if (typeSlection>1)
					{
						FlowerMain.typePicker.setVisible(false);
						JOptionPane.showMessageDialog(null,"There is nothing here");
					}
					
				}
			}
		}
	}

}
