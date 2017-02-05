package projet.Controller;

import projet.Component.BaseController;
import projet.Entity.Absence;
import projet.Entity.DAO.AbsencesDAO;
import projet.Entity.DAO.StudentDAO;
import projet.Entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

/**
 * Created by emsm on 05/02/2017.
 */
public class AbsenceController extends BaseController {
	private static final String BASE_PATH_CTRL = "/Absence";
	
	private AbsencesDAO absencesDAO;
	private StudentDAO studentDAO;
	
	public static String getBasePath( boolean fullPath ) {
		return ( ( fullPath ) ? BASE_PATH_PROJECT : "" ) + AbsenceController.BASE_PATH_CTRL;
	}
	
	@Override
	protected String getBasePathCtrl() {
		return AbsenceController.BASE_PATH_CTRL;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		absencesDAO = new AbsencesDAO();
		studentDAO = new StudentDAO();
		System.out.println( "-------------------- IN Absence Controller" );
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		initController( req );
		
		if ( actionMatch( "/new" ) )
			newAbsenceAction( req, resp );
		
		else if ( actionMatch( "/edit" ) )
			editAbsenceAction( req, resp );
		
		else if ( methodIsGET() && actionMatch( "/delete" ) )
			deleteAbsenceAction( req, resp );
		
		else
			listAbsenceAction( req, resp );
	}
	
	
	// -------------------------------------------------------------------------------------------------------- New Absence
	private void newAbsenceAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Student student = studentDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "etu" ) ) );
		
		if ( methodIsGET() ) {
			loadJSP( getServletParam( "pathNew" ), req, resp );
			
		} else {
			Absence absence = new Absence();
			
			absence.setFromDate( req.getParameter( "fromDate" ) );
			absence.setToDate( req.getParameter( "toDate" ) );
			absence.setStudent( student );
			
			absencesDAO.addEntity( absence );
			
			redirectToPath( AbsenceController.getBasePath( true ), req, resp );
		}
	}
	
	// -------------------------------------------------------------------------------------------------------- Edit Absence
	private void editAbsenceAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Absence absence = absencesDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "abs" ) ) );
		
		if ( methodIsGET() ) {
			Collection< Student > students = studentDAO.findAll();
			req.setAttribute( "students", students );
			req.setAttribute( "absence", absence );
			
			loadJSP( getServletParam( "pathEdit" ), req, resp );
			
		} else {
			absence.setFromDate( req.getParameter( "fromDate" ) );
			absence.setToDate( req.getParameter( "toDate" ) );
			
			absencesDAO.updateEntity( absence );
			
			redirectToPath( AbsenceController.getBasePath( true ), req, resp );
		}
	}
	
	// -------------------------------------------------------------------------------------------------------- Delete Absence
	private void deleteAbsenceAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Absence absence = absencesDAO.findByPrimaryKey( Integer.valueOf( req.getParameter( "abs" ) ) );
		absencesDAO.removeEntity( absence );
		
		redirectToPath( AbsenceController.getBasePath( true ), req, resp );
	}
	
	// -------------------------------------------------------------------------------------------------------- List Absence
	private void listAbsenceAction( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		Collection< Absence > absences = absencesDAO.findAll();
		req.setAttribute( "absences", absences );
		
		// Path
		loadJSP( getServletParam( "pathList" ), req, resp );
	}
}
