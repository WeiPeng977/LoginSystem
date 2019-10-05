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

$sql = "INSERT INTO  loginCheck(userName, password)
VALUES ('$user', '$pass')";

$result = mysqli_query($conn, "SELECT * FROM logincheck
WHERE userName='$user'");

while ($row = mysqli_fetch_array($result)) {
    $existingUser = $row['userName'];
    $existingPass = $row['password'];
}

if ($user == null) {
    echo "<script language='JavaScript'>alert('username can not be empty!'); window.location.href='RegisterPage.html'</script>";
}

if ($pass == null) {
    echo "<script language='javascript'>alert('password can not be empty!'); window.location.href=rRrRegisterPage.html/script>";
}

if ($user = $existingUser){
    echo "<script language='javascript'>alert('user already exist!'); window.location.href='RegisterPage.html'</script>";
}else{
    if (mysqli_query($conn, $sql)) {
        echo "<script language='JavaScript'>alert('register successful!'); window.location.href='LoginPage.php'</script>";
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conn);
    }
}
mysqli_close($conn);

