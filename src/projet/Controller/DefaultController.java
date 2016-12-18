package projet.Controller;

import projet.Components.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SMITHE on 13-Dec-16.
 */
public final class DefaultController extends Controller {
	public static final String BASE_PATH_CTRL = "/Default";
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + StudentController.BASE_PATH_CTRL;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println( "-------------------- IN Default Controller" );
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		initController( req );
		
		/*if ( getMethod().equals( "get" ) && getAction().equals( "/details" ) )
		
		else*/
		loadJSP( getServletParam( "pathIndex" ), req, resp );
	}
	
	@Override
	protected String getBasePathCtrl() {
		return DefaultController.BASE_PATH_CTRL;
	}
}
