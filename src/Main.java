import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StartDownload();
    }
    public  static  void StartDownload() {
        try {
            File myObj = new File("src/stickers_url.txt");
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            while (myReader.hasNextLine()) {
                count += 1;
                String dataUrl = myReader.nextLine();
                System.out.println(dataUrl);
                DownloadImage(
                        dataUrl,
                        "src/stickers/",
                        String.valueOf(count)
                );
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void DownloadImage(String imageUrl, String path, String filename) {
        BufferedImage image = null;
        try {
            URL url = new URL(imageUrl);
            image = ImageIO.read(url);
            ImageIO.write(image, "png", new File(path + filename + ".png"));
            System.out.println("done " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}