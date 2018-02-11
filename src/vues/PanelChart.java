package vues;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.paint.Color;
import modele.Donnees;

/**
 * Cette classe affiche le panel contenant
 * le diagramme.
 * @author Vimont Adrien et Marais Bastien
 *
 */
public class PanelChart extends JPanel {
	Chart chart;
	JFXPanel jfxPanel;
	static String typeChart;
	
	public PanelChart(Donnees donnees, String type) {
		
		typeChart = type;
		jfxPanel = new JFXPanel();
		this.add(jfxPanel);
		
		Platform.runLater(new Runnable() {
			public void run() {
				if (type == "bubble")
					initBubbleChart(donnees);
				else if (type == "line")
					initLineChart(donnees);
				else if (type == "scatter")
					initScatterChart(donnees);
				else if (type =="area")
					initAreaChart(donnees);
				else if (type =="bar")
					initBarChart(donnees);
				initFX();
			}
		});
		
	}
	
	/**
	 * affiche la figure  
	 */
	public void initFX() { 
		Group root = new Group();
		chart.setLayoutX(80);
		root.getChildren().add(chart);
		Scene scene = new Scene(root, 700, 500, Color.CORNSILK);
		jfxPanel.setScene(scene);
	}
	
	/**
	 * Transforme la figure en AreaChart
	 * avec les données transmisent.
	 * @param donnees les données de la figure
	 */
	public void initAreaChart(Donnees donnees) {
		int min = -10000;
		int max = 150000 ;
		int unit = 1 ;
		int compteur = 1;
		
		
		
		for(String nomSerie : donnees.getValeurs().keySet()){
			for(Integer x : donnees.getValeurs().get(nomSerie).keySet()){
				if (compteur == 1){
					min = x;
					max = x;
					compteur++;
				}
				else{
					min = PanelChart.min(min, x);
					max = PanelChart.max(max, x);
				}
			}
		}
		
		unit = (int)max/15;
				
		
		NumberAxis yAxis = new NumberAxis();
		NumberAxis xAxis = new NumberAxis(min,max,unit);
		
        
       
        xAxis.setLabel(donnees.getTitreX());
        yAxis.setLabel(donnees.getTitreY());
        AreaChart<Number,Number> ac = new AreaChart<Number,Number>(xAxis,yAxis);
        
        ac.setTitle(donnees.getTitre());
        ArrayList<XYChart.Series> listeSeries = addValeurChart(donnees);
        
        for(XYChart.Series serie : listeSeries){
        	 ac.getData().add(serie);
        }
        
        chart= ac;
	}
	
	/**
	 * Transforme la figure en LineChart
	 * avec les données transmisent.
	 * @param donnees les données de la figure
	 */
	public void initLineChart(Donnees donnees) {
		int min = -10000;
		int max = 150000 ;
		int unit = 1 ;
		int compteur = 1;
		
		
		
		for(String nomSerie : donnees.getValeurs().keySet()){
			for(Integer x : donnees.getValeurs().get(nomSerie).keySet()){
				if (compteur == 1){
					min = x;
					max = x;
					compteur++;
				}
				else{
					min = PanelChart.min(min, x);
					max = PanelChart.max(max, x);
				}
			}
		}
		
		unit = (int)max/15;
				
		
		NumberAxis yAxis = new NumberAxis();
		NumberAxis xAxis = new NumberAxis(min,max,unit);
		
        xAxis.setLabel(donnees.getTitreX());
        yAxis.setLabel(donnees.getTitreY());
        LineChart<Number,Number> ac =new LineChart<Number,Number>(xAxis,yAxis);
        
        ac.setTitle(donnees.getTitre());
        ArrayList<XYChart.Series> listeSeries = addValeurChart(donnees);
        
        for(XYChart.Series serie : listeSeries){
        	 ac.getData().add(serie);
        }
        
        chart = ac;
	}
	
