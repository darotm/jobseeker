package selenium;

import com.github.metalloid.webdriver.WebDriverPool;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class ScreenshotDriver {
    private static final Logger logger = LogManager.getLogger(ScreenshotDriver.class);
    private static File screenshot;
    private static LocalTime timestamp = LocalTime.now();

    public static void takeScreenshot(String className, String method, Throwable e) {
        WebDriver driver = WebDriverPool.get();
        if(driver instanceof TakesScreenshot){
            TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
            try {
                File localScreenshots = new File(("target"), "screenshots");
                if (!localScreenshots.isFile() || !localScreenshots.isDirectory()) {
                    localScreenshots.mkdirs();
                }
                screenshot = new File(localScreenshots, className + "_" + method + "_" + timestamp.getHour() + ":" + timestamp.getMinute() + ":" + timestamp.getSecond() + ".png");
                try {
                    FileUtils.moveFile(takesScreenshot.getScreenshotAs(OutputType.FILE), screenshot);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                logger.info("Screenshot for class={} method={} saved in: {}" + className + " " + method + " " + screenshot.getAbsolutePath());
            } catch (Exception e1){
                logger.error("Unable to take screenshot"+ e1);
            }
        }else{
            logger.info("Driver '{}' can't take screenshots so skipping it." + driver.getClass() + e);
        }
    }

    public static String getScreenshot() {
        logger.info("Get screenshot" + screenshot.getName());
        return screenshot.getAbsolutePath();
    }

}
