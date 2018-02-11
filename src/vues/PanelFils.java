package vues;

import javax.swing.JPanel;

import modele.Donnees;


/**
 * Cette classe h�rite de JPanel et est le contentPane
 * de fentreMere.
 * @author Vimont Adrien et Marais Bastien
 *
 */
public class PanelFils extends JPanel {
	PanelChart panelChart; // panel qui g�re les charts
	PanelTable panelTable; // panel g�rant la table

	
	public PanelFils(Donnees donnees, String type){
		
		panelChart = new PanelChart(donnees,type);
		panelTable = new PanelTable(donnees);

		add(panelChart);
		add(panelTable);
	}
}
