
package prATICE;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class FlowerPicker extends Frame implements ActionListener
{
		Button[][] canvas;
		static List<String> flowers = new ArrayList<String>();
	public FlowerPicker()
	{
		int rows =1;
		int numFlowers=4;
		flowers.add("Daisy");
		flowers.add("Tulip");
		flowers.add("Sunflower");
		canvas = new Button[rows][numFlowers];
		this.setLayout(new GridLayout(rows,numFlowers));
		
		// adds window adapter so frame will close
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		}
		);
		for(int i = 0; i < canvas.length; i ++)
		{
			for(int j = 0; j < flowers.size(); j++)
			{
				canvas[i][j] = new Button();
				canvas[i][j].addActionListener(this);
				canvas[i][j].setBackground(Color.CYAN);
				canvas[i][j].setLabel(flowers.get(j));
				add(canvas[i][j]);
			}
		}
	}

	public static void main(String[] args)
	{
		DerpalArt f1 = new DerpalArt();
		f1.setTitle("Pick a flower");
		f1.setBounds(100,100,500,500);
		f1.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i = 0; i < canvas.length; i ++)
		{
			for(int j = 0; j < canvas[0].length; j ++)
			{
				if(e.getSource() == canvas[i][j])
				{
					canvas[i][j].setBackground(Color.pink);
					int Slection = i+j;
					if(Slection == 0)
					{
						JOptionPane.showMessageDialog(null, "Daisy slected");
						System.exit(0);
					}
					if(Slection == 1)
					{
						JOptionPane.showMessageDialog(null,"Tulip slected");
						System.exit(0);
					}
					if(Slection == 2)
					{
						System.out.println("Sunflower slected");
						System.exit(0);
					}
				}
			}
		}
	}
}
