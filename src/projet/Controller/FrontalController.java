package projet.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SMITHE on 16-Dec-16.
 */
public class FrontalController extends Controller {
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		initController( req );
		
		Pattern pattern = Pattern.compile( "^/(\\w+)/?.*" );
		Matcher matcher = pattern.matcher( getAction() );
		String subContontroller;
		
		if ( matcher.find() ) {
			subContontroller = matcher.group( 1 );
			System.out.println( "Found value: " + subContontroller );
			
			Controller ctrl = new EtudiantController();
			ctrl.doGet( req, resp );
			
		} else {
			System.out.println( "NO MATCH" );
		}
		
	}
}
