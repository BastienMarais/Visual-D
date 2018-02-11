package vues;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import modele.Donnees;
import utilitaire.MethodesPourFichier;

/**
 * Cette classe affiche le panel contenant
 * tout le necessaire pour modifier un fichier.
 * @author Vimont Adrien et Marais Bastien
 *
 */
public class PanelAjout extends JPanel implements ActionListener {
	
	GridBagLayout gestionnaireGrid = new GridBagLayout();
	GridBagConstraints contrainte = new GridBagConstraints();
	JButton boutonFile = new JButton("Fichier");
	JLabel labelFile = new JLabel();
	JTextField serie = new JTextField("Nom de la série");
	JLabel labelValeur = new JLabel(" Valeurs :");
	JTextField valeurX = new JTextField("valeur abscisse");
	JTextField valeurY = new JTextField("valeur ordonné");
	JButton ajouter = new JButton("Ajouter");
	JLabel notification = new JLabel();
	JButton retour = new JButton("Retour");
	
	File selectedFile;
	PanelAffichage pAff;
	Donnees donneesModif;
	
	public PanelAjout(PanelAffichage panelAffichage){
		
		
		pAff = panelAffichage;
		setLayout(gestionnaireGrid);
		setBackground(new Color(155,155,155));
		contrainte.fill=GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10,10,10,10);
		
		
		// ajout de la première ligne
		contrainte.gridx=0;
		contrainte.gridy=0;
		add(boutonFile,contrainte);
		contrainte.gridx=1;
		add(labelFile,contrainte);
		contrainte.gridx=2;
		add(serie,contrainte);
		
		// ajout de la deuxième ligne 
		contrainte.gridx=0;
		contrainte.gridy=1;
		add(labelValeur,contrainte);
		contrainte.gridx=1;
		add(valeurX,contrainte);
		contrainte.gridx=2;
		add(valeurY,contrainte);
		
		// ajout de la troisème ligne
		contrainte.gridx=0;
		contrainte.gridy=2;
		add(retour,contrainte);
		contrainte.gridx=1;
		add(notification,contrainte);
		contrainte.gridx=2;
		add(ajouter,contrainte);
		
		// actionListener
		boutonFile.addActionListener(this);
		ajouter.addActionListener(this);
		retour.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource()== boutonFile){
			FileNameExtensionFilter filtre = new FileNameExtensionFilter("objet","obj");
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.addChoosableFileFilter(filtre);
			fileChooser.setFileFilter(filtre);
	        int returnValue = fileChooser.showOpenDialog(null);
	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	        	selectedFile = fileChooser.getSelectedFile();
	        	labelFile.setText(selectedFile.getName());
	        }
		}
		if (evt.getSource() == ajouter){
			donneesModif = (Donnees)MethodesPourFichier.lecture(selectedFile);
			donneesModif.addValeur(serie.getText(), Integer.parseInt(valeurX.getText()) , Integer.parseInt(valeurY.getText()));

			MethodesPourFichier.ecriture(selectedFile,donneesModif);
			notification.setText("Valeurs " + valeurX.getText()+" et " + valeurY.getText() + " ajoutées." );	
			
			if(pAff.fMere.donnees.getTitre().equals(donneesModif.getTitre())){
				pAff.fMere.donnees =(Donnees)MethodesPourFichier.lecture(selectedFile);
				pAff.fMere.setContentPane(new PanelFils(pAff.fMere.donnees,"area"));
			}
		}
		
		if (evt.getSource()== retour){
			pAff.gestionnaireCartes.show(pAff, "acceuil");
		}
		
	}
}
