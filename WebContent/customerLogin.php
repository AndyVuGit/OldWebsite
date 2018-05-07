<?php
$host="localhost";
$port=3306;
$socket="";
$user="root";
$password="root1";
$dbname="moviedb";

$con = new mysqli($host, $user, $password, $dbname, $port, $socket)

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$email = $_POST['email'];
$password = $_POST['password'];
$result = mysqli_query($con,"SELECT * FROM customers where 
email='$email' and password='$password'");
$row = mysqli_fetch_array($result);
$data = $row[0];

if($data){
echo $data;
}
mysqli_close($con);
?>