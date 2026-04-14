package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class App {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://automationexercise.com/product_details/1");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-default.cart")));
            addToCartButton.click();

            WebElement closeModalButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".close-modal")));
            closeModalButton.click();

            WebElement cartLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".shopping_cart a")));
            cartLink.click();

            System.out.println("Product added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
