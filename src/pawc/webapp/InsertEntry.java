package pawc.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/InsertEntry")
public class InsertEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PrintWriter out = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEntry() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String message = request.getParameter("message");
                    
            Persistence.newEntry(login, message);
            response.sendRedirect("ShowEntries");
                   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	    //processRequest(request, response);
	}
	
	protected String printRow(String author, String message){
	    return "<tr><td>"+author+"</td><td>"+message+"</td></tr>";
	}
	
	protected String table(String content){
	    return "<table border=1 style=\"width:100%\">"+ content +"</table>";
	}

}
