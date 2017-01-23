package projet.Filter;

import projet.Component.BaseController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by emsm on 18/12/2016.
 */
public class ControllerAccess implements Filter {
	public void destroy() {
	}
	
	public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
		HttpServletRequest request = ( HttpServletRequest ) req;
		HttpServletResponse response = ( HttpServletResponse ) resp;
		
		System.out.println( "-------------------- BEGIN ControllerAccess FILTER" );
		System.out.println( "RequestURI: " + request.getRequestURI() );
		
		Pattern regex = Pattern.compile( "\\.(ico|png|jpg|jpeg|css|js)$" );
		Matcher matcher = regex.matcher( request.getRequestURI() );
		
		if ( matcher.find() ) {
			System.out.println( "Resources access" );
			System.out.println( "-------------------- END FILTER" );
			chain.doFilter( req, resp );
			
		} else {
			
			Boolean callFromFrontalCtrl = request.getRequestURI().startsWith( BaseController.BASE_PATH_PROJECT );
			System.out.println( "Access from Frontal Controller: " + callFromFrontalCtrl );
			
			if ( !callFromFrontalCtrl ) {
				System.out.println( "Forbidden access Servlet" );
				System.out.println( "-------------------- END FILTER" );
				response.sendRedirect( BaseController.BASE_PATH_PROJECT );
				
			} else {
				System.out.println( "-------------------- END FILTER" );
				chain.doFilter( req, resp );
			}
		}
	}
	
	public void init( FilterConfig config ) throws ServletException {
		
	}
	
}
