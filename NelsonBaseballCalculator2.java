import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/* 
 * This program is a baseball calculator. It calculates the users batting average and slugging percentage.   
 * It does this by taking in the users information and will print the batting average and slugging percentage to the screen.
 * It will ask the user to enter the amount of total hits and at bats for thier average. and for slugging it will ask for 
 * the total amount of singles, doubles, triples, and homeruns. 
 * 
 * This is the batting class it gets the hits and at bats and sets them.
 * Then returns a toString.
 */
class Batting {
	private float hit;
	private float atBat;
	public float getHit() {
		return hit;
	}
	public void setHit(float hit) {
		this.hit = hit;
	}
	public float getAtBat() {
		return atBat;
	}
	public void setAtBat(float atBat) {
		this.atBat = atBat;
	}
	public Batting(float hit, float atBat) {
		setHit(hit);
		setAtBat(atBat);
	}
	@Override
	public String toString() {
		return String.format("x=%d, y=%d",hit,atBat);
	}
}

class BattingAverage {
	
}

class LinePanel extends JPanel implements MouseListener,MouseMotionListener,
KeyListener {
	private ArrayList<Batting> batting;
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			/*
			
			//Batting Average formula = Hits / total at bats
			lblBaFinal.setText((Float.parseFloat(txtHits.getText())/Float.parseFloat(txtAbs.getText())) * 1000 +"");

			// Slugging Percentage formula = (singles +(2 * doubles)) + (3 * triples) + (4 * homeruns) / at bats
			lblSlugFinal.setText(((Float.parseFloat(txtSingle.getText()) + (2 * Float.parseFloat(txtDouble.getText()))) 
					+ (3 * Float.parseFloat(txtTriple.getText()) + (4 * Float.parseFloat(txtHomerun.getText()))) 
					/ (Float.parseFloat(txtAbs.getText()))) + "");
			*/
		}
	}	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		requestFocusInWindow();
		repaint();
	}
	public void mouseDragged(MouseEvent e) {}
	public LinePanel(ArrayList<Batting> batting) {
		this.batting = batting;
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}
	@Override
	/*
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(message, 200, 400);
		*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Welcome", 10, 20);
	}
}

class TextFrame extends JFrame { //implements ActionListener,KeyListener {
	//private LinePanel lpan;
	private JTextField txtHits;
	private JTextField txtAbs;
	private JTextField txtSingle;
	private JTextField txtDouble;
	private JTextField txtTriple;
	private JTextField txtHomerun;
	private JLabel lblBaFinal;
	private JLabel lblSlugFinal;
	private JLabel lblAbhrFinal;
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			//Batting Average formula = Hits / total at bats
			lblBaFinal.setText((Float.parseFloat(txtHits.getText())/Float.parseFloat(txtAbs.getText())) +"");

			/*
			// Slugging Percentage formula = (singles +(2 * doubles)) + (3 * triples) + (4 * homeruns) / at bats
			lblSlugFinal.setText(((Float.parseFloat(txtSingle.getText()) + (2 * Float.parseFloat(txtDouble.getText()))) 
					+ (3 * Float.parseFloat(txtTriple.getText()) + (4 * Float.parseFloat(txtHomerun.getText()))) 
					/ (Float.parseFloat(txtAbs.getText()))) + "");
					 
			*/
			// Slugging Percentage formula = (singles +(2 * doubles)) + (3 * triples) + (4 * homeruns) / at bats
						lblSlugFinal.setText((((Float.parseFloat(txtSingle.getText()) + (2 * Float.parseFloat(txtDouble.getText()))) 
								+ (3 * Float.parseFloat(txtTriple.getText())) + (4 * Float.parseFloat(txtHomerun.getText()))) 
								/ (Float.parseFloat(txtAbs.getText()))) + "");
			repaint();
		}
	}	
	public void configureMenu() {
		JMenuBar bar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(miExit);
		bar.add(mnuFile);
		JMenu mnuEdit = new JMenu("Edit");
		JMenuItem miClear = new JMenuItem("Clear");
		miClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHits.setText("");
				txtAbs.setText("");
				lblBaFinal.setText("");
				lblSlugFinal.setText("");
				lblAbhrFinal.setText("");
				repaint();
			}
		});
		mnuEdit.add(miClear);
		bar.add(mnuEdit);
		setJMenuBar(bar);
	}
	public void configureUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,205,350);
		setTitle("Baseball Calculator");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new FlowLayout());
		JLabel lblHits = new JLabel("Total hits");
		txtHits = new JTextField(10);
		panCenter.add(lblHits);
		panCenter.add(txtHits);
		JLabel lblAbs = new JLabel("At Bats");
		txtAbs = new JTextField(10);
		panCenter.add(lblAbs);
		panCenter.add(txtAbs);
		JLabel lblSingles = new JLabel("Singles");
		txtSingle = new JTextField(10);
		panCenter.add(lblSingles);
		panCenter.add(txtSingle);
		JLabel lblDoubles = new JLabel("Doubles");
		txtDouble = new JTextField(10);
		panCenter.add(lblDoubles);
		panCenter.add(txtDouble);
		JLabel lblTriples = new JLabel("Triples");
		txtTriple = new JTextField(10);
		panCenter.add(lblTriples);
		panCenter.add(txtTriple);
		JLabel lblHomeruns = new JLabel("Home runs");
		txtHomerun = new JTextField(10);
		panCenter.add(lblHomeruns);
		panCenter.add(txtHomerun);
		JLabel lblAvg = new JLabel("Batting Average: ");
		panCenter.add(lblAvg);
		lblBaFinal = new JLabel();
		panCenter.add(lblBaFinal);
		JLabel lblSlugging = new JLabel("Slugging: ");
		panCenter.add(lblSlugging);
		lblSlugFinal = new JLabel();
		panCenter.add(lblSlugging);
		panCenter.add(lblSlugFinal);
		JLabel lblAbhr = new JLabel("At Bats per Homerun: ");
		lblAbhrFinal = new JLabel();
		panCenter.add(lblAbhr);
		panCenter.add(lblAbhrFinal);
		c.add(panCenter,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		
		
		// The enter button will divide the hits and at bats input by the user and show the batting average in a jlabel.
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						//Batting Average formula = Hits / total at bats
						lblBaFinal.setText((Float.parseFloat(txtHits.getText())/Float.parseFloat(txtAbs.getText())) * 1000 +"");
						/*
						// Slugging Percentage formula = (singles +(2 * doubles)) + (3 * triples) + (4 * homeruns) / at bats
						lblSlugFinal.setText(((Float.parseFloat(txtSingle.getText()) + (2 * Float.parseFloat(txtDouble.getText()))) 
								+ (3 * Float.parseFloat(txtTriple.getText()) + (4 * Float.parseFloat(txtHomerun.getText()))) 
								/ (Float.parseFloat(txtAbs.getText()))) + "");
						*/
						// Slugging Percentage formula = (singles +(2 * doubles)) + (3 * triples) + (4 * homeruns) / at bats
						lblSlugFinal.setText((((Float.parseFloat(txtSingle.getText()) + (2 * Float.parseFloat(txtDouble.getText()))) 
								+ (3 * Float.parseFloat(txtTriple.getText())) + (4 * Float.parseFloat(txtHomerun.getText()))) 
								/ (Float.parseFloat(txtAbs.getText()))) + "");
						lblAbhrFinal.setText((Float.parseFloat(txtHomerun.getText())/Float.parseFloat(txtAbs.getText())) * 100 +"");
						repaint();

			}
		}
	);
		panSouth.add(btnEnter);
		c.add(panSouth,BorderLayout.SOUTH);
		configureMenu();
		
	}
		public TextFrame() {
		configureUI();
	}
}

public class NelsonBaseballCalculator2 {
	public static void main(String[] args) {
		ArrayList<Batting> batting = new ArrayList<Batting>();
		TextFrame tf = new TextFrame();
		tf.setVisible(true);

	}

}
