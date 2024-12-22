package kelompok2.projectbp1;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.type.*;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import kelompok2.projectbp1.koneksi;

public class jasper {

    private koneksi koneksi;

    public jasper() {
        koneksi = new koneksi();
    }

    public void generateReport(List<Map<String, ?>> data) {
        try {

            // Membuat desain laporan
            JasperDesign jasperDesign = new JasperDesign();
            jasperDesign.setName("DynamicReport");
            jasperDesign.setPageWidth(595);
            jasperDesign.setPageHeight(842);
            jasperDesign.setColumnWidth(555);
            jasperDesign.setLeftMargin(20);
            jasperDesign.setRightMargin(20);
            jasperDesign.setTopMargin(20);
            jasperDesign.setBottomMargin(20);
            jasperDesign.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

            // Fields yang digunakan
            String[] fields = { "id_barang", "kategori_barang", "nama_barang", "jumlah_stok", "satuan", "harga_satuan" };
            for (String field : fields) {
                JRDesignField jrField = new JRDesignField();
                jrField.setName(field);
                jrField.setValueClass(String.class);
                jasperDesign.addField(jrField);
            }

            // Judul laporan
            JRDesignBand titleBand = new JRDesignBand();
            titleBand.setHeight(50);
            JRDesignStaticText titleText = new JRDesignStaticText();
            titleText.setText("Laporan Daftar Barang");
            titleText.setX(0);
            titleText.setY(10);
            titleText.setWidth(555);
            titleText.setHeight(30);
            titleText.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
            titleText.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
            titleBand.addElement(titleText);
            jasperDesign.setTitle(titleBand);

            // Header kolom
            JRDesignBand headerBand = new JRDesignBand();
            headerBand.setHeight(30);
            int x = 0;

            String[] headers = { "ID Barang", "Kategori Barang", "Nama Barang", "Jumlah Stok", "Satuan", "Harga Satuan" };
            for (String header : headers) {
                JRDesignStaticText headerText = new JRDesignStaticText();
                headerText.setText(header);
                headerText.setX(x);
                headerText.setY(0);
                headerText.setWidth(90);
                headerText.setHeight(30);
                headerText.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
                headerText.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
                headerText.setBackcolor(Color.RED);
                headerText.setForecolor(Color.WHITE);
                headerText.setMode(ModeEnum.OPAQUE);
                headerText.getLineBox().getPen().setLineWidth(0.5f);
                headerBand.addElement(headerText);
                x += 90;
            }
            jasperDesign.setColumnHeader(headerBand);

            // Detail baris
            JRDesignBand detailBand = new JRDesignBand();
            detailBand.setHeight(20);
            x = 0;

            for (String field : fields) {
                JRDesignTextField textField = new JRDesignTextField();
                textField.setX(x);
                textField.setY(0);
                textField.setWidth(90);
                textField.setHeight(20);
                textField.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
                textField.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
                textField.setExpression(new JRDesignExpression("$F{" + field + "}"));
                textField.getLineBox().getPen().setLineWidth(0.5f);
                detailBand.addElement(textField);
                x += 90;
            }
            ((JRDesignSection) jasperDesign.getDetailSection()).addBand(detailBand);

            // Kompilasi laporan dan mengisi data
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Tampilkan laporan
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        jasper reportGenerator = new jasper();
        List<Map<String, ?>> data = reportGenerator.fetchData();
        reportGenerator.generateReport(data);
    }

    private List<Map<String, ?>> fetchData() {
        List<Map<String, ?>> data = new ArrayList<>();
        String sql = "SELECT id_barang, kategori_barang, nama_barang, jumlah_stok, satuan, harga_satuan FROM persediaan";

        try (Connection con = koneksi.con;
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("id_barang", rs.getString("id_barang"));
                row.put("kategori_barang", rs.getString("kategori_barang"));
                row.put("nama_barang", rs.getString("nama_barang"));
                row.put("jumlah_stok", rs.getString("jumlah_stok"));
                row.put("satuan", rs.getString("satuan"));
                row.put("harga_satuan", rs.getString("harga_satuan"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
