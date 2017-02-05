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
	/**
	 * String Chemin ce trouvant après la base url projet
	 */
	public static final String BASE_PATH_CTRL = "";
	
	/**
	 * Chemin garantissant la passage par le contrôleur frontal
	 */
	public static final String BASE_PATH_PROJECT = "/do";
	
	private String action, method;
	
	
	// -------------------------------------------------------------------------- Initialisation
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + BASE_PATH_CTRL;
	}
	
	/**
	 * Executé à la destruction du Contrôleur
	 */
	@Override
	public void destroy() {
		GestionFactory.close();
		super.destroy();
	}
	
	/**
	 * Executé à la création du Contrôleur
	 *
	 * @throws ServletException
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		GestionFactory.open();
	}
	
	
	// -------------------------------------------------------------------------- Traitements
	
	/**
	 * Initialise les paramêtre du contrôleur pour chaque nouvelles requête
	 *
	 * @param req Requête reçus par le contrôleur
	 */
	protected void initController( HttpServletRequest req ) {
		// Get current path
		String pathInfo = req.getPathInfo();
		if ( pathInfo != null )
			pathInfo = pathInfo.substring( getBasePathCtrl().length() );
		
		System.out.println( "PathInfo: " + pathInfo );
		
		// Set action
		setAction( ( pathInfo != null )
			? pathInfo
			: getServletParam( "defaultPath" ) );
		
		// Set method
		setMethod( req.getMethod().toLowerCase() );
		
		System.out.println( "Action: " + action );
		System.out.println( "Method: " + method );
	}
	
	/**
	 * Executé lor d'une requête avec une méthode HTTP GET
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		super.doGet( req, resp );
	}
	
	/**
	 * Executé lor d'une requête avec une méthode HTTP POST
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		doGet( req, resp );
	}
	
	/**
	 * Charge la JSP indiquée en paramètre
	 *
	 * @param request Requête reçus par le Servlet
	 * @param response Réponse à envoyé
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void loadJSP( String url, HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher( url );
		rd.forward( request, response );
	}
	
	
	// -------------------------------------------------------------------------- Actions récurentes
	
	/**
	 * Redirige vers un chemin
	 *
	 * @param path Chemin de redirection
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void redirectToPath( String path, HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		loadJSP( path, req, resp );
	}
	
	/**
	 * Défini si la méthode HTTP d'une requête est de type GET
	 *
	 * @return True si vrai, False sinon
	 */
	protected boolean methodIsGET() {
		return getMethod().equals( "get" );
	}
	
	/**
	 * Défini si la méthode HTTP d'une requête est de type POST
	 *
	 * @return True si vrai, False sinon
	 */
	protected boolean methodIsPOST() {
		return getMethod().equals( "post" );
	}
	
	/**
	 * Détermine si l'action passé correspond à l'une des action du contrôleur
	 *
	 * @param path Action à verifier
	 * @return True si équivalente, False sinon
	 */
	protected boolean actionMatch( String path ) {
		return getAction().equals( path );
	}
	
	
	// -------------------------------------------------------------------------- Getter / Setter
	
	/**
	 * Retourne la valeur d'un paramètre d'un contrôleur
	 *
	 * @param name Nom du paramètre
	 * @return Valeur du paramètre
	 */
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
	
	protected String getBasePathProject() {
		return BASE_PATH_PROJECT;
	}
}
