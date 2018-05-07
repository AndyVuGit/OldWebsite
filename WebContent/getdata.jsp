<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="net.viralpatel.autocomplete.MovieList"%>
<%
    MovieList movielist = new MovieList();
 
    String query = request.getParameter("q");
     
    List<String> movies = movielist.getData(query);
 
    Iterator<String> iterator = movies.iterator();
    while(iterator.hasNext()) {
        String movie = (String)iterator.next();
        out.println(movie);
    }
%>