package projet.Controller;

import projet.Components.Controller;
import projet.Model.Etudiant;
import projet.Model.Groupe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by SMITHE on 13-Dec-16.
 */
public final class GroupeController extends Controller {
	private static final String BASE_PATH_CTRL = "/Groupe";
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + GroupeController.BASE_PATH_CTRL;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println( "-------------------- IN Groupe Controller" );
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		initController( req );
		
		if ( getMethod().equals( "get" ) && getAction().equals( "/details" ) )
			detailsGroupeAction( req, resp );
		else
			listGroupeAction( req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Liste groupe
	private void listGroupeAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Collection< Groupe > listGroupe = Arrays.asList(
			new Groupe( 0, "GroupeA" ),
			new Groupe( 1, "GroupeB" ),
			new Groupe( 2, "GroupeC" )
		);
		req.setAttribute( "listGroupe", listGroupe );
		
		loadJSP( getServeltParam( "pathList" ), req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Détails groupe
	private void detailsGroupeAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Collection< Etudiant > listEtuA = Arrays.asList(
			new Etudiant( 0, "Nom1", "Prenom1" ),
			new Etudiant( 1, "Nom2", "Prenom2" ),
			new Etudiant( 2, "Nom3", "Prenom3" )
		);
		
		Groupe groupeA = new Groupe( 0, "GroupeA" );
		
		req.setAttribute( "groupe", groupeA );
		loadJSP( getServeltParam( "pathDetails" ), req, resp );
	}
	
	@Override
	protected String getBasePathCtrl() {
		return GroupeController.BASE_PATH_CTRL;
	}
}
