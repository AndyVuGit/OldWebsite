<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SO question 2370960</title>
    </head>
    <body>
         <H1>${title}</H1>
         <p>ID: ${iden}</p>
         <p>Director: ${director}</p>
         <p>Year: ${year}</p>
         <p>Stars: ${stars}</p>
         <form action="addItem" method="post">
         <input type="hidden" name="movieName" value="${title}">
         <input type="hidden" name="movieID" value="${iden}"><br>
          <input type="hidden" name="orderQuantity" value="1"><br>
          
         
		<input type="submit" value="Add to Cart">
		<p><a href="mainpage.html">Back To Main Page</a></p>
</form>
    </body>
</html>