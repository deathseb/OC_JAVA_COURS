package fr.rasen.jdbc.testeurRequete;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

public class Fenetre extends JFrame{

	private JToolBar outil = new JToolBar();
	private JButton lancer = new JButton(new ImageIcon("src/images/testeur_requete/lancer.jpg"));
	private JSplitPane separateur;
	private JPanel resultat = new JPanel();
	private JTextPane requete = new JTextPane();
	
	public Fenetre() {
		this.setTitle("Testeur de requête SQL");
		this.setSize(600, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		initBarOutil();
		this.setVisible(true);
	}
	
	public void initBarOutil() {
		lancer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				recherche(requete.getText());
			}
			
		});
		outil.add(lancer);
		this.getContentPane().add(outil, BorderLayout.NORTH);
	}
	
	public void initEcran() {
		separateur = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(requete), resultat);
		separateur.setDividerLocation(150);
		this.getContentPane().add(separateur, BorderLayout.CENTER);
	}
	
	public void recherche(String str) {
		try {
			Statement state = Connecteur.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet res = state.executeQuery(str);
			ResultSetMetaData meta = res.getMetaData();
			Object[] colonne = new Object[meta.getColumnCount()];
			for(int i = 1; i <= meta.getColumnCount(); i++) { //récupère les noms des colonnes
				colonne[i-1] = meta.getColumnName(i);
			}
			
			Object[][] donnees = new Object[res.getRow()][meta.getColumnCount()];
			int j = 1;
			while(res.next()) {
				for(int i =1; i <= meta.getColumnCount(); i++) {
					donnees[j-1][i-1] = res.getObject(i);
				}
				j++;
			}
			res.close();
			state.close();
			resultat.removeAll();
			resultat.add(new JScrollPane(new JTable(donnees, colonne)), BorderLayout.CENTER);
			resultat.revalidate();
			resultat.repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
