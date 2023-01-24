/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DataBase {

    static final String DATABASE_URL = "jdbc:mysql://localhost/stone";
    static final String DATABASE_USER = "root";
    static final String DATABASE_PASS = "";
    static Connection connection = null; // manages connection
    static Statement statement = null; // query statement
    static ResultSet resultSet = null;
    private Object rollField;
    private Object brk;
    Connection condb;

    public DataBase() throws SQLException {
        getConnection();
    }

    void getConnection() {

        try {

            connection = (Connection) DriverManager.getConnection(DATABASE_URL,
                    DATABASE_USER, DATABASE_PASS);
            statement = (Statement) connection.createStatement();
            System.out.println("Connect Hoise...");
            //JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");

        } catch (SQLException e) {
            System.err.println("Connection Error");
            JOptionPane.showMessageDialog(null, "Open XAMPP Then Try Again");
            loginPage ob = new loginPage();
            ob.setVisible(true);

        }
    }

    public void Login(String password, String userName) {

        try {
            String sql = "select * from login where username = '" + userName + "' and password = '" + password + "'";
            resultSet = statement.executeQuery(sql);
            //this.dispose();
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");
               // allInfo ob = new allInfo();
                // this.dispose(); 
                //ob.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Rong Username And Password....!!!\n\t Try Again Boss....");
              //  loginForm ob = new loginForm();
                //ob.setVisible(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connected Not Succesfully Boss!!!!!!");
            System.out.println("ERROR " + ex);
        }
    }
    }