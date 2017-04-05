
package prATICE;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class DerpalArt extends Frame implements ActionListener
{
	Button[][] canvas;
		static List<String> flowers = new ArrayList<String>();
		public int Slection;
		private int time;
	public DerpalArt()
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
					Slection = i+j;
					if(Slection == 0)
					{
						JOptionPane.showMessageDialog(null, "Daisy slected");
						time=10;
					}
					if(Slection == 1)
					{
						JOptionPane.showMessageDialog(null,"Tulip slected");
						time=15;
					}
					if(Slection == 2)
					{
						JOptionPane.showMessageDialog(null,"Sunflower slected");
						time=20;
					}
				}
			}
		}
	}
	public int getSlection()
	{
		return Slection;
	}
}
