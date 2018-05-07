<?php  
 require "init.php";  
 $user_name = $_POST["login_name"];  
 $user_pass =  $_POST["login_pass"];  
 $sql_query = "select * from customers where email like '$user_name' and password like '$user_pass';";  
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) >0 )  
 {  
 echo "Login Success..Welcome ";  
 }  
 else  
 {   
 echo "Login Failed.......Try Again..";  
 }  
 ?>  