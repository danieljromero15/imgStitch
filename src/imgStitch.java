import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class imgStitch {
    public static void main(String[] args) {
        try {
            BufferedImage combined = new BufferedImage(12 * 3000, 10 * 3000, BufferedImage.TYPE_INT_RGB); //crashes through intellij, need to use terminal with at least 4gb xmx
            for (int i = 0; i <= 9; i++) {
                for (int abc = 0; abc < 12; abc++) { //if(i==9 && abc == 11){} else {
                    String imgName = Integer.toString(i) + toChar(abc);
                    System.out.println("src: " + imgName);

                    BufferedImage source = ImageIO.read(new File("img\\" + imgName + ".png"));

                    /*int width = 12*3000;
                    //System.out.println(width);
                    //height = height*3000;
                    int height = 1*3000; //default 9*3000
                    combined  = resize(combined, width, height);*/ //This is useful when constantly expanding, but uses too much memory

                    Graphics g = combined.getGraphics();
                    g.drawImage(source, abc * 3000, i * 3000, null);
                    g.dispose();
                    //}
                }
            }
            //combined = resize(combined,12*3000, 9*3000);
            ImageIO.write(combined, "PNG", new File("img\\", "combined.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static char toChar(int a) {
        return (char) (a + 65);
    }

    /*public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }*/
}
