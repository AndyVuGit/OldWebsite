<?php  
 require "init.php";  
 $name = "user";  
 $user_name = "user_name";  
 $user_pass = "user_pass";  
 $sql_query = "insert into user_info values('$name','$user_name','$user_pass');";  

if(mysqli_query($con,$sql_query))
{
	echo "<h3>Data Insertion Success...</h3>";
}
else
{
	echo "Data insertion error...".mysqli_error($con);
}
 ?>  