/**
 * Class providing methods for receiving and saving images.
 * This code implements a static method to read an image from a file, 
 * save it to disk, and then return it as a BufferedImage object.
 * 
 * Author: Diego Montoya
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RecieveImage {
    
    /**
     * Static method to read an image from a file, save it to disk, and return it as a BufferedImage.
     * 
     * @param filePath The path of the image file to be read.
     * @return The BufferedImage object representing the image read from the file.
     */
    public static BufferedImage ReadandSaveImage(String filePath) {
        try {
            File file = new File(filePath);
            BufferedImage image = ImageIO.read(file);

            File outputImage = new File("PRUEBA.bmp");
            ImageIO.write(image, "bmp", outputImage);

            System.out.println("Image received correctly");

            return image; 
        } catch (IOException e) {
            System.out.println("Error receiving the image: " + e.getMessage());
            return null; 
        }
    }
}
