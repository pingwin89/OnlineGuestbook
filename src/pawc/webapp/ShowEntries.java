package pawc.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/ShowEntries")
public class ShowEntries extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PrintWriter out = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEntries() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        this.out=out;
        try{
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Guestbook</title>");
            out.println("</head>");
            out.println("<body bgcolor=\"#8AE68A\">");
            out.println("<h1><p align=center>Guestbook entries</p>");
            out.println("</body>");
            out.println("</html>");
            List<EntryModel> list = Persistence.getAllEntries();
            String content = "";
            for(EntryModel entry : list){
                content+=printRow(entry.getAuthor(), entry.getMessage());
            }
            out.println("<p><a href=\"index.jsp\">back</a></p>");
            out.println(table(content));
        }
        finally{
            out.close();
        }
        
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
