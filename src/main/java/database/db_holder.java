package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class db_holder {

    private String url;
   // private String Username;
    //private String Password;
    private Connection con;

    public db_holder() {
        try {
            Class.forName("org.sqlite.JDBC");
            url = "jdbc:sqlite:C:\\Users\\hossa\\Downloads\\Compressed\\database\\ATMDB.db"; 
           // Username = "root";
           // Password = ""; // SQLite

            try {
                con = DriverManager.getConnection(url); 
            } catch (SQLException ex) {
                Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int rand() {
        return (int) Math.floor(Math.random() * 10);
    }

    public long card_no() {
        long card = 0;
        for (int i = 0; i < 16; i++) {
            card = (10 * card) + rand();
        }
        return card;
    }

    public long ins(String name, String mail, long phone, int age, String pan, long card) {
        long ans = 0;
        String sql = "insert into user_details(name,mail,phone,age,pan,card_no) values('" + name + "','" + mail + "'," + phone + "," + age + ",'" + pan + "'," + card + ")";
        try (Statement st = con.createStatement()) {
            st.execute(sql);
            ans = 1;
        } catch (SQLException ex) {
            Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ans;
    }

    public int chcekCardNumber(long num) {
        int flag = 0;
        String Sql = "SELECT card_no FROM user_details WHERE card_no = " + num;
        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(Sql);
            if (rs.isBeforeFirst()) {
                flag = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public int checkPin(long num) {
        int pin = 108;
        String Sql = "SELECT pin FROM user_details WHERE card_no = " + num;
        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(Sql);
            if (rs.next()) {
                pin = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pin;
    }

    public int setPin(int pin, long card) {
        int flag = 0;
        String Sql = "UPDATE user_details SET pin =" + pin + " WHERE card_no = " + card;
        try (Statement st = con.createStatement()) {
            st.executeUpdate(Sql);
            flag = 1;
        } catch (SQLException ex) {
            Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public int getValue(String getter, long num) {
        int flag = 0;
        String Sql = "SELECT " + getter + " FROM user_details WHERE card_no = " + num;
        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(Sql);
            if (rs.next()) {
                flag = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public int setValue(String setField, int setFieldValue, long card) {
        int flag = 0;
        String Sql = "UPDATE user_details SET " + setField + " =" + setFieldValue + " WHERE card_no = " + card;
        try (Statement st = con.createStatement()) {
            st.executeUpdate(Sql);
            flag = 1;
        } catch (SQLException ex) {
            Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public int trans_ins(String type, int amount, long card_no) {
        int flag = 0;
        String sql = "insert into trans(type,amount,card_no) values('" + type + "'," + amount + "," + card_no + ")";
        try (Statement st = con.createStatement()) {
            st.execute(sql);
            flag += 1;
        } catch (SQLException ex) {
            Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public ResultSet loadMiniStatement(long card) {
        ResultSet rs = null;
        String Sql = "SELECT * FROM trans WHERE card_no = " + card + " ORDER BY date DESC";
        try (Statement st = con.createStatement()) {
            rs = st.executeQuery(Sql);
        } catch (SQLException ex) {
            Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
