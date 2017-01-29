package projet.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SMITHE on 13-Dec-16.
 */
public class BaseController extends HttpServlet {
	public static final String BASE_PATH_CTRL = "";
	public static final String BASE_PATH_PROJECT = "/do";
	
	private String action, method;
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + BASE_PATH_CTRL;
	}
	
	@Override
	public void destroy() {
		GestionFactory.close();
		super.destroy();
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		GestionFactory.open();
	}
	
	protected void initController( HttpServletRequest req ) {
		String pathInfo = req.getPathInfo();
		if ( pathInfo != null )
			pathInfo = pathInfo.substring( getBasePathCtrl().length() );
		
		System.out.println( "PathInfo: " + pathInfo );
		
		setAction( ( pathInfo != null )
			? pathInfo
			: getServletParam( "defaultPath" ) );
		
		setMethod( req.getMethod().toLowerCase() );
		
		System.out.println( "Action: " + action );
		System.out.println( "Method: " + method );
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		super.doGet( req, resp );
	}
	
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		doGet( req, resp );
	}
	
	/**
	 * Charge la JSP indiquée en paramètre
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void loadJSP( String url, HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException {
		
		// L'interface RequestDispatcher permet de transférer le contrôle à une
		// autre servlet
		// Deux méthodes possibles :
		// - forward() : donne le contrôle à une autre servlet. Annule le flux
		// de sortie de la servlet courante
		// - include() : inclus dynamiquement une autre servlet
		// + le contrôle est donné à une autre servlet puis revient à la servlet
		// courante (sorte d'appel de fonction).
		// + Le flux de sortie n'est pas supprimé et les deux se cumulent
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher( url );
		rd.forward( request, response );
	}
	
	protected void redirectToPath( String path, HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		loadJSP( path, req, resp );
	}
	
	protected String getServletParam( String name ) {
		return getServletConfig().getInitParameter( name );
	}
	
	protected String getAction() {
		return ( action == null ) ? "" : action;
	}
	
	protected void setAction( String action ) {
		this.action = action;
	}
	
	protected String getMethod() {
		return ( method == null ) ? "" : method;
	}
	
	protected void setMethod( String method ) {
		this.method = method;
	}
	
	protected String getBasePathCtrl() {
		return BASE_PATH_CTRL;
	}
	
	protected boolean methodIsGET() {
		return getMethod().equals( "get" );
	}
	
	protected boolean methodIsPOST() {
		return getMethod().equals( "post" );
	}
	
	protected boolean actionMatch( String path ) {
		return getAction().equals( path );
	}
	
	protected String getBasePathProject() {
		return BASE_PATH_PROJECT;
	}
}
