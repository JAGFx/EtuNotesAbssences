package projet.Controller;

import projet.Component.BaseController;
import projet.Entity.DAO.GroupDAO;
import projet.Entity.Group;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by SMITHE on 13-Dec-16.
 */
public final class GroupController extends BaseController {
	private static final String BASE_PATH_CTRL = "/Group";
	
	private GroupDAO groupDAO;
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + GroupController.BASE_PATH_CTRL;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		groupDAO = new GroupDAO();
		System.out.println( "-------------------- IN Group Controller" );
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		initController( req );
		
		if ( methodIsGET() && actionMatch( "/details" ) )
			detailsGroupAction( req, resp );
		else
			listGroupAction( req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Liste groupe
	private void listGroupAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Collection< Group > listGroup =  groupDAO.findAll();
		req.setAttribute( "listGroup", listGroup );
		
		loadJSP( getServletParam( "pathList" ), req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Détails groupe
	private void detailsGroupAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Group groupA = groupDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "grp" ) ) );
		
		req.setAttribute( "group", groupA );
		loadJSP( getServletParam( "pathDetails" ), req, resp );
	}
	
	@Override
	protected String getBasePathCtrl() {
		return GroupController.BASE_PATH_CTRL;
	}
}
