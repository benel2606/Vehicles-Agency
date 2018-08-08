package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.Border;

import Decorators.ColorDecorator;
import Decorators.StatusDecorator;
import Deligators.ISeaVehicle;
import Deligators.IVehicle;
import Memento.Caretaker;
import Memento.Orginator;

public class MainFrame extends JFrame implements MileageObserver {

	private static final long serialVersionUID = 1L;
	
	static boolean answer=true;
	static Vector<VehiclesInventoryFrame>instancesInventory=new Vector<>();
	private static volatile MainFrame instances;
	static Boolean locked=false;
	
	//JButton----------------------------------------------------------------------------------------------------------------------------------------
	private JButton addVehiclesB=new JButton("Add new vehicles");
	private JButton testDriveB=new JButton("Test Drive");
	private JButton changeFlagB=new JButton("Change Flag");
	private JButton buyVehicleB=new JButton("Buy vehicle");
	private JButton resetAllMileageB=new JButton("Reset mileage");
	private JButton vehicleInventoryB=new JButton("Show vehicles inventory");
	private JButton saveStateB=new JButton("Save current state");
	private JButton backStateB=new JButton("Back to previous state");
	//ImageIcon--------------------------------------------------------------------------------------------------------------------------------------
	private ImageIcon buyI=new ImageIcon("pic\\icon_buy.png");
	private ImageIcon addI=new ImageIcon("pic\\icon_add.png");
	private ImageIcon flagI=new ImageIcon("pic\\icon_flag.png");
	private ImageIcon testI=new ImageIcon("pic\\icon_test.png");
	private ImageIcon resetI=new ImageIcon("pic\\icon_reset.png");
	private ImageIcon showI=new ImageIcon("pic\\icon_show.png");
	private ImageIcon saveI=new ImageIcon("pic\\save.png");
	private ImageIcon backI=new ImageIcon("pic\\back.png");
	//FlowLayout-------------------------------------------------------------------------------------------------------------------------------------
	private FlowLayout FlowLayoutButton=new FlowLayout();
	private FlowLayout FlowLayoutCenter=new FlowLayout();
	//JPanel-----------------------------------------------------------------------------------------------------------------------------------------
	private JPanel mainPanel=new JPanel();
	private JPanel panel1=new JPanel();
	private JPanel panelscroll=new JPanel();
	private JPanel panelTitle=new JPanel();
	private JPanel panelButton=new JPanel();
	private JPanel panelAllVehicles=new JPanel();
	//JLabel-----------------------------------------------------------------------------------------------------------------------------------------
	private Vector<JLabel>imagesToGetIndexL=new Vector<JLabel>();
	private JLabel main_titleL=new JLabel("Welcome to main menu");
	private JLabel currentClicked=null;
	private JLabel totalMilageL=new JLabel("Total Mileage:");
	//JscrollPane-----------------------------------------------------------------------------------------------------------------------------------
	private JScrollPane scroller = new JScrollPane(panel1);
	//Font-------------------------------------------------------------------------------------------------------------------------------------------
	private Font font15=new Font("Century Gothic", Font.PLAIN, 15);
	//JTextfield------------------------------------------------------------------------------------------------------------------------------------
	private JTextField totalMilageTF=new JTextField();
	
	private  int index=-1;
	private int totalMilage=0;
	private MileageObserver mileageObserver=this;
	private static final int MAX_THREADS = 1;
    private static final ExecutorService testdrivePool = Executors.newFixedThreadPool(MAX_THREADS);
    
