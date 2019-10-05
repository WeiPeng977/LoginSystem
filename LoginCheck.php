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

$result = mysqli_query($conn, "SELECT * FROM logincheck
WHERE userName='$user'");

while ($row = mysqli_fetch_array($result)) {
    $existingUser = $row['userName'];
    $existingPass = $row['password'];
}

mysqli_close($conn);

session_start();

if ($user != $_SESSION['userName']) {
    if ($_SESSION['userName'] != null) {
        echo "<script language='JavaScript'>alert('login failed! please signout first');window.location.href='LoginPage.php'</script>";
    }
}
if ($user == null) {
    echo "<script language='javascript'>alert('username can not be empty!'); window.location.href='LoginPage.php'</script>";
}

if ($pass == null) {
    echo "<script language='javascript'>alert('password can not be empty!'); window.location.href='LoginPage.php'</script>";
}

if ($existingUser == null) {
    echo "<script language='javascript'>alert('login failed! user does not exists'); window.location.href='LoginPage.php'</script>";
} else {
    if ($pass == $existingPass) {
        session_start();
        $_SESSION['userName'] = $user;
        echo "<script language='javascript'> window.location.href='Index.php'</script>";
    } else {
        echo "<script language='javascript'>alert('wrong password'); window.location.href='LoginPage.php'</script>";
    }
}





