package kelompok2.projectbp1;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class koneksi {
    Connection con;
    public koneksi() {
        String id, pass, driver, url;
        id = "root";
        pass = "";
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/db_mhs";
        
        try {
            // Memuat driver JDBC
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pass);
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }
}
