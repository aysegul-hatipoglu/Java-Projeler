/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MUTLU
 */
public class stokIslemleri {
   
    private Connection con = null; 
    private  PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private Statement statement2 = null;
    
    public stokIslemleri(){
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
    
    public ArrayList<parti> partileriGetir(){
        
        ArrayList<parti> cikti = new ArrayList<parti>();
        
        try {
            statement = (Statement) con.createStatement();
            String sorgu = "Select * from partiler";
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int parti_no = rs.getInt("parti_no");
                String tarih = rs.getString("date");
                String saat = rs.getString("time");
                cikti.add(new parti(parti_no, tarih, saat));
            }return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(stokIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
  
    
    public ArrayList<urun> urunleriGetir(int parti_no){ 
        
         ArrayList<urun> cikti = new ArrayList<urun>();
       
        String urunAdi = null;
        int urunFiyati = 0;
        
        String sorgu = "Select * from eslestirme where parti_no = ?";
        try {
           
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1, parti_no);
           
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                int urunId = rs.getInt("urun_id");
                int adet = rs.getInt("adet");
                
                String sorgu2 = "Select * from urun where urun_id = ?";
                try{
                    preparedStatement = (PreparedStatement) con.prepareStatement(sorgu2);
                    preparedStatement.setInt(1, urunId);

                    ResultSet rs2 = preparedStatement.executeQuery();
                    
                    while(rs2.next()){
                        urunAdi = rs2.getString("urun_adi");
                        urunFiyati = rs2.getInt("urun_fiyati");
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(stokIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
                cikti.add(new urun(urunId, urunAdi, urunFiyati,adet));
   
            }return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(stokIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public void partiOlustur(){
     
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        Time time = Time.valueOf(nowTime);
        Date date = Date.valueOf(nowDate);
        
        Random rand = new Random();
        long value = 11111111+rand.nextInt(999999999);
        
       
        String sorgu = "Insert into partiler (parti_no,date,time) VALUES(?, ?, ?)";
         try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setLong(1, value);
            preparedStatement.setDate(2, date);
            preparedStatement.setTime(3, time); 
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(stokIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } 
      
        int kac_tane = 3+rand.nextInt(15);      
        int urunKodlari[] = new int[kac_tane];
        int i = 0;
        int yeni = 0;
        
        while(i<kac_tane){
            yeni = 110+rand.nextInt(24);
            boolean sayac = false;
            
            for(int j=0; j<i; j++){
                if(yeni==urunKodlari[j]){
                    sayac=true;
                    break;
                }
            }
            if(sayac) continue;
            else {
                urunKodlari[i]=yeni;
                i++;
            }
        }   
        
        for(i=1; i<kac_tane;i++){    
            int adet = 5+rand.nextInt(15);  
            String sorgu3 = "Insert into eslestirme (parti_no,urun_id,adet) VALUES(?, ?, ?)";
            try {
                preparedStatement = (PreparedStatement) con.prepareStatement(sorgu3);
                preparedStatement.setLong(1, value);
                preparedStatement.setInt(2, urunKodlari[i]);
                preparedStatement.setInt(3, adet); 
                preparedStatement.executeUpdate();
               
            } catch (SQLException ex) {
                Logger.getLogger(stokIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(0);
            } 
            
        }
        
    }
     
    public void partiSil(int partiNo){
        String sorgu = "Delete from eslestirme where parti_no = ?";
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setInt(1,partiNo);
            preparedStatement.executeUpdate();
                    
        } catch (SQLException ex) {
            Logger.getLogger(stokIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sorgu1 = "Delete from partiler where parti_no = ?";
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu1);
            preparedStatement.setInt(1,partiNo);
            preparedStatement.executeUpdate();
                    
        } catch (SQLException ex) {
            Logger.getLogger(stokIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
}

    /*

    
    public boolean girisYap(String ad,String parola){
        String sorgu = "Select * From adminler where username = ? and password = ?";
        
        try {  
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, parola);
            
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();//varsa true yoksa false
            
        } catch (SQLException ex) {
            
            
            Logger.getLogger(calisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
 
    
    
   
    
    public void calisanGuncelle(int id, String ad, String soyad, String dep, String maas){
        String sorgu = "Update calisanlar set ad = ? , soyad = ? , departman = ? , maas = ? where id = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, dep);
            preparedStatement.setString(4, maas);
            preparedStatement.setInt(5, id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(calisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void calisanSil(int id){
        String sorgu = "Delete from calisanlar where id = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
                    
        } catch (SQLException ex) {
            Logger.getLogger(calisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
       public static void main(String[] args) {
        // TODO code application logic here
        calisanIslemleri calisan = new calisanIslemleri();
        }*/


