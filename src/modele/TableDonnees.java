package modele;

import java.awt.*;
import java.util.TreeSet;

import javax.swing.*;


/**
 * Cette classe permet d'afficher les données
 * des séries.
 * @author Vimont Adrien et Marais Bastien
 *
 */
public class TableDonnees extends JTable {
	TreeSet<Integer> valeurX;
	
	
	public TableDonnees(Donnees donnees){
		
		valeurX=new TreeSet<Integer>();
		for(String nomseries: donnees.getValeurs().keySet()){
			for(int i: donnees.getValeurs().get(nomseries).keySet()){
				valeurX.add(i);							
			}		
		}
		
		setModel(new ModeleTable(donnees,this));
		
		getTableHeader().setBackground(Color.blue);
		getTableHeader().setFont(new Font("Arial",Font.BOLD,15));
		getTableHeader().setForeground(new Color(0,255,0));
		getTableHeader().setResizingAllowed(false);
		getTableHeader().setReorderingAllowed(false);
		setRowHeight(50);
		setAutoResizeMode(20);
		
		int ligne=0;
		int val;
		
		
		int numserie=1;
		
		for(int valeur: valeurX){
			setValueAt(valeur,ligne,0);
			
			for(String nomseries: donnees.getValeurs().keySet()){
				if(donnees.getValeurs().get(nomseries).containsKey(valeur))
				{
					val=donnees.getValeurs().get(nomseries).get(valeur);
					setValueAt(val,ligne,numserie);
				}			
				numserie++;
			}
			numserie=1;
			ligne++;
		}
		
		
		
	}
}
