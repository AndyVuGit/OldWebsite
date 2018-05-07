<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<HTML>
    <HEAD>
        <TITLE>Browsing Stars</TITLE>
    </HEAD>

    <BODY>
        <H1>Browsing Stars </H1>
        <FORM NAME="form1" ACTION="starlist.jsp" METHOD="POST">

        <% 
            int current = 1;
            if(request.getParameter("hidden") != null) {
                current = Integer.parseInt(request.getParameter("hidden"));
            }
            int currentX = 10;
            if(request.getParameter("X") != null) {
                currentX = Integer.parseInt(request.getParameter("X"));
            }
            Connection connection = DriverManager.getConnection(
            		"jdbc:mysql:///moviedb", "root", "password");

            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

            ResultSet resultset = 
                statement.executeQuery("select * from stars"); 

            if(current < 1){
                current = 1;
            }

            resultset.last();
            int rows = resultset.getRow();
            if(current <= rows){
                resultset.absolute(current);
            }    
        %>

            <TABLE BORDER="1">
                <TR>
                    <TH>ID</TH>
                    <TH>Name</TH>
                    <TH>DOB</TH>
                    <TH>Photo</TH>
                </TR>
<%
int i=0;
while(resultset.next() && i<currentX) {
  i++;
  String s = resultset.getString(1);
  String name = resultset.getString(2)+ " " +resultset.getString(3);
  String id = "SingleStarServlet?id=" + s;
  //String id = "SingleMovieServlet?id=" + resultset.getString(2);
%>
                <TR>
               
                    <TD> <%= resultset.getString(1) %> </TD>
                    <TD> <a href=<%=id%>><%= name%> </a></TD>
                    <TD> <%= resultset.getString(4) %> </TD>
                    <TD> <%= resultset.getString(5) %> </TD>
                </TR>
<%
}
%>
            </TABLE>
            <BR>
            <INPUT TYPE="HIDDEN" NAME="hidden" VALUE="<%= current %>">
             <INPUT TYPE="TEXT" NAME="X" VALUE="<%=currentX%>">
            <INPUT TYPE="BUTTON" VALUE="Next Record" ONCLICK="moveNext()">
            <INPUT TYPE="BUTTON" VALUE="Previous Record" ONCLICK="movePrevious()">
        </FORM>

        <SCRIPT>
            <!--
            function moveNext()
            {
                var counter = 0
                counter = parseInt(document.form1.hidden.value) + parseInt(document.form1.X.value)
                document.form1.hidden.value = counter
                form1.submit()
            }    
            function movePrevious()
            {
                var counter = 0
                counter = parseInt(document.form1.hidden.value) - parseInt(document.form1.X.value)
                document.form1.hidden.value = counter
                form1.submit()
            }    
            // --> 
        </SCRIPT>
    </BODY>
</HTML>