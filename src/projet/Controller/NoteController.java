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
public final class NoteController extends BaseController {
	private static final String BASE_PATH_CTRL = "/Note";
	
	private NoteDAO noteDAO;
	private StudentDAO studentDAO;
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + NoteController.BASE_PATH_CTRL;
	}
	
	@Override
	protected String getBasePathCtrl() {
		return NoteController.BASE_PATH_CTRL;
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
		
		if ( methodIsGET() && actionMatch( "/details" ) )
			detailsNoteAction( req, resp );
		
		else if ( actionMatch( "/new" ) )
			newNoteAction( req, resp );
		
		else if ( actionMatch( "/edit" ) )
			editNoteAction( req, resp );
		
		else if ( methodIsGET() && actionMatch( "/delete" ) )
			deleteNoteAction( req, resp );
		
		else
			redirectToPath( StudentController.getBasePath( true ), req, resp );
	}
	
	
	// -------------------------------------------------------------------------------------------------------- Details Note
	private void detailsNoteAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Note note = noteDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "note" ) ) );
		req.setAttribute( "note", note );
		
		loadJSP( getServletParam( "pathDetails" ), req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- New Note
	private void newNoteAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		if ( methodIsGET() ) {
			loadJSP( getServletParam( "pathNew" ), req, resp );
			
		} else {
			Student student = studentDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "etu" ) ) );
			
			Note note = new Note();
			note.setName( req.getParameter( "name" ) );
			note.setCoef( Integer.valueOf( req.getParameter( "coef" ) ) );
			note.setGraddingScale( Integer.valueOf( req.getParameter( "gradingScale" ) ) );
			note.setValue( Float.valueOf( req.getParameter( "value" ) ) );
			note.setStudent( student );
			
			noteDAO.addEntity( note );
			
			redirectToPath( StudentController.getBasePath( true ), req, resp );
		}
	}
	
	// -------------------------------------------------------------------------------------------------------- Edit Note
	private void editNoteAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Note note = noteDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "note" ) ) );
		
		if ( methodIsGET() ) {
			Collection< Student > students = studentDAO.findAll();
			req.setAttribute( "students", students );
			req.setAttribute( "note", note );
			
			loadJSP( getServletParam( "pathEdit" ), req, resp );
			
		} else {
			note.setName( req.getParameter( "name" ) );
			note.setCoef( Integer.valueOf( req.getParameter( "coef" ) ) );
			note.setGraddingScale( Integer.valueOf( req.getParameter( "gradingScale" ) ) );
			note.setValue( Float.valueOf( req.getParameter( "value" ) ) );
			
			noteDAO.updateEntity( note );
			
			redirectToPath( NoteController.getBasePath( true ), req, resp );
		}
	}
	
	// -------------------------------------------------------------------------------------------------------- Delete Note
	private void deleteNoteAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Note note = noteDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "note" ) ) );
		noteDAO.removeEntity( note );
		
		redirectToPath( NoteController.getBasePath( true ), req, resp );
	}
}
