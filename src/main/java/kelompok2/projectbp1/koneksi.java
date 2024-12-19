package kelompok2.projectbp1;
import java.sql.Connection;
import java.sql.DriverManager;

public class koneksi {
    Connection con;
    public koneksi() {
        String id, pass, driver, url;
        id = "projectkel2";
        pass = "kelompok2bp1";
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://192.168.190.191:3306/gudang";

        
        try {
            // Memuat driver JDBC
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pass);            
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }
}
