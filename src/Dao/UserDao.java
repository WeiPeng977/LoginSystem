package Dao;

import Classes.User;

import java.sql.*;

public class UserDao {

    //JDBC驱动名及数据库URL，用户名以及密码。
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER = "root";
    private static final String PASS = "root";

    //SQL语句
    private static final String INSERT_USER_SQL = "INSERT INTO user" + "(userName, password) VALUES" + "(?,?);";
    private static final String SELECT_USER_BY_USERNAME = "select userName, password from user where userName = ?;";
    private static final String DELETE_USER_SQL = "delete from user where userName = ?;";
    private static final String UPDATE_USER_SQL = "update User set password = ? where userName =?;";

    //连接数据库
    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch(SQLException e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void createUser(User user) throws SQLException {
        System.out.println(INSERT_USER_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User readUser(String userName) {
        User user = null;
        //第一步，建立连接
        try (Connection connection = getConnection();
             //第二步，使用连接对象创建语句
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, userName);
            System.out.println(preparedStatement);
            //第三步，执行查询
            ResultSet rs = preparedStatement.executeQuery();
            //第四步，处理ResultSet对象.
            while (rs.next()) {

                String username = rs.getString("username");
                String password = rs.getString("password");
                user = new User(username, password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }



    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
