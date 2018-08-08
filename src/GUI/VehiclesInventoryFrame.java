package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Deligators.ISeaVehicle;
import Deligators.IVehicle;

public class VehiclesInventoryFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	//JPanel-----------------------------------------------------------------------------------------------------------------------------------------
	private JPanel mainPanel=new JPanel();
	private JPanel panel1=new JPanel();
	private JPanel panelscroll=new JPanel();
	private JPanel panelInfo=new JPanel();
	private JPanel panelTitle=new JPanel();
	private JPanel panelInfoTitle=new JPanel();
	private JPanel panelbutton=new JPanel();
	//FlowLayout-------------------------------------------------------------------------------------------------------------------------------------
	private FlowLayout myFlowLayout=new FlowLayout();
	//JLabel-----------------------------------------------------------------------------------------------------------------------------------------
	private Vector<JLabel>imagesToGetIndexL=new Vector<JLabel>();
	private Vector<JLabel>infoToGetIndexL=new Vector<JLabel>();
	private JLabel currentClicked=null;
	private JLabel titleL=new JLabel("Show vehicles inventory");
	private JLabel infoL=new JLabel("Vehicle information");
	private JLabel vehicleinfoL=new JLabel();
	//Font-----------------------------------------------------------------------------------------------------------------------------------------------------
	private Font font72 =new Font("Century Gothic", Font.PLAIN, 72);
	private Font font36=new Font("Century Gothic", Font.PLAIN, 36);
	private Font font20=new Font("Century Gothic", Font.BOLD, 20);
	//JscrollPane-----------------------------------------------------------------------------------------------------------------------------------
	private JScrollPane scroller = new JScrollPane(panel1);
	// ImageIcon------------------------------------------------------------------------------------------------------------------------------------------
	private ImageIcon backI=new ImageIcon("pic\\icon_back.png");
	//JButton----------------------------------------------------------------------------------------------------------------------------------------
	private JButton backToMainB = new JButton("Back");
	
	static Vector<VehiclesInventoryFrame>inventoryInstance=new Vector<>();
	
	public VehiclesInventoryFrame(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles) {
		this.setTitle("Show vehicles inventory");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		createVehiclesInventoryPanel(vehiclesAgency);
		
		backToMainB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchToMainWindow(vehiclesAgency, seaVehicles);
				
			}
		});
	}
	public void createVehiclesInventoryPanel(Vector<IVehicle>vehiclesAgency)
	{	
		panel1.removeAll();
		infoToGetIndexL.removeAllElements();
		
		mainPanel.setLayout(new GridLayout(2,1));
		
		myFlowLayout.setAlignment(FlowLayout.CENTER);
		panel1.setLayout(myFlowLayout);
		
		
		for(int i=0;i<vehiclesAgency.size();i++)
		{
			JLabel tmpPic = new JLabel();
			JLabel tmpinfo = new JLabel();
			int index=i;
			tmpPic.setIcon(resizeImage(vehiclesAgency.get(i).getImage()));
			tmpPic.addMouseListener(new MouseListener() {
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
					tmpPic.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
					if (currentClicked!=null&&currentClicked!=tmpPic)
						currentClicked.setBorder(BorderFactory.createEmptyBorder());
					currentClicked=tmpPic;
					vehicleinfoL.setText("<html>"+vehiclesAgency.elementAt(index).toString()+"</html>");
				}
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			panel1.add(tmpPic);
			imagesToGetIndexL.add(tmpPic);                                                                      // Labels vector that save images label, to use to get indexes in vehiclesAgency vector
			infoToGetIndexL.add(tmpinfo);
			
		}
		
		scroller.setPreferredSize(new Dimension(1300, 210));
		panelscroll.add(scroller);
				
		panelInfo.setLayout(myFlowLayout);
		vehicleinfoL.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,5));
		vehicleinfoL.setSize(new Dimension(800, 200));
		vehicleinfoL.setFont(font20);
		
		titleL.setFont(font72);
		infoL.setFont(font36);
	
		panelTitle.add(titleL);
		panelInfoTitle.add(infoL);
		
		backToMainB.setIcon(backI);
		backToMainB.setPreferredSize(new Dimension(140, 50));
		panelbutton.add(backToMainB);
		
		mainPanel.add(panelTitle);		
		
		add(mainPanel,BorderLayout.NORTH);
		add(panelscroll,BorderLayout.CENTER);
		add(vehicleinfoL,BorderLayout.SOUTH);
	}
 	public static ImageIcon resizeImage(ImageIcon image)
	{
		Image newImage=image.getImage();
		Image tmp=newImage.getScaledInstance(256, 180, Image.SCALE_REPLICATE);
		image = new ImageIcon(tmp);
		return image;
	}
 	public void switchToMainWindow(Vector<IVehicle>vehiclesAgency,Vector<ISeaVehicle>seaVehicles)
	{
		this.dispose();
	}
 	public static void NotifyWhenAgencyUpdate(Vector<IVehicle>vehiclesAgency)
 	{
 		for (VehiclesInventoryFrame i:inventoryInstance)
 		{
 			i.createVehiclesInventoryPanel(vehiclesAgency);
 			i.panel1.repaint();
 			i.panel1.validate();
 		}
 	}

}
