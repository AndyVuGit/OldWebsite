

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;


@WebServlet("/SingleMovieServlet")
public class SingleMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SingleMovieDAO s = new SingleMovieDAO();
	SingleStarDAO temp = new SingleStarDAO();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleMovieServlet() {

        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<Integer, SingleMoviePage> l = null;
		try {
			l = s.list();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<Integer, SingleStarPage> t = null;
		try {
			t = temp.list();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String id = request.getParameter("id");
		int in = Integer.parseInt(id);
		String title = l.get(in).movieName;
		String director= l.get(in).getDirector();
		String year= l.get(in).getYear();
		String stars = "";
		for (int i = 0; i < l.get(in).getStarId().size();i++){
			if(l.get(in).getStarId().get(i) == l.get(in).getStarId().getLast()){
				stars += "<a href=SingleStarServlet?id="+l.get(in).getStarId().get(i)+">"
						+t.get(l.get(in).getStarId().get(i)).getFirstName()+" " + t.get(l.get(in).getStarId().get(i)).getLastName()+"</a>";
			}
			else{
				stars += "<a href=SingleStarServlet?id="+l.get(in).getStarId().get(i)+">"
						+t.get(l.get(in).getStarId().get(i)).getFirstName()+" " + t.get(l.get(in).getStarId().get(i)).getLastName()+"</a>";
								stars += ", ";
				
			}
				
			}
			
		
		
        request.setAttribute("title", title); // This will be available as ${message}
        request.setAttribute("iden", id);
        request.setAttribute("director", director);
        request.setAttribute("year", year);
        request.setAttribute("stars", stars);
        request.getRequestDispatcher("singlemoviepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		doGet(request, response);
	}

}
