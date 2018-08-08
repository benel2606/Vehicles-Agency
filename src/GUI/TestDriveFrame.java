package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import Decorators.StatusDecorator;
import Deligators.IAirVehicle;
import Deligators.ILandVehicle;
import Deligators.ISeaVehicle;
import Deligators.IVehicle;

public class TestDriveFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	//JLabel-----------------------------------------------------------------------------------------------------------------------------------------
	private JLabel titleL=new JLabel("Take the vehicle to test Drive");
	private JLabel mileageL=new JLabel("Enter the number of mileages");
	private JLabel msgL=new JLabel();
	//JButton----------------------------------------------------------------------------------------------------------------------------------------
	private JButton enterB=new JButton("Enter");
	private JButton exitB=new JButton("Exit");
	//JTextField-------------------------------------------------------------------------------------------------------------------------------------
	private JTextField mileageTF=new JTextField();
	//ImageIcon--------------------------------------------------------------------------------------------------------------------------------------
	private ImageIcon enterI=new ImageIcon("pic\\icon_enter.png");
	private ImageIcon exitI=new ImageIcon("pic\\icon_exit.png");
	//JPanel-----------------------------------------------------------------------------------------------------------------------------------------
	private JPanel mainPanel=new JPanel();
	private JPanel titlePanel=new JPanel();
	private JPanel mileageTitlePanel=new JPanel();
	private JPanel mileageButtonPanel=new JPanel();
	private JPanel milageEnterPanel=new JPanel();
	private JPanel exitPanel=new JPanel();
	private JPanel msgPanel=new JPanel();
	//FlowLayout-------------------------------------------------------------------------------------------------------------------------------------
	private FlowLayout myFlowLayout=new FlowLayout();
	//Font-------------------------------------------------------------------------------------------------------------------------------------------
	private Font font22=new Font("Century Gothic", Font.PLAIN, 22);
	private Font fillDetailsF=new Font("Ariel", Font.PLAIN, 22);
	
	private static ReentrantLock air=new ReentrantLock();
	private static ReentrantLock land=new ReentrantLock();
	private static ReentrantLock sea=new ReentrantLock();
		
	public TestDriveFrame(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles,IVehicle v,MileageObserver mileageObserver) {
		this.setTitle("Main Menu");
		this.setSize(500,380);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		createTestDrivePanel(vehiclesAgency);
		
		enterB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					new SwingWorker<Void, Void>() {
						@Override
						protected Void doInBackground() {
							if (!mileageTF.getText().isEmpty())
							{
								msgToPanel(true);
								if (v instanceof IAirVehicle)
									air.lock();
								if (v instanceof ISeaVehicle)
									sea.lock();
								if (v instanceof ILandVehicle)
									land.lock();
								try {
									int n_index=vehiclesAgency.indexOf(v);
									msgToPanel(false);
									Thread.sleep(Integer.parseInt(mileageTF.getText())*100);
									n_index=vehiclesAgency.indexOf(v);
									vehiclesAgency.get(n_index).addDistance(Integer.parseInt(mileageTF.getText()));
									mileageObserver.notifyUpdateMileage(Integer.parseInt(mileageTF.getText()));
									MainGUI.semalock.get(n_index).release();
									MainFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
									VehiclesInventoryFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
									dispose();
									((StatusDecorator)v).setStatus("Available");
									MainFrame.updateToString(n_index, v);
								}
								catch (InterruptedException e) 
								{
									dispose();
								}
								if (v instanceof IAirVehicle)
									air.unlock();
								if (v instanceof ISeaVehicle)
									sea.unlock();
								if (v instanceof ILandVehicle)
									land.unlock();
							}
							else
								JOptionPane.showMessageDialog(null, "Missing mileage");	
							
							return null;
							
						}
					}.execute();
					
				}
			});
		exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int n_index=vehiclesAgency.indexOf(v);
				((StatusDecorator)v).setStatus("Available");
				MainFrame.updateToString(n_index, v);
				MainGUI.semalock.get(n_index).release();
				dispose();
			}
		});
	}
	public void createTestDrivePanel(Vector<IVehicle>vehiclesAgency)
	{
		myFlowLayout.setAlignment(FlowLayout.CENTER);
		titlePanel.setLayout(myFlowLayout);
		milageEnterPanel.setLayout(myFlowLayout);
		mileageTitlePanel.setLayout(myFlowLayout);
		mileageButtonPanel.setLayout(myFlowLayout);
		exitPanel.setLayout(myFlowLayout);
		msgPanel.setLayout(myFlowLayout);
		this.setLayout(myFlowLayout);
		mainPanel.setLayout(new GridLayout(6,1));
		
		msgL.setFont(new Font("Century Gothic", Font.BOLD, 16));
		msgL.setForeground(Color.RED);
		msgPanel.add(msgL);
		
		titleL.setFont(new Font("Century Gothic", Font.PLAIN, 34));
		mileageL.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		mileageTF.setPreferredSize(new Dimension(150, 50));			
		enterB.setPreferredSize(new Dimension(150, 50));
		exitB.setPreferredSize(new Dimension(150, 50));
		
		enterB.setFont(font22);
		exitB.setFont(font22);
		mileageTF.setFont(fillDetailsF);
		
		enterB.setIcon(enterI);	
		exitB.setIcon(exitI);
		
		titlePanel.add(titleL);
		mileageTitlePanel.add(mileageL);
		milageEnterPanel.add(mileageTF);
		mileageButtonPanel.add(enterB);
		exitPanel.add(exitB);
		
		mainPanel.add(titlePanel);
		mainPanel.add(mileageTitlePanel);
		mainPanel.add(milageEnterPanel);
		mainPanel.add(mileageButtonPanel);
		mainPanel.add(exitPanel);
		mainPanel.add(msgPanel);
		
		
		add(mainPanel);
		
	}
	public void switchToMainWindow(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles)
	{
		this.dispose();
	}
	public void msgToPanel(boolean ch) 
	{	
		if (ch)
			msgL.setText("In Process, please wait..");
		else
			msgL.setText("In test drive");
			
		msgPanel.repaint();
		msgPanel.revalidate();
	}

}
