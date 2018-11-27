/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author MUTLU
 */
public class ScreenCaptureMain {
    
class ScreenCapture {
     public void capture(String fileName, int second) throws Exception{
        (new Thread()).sleep(second*1000);
        int x = 15;
        int y = 44;
        int width = 948;
        int height = 940;
        BufferedImage screencapture = new Robot().createScreenCapture(
        new Rectangle(x, y, width, height) );
        File file = new File(fileName);
        ImageIO.write(screencapture, "jpg", file);
        JavaPdfBoxCreateImage jp = new JavaPdfBoxCreateImage();
        jp.pdfOlustur();
    }
}
    
public void gonder(){
          try {
            ScreenCapture sc = new ScreenCapture();
            sc.capture("C:/Users/MUTLU/Desktop/pdfDeneme/"+"kayit.jpg",1);
            //sc.capture("C:/Users/MUTLU/Desktop/pdfDeneme/kayit2.jpg",1);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }  
 
}