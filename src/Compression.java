/**
 * Class providing methods for image compression.
 * This code implements a compression algorithm that reduces the resolution of the image 
 * by dividing it into 4x4 pixel groups and calculating the average color of each group.
 * The final result is a compressed image with reduced size.
 * 
 * Author: Diego Montoya
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Compression {

    /**
     * Method to compress an image.
     * Reads the original image, calculates the average color of each 4x4 adjacent pixel group,
     * and creates a new compressed image using these average values.
     * 
     * @param originalFilePath Path of the original image file.
     * @param compressedFilePath Path of the compressed image file.
     */
    public static void compressImage(String originalFilePath, String compressedFilePath) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(originalFilePath));

            int compressedWidth = originalImage.getWidth() / 4;
            int compressedHeight = originalImage.getHeight() / 4;

            BufferedImage compressedImage = new BufferedImage(compressedWidth, compressedHeight, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < compressedWidth; x++) {
                for (int y = 0; y < compressedHeight; y++) {
                    int redSummatory = 0, greenSummatory = 0, blueSummatory = 0;
                    
                    for (int ay = 0; ay < 2; ay++) {
                        for (int ax = 0; ax < 2; ax++) {
                            int pixel = originalImage.getRGB(x * 4 + ax, y * 4 + ay);
                            redSummatory += (pixel >> 16) & 0xFF;
                            greenSummatory += (pixel >> 8) & 0xFF;
                            blueSummatory += pixel & 0xFF;
                        }
                    }

                    int averageRed = redSummatory / 4;
                    int averageGreen = greenSummatory / 4;
                    int averageBlue = blueSummatory / 4;

                    int compressedRGB = (averageRed << 16) | (averageGreen << 8) | averageBlue;

                    compressedImage.setRGB(x, y, compressedRGB);
                }
            }

            File compressedFile = new File(compressedFilePath);
            ImageIO.write(compressedImage, "bmp", compressedFile);

            System.out.println("The image has been compressed successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
