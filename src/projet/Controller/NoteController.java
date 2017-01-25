package projet.Controller;

import projet.Component.BaseController;
import projet.Entity.DAO.NoteDAO;
import projet.Entity.DAO.StudentDAO;
import projet.Entity.Note;
import projet.Entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by SMITHE on 24-Jan-17.
 */
public class NoteController extends BaseController {
	public static final String BASE_PATH_CTRL = "/Note";
	
	private NoteDAO noteDAO;
	private StudentDAO studentDAO;
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + NoteController.BASE_PATH_CTRL;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		noteDAO = new NoteDAO();
		studentDAO = new StudentDAO();
		System.out.println( "-------------------- IN Note Controller" );
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		initController( req );
		
		if ( getMethod().equals( "get" ) && getAction().equals( "/details" ) )
			detailsNoteAction( req, resp );
		
		else if ( getMethod().equals( "get" ) && getAction().equals( "/new" ) )
			newNoteAction( req, resp );
		
		else if ( getMethod().equals( "get" ) && getAction().equals( "/edit" ) )
			editNoteAction( req, resp );
		
		else if ( getMethod().equals( "get" ) && getAction().equals( "/delete" ) )
			deleteNoteAction( req, resp );
		
		else
			req
				.getRequestDispatcher( StudentController.getBasePath( true ) )
				.forward( req, resp );
	}
	
	
	// -------------------------------------------------------------------------------------------------------- Details Note
	private void detailsNoteAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Note note = noteDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "note" ) ) );
		req.setAttribute( "note", note );
		
		loadJSP( getServletParam( "pathDetails" ), req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- New Note
	private void newNoteAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Student student = studentDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "student" ) ) );
		
		Collection<Student> students = studentDAO.findAll();
		req.setAttribute( "students", students );
		
		Note note = new Note();
		note.setCoef( Integer.valueOf( req.getParameter( "note" ) ) );
		note.setGraddingScale( Integer.valueOf( req.getParameter( "gradingScale" ) ) );
		note.setValue( Float.valueOf( req.getParameter( "value" ) ) );
		note.setStudent( student );
		
		noteDAO.addEntity( note );
		
		req
			.getRequestDispatcher( NoteController.getBasePath( true ) )
			.forward( req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Edit Note
	private void editNoteAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Note note = noteDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "note" ) ) );
		
		note.setCoef( Integer.valueOf( req.getParameter( "note" ) ) );
		note.setGraddingScale( Integer.valueOf( req.getParameter( "gradingScale" ) ) );
		note.setValue( Float.valueOf( req.getParameter( "value" ) ) );
		
		noteDAO.updateEntity( note );
		
		req
			.getRequestDispatcher( NoteController.getBasePath( true ) )
			.forward( req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- Delete Note
	private void deleteNoteAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Note note = noteDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "note" ) ) );
		noteDAO.removeEntity( note );
		
		req
			.getRequestDispatcher( NoteController.getBasePath( true ) )
			.forward( req, resp );
	}
	
	@Override
	protected String getBasePathCtrl() {
		return StudentController.BASE_PATH_CTRL;
	}
}
