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
		
		else if ( actionMatch( "/new" ) )
			newGroupAction( req, resp );
		
		else if ( actionMatch( "/edit" ) )
			updateGroupAction( req, resp );
		
		else if ( methodIsGET() && actionMatch( "/delete" ) )
			deleteGroupAction( req, resp );
		
		else
			listGroupAction( req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- New Group
	private void newGroupAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		if ( methodIsGET() ) {
			
			// Path
			loadJSP( getServletParam( "pathNew" ), req, resp );
			
		} else {
			// TODO TRY CATCH
			Group group = new Group( null, req.getParameter( "name" ) );
			groupDAO.addEntity( group );
			
			redirectToPath( GroupController.getBasePath( true ), req, resp );
		}
	}
	
	// -------------------------------------------------------------------------------------------------------- Update Group
	private void updateGroupAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Group group = groupDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "grp" ) ) );
		
		if ( methodIsGET() ) {
			req.setAttribute( "grp", group );
			
			// Path
			loadJSP( getServletParam( "pathUpdate" ), req, resp );
			
		} else {
			// TODO TRY CATCH
			group.setName( req.getParameter( "name" ) );
			groupDAO.updateEntity( group );
			
			redirectToPath( GroupController.getBasePath( true ), req, resp );
		}
	}
	
	// -------------------------------------------------------------------------------------------------------- Delete Group
	private void deleteGroupAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Group group = groupDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "grp" ) ) );
		groupDAO.removeEntity( group );
		
		redirectToPath( GroupController.getBasePath( true ), req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- List Group
	private void listGroupAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Collection< Group > listGroup = groupDAO.findAll();
		req.setAttribute( "listGroup", listGroup );
		
		loadJSP( getServletParam( "pathList" ), req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Details Group
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
