<?php
$servername = "localhost";
$username = "root";
$password = "123456";
$dbname = "loginSystem";

// 创建连接
$conn = new mysqli($servername, $username, $password, $dbname);

// 检测连接
if ($conn->connect_error) {
    die("连接失败: " . $conn->connect_error);
}

$user = $_POST['userName'];
$pass = $_POST['password'];

if($user == null){
    echo "<script language='JavaScript'>window.location.href='LoginPage.php'</script>";
}

if ($pass == null) {
    echo "<script language='JavaScript'>alert('password can not be empty'); window.location.href='ModifyPage.php'</script>";
}else{
    mysqli_query($conn, "UPDATE logincheck SET password = $pass WHERE userName = '$user'");
    echo "<script language='javaScript'>alert('modify successful!');window.location.href='LoginPage.php'</script>";
}

mysqli_close($conn);
