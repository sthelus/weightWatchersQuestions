import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by thelusms on 4/4/18.
 */

public class Question2 {

    Question2(){

    }

    public void navigateToWebPage(String url){
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        try {
            synchronized (driver) {
                driver.wait(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }



    public static void main(String args[]){
        Question2 q2 = new Question2();
        q2.navigateToWebPage("https://google.com");


    }
}
