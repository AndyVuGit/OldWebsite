<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.servlet.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<HTML>
    <HEAD>
        <TITLE>Browsing Movies</TITLE>
    </HEAD>

    <BODY>
        <H1>Browsing Movies </H1>
        <FORM NAME="form1" ACTION="movielist.jsp" METHOD="POST">

        <% 
            int current = 1;
            if(request.getParameter("hidden") != null) {
                current = Integer.parseInt(request.getParameter("hidden"));
            }
            int currentX = 10;
            if(request.getParameter("X") != null) {
                currentX = Integer.parseInt(request.getParameter("X"));
            }
            Context ctx = null;
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
            Connection connection = ds.getConnection();

            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

            ResultSet resultset =
                statement.executeQuery("select * from movies") ; 

            if(!resultset.next()) {
                out.println("Sorry, could not find that movie. ");
            }
            else{
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
                    <TH>Title</TH>
                    <TH>Year</TH>
                    <TH>Director</TH>
                    <TH>BannerURL</TH>
                    <TH>TrailerURL</TH>
                </TR>
<%
int i=0;
while(resultset.next() && i<currentX) {
  i++;
  String s = resultset.getString(1);
  String id2 = "SingleMovieServlet?id=" + s;
  //String id = "SingleMovieServlet?id=" + resultset.getString(2);
%>
                <TR>
               
                    <TD> <%= resultset.getString(1) %> </TD>
                    <TD><style type="text/css">
      body {
        margin: 0;
        padding: 0;
        font-family: Arial, Helvetica, sans-serif;
      }
      
      h1, h3 {
        margin: 0;
        padding: 0;
        font-weight: normal;
      }
      
      a {
        color: #EB067B;
      }
      
      div#container {
        width: 580px;
        margin: 100px auto 0 auto;
        padding: 20px;
        border: 1px solid #1a1a1a;
      }
      
      /* HOVER STYLES */
      div#pop-up {
        display: none;
        position: absolute;
        width: 280px;
        padding: 10px;
        background: #eeeeee;
        color: #000000;
        border: 1px solid #1a1a1a;
        font-size: 90%;
      }
    </style>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
    <script type="text/javascript">
      $(function() {
        var moveLeft = 20;
        var moveDown = 10;
        
        $('a#trigger').hover(function(e) {
          $('div#pop-up').show();
          //.css('top', e.pageY + moveDown)
          //.css('left', e.pageX + moveLeft)
          //.appendTo('body');
        }, function() {
          $('div#pop-up').hide();
        });
        
        $('a#trigger').mousemove(function(e) {
          $("div#pop-up").css('top', e.pageY + moveDown).css('left', e.pageX + moveLeft);
        });
        
      });
    </script>
  </head>
  <body>
    <div id="container">
      <p>
        <a href=<%=id2%> id = "trigger"><%= resultset.getString(2) %></a>.
      </p>
      
      <!-- HIDDEN / POP-UP DIV -->
      <div id="pop-up">
        <h3>Pop-up Successfully Displayed</h3>
        <p>
          This is where stuff would go
        </p>
      </div>
      
    </div>
  </body>
</html></TD>
                    <TD> <%= resultset.getString(3) %> </TD>
                    <TD> <%= resultset.getString(4) %> </TD>
                    <TD> <%= resultset.getString(5) %> </TD>
                    <TD> <%= resultset.getString(6) %> </TD>
                </TR>
<%
}
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