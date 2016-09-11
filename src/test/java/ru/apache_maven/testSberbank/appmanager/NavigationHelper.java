package ru.apache_maven.testSberbank.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by azueva on 01.08.2016.
 */
public class NavigationHelper extends HelperBase {
  public NavigationHelper(WebDriver wd, WebDriverWait wait) {
    super(wd, wait);
  }

  public void goToYandexMarket() {
      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Маркет"))).click();
  }

  public void goToComputersSection() {
      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Компьютеры"))).click();
  }

  public void goToLaptopSection() {
      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Ноутбуки"))).click();
  }

  public void goToAdvancedSearch() {
      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Расширенный поиск →"))).click();
  }
}
