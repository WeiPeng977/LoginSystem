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

session_start();
$user = $_SESSION['userName'];

mysqli_query($conn,"DELETE FROM logincheck WHERE userName='$user'");

session_start();
session_destroy();
echo "<script language='JavaScript'>alert('logout successful!');window.location.href='LoginPage.php'</script>";
mysqli_close($conn);