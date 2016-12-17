package projet.Controller;

import projet.Model.Etudiant;
import projet.Model.GestionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by SMITHE on 13-Dec-16.
 */

public class EtudiantController extends Controller {
	private static final String BASE_PATH_CTRL = "/Etudiant";
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? Controller.BASE_PATH_PROJECT : "" ) + BASE_PATH_CTRL;
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		initController( req );
		
		if ( getMethod().equals( "get" ) && getAction().equals( "/details" ) )
			detailsEtudiantAction( req, resp );
		
		else if ( getMethod().equals( "get" ) && getAction().equals( "/notes" ) )
			listNotesEtudiantAction( req, resp );
		
		else
			listEtudiantAction( req, resp );
		
		loadJSP( req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Liste Etudiant
	private void listEtudiantAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Collection< Etudiant > etusList = GestionFactory.getEtudiants();
		req.setAttribute( "etusList", etusList );
		
		// Path
		setPathJSP( "pathList" );
	}
	
	// -------------------------------------------------------------------------------------------------------- Details Etudiant
	private void detailsEtudiantAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		// Set Etu past in params
		Etudiant etu = GestionFactory.getEtudiantById( Integer.valueOf( req.getParameter( "etu" ) ) );
		req.setAttribute( "etu", etu );
		
		// NbAvsence
		int nbAbsences = GestionFactory.getAbsencesByEtudiantId( etu.getId() );
		req.setAttribute( "nbAbsences", nbAbsences );
		
		// Path
		setPathJSP( "pathDetails" );
	}
	
	// -------------------------------------------------------------------------------------------------------- Liste notes Etudiant
	private void listNotesEtudiantAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		// Set Etu past in params
		Etudiant etu = GestionFactory.getEtudiantById( Integer.valueOf( req.getParameter( "etu" ) ) );
		
		ArrayList< Float > listNotes = new ArrayList<>( Arrays.asList(
			( float ) 12.5,
			( float ) 13.5,
			( float ) 14.5,
			( float ) 15.5
		) );
		
		etu.setNoteEtudiant( listNotes );
		req.setAttribute( "etu", etu );
		
		// Path
		setPathJSP( "pathListNotes" );
	}
}
