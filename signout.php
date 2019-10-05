<?php
session_start();
session_destroy();
echo "<script language='JavaScript'>alert('signout successful'); window.location.href='LoginPage.php'</script>";