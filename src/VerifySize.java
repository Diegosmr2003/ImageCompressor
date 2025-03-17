/**
 * Class providing methods to verify the size of an image.
 * This code implements a static method to check if an image has at least 
 * a specified minimum size.
 * 
 * Author: Diego Montoya
 */
import java.awt.image.BufferedImage;

public class VerifySize {
    
    /**
     * Static method that checks if an image has at least a specified minimum size.
     * 
     * @param image The BufferedImage image to be checked.
     * @return true if the image has at least the specified minimum size, false otherwise.
     */
    
    public static boolean Verify(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        
        return (width >= 4 && height >= 4);
    }
}
