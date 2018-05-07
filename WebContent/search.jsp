<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <script src="js/jquery.autocomplete.js"></script>  
    <style>
        input {
            font-size: 120%;
        }
    </style>
</head>
<BODY>
        <H1>Database Lookup</H1>
        <FORM ACTION="result.jsp" METHOD="POST">
            Please enter the title of the Movie:
            <BR>
            <input type="text" id="title" name="title"/>
     
    <script>
        $("#title").autocomplete("getdata.jsp");
    </script>
    <BR>
    <INPUT TYPE="SUBMIT" value="Search">
        </FORM>
    </BODY>
</html>