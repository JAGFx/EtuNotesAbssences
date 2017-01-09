package projet.Controller;

import projet.Component.BaseController;
import projet.Entity.DAO.StudentDAO;
import projet.Entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by SMITHE on 13-Dec-16.
 */

public final class StudentController extends BaseController {
	public static final String BASE_PATH_CTRL = "/Student";
	
	private StudentDAO studentDAO;
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + StudentController.BASE_PATH_CTRL;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		studentDAO = new StudentDAO();
		System.out.println( "-------------------- IN Student Controller" );
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		initController( req );
		
		if ( getMethod().equals( "get" ) && getAction().equals( "/details" ) )
			detailsStudentAction( req, resp );
		
		else if ( getMethod().equals( "get" ) && getAction().equals( "/notes" ) )
			listNotesStudentAction( req, resp );
		
		else
			listStudentAction( req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Liste Student
	private void listStudentAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Collection< Student > etusList = studentDAO.findAll();
		req.setAttribute( "etusList", etusList );
		
		// Path
		loadJSP( getServletParam( "pathList" ), req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Details Student
	private void detailsStudentAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		// Set Etu past in params
		Student etu = studentDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "etu" ) ) ); //GestionFactory.getEtudiantById( Integer.valueOf( req.getParameter( "etu" ) ) );
		req.setAttribute( "etu", etu );
		
		// NbAvsence
		// TODO NB Absence
		int nbAbsences = 0;
		req.setAttribute( "nbAbsences", nbAbsences );
		
		// Path
		loadJSP( getServletParam( "pathDetails" ), req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Liste notes Student
	private void listNotesStudentAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		// Set Etu past in params
		Student etu = studentDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "etu" ) ) );
		req.setAttribute( "etu", etu );
		
		// Path
		loadJSP( getServletParam( "pathListNotes" ), req, resp );
	}
	
	@Override
	protected String getBasePathCtrl() {
		return StudentController.BASE_PATH_CTRL;
	}
}
