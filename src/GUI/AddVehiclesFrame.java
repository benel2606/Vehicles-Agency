package GUI;

import Deligators.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;

import AbstractFactory.GeneralFactory;
import Decorators.ColorDecorator;
import Decorators.StatusDecorator;

public class AddVehiclesFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	// variable-------------------------------------------------------------------------------------------------------------------------------------------
	private String pathToPic;
	private Boolean flag = false;
	private String[] flagsArr = { "Israel", "USA", "Germany", "Italy", "Greece", "Somalia", "Pirates" };
	private int typeOfObject;
	
	// FlowLayout----------------------------------------------------------------------------------------------------------------------------------------
	private FlowLayout myFlowLayout = new FlowLayout();
	private FlowLayout myFlowLayoutButton = new FlowLayout();
	// GridLayout-----------------------------------------------------------------------------------------------------------------------------------------
	private GridLayout addGL;
	// BorderLayout---------------------------------------------------------------------------------------------------------------------------------------
	private BorderLayout mainBL = new BorderLayout();
	// JPanel---------------------------------------------------------------------------------------------------------------------------------------------
	private JPanel panel_addMain = new JPanel();
	private JPanel panel_addMain1 = new JPanel();
	private JPanel panel_addMain2 = new JPanel();
	private JPanel panel_addMain3 = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	// JButton--------------------------------------------------------------------------------------------------------------------------------------------
	private JButton jeepB = new JButton("Jeep");
	private JButton frigateB = new JButton("Frigate");
	private JButton spygliderB = new JButton("Spy Glider");
	private JButton toygliderB = new JButton("Toy Glider");
	private JButton amphibiousB = new JButton("Amphibious");
	private JButton bicycleB = new JButton("Bicycle");
	private JButton cruiseB = new JButton("Cruise Ship");
	private JButton hybridB = new JButton("Hybrid Aircraft");
	private JButton ebicycleB = new JButton("Electric Bicycle");
	private JButton menuB = new JButton("Menu");
	private JButton uploadB = new JButton("upload photo");
	private JButton saveB = new JButton("Save");
	private JButton backToMainB = new JButton("Back");
	// ImageIcon------------------------------------------------------------------------------------------------------------------------------------------
	private ImageIcon jeepI = new ImageIcon("pic\\jeep.png");
	private ImageIcon frigateI = new ImageIcon("pic\\frigate.png");
	private ImageIcon spygliderI = new ImageIcon("pic\\spy.png");
	private ImageIcon toygliderI = new ImageIcon("pic\\toy.png");
	private ImageIcon amphibiousI = new ImageIcon("pic\\amp.png");
	private ImageIcon bicycleI = new ImageIcon("pic\\bicycle.png");
	private ImageIcon cruiseI = new ImageIcon("pic\\cruise.png");
	private ImageIcon hybridI = new ImageIcon("pic\\hybrid.png");
	private ImageIcon ebicycleI = new ImageIcon("pic\\ebicycle.png");
	private ImageIcon menuI = new ImageIcon("pic\\menu.png");
	private ImageIcon jeepPic = new ImageIcon("pic\\jeepPic.png");
	private ImageIcon FrigatePic = new ImageIcon("pic\\frigatePic.png");
	private ImageIcon SpyGliderPic = new ImageIcon("pic\\SpyPic.png");
	private ImageIcon ToyGliderPic = new ImageIcon("pic\\toyPic.png");
	private ImageIcon amphibiousPic = new ImageIcon("pic\\ampPic.png");
	private ImageIcon bicyclePic = new ImageIcon("pic\\bicyclePic.png");
	private ImageIcon cruisePic = new ImageIcon("pic\\cruisePic.png");
	private ImageIcon hybridPic = new ImageIcon("pic\\HybridPic.png");
	private ImageIcon ebicyclePic = new ImageIcon("pic\\eBicyclePic.png");
	private ImageIcon newImage;
	private ImageIcon backI=new ImageIcon("pic\\icon_back.png");
	private ImageIcon saveI=new ImageIcon("pic\\icon_save.png");
	private ImageIcon uploadI=new ImageIcon("pic\\icon_upload.png");
	// JLabel---------------------------------------------------------------------------------------------------------------------------------------------
	private JLabel titleL = new JLabel("Welcome to Vehicles Agency");
	private JLabel titleL2 = new JLabel("choose a vehicle type to add to the agency");
	private JLabel emptyL = new JLabel("");
	private JLabel bigEmptyL = new JLabel("");
	private JLabel modelL = new JLabel("Model ");
	private JLabel passengerL = new JLabel("Passengers ");
	private JLabel maxSpeedL = new JLabel("Max speed ");
	private JLabel flagL = new JLabel("Flag");
	private JLabel windL = new JLabel("Wind direction ");
	private JLabel engineL = new JLabel("Engine ");
	private JLabel lifetimeL = new JLabel("Average life time ");
	private JLabel roadtypeL = new JLabel("Road type ");
	private JLabel wheelsL = new JLabel("Wheels ");
	private JLabel powerSourceL = new JLabel("Power source ");
	private JLabel picL = new JLabel();
	private JLabel title_addL = new JLabel();
	private JLabel selectPicL = new JLabel("Select photo");
	private JLabel SetPic = new JLabel("");
	private JLabel colorL = new JLabel("Color");
	// TextField-------------------------------------------------------------------------------------------------------------------------------------------
	private TextField modelT = new TextField(20);
	private TextField passengerT = new TextField(20);
	private TextField maxspeedT = new TextField(20);
	private TextField engineT = new TextField(20);
	private TextField lifetimeT = new TextField(20);
	private TextField wheelsT = new TextField(20);
	private TextField powerSourceT = new TextField(20);
	// JRadioButton-------------------------------------------------------------------------------------------------------------------------------------------
	private JRadioButton picRB = new JRadioButton();
	private JRadioButton RB1=new JRadioButton();
	private JRadioButton RB2=new JRadioButton();
	// JCheckBox----------------------------------------------------------------------------------------------------------------------------------------------
	private JCheckBox picCB = new JCheckBox();
	// JFileChooser-------------------------------------------------------------------------------------------------------------------------------------------
	private JFileChooser selectPicFC = new JFileChooser();
	// JComboBox----------------------------------------------------------------------------------------------------------------------------------------------
	private JComboBox<String> flagCB = new JComboBox<String>(flagsArr);
	private JComboBox<String> colorsComboBox = new JComboBox<>(new String[]{"Black", "Blue", "Red", "Green", "Purple","Yellow","Gray"});
	//Font-----------------------------------------------------------------------------------------------------------------------------------------------------
	private Font font30 =new Font("Century Gothic", Font.BOLD, 30);
	private Font font22=new Font("Century Gothic", Font.PLAIN, 20);
	private Font font15=new Font("Century Gothic", Font.PLAIN, 15);
	private Font fillDetailsF=new Font("Ariel", Font.PLAIN, 22);
	
	public String[] getJeepDetails(){return new String[] {modelT.getText(),maxspeedT.getText(),lifetimeT.getText(),engineT.getText()};}
	public String[] getFrigateDetails(){
		boolean choose=false;
		if (RB1.isSelected())
			choose=true;
		else
			choose=false;
		return new String[] {modelT.getText(),passengerT.getText(),maxspeedT.getText(),String.valueOf(choose)};
	}
	public String[] getSpyGliderDetails(){return new String[] {powerSourceT.getText()};}
	public String[] getAmphibiousDetails() 
	{
		boolean choose=false;
		if (RB1.isSelected())
			choose=true;
		else
			choose=false;
		
		return new String[] {modelT.getText(),passengerT.getText(), maxspeedT.getText(),wheelsT.getText(),String.valueOf(choose),String.valueOf(flagCB.getSelectedItem()),engineT.getText(), lifetimeT.getText()};
		
	}
	public String[] getRegularBicycleDetails()
	{
		boolean choose=false;
		if (RB1.isSelected())
			choose=true;
		else
			choose=false;
		
		return new String[] {modelT.getText(),passengerT.getText(),passengerT.getText(), maxspeedT.getText(),String.valueOf(choose)};
	}
	public String[] getCruiseShipDetails(){return new String[] {modelT.getText(),passengerT.getText(),maxspeedT.getText(),String.valueOf(flagCB.getSelectedItem()),engineT.getText(),lifetimeT.getText()};}
	public String[] getHybridAircraftDetails()
	{
		boolean choose=false;
		if (RB1.isSelected())
			choose=true;
		else
			choose=false;
	
		return new String[] {modelT.getText(),passengerT.getText(),maxspeedT.getText(),wheelsT.getText(),String.valueOf(choose),String.valueOf(flagCB.getSelectedItem()),engineT.getText(),lifetimeT.getText()};
	}
	public String[] getElectricBicycleDetails()
	{
		boolean choose=false;
		if (RB1.isSelected())
			choose=true;
		else
			choose=false;
		
		return new String[] {modelT.getText(),passengerT.getText(),maxspeedT.getText(),String.valueOf(choose),lifetimeT.getText()};
	}
	public ImageIcon getIcon(int num)
	{
		if (picRB.isSelected())
		{
			switch (num)
			{
			case 1:return jeepPic;
			case 2:return FrigatePic;
			case 3:return SpyGliderPic;
			case 4:return ToyGliderPic;
			case 5:return amphibiousPic;
			case 6:return bicyclePic;
			case 7:return cruisePic;
			case 8:return hybridPic;
			case 9:return ebicyclePic;
			}
		}
		else 
			return newImage;
		return null;	
	}
	
	
	public AddVehiclesFrame(Vector<IVehicle> vehiclesAgency,Vector<ISeaVehicle>seaVehicles) {
		this.setTitle("Add vehicles to agency");
		this.setSize(1350, 990);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setComponents();
		createAddVehiclesPanel(vehiclesAgency);
		
		saveB.addActionListener(l-> {			
				switch (typeOfObject) {
				case 1:
					if (modelT.getText().isEmpty() || maxspeedT.getText().isEmpty() || engineT.getText().isEmpty()
							|| lifetimeT.getText().isEmpty() || (!flag && !picRB.isSelected()))
						JOptionPane.showMessageDialog(null, "one or more details are missing, please try again");
					else 
					{
						IVehicle tmpVehicle=GeneralFactory.getFactory("Land").makeVehicle("Jeep", this);
						 new SwingWorker<Void, Void>() {
	                            @Override
	                            protected Void doInBackground() {
	                            	addVehicle(vehiclesAgency, seaVehicles, tmpVehicle, false, (String)colorsComboBox.getSelectedItem());
	                            	MainGUI.semalock.add(new Semaphore(1));
	                                return null;
	                            }
	                        }.execute();
					}
										
					break;

				case 2:
					if (modelT.getText().isEmpty() || maxspeedT.getText().isEmpty() || passengerT.getText().isEmpty()
							|| (!RB1.isSelected() && !RB2.isSelected()) || (!flag && !picRB.isSelected()))
						JOptionPane.showMessageDialog(null, "one or more details are missing, please try again");
					else 
					{
						
						IVehicle tmpVehicle=GeneralFactory.getFactory("Sea").makeVehicle("Frigate", this);
						 new SwingWorker<Void, Void>() {
	                            @Override
	                            protected Void doInBackground() {
	                            	addVehicle(vehiclesAgency, seaVehicles, tmpVehicle, true, (String)colorsComboBox.getSelectedItem());
	                            	MainGUI.semalock.add(new Semaphore(1));;
	                                return null;
	                            }
	                        }.execute();
					}
					break;

				case 3:
					if (powerSourceT.getText().isEmpty() || (!flag && !picRB.isSelected()))
						JOptionPane.showMessageDialog(null, "one or more details are missing, please try again");
					else 
					{
						
						IVehicle tmpVehicle=GeneralFactory.getFactory("Air").makeVehicle("Spy Glider", this);
						 new SwingWorker<Void, Void>() {
	                            @Override
	                            protected Void doInBackground() {
	                            	addVehicle(vehiclesAgency, seaVehicles, tmpVehicle, false, (String)colorsComboBox.getSelectedItem());
	                            	MainGUI.semalock.add(new Semaphore(1));;
	                                return null;
	                            }
	                        }.execute();
					}
					break;

				case 4:
					if (!flag && !picRB.isSelected())
						JOptionPane.showMessageDialog(null, "one or more details are missing, please try again");
					else 
					{
						
						IVehicle tmpVehicle=GeneralFactory.getFactory("Air").makeVehicle("Toy Glider", this);
						 new SwingWorker<Void, Void>() {
	                            @Override
	                            protected Void doInBackground() {
	                            	addVehicle(vehiclesAgency, seaVehicles, tmpVehicle, false, (String)colorsComboBox.getSelectedItem());
	                            	MainGUI.semalock.add(new Semaphore(1));;
	                                return null;
	                            }
	                        }.execute();
					}
					break;

				case 5:
					if (modelT.getText().isEmpty() || maxspeedT.getText().isEmpty() || passengerT.getText().isEmpty()
							|| wheelsT.getText().isEmpty() || engineT.getText().isEmpty()
							|| lifetimeT.getText().isEmpty() || !flagCB.isEnabled()
							|| (!RB1.isSelected() && !RB2.isSelected()) || (!flag && !picRB.isSelected()))
						JOptionPane.showMessageDialog(null, "one or more details are missing, please try again");
					else 
					{
						IVehicle tmpVehicle=GeneralFactory.getFactory("Sea").makeVehicle("Amphibious", this);
						 new SwingWorker<Void, Void>() {
	                            @Override
	                            protected Void doInBackground() {
	                            	addVehicle(vehiclesAgency, seaVehicles, tmpVehicle, true, (String)colorsComboBox.getSelectedItem());
	                            	MainGUI.semalock.add(new Semaphore(1));;
	                                return null;
	                            }
	                        }.execute();
					}
					break;

				case 6:
					if (modelT.getText().isEmpty() || maxspeedT.getText().isEmpty() || passengerT.getText().isEmpty()
							|| (!RB1.isSelected() && !RB2.isSelected()) || (!flag && !picRB.isSelected()))
						JOptionPane.showMessageDialog(null, "one or more details are missing, please try again");
					else 
					{
						
						IVehicle tmpVehicle=GeneralFactory.getFactory("Land").makeVehicle("Bicycle", this);
						 new SwingWorker<Void, Void>() {
	                            @Override
	                            protected Void doInBackground() {
	                            	addVehicle(vehiclesAgency, seaVehicles, tmpVehicle, false, (String)colorsComboBox.getSelectedItem());
	                            	MainGUI.semalock.add(new Semaphore(1));;
	                                return null;
	                            }
	                        }.execute();
					}
					break;

				case 7:
					if (modelT.getText().isEmpty() || maxspeedT.getText().isEmpty() || passengerT.getText().isEmpty()
							|| engineT.getText().isEmpty() || lifetimeT.getText().isEmpty() || !flagCB.isEnabled()
							|| (!flag && !picRB.isSelected()))
						JOptionPane.showMessageDialog(null, "one or more details are missing, please try again");
					else 
					{
						IVehicle tmpVehicle=GeneralFactory.getFactory("Sea").makeVehicle("Cruise", this);
						 new SwingWorker<Void, Void>() {
	                            @Override
	                            protected Void doInBackground() {
	                            	addVehicle(vehiclesAgency, seaVehicles, tmpVehicle, true, (String)colorsComboBox.getSelectedItem());
	                            	MainGUI.semalock.add(new Semaphore(1));;
	                                return null;
	                            }
	                        }.execute();
					}
					break;
				case 8:
					if (modelT.getText().isEmpty() || maxspeedT.getText().isEmpty() || passengerT.getText().isEmpty()
							|| wheelsT.getText().isEmpty() || engineT.getText().isEmpty()
							|| lifetimeT.getText().isEmpty() || !flagCB.isEnabled()
							|| (!RB1.isSelected() && !RB2.isSelected()) || (!flag && !picRB.isSelected()))
						JOptionPane.showMessageDialog(null, "one or more details are missing, please try again");
					else 
					{
						IVehicle tmpVehicle=GeneralFactory.getFactory("Sea").makeVehicle("Hybrid Aircraft", this);
						 new SwingWorker<Void, Void>() {
	                            @Override
	                            protected Void doInBackground() {
	                            	addVehicle(vehiclesAgency, seaVehicles, tmpVehicle, true, (String)colorsComboBox.getSelectedItem());
	                            	MainGUI.semalock.add(new Semaphore(1));;
	                                return null;
	                            }
	                        }.execute();
					}
					break;
				case 9:
					if (modelT.getText().isEmpty() || maxspeedT.getText().isEmpty()||passengerT.getText().isEmpty()
							|| lifetimeT.getText().isEmpty() || (!RB1.isSelected() && !RB2.isSelected())|| (!flag && !picRB.isSelected()))
						JOptionPane.showMessageDialog(null, "one or more details are missing, please try again");
					else 
					{
						IVehicle tmpVehicle=GeneralFactory.getFactory("Land").makeVehicle("Electric Bicycle", this);
						 new SwingWorker<Void, Void>() {
	                            @Override
	                            protected Void doInBackground() {
	                            	addVehicle(vehiclesAgency, seaVehicles, tmpVehicle, false, (String)colorsComboBox.getSelectedItem());
	                            	MainGUI.semalock.add(new Semaphore(1));;
	                                return null;
	                            }
	                        }.execute();
					}
					break;
				}
		});
		uploadB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				uploadPicAndResize();
			}
		});
		backToMainB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAllAndBackToAddVehiclesMain();
			}
		});
		menuB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchToMainWindow(vehiclesAgency, seaVehicles);
			}
		});
	}
	public void createAddVehiclesPanel(Vector<IVehicle> vehiclesAgency) {
		this.setLayout(mainBL);
		panel_addMain1.setLayout(myFlowLayoutButton);
		myFlowLayoutButton.setHgap(220);
		myFlowLayoutButton.setVgap(40);
		myFlowLayoutButton.setAlignment(FlowLayout.CENTER);

		jeepB.setHorizontalTextPosition(JButton.CENTER);
		jeepB.setVerticalTextPosition(JButton.TOP);
		jeepB.setIcon(jeepI);
		jeepB.setFont(font15);

		frigateB.setHorizontalTextPosition(JButton.CENTER);
		frigateB.setVerticalTextPosition(JButton.TOP);
		frigateB.setIcon(frigateI);
		frigateB.setFont(font15);

		spygliderB.setHorizontalTextPosition(JButton.CENTER);
		spygliderB.setVerticalTextPosition(JButton.TOP);
		spygliderB.setIcon(spygliderI);
		spygliderB.setFont(font15);

		toygliderB.setHorizontalTextPosition(JButton.CENTER);
		toygliderB.setVerticalTextPosition(JButton.TOP);
		toygliderB.setIcon(toygliderI);
		toygliderB.setFont(font15);

		amphibiousB.setHorizontalTextPosition(JButton.CENTER);
		amphibiousB.setVerticalTextPosition(JButton.TOP);
		amphibiousB.setIcon(amphibiousI);
		amphibiousB.setFont(font15);

		bicycleB.setHorizontalTextPosition(JButton.CENTER);
		bicycleB.setVerticalTextPosition(JButton.TOP);
		bicycleB.setIcon(bicycleI);
		bicycleB.setFont(font15);

		cruiseB.setHorizontalTextPosition(JButton.CENTER);
		cruiseB.setVerticalTextPosition(JButton.TOP);
		cruiseB.setIcon(cruiseI);
		cruiseB.setFont(font15);
		
		hybridB.setHorizontalTextPosition(JButton.CENTER);
		hybridB.setVerticalTextPosition(JButton.TOP);
		hybridB.setIcon(hybridI);
		hybridB.setFont(font15);
		
		ebicycleB.setHorizontalTextPosition(JButton.CENTER);
		ebicycleB.setVerticalTextPosition(JButton.TOP);
		ebicycleB.setIcon(ebicycleI);
		ebicycleB.setFont(font15);

		menuB.setHorizontalTextPosition(JButton.CENTER);
		menuB.setVerticalTextPosition(JButton.TOP);
		menuB.setIcon(menuI);
		menuB.setFont(font15);

		panel_addMain1.add(jeepB);
		panel_addMain1.add(frigateB);
		panel_addMain1.add(spygliderB);
		panel_addMain1.add(toygliderB);
		panel_addMain1.add(amphibiousB);
		panel_addMain1.add(bicycleB);
		panel_addMain1.add(cruiseB);
		panel_addMain1.add(hybridB);
		panel_addMain1.add(ebicycleB);
		
		titleL.setFont(new Font("Century Gothic", Font.PLAIN, 72));
		titleL2.setFont(new Font("Century Gothic", Font.PLAIN, 34));
		panel_addMain2.add(titleL);
		panel_addMain3.add(titleL2);
		
		panel_addMain.setLayout(new BorderLayout());
		panel_addMain.add(panel_addMain2,BorderLayout.NORTH);
		panel_addMain.add(panel_addMain3,BorderLayout.SOUTH);
		panel_addMain.add(panel_addMain1,BorderLayout.CENTER);

		this.add(panel_addMain, BorderLayout.CENTER);

		jeepB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfObject = 1;
				createAddJeepPanel(vehiclesAgency);
			}
		});
		frigateB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfObject = 2;
				createAddFrigatePanel(vehiclesAgency);
			}
		});
		spygliderB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfObject = 3;
				createAddSpyGliderPanel(vehiclesAgency);
			}
		});
		toygliderB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfObject = 4;
				createAddToyGliderPanel(vehiclesAgency);
			}
		});
		amphibiousB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfObject = 5;
				createAddAmphibiousPanel(vehiclesAgency);
			}
		});
		bicycleB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfObject = 6;
				createAddBicyclePanel(vehiclesAgency);
			}
		});
		cruiseB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfObject = 7;
				createAddCruiseShipPanel(vehiclesAgency);
			}
		});
		hybridB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfObject=8;
				createAddHybridAircraftPanel(vehiclesAgency);
			}
		});
		ebicycleB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfObject=9;
				createAddElectricBicyclePanel(vehiclesAgency);
				
			}
		});
	}
	public void setComponents()
	{
		addGL = new GridLayout(20, 1);
		
		title_addL.setFont(font30);

		modelL.setFont(font22);
		maxSpeedL.setFont(font22);
		engineL.setFont(font22);
		lifetimeL.setFont(font22);
		windL.setFont(font22);
		passengerL.setFont(font22);
		powerSourceL.setFont(font22);
		wheelsL.setFont(font22);
		flagL.setFont(font22);
		roadtypeL.setFont(font22);
		colorL.setFont(font22);
		
		RB1.setFont(font15);
		RB2.setFont(font15);
		
		modelT.setFont(fillDetailsF);
		maxspeedT.setFont(fillDetailsF);
		engineT.setFont(fillDetailsF);
		lifetimeT.setFont(fillDetailsF);	
		passengerT.setFont(fillDetailsF);
		powerSourceT.setFont(fillDetailsF);
		wheelsT.setFont(fillDetailsF);
		
		selectPicL.setFont(new Font("Century Gothic", Font.BOLD, 20));
		
		
		picRB.setFont(font15);
		saveB.setFont(font15);
		backToMainB.setFont(font15);
		uploadB.setFont(font15);
		saveB.setIcon(saveI);
		backToMainB.setIcon(backI);
		uploadB.setIcon(uploadI);

		panel1.setLayout(myFlowLayout);
		myFlowLayout.setAlignment(FlowLayout.LEFT);
		panel2.setLayout(addGL);
		addGL.setHgap(10);
		panel3.setLayout(myFlowLayout);
		myFlowLayout.setHgap(30);
		
		
		saveB.setPreferredSize(new Dimension(140, 50));
		backToMainB.setPreferredSize(new Dimension(140, 50));
		uploadB.setPreferredSize(new Dimension(180, 50));
	}
	public void createAddJeepPanel(Vector<IVehicle> vehiclesAgency) {

		panel_addMain.setVisible(false);
		SetPic.setIcon(null);
		picRB.setSelected(false);	
		title_addL.setText("Add details of the jeep");

		picL.setIcon(jeepPic);
		picRB.setSelected(false);
		modelT.setText("");
		maxspeedT.setText("");
		engineT.setText("");
		lifetimeT.setText("");		

		panel2.add(title_addL);
		panel2.add(modelL);
		panel2.add(modelT);
		panel2.add(maxSpeedL);
		panel2.add(maxspeedT);
		panel2.add(engineL);
		panel2.add(engineT);
		panel2.add(lifetimeL);
		panel2.add(lifetimeT);
		panel2.add(colorL);
		panel2.add(colorsComboBox);
		
		
		panel1.add(panel2);

		picRB.setText("Jeep");
		
		panel3.add(selectPicL);
		panel3.add(emptyL);
		panel3.add(picRB);
		panel3.add(picL);
		panel3.add(new JLabel("OR"));
		panel3.add(uploadB);
		panel3.add(SetPic);
		panel3.add(bigEmptyL);
		panel3.add(saveB);
		panel3.add(backToMainB);

		add(panel1, BorderLayout.WEST);
		add(panel3, BorderLayout.SOUTH);
	}
	public void createAddFrigatePanel(Vector<IVehicle> vehiclesAgency) {

		panel_addMain.setVisible(false);
		SetPic.setIcon(null);
		picCB.setSelected(false);
		picL.setIcon(FrigatePic);

		title_addL.setText("Add details of the frigate");
		RB1.setText("With wind direction");
		RB2.setText("Against wind direction");
		RB1.setFont(font15);
		RB2.setFont(font15);

		modelT.setText("");
		maxspeedT.setText("");
		passengerT.setText("");
		RB1.setSelected(false);
		RB2.setSelected(false);
		picRB.setSelected(false);
		
		panel2.add(title_addL);
		panel2.add(modelL);
		panel2.add(modelT);
		panel2.add(passengerL);
		panel2.add(passengerT);
		panel2.add(maxSpeedL);
		panel2.add(maxspeedT);
		panel2.add(windL);
		panel2.add(RB1);
		panel2.add(RB2);
		panel2.add(colorL);
		panel2.add(colorsComboBox);
		
		panel1.add(panel2);
		
		picRB.setText("Frigate");
		selectPicL.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panel3.add(selectPicL);
		panel3.add(emptyL);
		panel3.add(picRB);
		panel3.add(picL);
		panel3.add(new JLabel("OR"));
		panel3.add(uploadB);
		panel3.add(SetPic);
		panel3.add(bigEmptyL);
		panel3.add(saveB);
		panel3.add(backToMainB);

		add(panel1, BorderLayout.WEST);
		add(panel3, BorderLayout.SOUTH);
	}
	public void createAddSpyGliderPanel(Vector<IVehicle> vehiclesAgency) {
		panel_addMain.setVisible(false);
		SetPic.setIcon(null);
		picRB.setSelected(false);

		title_addL.setText("Add details of the Spy Glider");
		picL.setIcon(SpyGliderPic);
		
		powerSourceT.setText("");

		panel2.add(title_addL);
		panel2.add(powerSourceL);
		panel2.add(powerSourceT);
		panel2.add(colorL);
		panel2.add(colorsComboBox);
		
		panel1.add(panel2);

		picRB.setText("Spy Glider");
		
		panel3.add(selectPicL);
		panel3.add(emptyL);
		panel3.add(picRB);
		panel3.add(picL);
		panel3.add(new JLabel("OR"));
		panel3.add(uploadB);
		panel3.add(SetPic);
		panel3.add(bigEmptyL);
		panel3.add(saveB);
		panel3.add(backToMainB);

		add(panel1, BorderLayout.WEST);
		add(panel3, BorderLayout.SOUTH);
	}
	public void createAddToyGliderPanel(Vector<IVehicle> vehiclesAgency) {
		panel_addMain.setVisible(false);
		SetPic.setIcon(null);
		picRB.setSelected(false);

		title_addL.setText("Add details of the Toy Glider");
		picL.setIcon(ToyGliderPic);
		
		panel2.add(title_addL);
		panel2.add(colorL);
		panel2.add(colorsComboBox);
		panel1.add(panel2);
		
		picRB.setText("Toy Glider");
		selectPicL.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panel3.add(selectPicL);
		panel3.add(emptyL);
		panel3.add(picRB);
		panel3.add(picL);
		panel3.add(new JLabel("OR"));
		panel3.add(uploadB);
		panel3.add(SetPic);
		panel3.add(bigEmptyL);
		panel3.add(saveB);
		panel3.add(backToMainB);

		add(panel1, BorderLayout.WEST);
		add(panel3, BorderLayout.SOUTH);
	}
	public void createAddAmphibiousPanel(Vector<IVehicle> vehiclesAgency) {
		panel_addMain.setVisible(false);
		SetPic.setIcon(null);
		picRB.setSelected(false);

		title_addL.setText("Add details of the Amphibious");
		title_addL.setFont(font30);

		RB1.setText("With wind direction");
		RB2.setText("Against wind direction");
		
		picL.setIcon(amphibiousPic);

		modelT.setText("");
		passengerT.setText("");
		maxspeedT.setText("");
		wheelsT.setText("");
		engineT.setText("");
		lifetimeT.setText("");
		RB1.setSelected(false);
		RB2.setSelected(false);

		panel2.add(title_addL);
		panel2.add(modelL);
		panel2.add(modelT);
		panel2.add(passengerL);
		panel2.add(passengerT);
		panel2.add(maxSpeedL);
		panel2.add(maxspeedT);
		panel2.add(wheelsL);
		panel2.add(wheelsT);
		panel2.add(engineL);
		panel2.add(engineT);
		panel2.add(lifetimeL);
		panel2.add(lifetimeT);
		panel2.add(windL);
		panel2.add(RB1);
		panel2.add(RB2);
		panel2.add(flagL);
		panel2.add(flagCB);
		panel2.add(colorL);
		panel2.add(colorsComboBox);

		panel1.add(panel2);
		
		picRB.setText("Amphibious");
		selectPicL.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panel3.add(selectPicL);
		panel3.add(emptyL);
		panel3.add(picRB);
		panel3.add(picL);
		panel3.add(new JLabel("OR"));
		panel3.add(uploadB);
		panel3.add(SetPic);
		panel3.add(bigEmptyL);
		panel3.add(saveB);
		panel3.add(backToMainB);
		
		add(panel1, BorderLayout.WEST);
		add(panel3, BorderLayout.SOUTH);

	}
	public void createAddBicyclePanel(Vector<IVehicle> vehiclesAgency) {

		panel_addMain.setVisible(false);
		SetPic.setIcon(null);
		picRB.setSelected(false);

		picL.setIcon(bicyclePic);

		title_addL.setText("Add details of the bicycle");

		RB1.setText("Dirt road");
		RB2.setText("Paved road");
		
		modelT.setText("");
		maxspeedT.setText("");
		passengerT.setText("");
		RB1.setSelected(false);
		RB2.setSelected(false);
		
		panel2.add(title_addL);
		panel2.add(modelL);
		panel2.add(modelT);
		panel2.add(passengerL);
		panel2.add(passengerT);
		panel2.add(maxSpeedL);
		panel2.add(maxspeedT);
		panel2.add(roadtypeL);
		panel2.add(RB1);
		panel2.add(RB2);
		panel2.add(colorL);
		panel2.add(colorsComboBox);

		panel1.add(panel2);

		picRB.setText("Bicycle");
		selectPicL.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panel3.add(selectPicL);
		panel3.add(emptyL);
		panel3.add(picRB);
		panel3.add(picL);
		panel3.add(new JLabel("OR"));
		panel3.add(uploadB);
		panel3.add(SetPic);
		panel3.add(bigEmptyL);
		panel3.add(saveB);
		panel3.add(backToMainB);
		
		add(panel1, BorderLayout.WEST);
		add(panel3, BorderLayout.SOUTH);
	}
	public void createAddCruiseShipPanel(Vector<IVehicle> vehiclesAgency) {
		panel_addMain.setVisible(false);
		SetPic.setIcon(null);
		picRB.setSelected(false);

		title_addL.setText("Add details of the Cruise Ship");

		RB1.setText("With wind direction");
		RB2.setText("Against wind direction");

		picL.setIcon(cruisePic);

		modelT.setText("");
		passengerT.setText("");
		maxspeedT.setText("");
		engineT.setText("");
		lifetimeT.setText("");
		
		panel2.add(title_addL);
		panel2.add(modelL);
		panel2.add(modelT);
		panel2.add(passengerL);
		panel2.add(passengerT);
		panel2.add(maxSpeedL);
		panel2.add(maxspeedT);
		panel2.add(engineL);
		panel2.add(engineT);
		panel2.add(lifetimeL);
		panel2.add(lifetimeT);
		panel2.add(flagL);
		panel2.add(flagCB);
		panel2.add(colorL);
		panel2.add(colorsComboBox);
		
		panel1.add(panel2);
		
		picRB.setText("Cruise ship");
		panel3.add(selectPicL);
		panel3.add(emptyL);
		panel3.add(picRB);
		panel3.add(picL);
		panel3.add(new JLabel("OR"));
		panel3.add(uploadB);
		panel3.add(SetPic);
		panel3.add(bigEmptyL);
		panel3.add(saveB);
		panel3.add(backToMainB);
		
		add(panel1, BorderLayout.WEST);
		add(panel3, BorderLayout.SOUTH);

	}
	public void createAddHybridAircraftPanel(Vector<IVehicle> vehiclesAgency) {
		panel_addMain.setVisible(false);
		SetPic.setIcon(null);
		picRB.setSelected(false);

		title_addL.setText("Add details of the Hybrid Aircraft");

		RB1.setText("With wind direction");
		RB2.setText("Against wind direction");
		
		picL.setIcon(hybridPic);

		modelT.setText("");
		passengerT.setText("");
		maxspeedT.setText("");
		wheelsT.setText("");
		engineT.setText("");
		lifetimeT.setText("");
		RB1.setSelected(false);
		RB2.setSelected(false);

		panel2.add(title_addL);
		panel2.add(modelL);
		panel2.add(modelT);
		panel2.add(passengerL);
		panel2.add(passengerT);
		panel2.add(maxSpeedL);
		panel2.add(maxspeedT);
		panel2.add(wheelsL);
		panel2.add(wheelsT);
		panel2.add(engineL);
		panel2.add(engineT);
		panel2.add(lifetimeL);
		panel2.add(lifetimeT);
		panel2.add(windL);
		panel2.add(RB1);
		panel2.add(RB2);
		panel2.add(flagL);
		panel2.add(flagCB);
		panel2.add(colorL);
		panel2.add(colorsComboBox);
		
		panel1.add(panel2);

		picRB.setText("Hybrid Aircraft");
		panel3.add(selectPicL);
		panel3.add(emptyL);
		panel3.add(picRB);
		panel3.add(picL);
		panel3.add(new JLabel("OR"));
		panel3.add(uploadB);
		panel3.add(SetPic);
		panel3.add(bigEmptyL);
		panel3.add(saveB);
		panel3.add(backToMainB);

		add(panel1, BorderLayout.WEST);
		add(panel3, BorderLayout.SOUTH);
	}
	public void createAddElectricBicyclePanel(Vector<IVehicle> vehiclesAgency) {

		panel_addMain.setVisible(false);
		SetPic.setIcon(null);
		picRB.setSelected(false);	
	
		title_addL.setText("Add details of the electric bicycle");
		
		RB1.setText("Dirt road");
		RB2.setText("Paved road");

		picL.setIcon(ebicyclePic);
		picRB.setSelected(false);
		modelT.setText("");
		passengerT.setText("");
		maxspeedT.setText("");
		lifetimeT.setText("");	
		RB1.setSelected(false);
		RB2.setSelected(false);
	
		panel2.add(title_addL);
		panel2.add(modelL);
		panel2.add(modelT);
		panel2.add(passengerL);
		panel2.add(passengerT);
		panel2.add(maxSpeedL);
		panel2.add(maxspeedT);
		panel2.add(lifetimeL);
		panel2.add(lifetimeT);
		panel2.add(roadtypeL);
		panel2.add(RB1);
		panel2.add(RB2);
		panel2.add(colorL);
		panel2.add(colorsComboBox);
		
		panel1.add(panel2);
		
		picRB.setText("Electric Bicycle");
		panel3.add(selectPicL);
		panel3.add(emptyL);
		panel3.add(picRB);
		panel3.add(picL);
		panel3.add(new JLabel("OR"));
		panel3.add(uploadB);
		panel3.add(SetPic);
		panel3.add(bigEmptyL);
		panel3.add(saveB);
		panel3.add(backToMainB);

		add(panel1, BorderLayout.WEST);
		add(panel3, BorderLayout.SOUTH);
	}
	public void addVehicle(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehiclesAgency,IVehicle v,boolean seaVehicle,String color)
	{
		//new UpdateFrame(3, 8);
		if (seaVehicle)
			seaVehiclesAgency.add((ISeaVehicle)v);
		v=new ColorDecorator(color, v);
		v=new StatusDecorator(v,"Available");
		vehiclesAgency.add(v);
		MainFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
		VehiclesInventoryFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
			
	}
	public void uploadPicAndResize() {
		selectPicFC.showOpenDialog(null);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
		selectPicFC.setFileFilter(filter);
		File f = selectPicFC.getSelectedFile();
		pathToPic = f.getAbsolutePath();
		newImage = new ImageIcon(new ImageIcon(pathToPic).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
		SetPic.setIcon(newImage);
		flag = true;
	}
	public void clearAllAndBackToAddVehiclesMain() {
		panel1.removeAll();
		panel1.revalidate();
		panel1.repaint();
		panel2.removeAll();
		panel2.revalidate();
		panel2.repaint();
		panel3.removeAll();
		panel3.revalidate();
		panel3.repaint();
		
//		panel_addMain.repaint();
//		panel_addMain.revalidate();

		panel_addMain.setVisible(true);
	}
	public void testPrintVehicles(Vector<Vehicle> vehicles) {
		for (int i = 0; i < vehicles.size(); i++) {
			System.out.println(i + " " + vehicles.get(i));
		}

	}
	public void switchToMainWindow(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles)
	{
		this.dispose();
		MainFrame frame = new MainFrame(vehiclesAgency,seaVehicles);
		frame.setVisible(true);
	}
	public void updateWindow(Vector<IVehicle>vehiclesAgency)
	{
		MainFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
		VehiclesInventoryFrame.NotifyWhenAgencyUpdate(vehiclesAgency);
		clearAllAndBackToAddVehiclesMain();
	}
}
