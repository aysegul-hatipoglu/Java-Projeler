/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boynerfatura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MUTLU
 */
public class BoynerFatura {

   private Connection con = null; 
   private  PreparedStatement preparedStatement = null;
   private Statement statement = null;
   private ResultSet rs = null;
   
   
   public BoynerFatura(){
         String url = "jdbc:mysql://"+Database.host+":"+Database.port+"/"+Database.db_ismi+"?useUnicode=true&characterEncoding=utf8"; //en son eklenen kısım veritabanına birşeyler eklerken türkçe karakter girmemizi sağlar
        
        //drivere su sekilde özellikle baslatmak gerekiyor yoksa sıkıntı cıkabilir
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı...");
        }
        
        try {
            con = (Connection) DriverManager.getConnection(url, Database.kullaniciAdi, Database.parola);
            System.out.println("Bağlantı Başarılı");
            
        }catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız");
            //ex.printStackTrace();
        }
   }
    public ResultSet erisimMusteriBilgi(){
            
       try {
            statement = con.createStatement();
            String vericek = "SELECT * FROM fatura where tc='2147483647' ";
            rs = statement.executeQuery(vericek);
           
            while(rs.next()) {
                return rs;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
           
        }
        return null;
    }
    
    public ResultSet erisimFaturaBilgi(){
        try {
            statement = con.createStatement();
            String vericek = "SELECT * FROM odeme where siparisNo='1001737985'";
            rs = statement.executeQuery(vericek);
           
            while(rs.next()) {
                 //System.out.println("sekil : = "+rs.getString("odemeTarihi"));
                return rs;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
           
        }
        return null;
    }

    public ArrayList<urun> urunGetir(){
        
        ArrayList<urun> urun = new ArrayList<urun>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * from urunler";
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                
                String irsNo = rs.getString("irsNo");
                String irsTarih = rs.getString("irsTarih");
                int malzKodu = rs.getInt("malzKodu");
                String malzTanımı = rs.getString("malzTanımı");
                float birimFiyati = rs.getFloat("birimFiyati");
                int miktar = rs.getInt("miktar");
                int kdvOrani = rs.getInt("kdvOrani");
                float iskonto = rs.getFloat("iskonto");
               
                
                urun.add(new urun(irsNo,irsTarih,malzKodu,malzTanımı,birimFiyati,miktar,kdvOrani,iskonto));
            }return urun;
            
        } catch (SQLException ex) {
            Logger.getLogger(BoynerFatura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   }
    public static void main(String[] args) {
        // TODO code application logic here
        
        BoynerFatura by = new BoynerFatura();
        by.erisimFaturaBilgi();
        
    }
    
}
