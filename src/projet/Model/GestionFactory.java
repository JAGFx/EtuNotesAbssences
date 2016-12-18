package projet.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class GestionFactory {
	// CHARGER en premier à l'execution du projet (car constante : static final)
	private static final HashMap< Integer, Student > LISTE_ID_ETUDIANTS = intializeListEtudiants();
	
	/////// SIMULATION DE LA PERSISTANCE DES ETUDIANTS ET DES ABSENCES
	private static final HashMap< Integer, Integer > LISTE_ID_ABSENCES = intializelistEtudiantAbsence();
	
	public GestionFactory() {
	}
	
	// Initialisation des étudiants
	private static HashMap< Integer, Student > intializeListEtudiants() {
		
		// Création des étudiants
		Student etu1 = new Student( 0, "Brunet-Manquat", "Francis" );
		Student etu2 = new Student( 1, "Martin", "Philippe" );
		
		// Création du hasmap (association clé/valeur)
		// Association id -> etudiant
		HashMap< Integer, Student > listEtudiantsTemp = new HashMap<>();
		listEtudiantsTemp.put( etu1.getId(), etu1 );
		listEtudiantsTemp.put( etu2.getId(), etu2 );
		
		//
		return listEtudiantsTemp;
	}
	
	// Initialisation des absences
	private static final HashMap< Integer, Integer > intializelistEtudiantAbsence() {
		
		// Création du hasmap (association clé/valeur)
		// Association etudiant id -> absences
		HashMap< Integer, Integer > listEtudiantAbsenceTemp = new HashMap<>();
		
		// Le nombre d'absences est généré aléatoirement
		Random rand = new Random();
		for ( Student student : LISTE_ID_ETUDIANTS.values() ) {
			listEtudiantAbsenceTemp.put( student.getId(), rand.nextInt( 10 ) );
		}
		
		//
		return listEtudiantAbsenceTemp;
	}
	
	
	/////// METHODES A UTILISER
	// Retourne l'ensemble des etudiants
	public static Collection< Student > getEtudiants() {
		return LISTE_ID_ETUDIANTS.values();
	}
	
	// Retourne un étudiant en fonction de son id 
	public static Student getEtudiantById( int id ) {
		return LISTE_ID_ETUDIANTS.get( id );
	}
	
	// Retourne le nombre d'absences d'un etudiant en fonction de son id 
	public static Integer getAbsencesByEtudiantId( int id ) {
		return LISTE_ID_ABSENCES.get( id );
	}
	
}