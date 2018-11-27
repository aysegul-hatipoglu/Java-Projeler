/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


public class JavaPdfBoxCreateImage {
    
    public void pdfOlustur() throws IOException{
         try (PDDocument doc = new PDDocument()) { 

            PDPage myPage = new PDPage();
            doc.addPage(myPage);

            String imgFileName = "C:/Users/MUTLU/Desktop/pdfDeneme/kayit.jpg";
            PDImageXObject pdImage = PDImageXObject.createFromFile(imgFileName, doc);//PDImageXObject PDFBox'ta görüntülerle çalışmak için kullanılır.
            
            int iw = pdImage.getWidth();//Görüntünün genişliğini elde ederiz.
            int ih = pdImage.getHeight();//Görüntünün yüksekliğini elde ederiz 
            
            float offset = 20f; 

            //PDPageContentStream's drawImage() görüntüyü sayfaya çeker.
            try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {
                
                cont.drawImage(pdImage, offset, offset, iw-373, ih-220);//en dogrusu 2f, -150f, iw, ih
            }
            
            doc.save("C:/Users/MUTLU/Desktop/pdfDeneme/fatura.pdf");
            
            File f = new File(imgFileName); 
            if(!f.exists()){ // eğer dosya yoksa
                 
            }else{
                f.delete(); // eğer dosyamız varsa.. // silme işlemi gerçekleştirir.
                System.out.println("Dosya başarılı bir şekilde kaydedildi");
            }
                    
        }
    }
      
}
