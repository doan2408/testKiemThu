package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selemium {

    WebDriver webDriver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }


    @Test
    @Order(1)
    void testSelemium() {
        webDriver.get("https://vitimex.com.vn/dang-ky.html");
        webDriver.findElement(By.id("name")).sendKeys("nguyen ba doan");
        webDriver.findElement(By.id("phone")).sendKeys("0999992922313132123");
        webDriver.findElement(By.id("email")).sendKeys("nguyen ba doan");
        webDriver.findElement(By.id("pass-regis")).sendKeys("nguyen ba doan");
        webDriver.findElement(By.id("pass-confirm")).sendKeys("nguyen ba doan");
        webDriver.findElement(By.id("register-btn")).click();
    }

    @Test
    @Order(2)
    void testSelemiumLogin() throws InterruptedException {
        webDriver.get("https://vitimex.com.vn/");
        webDriver.findElement(By.xpath("//div[@class='li_log']//a[@data-bs-toggle='modal']//*[name()='svg']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//input[@id='account']")).sendKeys("nguyenbadoan.qc2005@gmail.com");
        webDriver.findElement(By.xpath("//input[@id='pass']")).sendKeys("257257");
        webDriver.findElement(By.xpath("//*[@id=\"signin-btn\"]")).click();
        Thread.sleep(2000); //login xong đợi 2 giây cho load trang

        webDriver.findElement(By.xpath("//a[@class='item']//img[@title='Áo Len']")).click();

        webDriver.findElement(By.xpath("//a[2]//div[1]//img[2]")).click();
        webDriver.findElement(By.xpath("//a[@id='size1']")).click();
        webDriver.findElement(By.xpath("//a[@id='addCart_page0']")).click();

//        webDriver.findElement(By.xpath("//div[@id='slide-hbc-28']//div[7]//a[1]//div[1]//img[2]")).click();
//        Thread.sleep(2000);
////        webDriver.findElement(By.xpath("//a[1]//div[1]//img[2]")).click();
////        Thread.sleep(2000);
//        webDriver.findElement(By.xpath("//a[@id='size1']")).click();
//        webDriver.findElement(By.xpath("//a[@id='addCart_page0']")).click();
    }

}