	/**
	 * Transforme la figure en ScatterChart
	 * avec les données transmisent.
	 * @param donnees les données de la figure
	 */
	public void initScatterChart(Donnees donnees) {
        
		int min = -10000;
		int max = 150000 ;
		int unit = 1 ;
		int compteur = 1;
		
		
		
		for(String nomSerie : donnees.getValeurs().keySet()){
			for(Integer x : donnees.getValeurs().get(nomSerie).keySet()){
				if (compteur == 1){
					min = x;
					max = x;
					compteur++;
				}
				else{
					min = PanelChart.min(min, x);
					max = PanelChart.max(max, x);
				}
			}
		}
		
		unit = (int)max/15;
				
		
		NumberAxis yAxis = new NumberAxis();
		NumberAxis xAxis = new NumberAxis(min,max,unit);
		
        xAxis.setLabel(donnees.getTitreX());
        yAxis.setLabel(donnees.getTitreY());
        ScatterChart<Number,Number> ac =new ScatterChart<Number,Number>(xAxis,yAxis);
        
        ac.setTitle(donnees.getTitre());
        ArrayList<XYChart.Series> listeSeries = addValeurChart(donnees);
        
        for(XYChart.Series serie : listeSeries){
        	 ac.getData().add(serie);
        }
        
        chart = ac;
	}
	
	/**
	 * Transforme la figure en BubbleChart
	 * avec les données transmisent.
	 * @param donnees les données de la figure
	 */
	public void initBubbleChart(Donnees donnees) {
		int min = -10000;
		int max = 150000 ;
		int unit = 1 ;
		int compteur = 1;
		
		
		
		for(String nomSerie : donnees.getValeurs().keySet()){
			for(Integer x : donnees.getValeurs().get(nomSerie).keySet()){
				if (compteur == 1){
					min = x;
					max = x;
					compteur++;
				}
				else{
					min = PanelChart.min(min, x);
					max = PanelChart.max(max, x);
				}
			}
		}
		
		unit = (int)max/15;
				
		
		NumberAxis yAxis = new NumberAxis();
		NumberAxis xAxis = new NumberAxis(min,max,unit);
		
        xAxis.setLabel(donnees.getTitreX());
        yAxis.setLabel(donnees.getTitreY());
        BubbleChart<Number,Number> ac =new BubbleChart<Number,Number>(xAxis,yAxis);
        
        ac.setTitle(donnees.getTitre());
        ArrayList<XYChart.Series> listeSeries = addValeurChart(donnees);
        
        for(XYChart.Series serie : listeSeries){
        	 ac.getData().add(serie);
        }
        
        chart = ac;
	}
	
	/**
	 * Transforme la figure en BarChart
	 * avec les données transmisent.
	 * @param donnees les données de la figure
	 */
	public void initBarChart(Donnees donnees) {
		CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel(donnees.getTitreX());
        yAxis.setLabel(donnees.getTitreY());
        BarChart<String,Number> ac =new BarChart<String,Number>(xAxis,yAxis);
        
        ac.setTitle(donnees.getTitre());
        ArrayList<XYChart.Series> listeSeries = addValeurChart(donnees);
        
        for(XYChart.Series serie : listeSeries){
        	 ac.getData().add(serie);
        }
        
        chart = ac;
	}
	
	/**
	 * Convertit Donnees.valeurs en ArrayList de XYChart.Series
	 * @param donnees données a ajouter
	 * @return la liste des Series
	 */
	public static ArrayList<XYChart.Series> addValeurChart(Donnees donnees ){
		
		ArrayList<XYChart.Series> listeSeries = new ArrayList<XYChart.Series>();
		
		
		for(String nomSerie : donnees.getValeurs().keySet()){
			
			XYChart.Series serie = new XYChart.Series();
			serie.setName(nomSerie);
			
			if (typeChart.equals("bar")){
				TreeMap<Integer,Integer> absTries = new TreeMap<Integer,Integer>();
				for(Integer x : donnees.getValeurs().get(nomSerie).keySet()){
					int y = donnees.getValeurs().get(nomSerie).get(x);
					absTries.put(x,y);
				}
				for(Integer x : absTries.keySet()){
					serie.getData().add(new XYChart.Data(Integer.toString(x), absTries.get(x)));
				}
			}
			else {
				for(int x : donnees.getValeurs().get(nomSerie).keySet()){
					int y = donnees.getValeurs().get(nomSerie).get(x);
					serie.getData().add(new XYChart.Data(x, y));
				}
			}
			listeSeries.add(serie);
		}
		return listeSeries;
		
	}
	
	/**
	 * Renvoi le plus petit int
	 * @param a un entier
	 * @param b un entier
	 * @return le plus petit
	 */
	public static int min(int a,int b){
		if (a>b)
			return b;
		else
			return a;
	}
	
	/**
	 * Renvoi le plus grand int
	 * @param a un entier
	 * @param b un entier
	 * @return le plus grand
	 */
	public static int max(int a,int b){
		if (a>b)
			return a;
		else
			return b;
	}
	
}
