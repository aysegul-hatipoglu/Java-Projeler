
import boynerfatura.BoynerFatura;
import boynerfatura.urun;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class arayuz extends javax.swing.JFrame {

    DefaultTableModel model ;
    BoynerFatura bf = new BoynerFatura();
 
    public arayuz(java.awt.Frame parent, boolean modal) {
        //super(parent, modal);
       
       
        initComponents();
        model = (DefaultTableModel)tablomm.getModel();
         
          
        model.setRowCount(0);
        ArrayList<urun> urunler = new ArrayList<urun>();
        urunler = bf.urunGetir();
        float tutar=0;
        if(urunler!=null){
            for(urun urun : urunler){
                Object[] eklenecek = {urun.getIrsNo(),urun.getIrsTarih(),urun.getMalzKodu(),urun.getMalzTanımı(),urun.getBirimFiyati(),urun.getMiktar(),urun.getKdvOrani(),urun.getIskonto(),urun.getBirimFiyati()*urun.getMiktar()};
                model.addRow(eklenecek);
                tutar+=urun.getBirimFiyati()*urun.getMiktar();
            }
            String sonuc = new DecimalFormat("##.##").format(tutar);
            araToplam.setText(sonuc);
            matrah8.setText(sonuc);
            
            Float kdvsekiz = tutar*8/100;
            String sonuc2 = new DecimalFormat("##.##").format(kdvsekiz);
            float deneme1=0;
            String deneme2 = new DecimalFormat("##.##").format(deneme1);
            matrah18.setText(deneme2);
            kdv18.setText(deneme2);
            kdv8.setText(sonuc2);
            float toplam1 = tutar + kdvsekiz + deneme1 + deneme1 ;
            String toplam2 = new DecimalFormat("##.##").format(toplam1);
            toplam.setText(toplam2);
        }

        try {
            
            ResultSet rs = bf.erisimMusteriBilgi();
            String isim = rs.getString("isim");
            String adres1 = rs.getString("adres");
            String eposta1 = rs.getString("eposta");
            String tel1 = rs.getString("telefon");
            int tc1 = rs.getInt("tc");
            String tc2 = Integer.toString(tc1);
            
            isimSoyisim.setText(isim);
            adres.setText(adres1);
            eposta.setText(eposta1);
            tel.setText(tel1);
            tc.setText(tc2);
        } catch (SQLException ex) {
            Logger.getLogger(arayuz.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
         try {
           // initComponents();
            ResultSet rs = bf.erisimFaturaBilgi();
            int siparis = rs.getInt("siparisNo");
            String odemeSek = rs.getString("odemeSekli");
            String odemeTar = rs.getString("odemeTarihi");
            String kargoSek = rs.getString("kargoSekli");
            String kargoTar = rs.getString("kargoTarihi");
            String siparis2 = Integer.toString(siparis);
            
            siparisNumarasi.setText(siparis2);
            odemeSekli.setText(odemeSek);
            odemeTarihi.setText(odemeTar);
            kargoBilgisi.setText(kargoSek);
            kargoTarihi.setText(kargoTar);
        } catch (SQLException ex) {
            Logger.getLogger(arayuz.class.getName()).log(Level.SEVERE, null, ex);
        
         
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        anaPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablomm = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        siparisNo = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        yaziylaTL = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        odemeSekli = new javax.swing.JLabel();
        odemeTarihi = new javax.swing.JLabel();
        siparisNumarasi = new javax.swing.JLabel();
        kargoBilgisi = new javax.swing.JLabel();
        kargoTarihi = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        toplam = new javax.swing.JLabel();
        kdv18 = new javax.swing.JLabel();
        kdv8 = new javax.swing.JLabel();
        matrah18 = new javax.swing.JLabel();
        matrah8 = new javax.swing.JLabel();
        araToplam = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        isimSoyisim = new javax.swing.JLabel();
        adres = new javax.swing.JLabel();
        eposta = new javax.swing.JLabel();
        tel = new javax.swing.JLabel();
        tc = new javax.swing.JLabel();
        yazdirButonu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        anaPanel.setBackground(new java.awt.Color(255, 255, 255));
        anaPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0), 2));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boyy.jpg"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoo.jpg"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tel:02123357575  Fax:02122766880");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("34396 MASLAK/İSTANBUL");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/cizgi.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("BOYNER BÜYÜK MAĞAZACILIK A.Ş");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("BÜYÜKDERE CAD. USO CENTER BİNASI KAT:12-Z02  NO:245/10");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/cizgi.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Web Sitesi: www.boyner.com.tr");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Eposta: boyner@boyner.com.tr");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Vergi Dairesi: BÜYÜK MÜKELLEFLER");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("VKN: 5200843963");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Sicil No: 284082/221664");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("İşletme Merkezi : İSTANBUL");

        tablomm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablomm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "İrs/Tsl No", "İrs/Tsl Tarihi", "Mlz. Kodu", "Mlz. Tanımı", "Birim Fiyat", "Miktar", "KDV Oranı", "İskonto", "Tutar"
            }
        ));
        tablomm.setColumnSelectionAllowed(true);
        tablomm.setGridColor(new java.awt.Color(255, 255, 255));
        tablomm.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tablomm.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablomm);
        tablomm.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tablomm.getColumnModel().getColumnCount() > 0) {
            tablomm.getColumnModel().getColumn(3).setMinWidth(100);
            tablomm.getColumnModel().getColumn(3).setPreferredWidth(50);
            tablomm.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Parası yoksa  iade olunacak satış bedelinden nakden(İMF vb. düzenlenmişse tutarından) indirilerek alınır. Haksız kazanılan tüm paralara aynı işlem yapılır.");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Bu Ürünler usulunce iade edilir/değiştirilir ise Hopi Programı’nda  Ürünler için  kazanılan  Paracık tutarları müşteriden geri  alınır.  Müşteri’nin  başka yeterli ");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/tablo_1.JPG"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("İDARE BÖLÜMÜ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(377, 377, 377))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        siparisNo.setBackground(new java.awt.Color(255, 255, 255));
        siparisNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        siparisNo.setForeground(new java.awt.Color(204, 0, 0));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("E-Arşiv izni kapsamında elektronik ortamda iletilmiştir");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Bu satış internet üzerinden yapılmıştır.");

        yaziylaTL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yaziylaTL.setText("yazıylaTL");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("-----İNTERNET SATIŞ BİLGİLERİ-----");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Ödeme Şekli : ");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Ödeme Tarihi :");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Kargo Tarihi :");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Kargo Bilgisi :");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("Sipariş Numarası : ");

        odemeSekli.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        odemeSekli.setForeground(new java.awt.Color(204, 0, 0));
        odemeSekli.setText("jLabel39");

        odemeTarihi.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        odemeTarihi.setForeground(new java.awt.Color(204, 0, 0));
        odemeTarihi.setText("jLabel40");

        siparisNumarasi.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        siparisNumarasi.setForeground(new java.awt.Color(204, 0, 0));
        siparisNumarasi.setText("jLabel41");

        kargoBilgisi.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        kargoBilgisi.setForeground(new java.awt.Color(204, 0, 0));
        kargoBilgisi.setText("jLabel42");

        kargoTarihi.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        kargoTarihi.setForeground(new java.awt.Color(204, 0, 0));
        kargoTarihi.setText("jLabel44");

        javax.swing.GroupLayout siparisNoLayout = new javax.swing.GroupLayout(siparisNo);
        siparisNo.setLayout(siparisNoLayout);
        siparisNoLayout.setHorizontalGroup(
            siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(siparisNoLayout.createSequentialGroup()
                .addGroup(siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(siparisNoLayout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siparisNumarasi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(yaziylaTL, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(siparisNoLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(42, 42, 42)
                        .addComponent(odemeSekli, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(siparisNoLayout.createSequentialGroup()
                .addGroup(siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addGroup(siparisNoLayout.createSequentialGroup()
                        .addGroup(siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGap(39, 39, 39)
                        .addGroup(siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kargoTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(odemeTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kargoBilgisi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(siparisNoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel33)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        siparisNoLayout.setVerticalGroup(
            siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(siparisNoLayout.createSequentialGroup()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yaziylaTL)
                .addGap(2, 2, 2)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(odemeSekli, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addGroup(siparisNoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(odemeTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(kargoTarihi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(kargoBilgisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(siparisNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(siparisNoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel38))
                    .addComponent(siparisNumarasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("ARA TOPLAM          :");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("KDV MATRAH %8   :");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("KDV MATRAH %18 :");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("KDV %8                  :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("KDV %18                :");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("GENEL TOPLAM        :");

        toplam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        toplam.setText("jLabel36");

        kdv18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kdv18.setText("0.00");

        kdv8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kdv8.setText("jLabel34");

        matrah18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        matrah18.setText("0.00");

        matrah8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        matrah8.setText("jLabel32");

        araToplam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        araToplam.setText("jLabel31");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toplam)
                    .addComponent(kdv18)
                    .addComponent(kdv8)
                    .addComponent(matrah18)
                    .addComponent(matrah8)
                    .addComponent(araToplam))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(araToplam, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matrah8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(matrah18, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kdv8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(kdv18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(toplam))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Sayın:");

        isimSoyisim.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        adres.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        adres.setText("jLabel16");

        eposta.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        eposta.setText("jLabel16");

        tel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tel.setText("jLabel16");

        tc.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tc.setText("jLabel16");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isimSoyisim, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(eposta, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                            .addComponent(tel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addComponent(tc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(isimSoyisim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tc)
                .addGap(3, 3, 3)
                .addComponent(adres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eposta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout anaPanelLayout = new javax.swing.GroupLayout(anaPanel);
        anaPanel.setLayout(anaPanelLayout);
        anaPanelLayout.setHorizontalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, anaPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(374, 374, 374))
            .addGroup(anaPanelLayout.createSequentialGroup()
                .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(anaPanelLayout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(anaPanelLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel23)
                                .addGroup(anaPanelLayout.createSequentialGroup()
                                    .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20)
                                        .addGroup(anaPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(140, 140, 140)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(anaPanelLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(anaPanelLayout.createSequentialGroup()
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(57, 57, 57)
                                    .addComponent(siparisNo, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24))
                                .addGroup(anaPanelLayout.createSequentialGroup()
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(184, 184, 184)))))
                    .addGroup(anaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        anaPanelLayout.setVerticalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, anaPanelLayout.createSequentialGroup()
                .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(anaPanelLayout.createSequentialGroup()
                        .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(anaPanelLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(anaPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addGroup(anaPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(siparisNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(520, 520, 520)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        yazdirButonu.setText("YAZDIR");
        yazdirButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yazdirButonuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(yazdirButonu)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yazdirButonu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yazdirButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yazdirButonuActionPerformed
        ScreenCaptureMain sc = new ScreenCaptureMain();
        sc.gonder();
        System.exit(0);
    }//GEN-LAST:event_yazdirButonuActionPerformed

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
            java.util.logging.Logger.getLogger(arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                arayuz dialog = new arayuz(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adres;
    private javax.swing.JPanel anaPanel;
    private javax.swing.JLabel araToplam;
    private javax.swing.JLabel eposta;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel isimSoyisim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kargoBilgisi;
    private javax.swing.JLabel kargoTarihi;
    private javax.swing.JLabel kdv18;
    private javax.swing.JLabel kdv8;
    private javax.swing.JLabel matrah18;
    private javax.swing.JLabel matrah8;
    private javax.swing.JLabel odemeSekli;
    private javax.swing.JLabel odemeTarihi;
    private javax.swing.JPanel siparisNo;
    private javax.swing.JLabel siparisNumarasi;
    private javax.swing.JTable tablomm;
    private javax.swing.JLabel tc;
    private javax.swing.JLabel tel;
    private javax.swing.JLabel toplam;
    private javax.swing.JButton yazdirButonu;
    private javax.swing.JLabel yaziylaTL;
    // End of variables declaration//GEN-END:variables
}
