import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by thelusms on 4/4/18.
 */

public class Question2 {

    Question2(){

    }

    //Didn't have time to clean up the profuse driver waits. The question was issued in 8 points
    //Please bear in mind that your IDE may need to be configured correctly to run this. Use the latest
    //chromedriver. Also I made this in Intellij and used the Test annotation from TestNG. Assuming you
    //run this method using those same resources, everything should check out and pass. The Question
    //specifies that this exercise has to run as an automated test, so I opted to use the test annotation

    //Author: Sidney Thelusma
    //Date: 4/5/18

    @Test
    public void question2Exercise(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.weightwatchers.com/us/"); //Point 1
        try {
            synchronized (driver) {
                driver.wait(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(driver.getTitle().equals("Weight Loss Program, Recipes & Help | Weight Watchers")){//Point 2
            System.out.println("Page has expected title.");
        }
        else{
            System.out.println("Page title was not expected.");
        }
        driver.findElement(By.className("find-a-meeting")).click(); //Point 3
        try {
            synchronized (driver) {
                driver.wait(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver.getTitle().contains("Get Schedules & Times Near You")) {//Point 4
            System.out.println("Page title contains expected string.");
        } else {
            System.out.println("Page title does not contain expected String.");
        }

        driver.findElement(By.id("meetingSearch")).sendKeys("10011", Keys.RETURN);//Point 5

        try {
            synchronized (driver) {
                driver.wait(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String locationName = driver.findElement(By.cssSelector("div.meeting-locations-list > div:nth-child(1)" +
                "> result-location > div.meeting-location > div.meeting-location__top > a > location-address > " +
                "div.location > div.location__container > div.location__top > div.location__name > span")).getText();

        System.out.println(locationName);//Point 6 part 1

        System.out.println(driver.findElement(By.cssSelector("div.meeting-locations-list > div:nth-child(1)" +
                "> result-location > div.meeting-location > div.meeting-location__top > a > location-address > " +
                "div.location > div.location__container > div.location__top > div.location__distance")).getText());
        //Point 6 part 2


        driver.findElement(By.cssSelector("div.meeting-locations-list > div:nth-child(1)")).click();//Point 7

        try {
            synchronized (driver) {
                driver.wait(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String newPageLocationName = driver.findElement(By.cssSelector("div.location__name > span")).getText();

        if(locationName.equals(newPageLocationName)){
            System.out.println("This location name matches the location name on the previous page.");
        }

        String dayOfTheWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(Calendar.getInstance().getTime());

        List<WebElement> daysOfOperatingHours = driver.findElements(By.className("hours-list-item-wrapper"));
        for(WebElement day : daysOfOperatingHours){
            if (day.findElement(By.className("hours-list-item-day")).getText().equals(dayOfTheWeek)){
                System.out.println(day.getText());//Point 8
            }
        }
        driver.close();
    }
}