    private Orginator orginator=new Orginator();
    private Caretaker caretaker=new Caretaker();
	
    
    
	
	public MainFrame(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles ) {
		
		this.setTitle("Main Menu");
		this.setSize(1400, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		createMainFrame(vehiclesAgency);
		buyVehicleB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!vehiclesAgency.isEmpty())
				{
					index=imagesToGetIndexL.indexOf(currentClicked);
					if (currentClicked!=null&&index!=-1)
					{	
						IVehicle v=vehiclesAgency.get(index);	
						if (v.getStatus().equals("Available"))
						{
							new SwingWorker<Void,Void>() {
								@Override
								protected Void doInBackground() throws InterruptedException {	
									
															
									((StatusDecorator)v).setStatus("In buying process");
									updateToString(index, v);
									randomTimeSleep(3,8);
									YesNoFrame frame=new YesNoFrame(vehiclesAgency, v,mileageObserver);
									frame.setVisible(true);
									return null;
								}
								
							}.execute();
						}
					}
					
					else
						JOptionPane.showMessageDialog(null, "Please select a vehicle");						
				}
				else 
					JOptionPane.showMessageDialog(null, "There are no vehicles");
			}
			
		});
		addVehiclesB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchWindowToAddVehicles(vehiclesAgency,seaVehicles);
			}
		});
		testDriveB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index=imagesToGetIndexL.indexOf(currentClicked);
				if (currentClicked!=null&&index!=-1)
				{
					IVehicle v=vehiclesAgency.get(index);
					if(v.getStatus().equals("Available"))
					{
						testdrivePool.execute(new SwingWorker<Void, Void>(){
							@Override
							protected Void doInBackground() {	
//								index=imagesToGetIndexL.indexOf(currentClicked);
//								IVehicle v=vehiclesAgency.get(index);
								if (currentClicked!=null)
								{
									((StatusDecorator)v).setStatus("In test drive");
									MainFrame.updateToString(index, v);
									TestDriveFrame testFrame=new TestDriveFrame(vehiclesAgency, seaVehicles,v,mileageObserver);
									testFrame.setVisible(true);
								}
								
								return null;
							}
						});
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Please select a vehicle");
			}
		});
		changeFlagB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (seaVehicles.isEmpty())
					JOptionPane.showMessageDialog(null, "There are no sea vehicles");
				else
				{
					switchWindowToChangeFlag(vehiclesAgency,seaVehicles);
					NotifyWhenAgencyUpdate(vehiclesAgency);
					VehiclesInventoryFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
				}
			}
		});
		resetAllMileageB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!vehiclesAgency.isEmpty())
				{
					for (int i=0;i<vehiclesAgency.size();i++)
					{
						vehiclesAgency.get(i).setDistance(0);
						notifyResetMileage();
						NotifyWhenAgencyUpdate(vehiclesAgency);
						VehiclesInventoryFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
					}
						
					if (vehiclesAgency.size()!=0)
						JOptionPane.showMessageDialog(null,"All vehicles milage are reset");
				}
				else 
					JOptionPane.showMessageDialog(null, "There are no vehicles");
				
			}
		});
		vehicleInventoryB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchWindowToVehiclesInventory(vehiclesAgency,seaVehicles);	
			}
		});
		saveStateB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<IVehicle> tmpVehicleAgency = new Vector<>();
	            Vector<ISeaVehicle> tmpSeaVehicle = new Vector<>();
	            cloneAgency(vehiclesAgency, seaVehicles, tmpVehicleAgency, tmpSeaVehicle);
	            orginator.setVehicleAgency(tmpVehicleAgency);
	            orginator.setSeaVehicles(tmpSeaVehicle);
	            orginator.setTotalMileage(totalMilage);
	            caretaker.addMemento(orginator.createMemento());
	            JOptionPane.showMessageDialog(null, "Current state was saved");
			}
		});
		backStateB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (orginator.setMemento(caretaker.getMemento())) {
					setCloneVehicles(vehiclesAgency, orginator.getVehicleAgency());
					setCloneSeaVehicles(seaVehicles, orginator.getSeaVehicles());
					int milage=orginator.getTotalMileage();
					totalMilageTF.setText(String.valueOf(milage));
					totalMilage=milage;
					NotifyWhenAgencyUpdate(vehiclesAgency);
					VehiclesInventoryFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
					JOptionPane.showMessageDialog(null, "The system is back to the previous state");	
				}
				else
	                JOptionPane.showMessageDialog(null, "First you need to save a state");
				
			}
		});
	}
	public void createMainFrame(Vector<IVehicle>vehiclesAgency)
	{	
		panel1.removeAll();
		imagesToGetIndexL.removeAllElements();
		
		FlowLayoutCenter.setAlignment(FlowLayout.CENTER);
		panel1.setLayout(FlowLayoutCenter);
	
		mainPanel.setLayout(new GridLayout(3, 1));
		for(int i=0;i<vehiclesAgency.size();i++)
		{
			JLabel tmp = new JLabel();
			tmp.setIcon(resizeImage(vehiclesAgency.get(i).getImage()));
			Border tmpBorder=vehiclesAgency.get(i).getBorder();
			tmp.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {

				}
				
				@Override
				public void mouseEntered(MouseEvent e) {

				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					tmp.setBorder(tmpBorder);
					
					if (currentClicked!=null&&currentClicked!=tmp)
						currentClicked.setBorder(BorderFactory.createEmptyBorder());
					currentClicked=tmp;
				}
			});
			panel1.add(tmp);
			imagesToGetIndexL.add(tmp);                                                                      // Labels vector that save images label, to use to get indexes in vehiclesAgency vector
			tmp.setToolTipText(vehiclesAgency.elementAt(i).toString());
		}
		
		scroller.setPreferredSize(new Dimension(1500, 210));
		panelscroll.add(scroller);
		
		panelTitle.setLayout(FlowLayoutCenter);
		main_titleL.setFont(new Font("Century Gothic", Font.PLAIN, 72));
		panelTitle.add(main_titleL);
		
		addVehiclesB.setPreferredSize(new Dimension(220, 60));
		buyVehicleB.setPreferredSize(new Dimension(220, 60));
		testDriveB.setPreferredSize(new Dimension(220, 60));
		changeFlagB.setPreferredSize(new Dimension(220, 60));
		resetAllMileageB.setPreferredSize(new Dimension(220, 60));
		vehicleInventoryB.setPreferredSize(new Dimension(250, 60));
		saveStateB.setPreferredSize(new Dimension(220, 60));
		backStateB.setPreferredSize(new Dimension(240, 60));
		totalMilageTF.setPreferredSize(new Dimension(100, 60));		
		
		addVehiclesB.setFont(font15);
		buyVehicleB.setFont(font15);
		testDriveB.setFont(font15);
		changeFlagB.setFont(font15);
		resetAllMileageB.setFont(font15);
		vehicleInventoryB.setFont(font15);
		saveStateB.setFont(font15);
		backStateB.setFont(font15);
		totalMilageL.setFont(font15);
		totalMilageTF.setFont(font15);
		
		totalMilageTF.setText(String.valueOf(totalMilage));
		totalMilageTF.setEditable(false);
		
		
		addVehiclesB.setIcon(addI);
		buyVehicleB.setIcon(buyI);
		testDriveB.setIcon(testI);
		changeFlagB.setIcon(flagI);
		resetAllMileageB.setIcon(resetI);
		vehicleInventoryB.setIcon(showI);
		saveStateB.setIcon(saveI);
		backStateB.setIcon(backI);
						
		FlowLayoutButton.setHgap(40);
		
		panelAllVehicles.setLayout(FlowLayoutButton);
		panelAllVehicles.add(totalMilageL);
		panelAllVehicles.add(totalMilageTF);
		panelAllVehicles.add(resetAllMileageB);
		panelAllVehicles.add(vehicleInventoryB);
		
		panelAllVehicles.add(saveStateB);
		panelAllVehicles.add(backStateB);

		panelButton.setLayout(FlowLayoutButton);
		panelButton.add(addVehiclesB);
		panelButton.add(buyVehicleB);
		panelButton.add(testDriveB);
		panelButton.add(changeFlagB);
		
		mainPanel.add(panelTitle);
		mainPanel.add(panelscroll);
		mainPanel.add(panelButton);
	
		add(mainPanel,BorderLayout.CENTER);
		add(panelAllVehicles,BorderLayout.SOUTH);
	}		
 	public static ImageIcon resizeImage(ImageIcon image)
	{
		Image newImage=image.getImage();
		Image tmp=newImage.getScaledInstance(256, 180, Image.SCALE_REPLICATE);
		image = new ImageIcon(tmp);
		return image;
	}
	public void switchWindowToBuyVehicles(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles,int index)
	{
		this.dispose();
		BuyVehiclesFrame frame=new BuyVehiclesFrame(vehiclesAgency,seaVehicles,index);
		frame.setVisible(true);
	}
	public void switchWindowToAddVehicles(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles)
	{
		AddVehiclesFrame frame=new AddVehiclesFrame(vehiclesAgency,seaVehicles);
		frame.setVisible(true);
	}
	public void switchWindowToTestDrive(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehices,IVehicle v,MileageObserver mileageObserver)//int index)
	{
		TestDriveFrame frame=new TestDriveFrame(vehiclesAgency,seaVehices,v,mileageObserver);//,index);
		frame.setVisible(true);
	}
	public void switchWindowToChangeFlag(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles)
	{
		ChangeFlagFrame frame=new ChangeFlagFrame(vehiclesAgency,seaVehicles);
		frame.setVisible(true);
	}
	public void switchWindowToVehiclesInventory(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles)
	{
		VehiclesInventoryFrame frame=new VehiclesInventoryFrame(vehiclesAgency,seaVehicles);
		VehiclesInventoryFrame.inventoryInstance.add(frame);
		frame.setVisible(true);
		
	}
	public static void NotifyWhenAgencyUpdate(Vector<IVehicle>vehiclesAgency)
	{
		instances.createMainFrame(vehiclesAgency);
		instances.panel1.repaint();
		instances.panel1.revalidate();
	}
	static void randomTimeSleep(int min,int max)
	{
		min*=1000;
		max*=1000;
		Random rand=new Random();
		int n=rand.nextInt(max-min+1)+min;
		System.out.println(n);
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	public void updateToolTip(int index,IVehicle v)
	{	
		JLabel tmpLabel = imagesToGetIndexL.get(index);
        tmpLabel.setToolTipText(v.toString());
	}
	public static void updateToString(int index, IVehicle v) {
		instances.updateToolTip(index, v);
		instances.panelscroll.repaint();
		instances.panelscroll.revalidate();
		instances.scroller.repaint();
		instances.scroller.revalidate();
		instances.panel1.repaint();
		instances.panel1.revalidate();
        
	}
	@Override
	public void notifyUpdateMileage(int km) {
		totalMilage+=km;
		totalMilageTF.setText(String.valueOf(totalMilage));
	}
	@Override
	public void notifyResetMileage() {
		totalMilage=0;
		totalMilageTF.setText(String.valueOf(totalMilage));
		
	}
	void registerObserver(MileageObserver observer) {
        mileageObserver = observer;
    }
	static MainFrame getInstance(Vector<IVehicle>vehicleAgency,Vector<ISeaVehicle>seaVehicles) {
        if (instances == null)
            synchronized (MainFrame.class) { 
                if (instances == null)
                    instances = new MainFrame(vehicleAgency,seaVehicles);
            }
        return instances;
    }
	public void cloneAgency(Vector<IVehicle>vehicleAgency,Vector<ISeaVehicle>seaVehicles,Vector<IVehicle>cloneVehicleAgency,Vector<ISeaVehicle>cloneSeaVehicleAgency)
	{
		for (IVehicle v:vehicleAgency) {
			IVehicle tmp=(IVehicle)v.cloneVehicle();
			cloneVehicleAgency.add(tmp);
			try {
				cloneSeaVehicleAgency.add((ISeaVehicle)((ColorDecorator)((StatusDecorator)tmp).withoutStatusDecorator()).withoutColorDecorator());
			}catch (ClassCastException e) {
				
				}
				
			}
	}
	public void setCloneVehicles(Vector<IVehicle>vehiclesAgency,Vector<IVehicle>cloneAgency)
	{
		vehiclesAgency.clear();
		for (int i=0;i<cloneAgency.size();i++)
		{
			
			vehiclesAgency.add(cloneAgency.get(i));
		}
	}
	public void setCloneSeaVehicles(Vector<ISeaVehicle>seaVehiclesAgency,Vector<ISeaVehicle>cloneAgency)
	{
		seaVehiclesAgency.clear();
		for (int i=0;i<cloneAgency.size();i++)
		{
			
			seaVehiclesAgency.add(cloneAgency.get(i));
		}
	}
	
}
