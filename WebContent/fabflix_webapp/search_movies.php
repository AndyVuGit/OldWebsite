<?php
require "init.php";
$sql = "select title from movies where title like '%star%'";
 
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

