

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SingleStarServlet
 */
@WebServlet("/SingleStarServlet")
public class SingleStarServlet extends HttpServlet {
	SingleStarDAO s = new SingleStarDAO();
	SingleMovieDAO temp = new SingleMovieDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleStarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<Integer, SingleStarPage> l = null;
		try {
			l = s.list();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<Integer, SingleMoviePage> t = null;
		try {
			t = temp.list();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		int in = Integer.parseInt(id);
		String first = l.get(in).getFirstName();
		String last = l.get(in).getLastName();
		String movies= "";
		String dob = l.get(in).getDob();
		String photo = l.get(in).getPhotoURL();
		
		for (int i = 0; i < l.get(in).getMoviekey().size();i++){
			if(l.get(in).getMoviekey().get(i) == l.get(in).getMoviekey().getLast()){
				movies += "<a href=SingleMovieServlet?id="+l.get(in).getMoviekey().get(i)+">"
						+t.get(l.get(in).getMoviekey().get(i)).getMovieName()+"</a>";
			}
			else{
				movies += "<a href=SingleMovieServlet?id="+l.get(in).getMoviekey().get(i)+">"
						+t.get(l.get(in).getMoviekey().get(i)).getMovieName()+"</a>";
								movies += ", ";
				
			}
				
			}
			



		
		
        request.setAttribute("First", first); // This will be available as ${message}
        request.setAttribute("Last", last);
        request.setAttribute("iden", id);
        request.setAttribute("movies", movies);
        request.setAttribute("dob", dob);
        request.setAttribute("photo", photo);
        request.getRequestDispatcher("singlestarpage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
