package GUI;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Deligators.ISeaVehicle;
import Deligators.IVehicle;

public class BuyVehiclesFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//JLabel-----------------------------------------------------------------------------------------------------------------------------------------
	private JLabel successL=new JLabel("Purchase successful");
	private JLabel detailsL=new JLabel("Your vehicles details");
	private JLabel vehicleDetailsL=new JLabel();
	private JLabel imageL=new JLabel();
	//JPanel-----------------------------------------------------------------------------------------------------------------------------------------
	private JPanel mainPanel=new JPanel();
	private JPanel titlePanel=new JPanel();
	private JPanel detailsPanel=new JPanel();
	private JPanel vehiclesDetailsPanel=new JPanel();
	private JPanel imagePanel=new JPanel();
	private JPanel buttonPanel=new JPanel();
	//GridLayout-------------------------------------------------------------------------------------------------------------------------------------
	private GridLayout GR=new GridLayout(9, 1);
	//FlowLayout-------------------------------------------------------------------------------------------------------------------------------------
	private FlowLayout mainFlowLayout=new FlowLayout();
	//JButton----------------------------------------------------------------------------------------------------------------------------------------
	private JButton backToAgencyB=new JButton("Back");
	//Font-------------------------------------------------------------------------------------------------------------------------------------------
	private Font font15=new Font("Century Gothic", Font.PLAIN, 15);
	
	
	public BuyVehiclesFrame(Vector<IVehicle> vehiclesAgency,Vector<ISeaVehicle>seaVehicles,int index)
	{
		this.setTitle("Purchase successful");
		this.setSize(1900, 950);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		createBuyVehiclesPanel(vehiclesAgency, index);
		
		backToAgencyB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchToMainWindow(vehiclesAgency,seaVehicles);
			}
		});
	}
	private void createBuyVehiclesPanel(Vector<IVehicle>vehiclesAgency,int index)
	{
		this.setLayout(mainFlowLayout);
		mainPanel.setLayout(GR);
		GR.setVgap(0);
		
		vehicleDetailsL.setText(vehiclesAgency.get(index).toString());
		imageL.setIcon(vehiclesAgency.get(index).getImage());
		
		successL.setFont(new Font("Century Gothic", Font.PLAIN, 72));
		detailsL.setFont(new Font("Century Gothic", Font.PLAIN, 52));
		vehicleDetailsL.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		backToAgencyB.setPreferredSize(new Dimension(200, 50));
		backToAgencyB.setFont(font15);
		
		titlePanel.add(successL);
		detailsPanel.add(detailsL);
		vehiclesDetailsPanel.add(vehicleDetailsL);
		imagePanel.add(imageL);
		buttonPanel.add(backToAgencyB);
		
		mainPanel.add(titlePanel);
		mainPanel.add(detailsPanel);
		mainPanel.add(vehiclesDetailsPanel);
		mainPanel.add(buttonPanel);
		
		add(mainPanel);
				
	}
	public void switchToMainWindow(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles)
	{
		this.dispose();
		MainFrame frame2 = new MainFrame(vehiclesAgency,seaVehicles);
		frame2.setVisible(true);
	}
	
}
