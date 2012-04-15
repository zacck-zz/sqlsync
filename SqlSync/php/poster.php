<?php

	include 'connection.php';
	
	$row = $_REQUEST['id'];
	$name = $_REQUEST['f_name'];
	$sname = $_REQUEST['s_name'];
	$town = $_REQUEST['town'];
	$item  = $_REQUEST['item'];
	
	$ins = mysql_query("INSERT INTO items (_id, name, s_name, town, item) VALUES('$row','$name','$sname','$town', '$item')");
	
	if(!$ins)
	{
		echo (mysql_error());
	}
	else
	{
		echo ("data inserted");
	}
	



?>