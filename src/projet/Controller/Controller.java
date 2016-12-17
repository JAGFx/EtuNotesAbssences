package projet.Controller;

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
public class Controller extends HttpServlet {
	protected static final String BASE_PATH_CTRL = "";
	protected static final String BASE_PATH_PROJECT = "";
	private String action, method, pathJSP;
	
	protected static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + BASE_PATH_CTRL;
	}
	
	protected void initController( HttpServletRequest req ) {
		setAction( ( req.getPathInfo() != null )
			? req.getPathInfo()
			: getServletConfig().getInitParameter( "defaultPath" ) );
		
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
	protected void loadJSP( HttpServletRequest request, HttpServletResponse response )
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
		RequestDispatcher rd = sc.getRequestDispatcher( getPathJSP() );
		rd.forward( request, response );
	}
	
	protected String getAction() {
		return action;
	}
	
	protected void setAction( String action ) {
		this.action = action;
	}
	
	protected String getMethod() {
		return method;
	}
	
	protected void setMethod( String method ) {
		this.method = method;
	}
	
	protected String getPathJSP() {
		return pathJSP;
	}
	
	/**
	 * @param pathJSP Nom du parametre de Servlet pour un JSP
	 */
	protected void setPathJSP( String pathJSP ) {
		this.pathJSP = getServletConfig().getInitParameter( pathJSP );
	}
}
