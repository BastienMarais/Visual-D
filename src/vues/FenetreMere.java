package vues;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import modele.Donnees;
import utilitaire.Constante;
import utilitaire.MethodesPourFichier;

/**
 * Cette classe est la JFrame de l'application
 * @author Vimont Adrien et Marais Bastien
 *
 */

public class FenetreMere extends JFrame implements ActionListener {
	
	JMenu fichier = new JMenu("Fichier");
    JMenu charts = new JMenu("Charts");
    JMenuItem choix_fichier = new JMenuItem("Choix du fichier");
    JMenuItem ajout_modif = new JMenuItem("Nouveau/Modifier");
    JMenuItem quitter = new JMenuItem("Quitter");
    JMenuItem areaChart = new JMenuItem("Area Chart");
    JMenuItem lineChart = new JMenuItem("Line Chart");
    JMenuItem scatterChart = new JMenuItem("Scatter Chart");
    JMenuItem bubbleChart = new JMenuItem("Bubble Chart");
    JMenuItem barChart = new JMenuItem("Bar Chart");
    JMenuBar menuBar = new JMenuBar();
    Donnees donnees; // données a afficher
    
    
    public FenetreMere(){
    	super("Visualisation de données");
    	menuBar.add(fichier);
        fichier.add(choix_fichier);
        fichier.add(ajout_modif);
        choix_fichier.addActionListener(this);
        ajout_modif.addActionListener(this);
        fichier.add(quitter);
        quitter.addActionListener(this);
        menuBar.add(charts);
        charts.add(areaChart);
        charts.add(lineChart);
        charts.add(scatterChart);
        charts.add(bubbleChart);
        charts.add(barChart);
        
        areaChart.addActionListener(this);
        lineChart.addActionListener(this);
        scatterChart.addActionListener(this);
        bubbleChart.addActionListener(this);
        barChart.addActionListener(this);
        
        donnees = Constante.DEFAULT_DONNEES;
 		setContentPane(new PanelFils(donnees,"area"));
 		setSize(1400, 600);
 		setVisible(true);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		setJMenuBar(menuBar);
    }
    
	
	public static void main(String[] args) {
		new Constante(); // initialise les constantes
		new FenetreMere();
	}


	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()== quitter){
			int reponse = JOptionPane.showConfirmDialog(this,"Etes vous sûr de vouloir quitter ?",
														"Confirmation",JOptionPane.OK_CANCEL_OPTION);
			switch(reponse){
				case JOptionPane.CLOSED_OPTION: break;
				case JOptionPane.OK_OPTION: System.exit(0);break;
				case JOptionPane.CANCEL_OPTION: break;
			}
		}
		if(evt.getSource()== choix_fichier){
			FileNameExtensionFilter filtre = new FileNameExtensionFilter("objet","obj");
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.addChoosableFileFilter(filtre);
			fileChooser.setFileFilter(filtre);
	        int returnValue = fileChooser.showOpenDialog(null);
	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	          donnees = (Donnees) MethodesPourFichier.lecture(selectedFile);
	          setContentPane(new PanelFils(donnees,"area"));
	        }
		 }
		if (evt.getSource()== areaChart)
			setContentPane(new PanelFils(donnees,"area"));
		if (evt.getSource()== lineChart)
			setContentPane(new PanelFils(donnees,"line"));
		if (evt.getSource()== scatterChart)
			setContentPane(new PanelFils(donnees,"scatter"));
		if (evt.getSource()== bubbleChart)
			setContentPane(new PanelFils(donnees,"bubble"));
		if (evt.getSource()== barChart)
			setContentPane(new PanelFils(donnees,"bar"));
		if (evt.getSource()== ajout_modif)
			new InterfaceNewAddDonnees(this);
	}
}
