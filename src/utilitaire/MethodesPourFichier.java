package utilitaire;
import java.io.*;

/**
 * Cette classe regoupe les fonctions permettant
 * l'écriture et la lecture d'un fichier.obj.
 * @author Vimont Adrien et Marais Bastien
 *
 */
public class MethodesPourFichier {

	/**
	 * Permet de lire un fichier.obj
	 * @param parFichier le chemin du fichier
	 * @return l'objet lu dans le fichier
	 */
	public static Object lecture(File parFichier){
		
		ObjectInputStream flux;
		Object objetLu = null;
		
		try{
			flux = new ObjectInputStream(new FileInputStream(parFichier));
			objetLu = (Object)flux.readObject();
			flux.close();
		}
		catch(ClassNotFoundException parException){
			System.err.println(parException.toString());
			System.exit(1);
		}
		catch(IOException parException){
			System.err.println("Erreur lecture fichier "+ parException.toString());
			System.exit(1);
		}
		return objetLu;
	}
	
	/**
	 * Permet d'écrire dans un fichier.obj
	 * @param parfichier le chemin du fichier où écrire
	 * @param parObjet l'objet a écrire
	 */
	public static void ecriture(File parfichier, Object parObjet){
		ObjectOutputStream flux = null;
		try{
			flux = new ObjectOutputStream(new FileOutputStream(parfichier));
			flux.writeObject(parObjet);
			flux.flush();
			flux.close();
		}
		catch(IOException parException){
			System.err.println("Problème a l'écriture \n"+ parException.toString());
			System.exit(1);
		}
		
	}
}
