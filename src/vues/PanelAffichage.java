package vues;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Cette classe affiche les panels pour
 * cr�er ou mettre a jour les fichiers.
 * @author Vimont Adrien et Marais Bastien
 *
 */
public class PanelAffichage extends JPanel implements ActionListener{
	
	CardLayout gestionnaireCartes = new CardLayout(5,5);
	JButton nouveau = new JButton("Nouveau Fichier");
	JButton ajouter = new JButton("Ajouter donn�es");
	JLabel texte = new JLabel ("<== A vous de choisir ==>");
	JPanel acceuil = new JPanel();
	PanelNouv panelNouv ; 
	PanelAjout panelAjout ;
	FenetreMere fMere;
	
	public PanelAffichage(FenetreMere fenetreMere) {

		setLayout(gestionnaireCartes);
		fMere = fenetreMere;
		// cr�ation de acceuil :
		acceuil.add(nouveau);
		acceuil.add(texte);
		acceuil.add(ajouter);
		nouveau.addActionListener(this);
		ajouter.addActionListener(this);
		
		// creation des autres panels : 
		panelNouv = new PanelNouv(this);
		panelAjout = new PanelAjout(this);
		
		// ajout des diapos
		add(acceuil,"acceuil");
		add(panelNouv,"panelNouv");
		add(panelAjout,"panelAjout");
	}



	
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource()== nouveau){
			panelNouv.nomFile.setText("");
			panelNouv.titre.setText("Titre");
			panelNouv.titreX.setText("axe x");
			panelNouv.titreY.setText("axe y");
			panelNouv.notification.setText("");
			gestionnaireCartes.show(this,"panelNouv");
		}
		if (evt.getSource()== ajouter){
			panelAjout.labelFile.setText("");
			panelAjout.serie.setText("Nom de la s�rie");
			panelAjout.valeurX.setText("valeur abscisse");
			panelAjout.valeurY.setText("valeur ordonn�");
			panelAjout.notification.setText("");
			gestionnaireCartes.show(this,"panelAjout");
		}
		
	}
}
