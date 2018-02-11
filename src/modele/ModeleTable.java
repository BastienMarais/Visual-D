package modele;

import javax.swing.table.DefaultTableModel;


/**
 * Cette classe permet de remplir la
 * JTable.
 * @author Vimont Adrien et Marais Bastien
 *
 */
public class ModeleTable extends DefaultTableModel {
	
	public ModeleTable(Donnees donnees,TableDonnees td){
		
		String[] intitulesColonnes = new String[donnees.getValeurs().size()+1];
		intitulesColonnes[0]=donnees.getTitreX();
		int i=1;
		for(String nomseries: donnees.getValeurs().keySet()){
			intitulesColonnes[i]=nomseries;
			i++;
		}
		
		setColumnIdentifiers(intitulesColonnes);
		
		int j=0;
		for(String nomseries: donnees.getValeurs().keySet()){
			if(j<donnees.getValeurs().get(nomseries).size())
				j=donnees.getValeurs().get(nomseries).size();
		}
		setRowCount(td.valeurX.size());
	}
}