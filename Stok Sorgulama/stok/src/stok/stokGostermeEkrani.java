
package stok;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class stokGostermeEkrani extends javax.swing.JDialog {

  
    DefaultTableModel model ;
    stokIslemleri islemler = new stokIslemleri();
    
    public stokGostermeEkrani(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel)partiTablosu.getModel();
        partiGoruntule();      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        aramaCubugu = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        partiEkleButonu = new javax.swing.JButton();
        yaziAlani = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        partiTablosu = new javax.swing.JTable();
        partiSil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        aramaCubugu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aramaCubuguKeyReleased(evt);
            }
        });

        partiEkleButonu.setBackground(new java.awt.Color(51, 204, 255));
        partiEkleButonu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        partiEkleButonu.setText("Yeni Parti Oluştur");
        partiEkleButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partiEkleButonuActionPerformed(evt);
            }
        });

        yaziAlani.setForeground(new java.awt.Color(51, 51, 255));

        partiTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PARTİ NO", "TARİH", "SAAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        partiTablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partiTablosuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(partiTablosu);

        partiSil.setBackground(new java.awt.Color(51, 204, 255));
        partiSil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        partiSil.setText("Stoktan Çıkar");
        partiSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partiSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(aramaCubugu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(partiEkleButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(73, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(partiSil, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yaziAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(partiEkleButonu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(partiSil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yaziAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void partiTablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partiTablosuMouseClicked

        int selectedrow = partiTablosu.getSelectedRow();
        String partiNo = model.getValueAt(selectedrow,0).toString();
        String tarih = model.getValueAt(selectedrow,1).toString();
        String saat = model.getValueAt(selectedrow,2).toString();

        urunEkrani urunEkrani = new urunEkrani(this, true, partiNo, tarih, saat);
        urunEkrani.setVisible(true);

    }//GEN-LAST:event_partiTablosuMouseClicked

    private void partiEkleButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partiEkleButonuActionPerformed

        islemler.partiOlustur();

        partiGoruntule();
        yaziAlani.setText("Yeni parti başarıyla stoğa eklendi");
    }//GEN-LAST:event_partiEkleButonuActionPerformed

    private void aramaCubuguKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aramaCubuguKeyReleased
        String ara = aramaCubugu.getText();
        dinamikAra(ara);
    }//GEN-LAST:event_aramaCubuguKeyReleased

    private void partiSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partiSilActionPerformed
        int selectedrow = partiTablosu.getSelectedRow();
        String partiNo = model.getValueAt(selectedrow,0).toString();
        int parti_no = Integer.valueOf(partiNo);
        islemler.partiSil(parti_no);
        yaziAlani.setText("Yeni parti başarıyla stoktan çıkarıldı");
        partiGoruntule();
    }//GEN-LAST:event_partiSilActionPerformed

    public void dinamikAra(String aranacak){//burada tablomuzu filtreledik ezbere gerek yok gerekirse kopyala
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        partiTablosu.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(aranacak));
    }
    
    public void partiGoruntule(){
        
        model.setRowCount(0);
        ArrayList<parti> partiler = new ArrayList<parti>();
        partiler = islemler.partileriGetir();
        if(partiler!=null){
            for(parti i : partiler){
                Object[] eklenecek = {i.getParti_no(),i.getTarih(),i.getSaat()};
                model.addRow(eklenecek);
            }
        }
    }
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
            java.util.logging.Logger.getLogger(stokGostermeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stokGostermeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stokGostermeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stokGostermeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                stokGostermeEkrani dialog = new stokGostermeEkrani(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField aramaCubugu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton partiEkleButonu;
    private javax.swing.JButton partiSil;
    private javax.swing.JTable partiTablosu;
    private javax.swing.JLabel yaziAlani;
    // End of variables declaration//GEN-END:variables
}
