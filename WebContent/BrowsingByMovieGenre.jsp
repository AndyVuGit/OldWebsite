<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<HTML>
    <HEAD>
        <TITLE>Browsing Movies</TITLE>
    </HEAD>

    <BODY>
        <H1>Navigating in a Database Table </H1>

        <% 
            Connection connection = DriverManager.getConnection(
            		"jdbc:mysql:///moviedb", "root", "password");

            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
            
            String id = request.getParameter("name");

            ResultSet resultset = 
                statement.executeQuery("select movies.* from movies, genres_in_movies, genres where genres.id = genres_in_movies.genre_id and genres_in_movies.movie_id = movies.id and name = '" + id + "'"); 
   
        %>

            <TABLE BORDER="1">
                <TR>
                    <TH>ID</TH>
                    <TH>Title</TH>
                    <TH>Year</TH>
                    <TH>Director</TH>
                    <TH>BannerURL</TH>
                    <TH>TrailerURL</TH>
                </TR>
<%
int i=0;
                while(resultset.next()) {
                	  i++;
                	  String s = resultset.getString(1);
                	  String id2 = "SingleMovieServlet?id=" + s;
                	  //String id = "SingleMovieServlet?id=" + resultset.getString(2);
                	%>
                	                <TR>
                	               
                	                    <TD> <%= resultset.getString(1) %> </TD>
                	                    <TD> <a href=<%=id2%>><%= resultset.getString(2) %></a></TD>
                	                    <TD> <%= resultset.getString(3) %> </TD>
                	                    <TD> <%= resultset.getString(4) %> </TD>
                	                    <TD> <%= resultset.getString(5) %> </TD>
                	                    <TD> <%= resultset.getString(6) %> </TD>
                	                </TR>
                	<%
                	}
%>
            </TABLE>
    </BODY>
</HTML>