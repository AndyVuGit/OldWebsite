<?php
require_once("dbcontroller.php");
$db_handle = new DBController();
if(!empty($_POST["keyword"])) {
$query ="SELECT * FROM movies WHERE title like '%" . $_POST["keyword"] . "%' ORDER BY title LIMIT 0,6";
$result = $db_handle->runQuery($query);
if(!empty($result)) {
?>
<ul id="country-list">
<?php
foreach($result as $country) {
?>
<li onClick="selectCountry('<?php echo $country["title"]; ?>');"><?php echo $country["title"]; ?></li>
<?php } ?>
</ul>
<?php } } ?>