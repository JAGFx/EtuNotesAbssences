package projet.Controller;

import projet.Component.BaseController;
import projet.Entity.DAO.GroupDAO;
import projet.Entity.DAO.StudentDAO;
import projet.Entity.Group;
import projet.Entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by SMITHE on 13-Dec-16.
 */

public final class StudentController extends BaseController {
	public static final String BASE_PATH_CTRL = "/Student";
	
	private StudentDAO studentDAO;
	private GroupDAO groupDAO;
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + StudentController.BASE_PATH_CTRL;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		studentDAO = new StudentDAO();
		groupDAO = new GroupDAO();
		System.out.println( "-------------------- IN Student Controller" );
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		initController( req );
		
		if ( methodIsGET() && actionMatch( "/details" ) )
			detailsStudentAction( req, resp );
		
		else if ( methodIsGET() && actionMatch( "/notes" ) )
			listNotesStudentAction( req, resp );
		
		else if ( actionMatch( "/new" ) )
			newStudentAction( req, resp );
		
		else if ( actionMatch( "/edit" ) )
			updateStudentAction( req, resp );
		
		else if ( methodIsGET() && actionMatch( "/delete" ) )
			deleteStudentAction( req, resp );
		
		else
			listStudentAction( req, resp );
	}
	
	
	// -------------------------------------------------------------------------------------------------------- New Student
	private void newStudentAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		if ( methodIsGET() ) {
			Collection< Group > groups = groupDAO.findAll();
			req.setAttribute( "groups", groups );
			
			// Path
			loadJSP( getServletParam( "pathNewStudent" ), req, resp );
			
		} else {
			// TODO TRY CATCH
			Group group = groupDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "group" ) ) );
			
			Student student = new Student( null, req.getParameter( "firstname" ), req.getParameter( "lastname" ) );
			student.setGroup( group );
			//group.addStudent( student );
			
			//groupDAO.updateEntity( group );
			studentDAO.addEntity( student );
			
			req
				.getRequestDispatcher( StudentController.getBasePath( true ) )
				.forward( req, resp );
		}
	}
	
	// -------------------------------------------------------------------------------------------------------- Update Student
	private void updateStudentAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		System.out.println( Integer.valueOf( req.getParameter( "etu" ) ) );
		
		if ( methodIsGET() ) {
			System.out.println( Integer.valueOf( req.getParameter( "etu" ) ) );
			
			HashSet< Group > groups = groupDAO.findAll();
			req.setAttribute( "groups", groups );
			
			Student etu = studentDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "etu" ) ) );
			req.setAttribute( "etu", etu );
			
			// Path
			loadJSP( getServletParam( "pathUpdateStudent" ), req, resp );
			
		} else {
			// TODO TRY CATCH
			Group group = groupDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "group" ) ) );
			
			Student student = studentDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "etu" ) ) );
			student.setGroup( group );
			student.setFirstname( req.getParameter( "firstname" ) );
			student.setLastname( req.getParameter( "lastname" ) );
			
			//group.addStudent( student );
			//groupDAO.updateEntity( group );
			
			studentDAO.updateEntity( student );
			
			req
				.getRequestDispatcher( StudentController.getBasePath( true ) )
				.forward( req, resp );
		}
	}
	
	// -------------------------------------------------------------------------------------------------------- Delete Student
	private void deleteStudentAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Student student = studentDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "etu" ) ) );
		studentDAO.removeEntity( student );
		
		req
			.getRequestDispatcher( StudentController.getBasePath( true ) )
			.forward( req, resp );
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
		Student etu = studentDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "etu" ) ) );
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
