package projet.Controller;

import projet.Component.BaseController;
import projet.Entity.Group;
import projet.Entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by SMITHE on 13-Dec-16.
 */
public final class GroupController extends BaseController {
	private static final String BASE_PATH_CTRL = "/Group";
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + GroupController.BASE_PATH_CTRL;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println( "-------------------- IN Group Controller" );
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		initController( req );
		
		if ( getMethod().equals( "get" ) && getAction().equals( "/details" ) )
			detailsGroupAction( req, resp );
		else
			listGroupAction( req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Liste groupe
	private void listGroupAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Collection< Group > listGroup = Arrays.asList(
			new Group( 0, "GroupeA" ),
			new Group( 1, "GroupeB" ),
			new Group( 2, "GroupeC" )
		);
		req.setAttribute( "listGroup", listGroup );
		
		loadJSP( getServletParam( "pathList" ), req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Détails groupe
	private void detailsGroupAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Collection< Student > listEtuA = Arrays.asList(
			new Student( 0, "Nom1", "Prenom1" ),
			new Student( 1, "Nom2", "Prenom2" ),
			new Student( 2, "Nom3", "Prenom3" )
		);
		
		Group groupA = new Group( 0, "GroupeA" );
		
		req.setAttribute( "group", groupA );
		loadJSP( getServletParam( "pathDetails" ), req, resp );
	}
	
	@Override
	protected String getBasePathCtrl() {
		return GroupController.BASE_PATH_CTRL;
	}
}
