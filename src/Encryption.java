import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Encryption extends ImageProcess {
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

    static File file = new File("cat.jpg");
    static BufferedImage img;
    static {
        try {
            img = ImageIO.read(file);
            validateImageSize(img);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (ImageSizeException e) {
            throw new RuntimeException(e);
        }
    }    public String inputMessage(){
        System.out.println("Enter the message you want to hide (Must be 1-255 character long):");
        String message = sc.nextLine();
        System.out.println("Message length: " + message.length());
        while(message.isEmpty() || message.length()>255){
            System.out.println("Enter a String with length 1-255:");
            message = sc.nextLine();
        }
        return message;
    }

    public int targetBlueValueCreator(int messageLength){
        int targetBlueValue = rand.nextInt(256);
        while(targetBlueValue == messageLength){
            System.out.println("Invalid entry.");
            targetBlueValue = rand.nextInt(256);
        }
        return targetBlueValue;
    }

    public int[] uniqueElementArrayCreator(int messageLength){
        int[] uniqueArray = new int[messageLength];
        uniqueArray[0] = rand.nextInt(256);
        for (int i = 1; i < uniqueArray.length; i++) {
            boolean unique = true;
            while (unique) {
                unique = false;
                uniqueArray[i] = rand.nextInt(256);
                for (int j = 1; j < i; j++) {
                    if (uniqueArray[i] == uniqueArray[j]) {
                        unique = true;
                        break;
                    }
                }
            }
        }
        return uniqueArray;
    }
    public int[] bubbleSort(int[] randomArrays) {
        int temp = 0;
        int n = randomArrays.length;
        for(int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (randomArrays[j - 1] > randomArrays[j]) {
                    // swap elements
                    temp = randomArrays[j - 1];
                    randomArrays[j - 1] = randomArrays[j];
                    randomArrays[j] = temp;
                }
            }
        }
        return randomArrays;
    }
    public int[][][] pixelTargetBlueChanger(BufferedImage img,int [][][]pixelArray, int targetBlueValue){
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                if(pixelArray[x][y][2] == targetBlueValue){
                    if(targetBlueValue == 255){
                        pixelArray[x][y][2]--;
                    }
                    else{
                        pixelArray[x][y][2]++;
                    }
                }
            }
        }
        pixelArray[0][0][0] = message.length();
        pixelArray[0][0][1] = targetBlueValue;
        return pixelArray;
    }


    public int[][] randomPixelCreator(int messageLength){
        int [][]randomPixels = new int[messageLength][2];
        for (int i = 0; i < messageLength; i++) {
            boolean unique = false;
            while (!unique) {
                unique = true;//Hello World
                randomPixels[i][0] = rand.nextInt(img.getWidth());
                randomPixels[i][1] = rand.nextInt(img.getHeight());
                while(randomPixels[i][0] == 0 && randomPixels[i][1] == 0) {
                    randomPixels[i][0] = rand.nextInt(img.getWidth());
                    randomPixels[i][1] = rand.nextInt(img.getHeight());
                }
                for (int j = 0; j < i; j++) {
                    if (randomPixels[i][0] == randomPixels[j][0] && randomPixels[i][1] == randomPixels[j][1]) {
                        unique = false;
                        break;
                    }
                }
            }
        }
        return randomPixels;
    }

    public int [][][]imagePixelChanger(int[][][] designedArray, int[][] randomPixels, int[] randomArray, int targetBlueValue, String message){
        for(int i=0; i<message.length(); i++){
            int x = randomPixels[i][0];//34
            int y = randomPixels[i][1];//49

            char ascii = message.charAt(i);

            designedArray [x][y][0] = randomArray[i];
            designedArray [x][y][1] = ascii;
            designedArray [x][y][2] = targetBlueValue;
        }
        return designedArray;
    }

    public void imageEncryptor(){
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                int rgb = (changedPixelArray[x][y][0] << 16 | changedPixelArray[x][y][1] << 8 | changedPixelArray[x][y][2]);

                img.setRGB(x,y,rgb);
            }
        }

        try{
            file = new File("C:/Users/yaman/Desktop/cat - Copy2.png");
            ImageIO.write(img, "png", file);
        }
        catch(IOException e) {
            System.out.println("Error writing image: " + e);
        }
        System.out.println("Image encrypted successfully.");
    }

    protected String message = inputMessage();
    private int targetBlueValue = targetBlueValueCreator(message.length());
    private int[] randomArray = uniqueElementArrayCreator(message.length());
    protected int [] sortedArray = bubbleSort(randomArray);
    private int [][][] pixelArray = getPixelArray(img);
    private int [][][] designedArray = pixelTargetBlueChanger(img, pixelArray, targetBlueValue);
    private int [][] randomPixelArray = randomPixelCreator(message.length());
    private int [][][] changedPixelArray = imagePixelChanger(designedArray, randomPixelArray ,randomArray, targetBlueValue, message);

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTargetBlueValue() {
        return targetBlueValue;
    }

    public void setTargetBlueValue(int targetBlueValue) {
        this.targetBlueValue = targetBlueValue;
    }

    public int[] getRandomArray() {
        return randomArray;
    }

    public void setRandomArray(int[] randomArray) {
        this.randomArray = randomArray;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }

    public int[][][] getPixelArray() {
        return pixelArray;
    }

    public void setPixelArray(int[][][] pixelArray) {
        this.pixelArray = pixelArray;
    }

    public int[][][] getDesignedArray() {
        return designedArray;
    }

    public void setDesignedArray(int[][][] designedArray) {
        this.designedArray = designedArray;
    }

    public int[][] getRandomPixelArray() {
        return randomPixelArray;
    }

    public void setRandomPixelArray(int[][] randomPixelArray) {
        this.randomPixelArray = randomPixelArray;
    }

    public int[][][] getChangedPixelArray() {
        return changedPixelArray;
    }

    public void setChangedPixelArray(int[][][] changedPixelArray) {
        this.changedPixelArray = changedPixelArray;
    }
}