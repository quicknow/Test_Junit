package cn.loryroad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {
    /**
     * @author Young
     * 
     */
    public static void addCookies() {

        //WebDriver driver = new ChromeDriver();
    	WebDriver driver = DriverFactory.create();
        driver.get("http://www.zhihu.com/#signin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement user = driver
                .findElement(By.xpath("//input[@name='email']"));
        user.clear();
        user.sendKeys("xiaozhuzhu7586@126.com");
        WebElement password = driver.findElement(By
                .xpath("//input[@name='password']"));
        password.clear();
        password.sendKeys("dulizizhu2007");

        WebElement submit = driver.findElement(By
                .xpath("//button[@class='sign-button']"));
        submit.submit();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        File file = new File("broswer.data");
        try {
            // delete file if exists
            file.delete();
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Cookie ck : driver.manage().getCookies()) {
                bw.write(ck.getName() + ";" + ck.getValue() + ";"
                        + ck.getDomain() + ";" + ck.getPath() + ";"
                        + ck.getExpiry() + ";" + ck.isSecure());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("cookie write to file");
        }
    }
}