import java.awt.image.BufferedImage;
import java.io.File;
/**
 * Author: Diego Montoya
 */
public class App {
    public static void main(String[] args) {

    String filePath = "src/IMAGES/FOTO_04.bmp";
    String compressedFilePath = "compressed_image.Montoya";
    String decompressedFilePath = "decompressed_image.bmp";
    
        
        System.out.println("Attempting to load image from: " + new File(filePath).getAbsolutePath());
        BufferedImage bmpImage = RecieveImage.ReadandSaveImage(filePath);

        if (!VerifySize.Verify(bmpImage)) {
            System.out.println("Very small image, please select an image of at least 4x4 pixels.");
            return; 
        }


        Compression.compressImage(filePath, compressedFilePath);
        Decompress.decompressImage(compressedFilePath, decompressedFilePath);
        
        
    }
}
