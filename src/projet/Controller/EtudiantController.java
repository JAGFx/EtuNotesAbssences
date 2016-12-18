package projet.Controller;

import projet.Components.Controller;
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

public final class EtudiantController extends Controller {
	public static final String BASE_PATH_CTRL = "/Etudiant";
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + EtudiantController.BASE_PATH_CTRL;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println( "-------------------- IN Etudiant Controller" );
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
	}
	
	// -------------------------------------------------------------------------------------------------------- Liste Etudiant
	private void listEtudiantAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Collection< Etudiant > etusList = GestionFactory.getEtudiants();
		req.setAttribute( "etusList", etusList );
		
		// Path
		loadJSP( getServeltParam( "pathList" ), req, resp );
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
		loadJSP( getServeltParam( "pathDetails" ), req, resp );
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
		loadJSP( getServeltParam( "pathListNotes" ), req, resp );
	}
	
	@Override
	protected String getBasePathCtrl() {
		return EtudiantController.BASE_PATH_CTRL;
	}
}
