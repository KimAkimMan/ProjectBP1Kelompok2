/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kelompok2.projectbp1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class DaftarPersediaan extends javax.swing.JFrame {
    Statement st;
    ResultSet rs;
    koneksi koneksi;
    public DaftarPersediaan() {
        koneksi = new koneksi();
        initComponents();
        load_data();
    }
    public void load_data() {
        Object header[] = {"ID Barang", "Kategori", "Nama Barang", "Jumlah Stok", "Satuan", "Harga Satuan"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        TB_Daftar_Persediaan.setModel(data);
        
        // Pastikan nama kolom sesuai dengan yang ada di tabel
        String sql = "SELECT id_barang, kategori_barang, nama_barang, jumlah_stok, satuan, harga_satuan FROM persediaan";
        
        try {
            st = koneksi.con.createStatement();  
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String k1 = rs.getString(1);
                String k2 = rs.getString(2);
                String k3 = rs.getString(3);
                String k4 = rs.getString(4);
                String k5 = rs.getString(5);
                String k6 = rs.getString(6);

                String k[] = {k1, k2, k3, k4, k5, k6};
                data.addRow(k);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void clear() {
        ID_Barang.setText("");
        makanan.setSelected(false);
        minuman.setSelected(false);
        Nama_Barang.setText("");
        Jumlah_Stok.setText("");
        Satuan.setText("");
        Harga_Satuan.setText("");
    }
    public void edit_data() {
        String kategori="";
            if(minuman.isSelected()){
                kategori= minuman.getText();
                makanan.setSelected(false);
            }else if(makanan.isSelected()){
                kategori= makanan.getText();
                minuman.setSelected(false);
            }
        try {
            String sql_edit = String.format(
            "UPDATE persediaan SET kategori_barang = '%s', nama_barang = '%s', jumlah_stok = '%s', satuan = '%s', harga_satuan = '%s'  WHERE id_barang = '%s'",
                kategori,     // Kategori
                Nama_Barang.getText(),         // Nama Barang
                Jumlah_Stok.getText(),       // Jumlah Stok
                Satuan.getText(),       // Satuan
                Harga_Satuan.getText(),         // Harga Satuan
                ID_Barang.getText()           // ID Barang
            );
            st.execute(sql_edit);
            JOptionPane.showMessageDialog(null, "Data Barang Berhasil Di Input");
            load_data(); // Refresh tabel setelah input data
            clear();     // Bersihkan input setelah input data
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TB_Daftar_Persediaan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        find_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ID_Barang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        makanan = new javax.swing.JRadioButton();
        minuman = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        Nama_Barang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Jumlah_Stok = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Satuan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Harga_Satuan = new javax.swing.JTextField();
        Tombol_Edit = new javax.swing.JButton();
        laporan_jasper = new javax.swing.JButton();
        tombol_exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TB_Daftar_Persediaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TB_Daftar_Persediaan);

        jLabel1.setText("Cari Berdasarkan ID:");

        find_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_idActionPerformed(evt);
            }
        });
        find_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                find_idKeyReleased(evt);
            }
        });

        jLabel3.setText("Masukan Data-data Berikut:");

        jLabel4.setText("ID Barang");

        ID_Barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_BarangActionPerformed(evt);
            }
        });

        jLabel9.setText("Kategori");

        makanan.setText("Makanan");

        minuman.setText("Minuman");

        jLabel5.setText("Nama Barang");

        jLabel6.setText("Jumlah Stok");

        jLabel7.setText("Satuan");

        jLabel8.setText("Harga Satuan (Rp)");

        Tombol_Edit.setText("EDIT");
        Tombol_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tombol_EditActionPerformed(evt);
            }
        });

        laporan_jasper.setText("LAPORAN");
        laporan_jasper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporan_jasperActionPerformed(evt);
            }
        });

        tombol_exit.setText("EXIT");
        tombol_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_exitActionPerformed(evt);
            }
        });

        jLabel2.setText("DAFTAR PERSEDIAAN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Tombol_Edit)
                            .addGap(47, 47, 47)
                            .addComponent(laporan_jasper)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tombol_exit))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel4))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Harga_Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ID_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(makanan)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(minuman))
                                .addComponent(Nama_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Jumlah_Stok, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(31, 31, 31)
                            .addComponent(find_id, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(find_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ID_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(makanan)
                            .addComponent(minuman))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Nama_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Jumlah_Stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(28, 28, 28))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(Harga_Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tombol_Edit)
                                .addComponent(laporan_jasper))
                            .addComponent(tombol_exit))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void find_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_find_idActionPerformed

    private void ID_BarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_BarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_BarangActionPerformed

    private void laporan_jasperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporan_jasperActionPerformed
        jasper reportGenerator = new jasper();
        List<Map<String, ?>> data = reportGenerator.fetchData();
        reportGenerator.generateReport(data);
    }//GEN-LAST:event_laporan_jasperActionPerformed

    private void find_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_find_idKeyReleased
        Object header[] = {"ID Barang", "Kategori", "Nama Barang", "Jumlah Stok", "Satuan", "Harga Satuan"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        TB_Daftar_Persediaan.setModel(data);
        String cariID = find_id.getText();

        try {
            st = koneksi.con.createStatement();
            String query = "SELECT * FROM persediaan WHERE id_barang LIKE '%" + cariID + "%' ORDER BY id_barang ASC";
            rs = st.executeQuery(query);

            while (rs.next()) {
                data.addRow(new Object[]{
                    rs.getString("id_barang"),
                    rs.getString("kategori_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("jumlah_stok"),
                    rs.getString("satuan"),
                    rs.getString("harga_satuan")
                });
            }
            TB_Daftar_Persediaan.setModel(data);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    }//GEN-LAST:event_find_idKeyReleased

    private void Tombol_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tombol_EditActionPerformed
        edit_data();
        clear();
        load_data();
    }//GEN-LAST:event_Tombol_EditActionPerformed

    private void tombol_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_exitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_tombol_exitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaftarPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarPersediaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Harga_Satuan;
    private javax.swing.JTextField ID_Barang;
    private javax.swing.JTextField Jumlah_Stok;
    private javax.swing.JTextField Nama_Barang;
    private javax.swing.JTextField Satuan;
    private javax.swing.JTable TB_Daftar_Persediaan;
    private javax.swing.JButton Tombol_Edit;
    private javax.swing.JTextField find_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton laporan_jasper;
    private javax.swing.JRadioButton makanan;
    private javax.swing.JRadioButton minuman;
    private javax.swing.JButton tombol_exit;
    // End of variables declaration//GEN-END:variables
}
