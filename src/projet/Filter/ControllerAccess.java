package projet.Filter;

import projet.Components.Controller;
import projet.Controller.FrontalController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
		
		Boolean callFromFrontalCtrl = request.getRequestURI().startsWith( FrontalController.BASE_PATH_PROJECT );
		System.out.println( "Access from Frontal Controller: " + callFromFrontalCtrl );
		
		if ( !callFromFrontalCtrl ) {
			System.out.println( "Forbidden access Servlet" );
			System.out.println( "-------------------- END FILTER" );
			response.sendRedirect( Controller.BASE_PATH_PROJECT );
			
		} else {
			System.out.println( "-------------------- END FILTER" );
			chain.doFilter( req, resp );
		}
		
		
	}
	
	public void init( FilterConfig config ) throws ServletException {
		
	}
	
}
