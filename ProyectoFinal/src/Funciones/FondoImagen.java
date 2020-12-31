package Funciones;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;


public class FondoImagen implements Border{
    public BufferedImage back;

    public FondoImagen(String img){
        try {
            URL imagePath = new URL(getClass().getResource(img).toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {
        }
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, x, y, width,height,null);
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    public boolean isBorderOpaque() {
        return false;
    }

}