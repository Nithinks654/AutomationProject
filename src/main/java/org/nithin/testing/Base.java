package org.nithin.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Base {

    public static String randomEmailGenerator() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i <= 5; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return "test" + randomString + timeStamp + "@gmail.com";
    }

    public static Select dropDown(WebElement ele) {

        Select drpdown = new Select(ele);
        return drpdown;

    }
}
