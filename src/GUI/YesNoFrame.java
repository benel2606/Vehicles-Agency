package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Decorators.StatusDecorator;
import Deligators.IVehicle;

public class YesNoFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel askL=new JLabel("Do you want to buy this car?");
	private JLabel infoL=new JLabel();
	
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	private JPanel panel3=new JPanel();
	
	private FlowLayout myFlowLayout=new FlowLayout();
	
	private JButton yesB=new JButton("Yes");
	private JButton NoB=new JButton("No");
	
	private Font font25=new Font("Century Gothic", Font.PLAIN, 25);
	private Font font15=new Font("Century Gothic", Font.PLAIN, 15);
	private Font font20=new Font("Century Gothic", Font.PLAIN, 20);
	
	public YesNoFrame(Vector<IVehicle> vehiclesAgency,IVehicle v,MileageObserver mileageObserver)
	{
		this.setTitle("Buy");
		this.setSize(700,250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLayout(new BorderLayout());
		createYesNoPanel(vehiclesAgency,v);
		
		yesB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateFrame(3,8);
				//int n_index=vehiclesAgency.indexOf(v);
				vehiclesAgency.remove(v);	
				mileageObserver.notifyUpdateMileage(-v.getDistance());
				MainFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
				VehiclesInventoryFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
				exit();
			}
		});
		NoB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n_index=vehiclesAgency.indexOf(v);
				((StatusDecorator)v).setStatus("Available");
				MainFrame.updateToString(n_index, v);
				exit();
			}
		});
	
	}
	public void createYesNoPanel(Vector<IVehicle> vehiclesAgency,IVehicle v)
	{
		myFlowLayout.setAlignment(FlowLayout.CENTER);
		panel1.setLayout(myFlowLayout);
		panel2.setLayout(myFlowLayout);
		panel3.setLayout(myFlowLayout);
		myFlowLayout.setHgap(120);
		
		infoL.setPreferredSize(new Dimension(600,100));
		yesB.setPreferredSize(new Dimension(150, 40));
		NoB.setPreferredSize(new Dimension(150, 40));
		
		infoL.setText("<html>"+v.toString()+"</html>");
		askL.setFont(font25);
		infoL.setFont(font15);
		yesB.setFont(font20);
		NoB.setFont(font20);
		
		panel1.add(askL);
		panel2.add(infoL);
		panel3.add(yesB);
		panel3.add(NoB);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3, BorderLayout.SOUTH);
	}
	public void exit()
	{
		this.dispose();
	}
	
}
