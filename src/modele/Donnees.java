package modele;


import java.io.Serializable;
import java.util.HashMap;

/**
 * Cette classe permet de stocker les données
 * utiles relatives aux diagrammes
 * @author Vimont Adrien et Marais Bastien
 *
 */
public class Donnees implements Serializable{
	int nbSerie;
	String titre;
	String titreX;
	String titreY;
	HashMap<String,HashMap<Integer,Integer>> valeurs; // <nom serie, <indice x,indice y>>
	
	public Donnees(){
		nbSerie = 0;
		titre = "";
		titreX ="";
		titreY = "";
		valeurs = new HashMap<String,HashMap<Integer,Integer>>();
		
	}
	
	//************GET************
	

	public String getTitre() {
		return titre;
	}
	
	public String getTitreX() {
		return titreX;
	}
	
	public String getTitreY() {
		return titreY;
	}

	public HashMap<String,HashMap<Integer,Integer>> getValeurs(){
		return valeurs;
	}
	
	public int getNbSerie(){
		return nbSerie;
	}
	
	//************SET************
	
	public void setTitre(String t) {
		titre = t;
	}
	
	public void setTitreX(String t) {
		titreX = t;
	}
	
	public void setTitreY(String t) {
		titreY = t;
	}

	/**
	 * Ajoute une valeur a la hashmap
	 * @param nomSerie nom de la série, sert de key
	 * @param x abscisse
	 * @param y ordonnée
	 */
	public void addValeur(String nomSerie,int x ,int y ){
		HashMap<Integer,Integer> hash = null;
		
		
		if (valeurs.containsKey(nomSerie)){
			hash = valeurs.get(nomSerie);
		}
		else {
			nbSerie +=1;
			hash = new HashMap<Integer,Integer>();
		}
		
		hash.put(x,y);
		valeurs.put(nomSerie,hash);

	}
		

	
	

	

}
