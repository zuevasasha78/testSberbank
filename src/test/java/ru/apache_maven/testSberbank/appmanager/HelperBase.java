package ru.apache_maven.testSberbank.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created by azueva on 01.08.2016.
 */
public class HelperBase {
  protected WebDriver wd;
  protected WebDriverWait wait;

  public HelperBase(WebDriver wd, WebDriverWait wait) {
    this.wd = wd;
    this.wait = wait;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void type(WebElement webElement, String text) {
    webElement.clear();
    webElement.sendKeys(text);
  }

  public void allertAccept(){
   try { wd.switchTo().alert().accept();
  } catch (NoAlertPresentException e){
     System.out.println("Алерта нет");
   }
  }

  protected void attach(By locator, File file) {
    if (file != null) {
      wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
  }



