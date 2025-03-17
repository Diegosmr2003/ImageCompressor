/**
 * Class providing methods to decompress images.
 * This code implements a static method to decompress an image that has been previously compressed.
 * 
 * Author: Diego Montoya
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Decompress {

    /**
     * Static method to decompress a previously compressed image.
     * Reads the compressed image,  takes the  width and height, and multiply it by 4, then restores the compressed pixels to their original positions in the decompressed image.
     * 
     * @param compressedFilePath Path of the compressed image file.
     * @param decompressedFilePath Path of the decompressed image file.
     */
    public static void decompressImage(String compressedFilePath, String decompressedFilePath) {
        try {
            BufferedImage compressedImage = ImageIO.read(new File(compressedFilePath));

            int compressedWidth = compressedImage.getWidth();
            int compressedHeight = compressedImage.getHeight();

            int decompressedWidth = compressedWidth * 4;
            int decompressedHeight = compressedHeight * 4;

            BufferedImage decompressedImage = new BufferedImage(decompressedWidth, decompressedHeight, BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < compressedHeight; y++) {
                for (int x = 0; x < compressedWidth; x++) {
                    int compressedRGB = compressedImage.getRGB(x, y);

                    for (int ay = 0; ay < 4; ay++) {
                        for (int ax = 0; ax < 4; ax++) {
                            decompressedImage.setRGB(x * 4 + ax, y * 4 + ay, compressedRGB);
                        }
                    }
                }
            }

            File decompressedFile = new File(decompressedFilePath);
            ImageIO.write(decompressedImage, "bmp", decompressedFile);

            System.out.println("The image has been decompressed successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
