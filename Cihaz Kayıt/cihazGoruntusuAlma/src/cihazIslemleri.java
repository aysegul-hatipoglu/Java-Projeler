import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cihazIslemleri  {
    private Connection con = null; 
    private  PreparedStatement preparedStatement = null;
    private Statement statement = null;

    public cihazIslemleri(){
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
   

    public void cihazEkle(int cihaz_id,String cihaz_ismi){
        try{
            
            LocalDate nowDate = LocalDate.now();
            LocalTime nowTime = LocalTime.now();
            Time time = Time.valueOf(nowTime);
            Date date = Date.valueOf(nowDate);
                        
            File file=new File("C:/Users/MUTLU/Desktop/kamera/resim.png");
            FileInputStream fis=new FileInputStream(file);    
            PreparedStatement ps=con.prepareStatement("insert into cihaz_bilgi (cihaz_id,cihaz_adi,tarih,saat,cihaz_goruntusu) values(?,?,?,?,?)"); 
            ps.setInt(1,cihaz_id);
            ps.setString(2,cihaz_ismi);
            ps.setDate(3,date);
            ps.setTime(4,time); 
            ps.setBinaryStream(5,fis,(int)file.length());  
            ps.executeUpdate();
            
               
            ps.close();
            fis.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ResultSet cihazOku(int cihaz_id) throws IOException{
        
        String sql = "SELECT * from cihaz_bilgi where cihaz_id = ?";
            
        try{
            preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setInt(1,cihaz_id);
            ResultSet resultSet = preparedStatement.executeQuery();
                  
            while (resultSet.next()){
                int n = resultSet.getInt(1);
                String name = resultSet.getString(2);
                File image = new File("C:/Users/MUTLU/Desktop/kamera/cihaz.png");
                FileOutputStream fos = new FileOutputStream(image);

                byte[] buffer = new byte[1];
                InputStream is = resultSet.getBinaryStream(5);
                try {
                    while (is.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(cihazIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                }
                fos.close();
                return resultSet;
            }   
            con.close();
            }catch (SQLException ex) {
                    Logger.getLogger(cihazIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                   
                } catch (FileNotFoundException ex) {
                Logger.getLogger(cihazIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            }return null;   
        }
}