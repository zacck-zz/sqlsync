<?php

	include 'connection.php';
	
	$sel = mysql_query("SELECT MAX(_id) FROM items");
	$row_list = array();
	
	if(!$sel)
	{
		echo("error ".mysql_error());
	}

		while($rw = mysql_fetch_assoc($sel))
		{
			//$row_list[] = array('row'=>$row['MAX(_id)']);
			$row_list = array('post'=>$rw);
		}
		echo  str_ireplace('\\','',str_ireplace('\r\n','',json_encode(array('rows'=>$rows_list))));
	
	
	
	

?>