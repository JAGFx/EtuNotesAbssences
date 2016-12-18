package projet.Controller;

import projet.Components.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SMITHE on 16-Dec-16.
 */
public final class FrontalController extends Controller {
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println( "-------------------- IN Frontal Controller" );
	}
	
	@Override
	protected void service( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		try {
			initController( req );
			
			Pattern pattern = Pattern.compile( "^/(\\w+)/?.*" );
			Matcher matcher = pattern.matcher( getAction() );
			String subController;
			
			if ( matcher.find() ) {
				subController = matcher.group( 1 );
				getServletConfig().getServletContext().getRequestDispatcher( "/" + subController ).include( req, resp );
				
			} else
				getServletConfig().getServletContext().getRequestDispatcher( getServletParam( "defaultController" ) ).include( req, resp );
			
			
		} catch ( Throwable t ) {
			System.out.println( t.getMessage() );
			throw new ServletException( t );
		}
	}
	
}
