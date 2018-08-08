package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Deligators.ISeaVehicle;
import Deligators.IVehicle;

public class ChangeFlagFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private String[] flagsArr = { "Israel", "USA", "Germany", "Italy", "Greece", "Somalia", "Pirates" };
	// JButton----------------------------------------------------------------------------------------------------------------------------------------------
	private JButton changeB=new JButton("Change");
	private JButton backB=new JButton("back");
	//ImageIcon--------------------------------------------------------------------------------------------------------------------------------------
	private ImageIcon backI=new ImageIcon("pic\\icon_back2.png");
	private ImageIcon changeI=new ImageIcon("pic\\icon_change.png");
	//IconImage-------------------------------------------------------------------------------------------------------------------------------------
	private ImageIcon israelI=new ImageIcon("pic\\israel.png");
	private ImageIcon usaI=new ImageIcon("pic\\usa.png");
	private ImageIcon germanyI=new ImageIcon("pic\\germany.png");
	private ImageIcon italyI=new ImageIcon("pic\\italy.png");
	private ImageIcon greeceI=new ImageIcon("pic\\greece.png");
	private ImageIcon somaliaI=new ImageIcon("pic\\somalia.png");
	private ImageIcon piratesI=new ImageIcon("pic\\pirates.png");
	private ImageIcon[] imageIconArr= {israelI,usaI,germanyI,italyI,greeceI,somaliaI,piratesI};
	//JLabel-----------------------------------------------------------------------------------------------------------------------------------------
	private JLabel titleL=new JLabel("Change flag");
	//JPanel-----------------------------------------------------------------------------------------------------------------------------------------
	private JPanel mainP=new JPanel();
	private JPanel titleP=new JPanel();
	private JPanel flagP=new JPanel();
	private JPanel buttonP=new JPanel();
	//FlowLayout-------------------------------------------------------------------------------------------------------------------------------------
	private FlowLayout myFlowLayout=new FlowLayout();
	// JComboBox----------------------------------------------------------------------------------------------------------------------------------------------
	private JComboBox<ImageIcon> flagCB = new JComboBox<ImageIcon>(imageIconArr);
	//Font-------------------------------------------------------------------------------------------------------------------------------------------
	private Font font22=new Font("Century Gothic", Font.PLAIN, 22);
	
	public ChangeFlagFrame(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles) {
		this.setTitle("Change falg");
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createChangeFlagPanel();
		
		changeB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i=0;i<seaVehicles.size();i++)
				{
					seaVehicles.get(i).setFlag(flagsArr[flagCB.getSelectedIndex()]);
				}
				switchToMainWindow(vehiclesAgency, seaVehicles);
				if (seaVehicles.size()>0)
				JOptionPane.showMessageDialog(null,"All flags change to "+ flagsArr[flagCB.getSelectedIndex()]);
				else
					JOptionPane.showMessageDialog(null,"Not exist sea vehicles in agency");
					
			}
		});
		backB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchToMainWindow(vehiclesAgency, seaVehicles);
				
			}
		});
	}
	public void createChangeFlagPanel()
	{
		myFlowLayout.setAlignment(FlowLayout.CENTER);
		this.setLayout(new BorderLayout());
		mainP.setLayout(new BorderLayout());
		buttonP.setLayout(myFlowLayout);
		myFlowLayout.setHgap(50);
				
		titleL.setFont(new Font("Century Gothic", Font.PLAIN, 52));
		backB.setPreferredSize(new Dimension(200, 50));
		changeB.setPreferredSize(new Dimension(200, 50));
		
		backB.setFont(font22);
		changeB.setFont(font22);
		
		backB.setIcon(backI);
		changeB.setIcon(changeI);
		
		titleP.setLayout(myFlowLayout);
		flagP.setLayout(myFlowLayout);	
				
		titleP.add(titleL);
		flagP.add(flagCB);
		buttonP.add(changeB);
		buttonP.add(backB);
		
		mainP.add(titleP,BorderLayout.NORTH);
		mainP.add(flagP, BorderLayout.CENTER);
		mainP.add(buttonP, BorderLayout.SOUTH);
		
		add(mainP,BorderLayout.NORTH);
		
	
		
	}
	public static ImageIcon resizeImage(ImageIcon image)
	{
		Image newImage=image.getImage();
		Image tmp=newImage.getScaledInstance(256, 140, Image.SCALE_REPLICATE);
		image = new ImageIcon(tmp);
		return image;
	}
	public void switchToMainWindow(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles)
	{
		for (int i=0;i<vehiclesAgency.size();i++)
			System.out.println(vehiclesAgency.get(i).toString());
		for (int i=0;i<seaVehicles.size();i++)
			System.out.println(seaVehicles.get(i).toString());
		this.dispose();
		MainFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
	}
}
