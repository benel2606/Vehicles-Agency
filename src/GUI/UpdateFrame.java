package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class UpdateFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	static final Object lock = new Object();
		
	private JLabel updateL=new JLabel("The system are update, please wait...");
	private JLabel updatePic=new JLabel();
	
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	
	private FlowLayout myFlowLayout=new FlowLayout();
	
	private ImageIcon updateI=new ImageIcon("pic\\load2.gif");
	
	private Font font20=new Font("Century Gothic", Font.PLAIN, 20);
	private int min;
	private int max;
	public UpdateFrame(int min1,int max1)
	{
		setTitle("Update");
		setSize(400,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		createUpdatePanel();	
		min=min1;
		max=max1;
		min*=1000;
		max*=1000;
		new SwingWorker<Object, Object>() {
			@Override
			protected Object doInBackground() throws Exception {
				try {
					Thread.sleep(new Random().nextInt(max-min+1)+min);
					dispose();
				} catch (InterruptedException e) {
					dispose();
				}
				return null;
			}
			
		}.execute();
				
	}
	public void createUpdatePanel()
	{
		myFlowLayout.setAlignment(FlowLayout.CENTER);
		panel1.setLayout(myFlowLayout);
		panel2.setLayout(myFlowLayout);
		
		updatePic.setIcon(updateI);
		updateL.setFont(font20);
		panel1.add(updateL);
		panel2.add(updatePic);
		
		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.CENTER);
		//this.add(updateL,BorderLayout.NORTH);
		//this.add(updatePic,BorderLayout.CENTER);
		
	}
}
