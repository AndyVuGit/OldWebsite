<?php
require "init.php";
header('Content-Type: application/json');
 
$sql = "select title from movies";
 
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,
array('title'=>$row[0]
));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>

