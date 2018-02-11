package utilitaire;


import javafx.scene.chart.XYChart;
import modele.Donnees;

/**
 * Cette classe regoupe les différentes constantes
 * de l'application.
 * @author Vimont Adrien et Marais Bastien
 *
 */
public class Constante {
	public static Donnees DEFAULT_DONNEES; 
	public static String REP_FILE = "fichiers";
	
	public Constante(){
		
		// DEFAULT_DONNEES
        
		DEFAULT_DONNEES = new Donnees();
        DEFAULT_DONNEES.setTitre("Temperature Monitoring (in Degrees C)");
 
        XYChart.Series seriesApril= new XYChart.Series();
        seriesApril.setName("April");
   
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),1,4);
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),3,10);
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),6,15);
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),9,8);
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),12,5);
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),15,18);
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),18,15);
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),21,13);       
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),24,19);      
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),27,21);
        DEFAULT_DONNEES.addValeur(seriesApril.getName(),30,21);
        
        
        XYChart.Series seriesMay = new XYChart.Series();
        seriesMay.setName("May");
        
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),1,20);
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),3,15);
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),6,13);
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),9,12);
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),12,14);
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),15,18);
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),18,25);
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),21,25);
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),24,23);
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),27,26);
        DEFAULT_DONNEES.addValeur(seriesMay.getName(),31,26);
        
        
        DEFAULT_DONNEES.setTitreX("Temps (jours)");
        DEFAULT_DONNEES.setTitreY("Température (°C)");
        
        
        
        
	}
}
