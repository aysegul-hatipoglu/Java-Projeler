import java.awt.image.BufferedImage;
import org.opencv.core.Core;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
 
public class VideoCap {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
 
    VideoCapture cap;
    Mat2Image mat2Img = new Mat2Image();
 
    VideoCap(){
        
        cap = new VideoCapture();
        //Bazı kameralarda sorun çıkartabileceği için boyutları oldukça küçük olarak ayarladım kameranıza göre hd olarak değiştirebilirsiniz
      	cap.set(Highgui.CV_CAP_PROP_FRAME_WIDTH, 50);
    	cap.set(Highgui.CV_CAP_PROP_FRAME_HEIGHT, 50);
        /*0 yaparsanız varsayılan kamera çalışır birden fazla kamera var ise 1 , 2 ,3 şeklinde numaları devam edektir. linux kullanıyorsanız lsusb ile bağlı usb kameraları görüntüleyebilirsiniz.*/
        cap.open(0);
    } 
 
    BufferedImage getOneFrame() {
        cap.read(mat2Img.mat);
        return mat2Img.getImage(mat2Img.mat);
    }
}