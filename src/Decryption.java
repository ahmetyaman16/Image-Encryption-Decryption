import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Decryption extends ImageProcess {
    static class ImageSizeException extends Exception {
        public ImageSizeException(String message) {
            super(message);
        }
    }

    public static void validateImageSize(BufferedImage image) throws ImageSizeException {
        if (image.getWidth() > 128 || image.getHeight() > 128) {
            throw new ImageSizeException("Image dimensions exceed 50x50 pixels.");
        }
    }

    static File file = new File("C:/Users/yaman/Desktop/cat - Copy2.png");
    static BufferedImage decryptedImg;
    static {
        try {
            decryptedImg = ImageIO.read(file);
            validateImageSize(decryptedImg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (ImageSizeException e) {
            throw new RuntimeException(e);
        }
    }

    public int[][] bubbleSort(int[][] decryptMessage) {
        int n = decryptMessage.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (decryptMessage[j][0] > decryptMessage[j + 1][0]) {
                    int[] temp = decryptMessage[j];
                    decryptMessage[j] = decryptMessage[j + 1];
                    decryptMessage[j + 1] = temp;
                }
            }
        }
        return decryptMessage;
    }

    // Decrypting the message from the pixel array
    public int[][] messageDecryptor(int[][][] pixelArray) {
        int[][] decryptedMessage = new int[messageLength][2];
        int k = 0;
        for (int i = 0; i < decryptedImg.getWidth(); i++) {
            for (int j = 0; j < decryptedImg.getHeight(); j++) {
                if (pixelArray[i][j][2] == targetBlueValue) {
                    decryptedMessage[k][0] = pixelArray[i][j][0];
                    decryptedMessage[k][1] = pixelArray[i][j][1];
                    k++;
                }
                if (k == messageLength) {
                    break;
                }
            }
            if (k == messageLength) {
                break;
            }
        }
        return decryptedMessage;
    }

    public int []asciiArrayDecryption(int[][] decryptMessage) {
        int[] asciiArray = new int[decryptMessage.length];
        for (int i = 0; i < decryptMessage.length; i++) {
            asciiArray[i] = sortedDecryptedMessage[i][1];
        }
        return asciiArray;
    }
    public String asciiArrayToString(int[] asciiArray) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < asciiArray.length; i++) {
            message.append((char) asciiArray[i]);
        }
        return message.toString();
    }


    protected int [][][] pixelArray = getPixelArray(decryptedImg);
    private int messageLength = pixelArray[0][0][0];
    private int targetBlueValue = pixelArray[0][0][1];
    private int [][] decryptMessage = messageDecryptor(pixelArray);
    private int [][] sortedDecryptedMessage = bubbleSort(decryptMessage);
    protected int [] asciiArray = asciiArrayDecryption(decryptMessage);
    private String hiddenMessage = asciiArrayToString(asciiArray);

    public int[][][] getPixelArray() {
        return pixelArray;
    }

    public void setPixelArray(int[][][] pixelArray) {
        this.pixelArray = pixelArray;
    }

    public int getMessageLength() {
        return messageLength;
    }

    public void setMessageLength(int messageLength) {
        this.messageLength = messageLength;
    }

    public int getTargetBlueValue() {
        return targetBlueValue;
    }

    public void setTargetBlueValue(int targetBlueValue) {
        this.targetBlueValue = targetBlueValue;
    }

    public int[][] getDecryptMessage() {
        return decryptMessage;
    }

    public void setDecryptMessage(int[][] decryptMessage) {
        this.decryptMessage = decryptMessage;
    }

    public int[][] getSortedDecryptedMessage() {
        return sortedDecryptedMessage;
    }

    public void setSortedDecryptedMessage(int[][] sortedDecryptedMessage) {
        this.sortedDecryptedMessage = sortedDecryptedMessage;
    }

    public int[] getAsciiArray() {
        return asciiArray;
    }

    public void setAsciiArray(int[] asciiArray) {
        this.asciiArray = asciiArray;
    }

    public String getHiddenMessage() {
        return hiddenMessage;
    }

    public void setHiddenMessage(String hiddenMessage) {
        this.hiddenMessage = hiddenMessage;
    }
}