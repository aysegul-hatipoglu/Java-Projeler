/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalımza;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DigitalImza{
    
	public void imzaEkrani(){
	
		JFrame frame = new JFrame("Lütfen Aşağıdaki Beyaz Alana imzanızı çiziniz");
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
		final PadDraw drawPad = new PadDraw(); //Pad draw yaratılır bu boya programıdır
		content.add(drawPad, BorderLayout.CENTER); //drawPad i merkeze ayarlar	
		
		JPanel panel = new JPanel();
	
		panel.setPreferredSize(new Dimension(100, 168));
		panel.setMinimumSize(new Dimension(32, 68));
		panel.setMaximumSize(new Dimension(132, 168));
             
		
		JButton clearButton = new JButton("Clear");
                JButton okButton = new JButton("Onayla");
                
		//creates the clear button and sets the text as "Clear"
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.clear();
			}
		});
		
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        String fileName = "C:/Users/MUTLU/Desktop/pdfDeneme/imza.jpg";
                        ScreenCapture sc = new ScreenCapture();
                        try {
                            sc.capture(fileName, 1);
                        } catch (Exception ex) {
                            Logger.getLogger(DigitalImza.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.setVisible(false);
		    }
		});

		panel.add(clearButton);
                panel.add(okButton);
		//adds the buttons to the panel
		
		content.add(panel, BorderLayout.WEST);
		//sets the panel to the left
		
		frame.setSize(800, 400);
		//sets the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//makes it so you can close
		frame.setVisible(true);
		//makes it so you can see it
	}
}


class PadDraw extends JComponent{
	Image image;
	//this is gonna be your image that you draw on
	Graphics2D graphics2D;
	//this is what we'll be using to draw on
	int currentX, currentY, oldX, oldY;
	//these are gonna hold our mouse coordinates

	//Now for the constructors
	public PadDraw(){
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		//if the mouse is pressed it sets the oldX & oldY
		//coordinates as the mouses x & y coordinates
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				currentX = e.getX();
				currentY = e.getY();
				if(graphics2D != null)
				graphics2D.drawLine(oldX, oldY, currentX, currentY);
				repaint();
				oldX = currentX;
				oldY = currentY;
			}

		});
		//while the mouse is dragged it sets currentX & currentY as the mouses x and y
		//then it draws a line at the coordinates
		//it repaints it and sets oldX and oldY as currentX and currentY
	}

	public void paintComponent(Graphics g){
		if(image == null){
			image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();

		}
		g.drawImage(image, 0, 0, null);
	}

	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}
	
}

    
class ScreenCapture {
     public void capture(String fileName, int second) throws Exception{
        (new Thread()).sleep(second*1000);
        int x = 110;
        int y = 40;
        int width = 500;
        int height = 350;
        BufferedImage screencapture = new Robot().createScreenCapture(
            new Rectangle(x, y, width, height) );
        File file = new File(fileName);
        ImageIO.write(screencapture, "jpg", file);
        
    }
}
    


