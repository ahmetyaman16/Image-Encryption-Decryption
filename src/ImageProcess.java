import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class ImageProcess {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();



    //Resimdeki her pikselin rgb değerini bir arraye atma
    public int[][][] getPixelArray(BufferedImage img) {
        int[][][] pixelArray = new int[img.getWidth()][img.getHeight()][3];
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                //Retrieving contents of a pixel
                int pixel = img.getRGB(x, y);
                //Creating a Color object from pixel value
                Color color = new Color(pixel, false);
                //Retrieving the R G B values
                pixelArray[x][y][0] = color.getRed();
                pixelArray[x][y][1] = color.getGreen();
                pixelArray[x][y][2] = color.getBlue();
            }
        }
        return pixelArray;
    }
}