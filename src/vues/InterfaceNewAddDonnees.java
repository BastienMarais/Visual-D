package vues;

import java.awt.Color;
import javax.swing.JFrame;


/**
 * Cette classe affiche une fen�tre qui va g�rer les panels
 * g�rant la gestion de fichiers.
 * @author Vimont Adrien et Marais Bastien
 *
 */
public class InterfaceNewAddDonnees extends JFrame {

	
	public InterfaceNewAddDonnees(FenetreMere fenetreMere){
		super("Ajouter ou modifier les donn�es");
		PanelAffichage contentPane = new PanelAffichage(fenetreMere);
		setContentPane(contentPane); 
		contentPane.setBackground(new Color(150,150,150)); // couleur du conteneur
		setSize(800,600); // dimensions
		setVisible(true); // visible ou non 
		setLocation(50,150); // position de la fen�tre
	}
	

}
