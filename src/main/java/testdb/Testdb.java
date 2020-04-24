package testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(value = "/testDbConnection")
public class Testdb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // setup connection variables
        String user = "koronawirus2020";
        String password = "koronawirus2020";

        String jdbcUrl = "jdbc:mysql://localhost:3306/management_of_monthly_payments?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

            // get connection to database
        try{
            PrintWriter writer = resp.getWriter();
            writer.println("Connecting to database: " + jdbcUrl);
            // load and register JDBC driver for MySQL

            Class.forName(driver);

            Connection myConnection = DriverManager.getConnection(jdbcUrl,user,password);


            writer.println("\n" +
                    "Successfully connected to the database");
            writer.println("\n\n");
            writer.println(" __  __        _____  ____  _      ");
            writer.println("|  \\/  |      / ____|/ __ \\| |     ");
            writer.println("| \\  / |_   _| (___ | |  | | |     ");
            writer.println("| |\\/| | | | |\\___ \\| |  | | |     ");
            writer.println("| |  | | |_| |____) | |__| | |____ ");
            writer.println("|_|  |_|\\__, |_____/ \\___\\_\\______|");
            writer.println("         __/ |                     ");
            writer.println("        |___/                      ");

            // close connection
            myConnection.close();
        }
         catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
