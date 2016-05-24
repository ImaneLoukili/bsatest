package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BsaGUI extends JFrame {
	private JLabel jlparam=new JLabel("Entrez ces parametres :");
	private JLabel jldim=new JLabel(" dimension (la taille d'un individu):");
	private JLabel jlpopsize=new JLabel("popsize (le nombre d'individus de la population):");
	private JLabel jlNbRun=new JLabel("indRun (le nombre d'executions):");
	private JLabel jlmixRate=new JLabel("mixrate (la probabilite de mutation):");
	private JPanel jpnln = new JPanel();
	private JPanel jpnl = new JPanel();
	
	
	
	public BsaGUI() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("BSA ALGORITHM");
		jpnln.setLayout(new FlowLayout());
		jpnln.add(jlparam);
		this.add(jpnln, BorderLayout.NORTH);
		jpnl.setLayout(new GridLayout(2,2));
		jpnl.add(jldim);
		jpnl.add(jlpopsize);
		jpnl.add(jlNbRun);
		jpnl.add(jlmixRate);
		this.add(jpnl);
		
		
		
		
		this.setBounds(100,100,1000,1000); 
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new BsaGUI();
	}

}
