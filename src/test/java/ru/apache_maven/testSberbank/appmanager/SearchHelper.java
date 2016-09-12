package ru.apache_maven.testSberbank.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchHelper extends HelperBase {
  public SearchHelper (WebDriver wd, WebDriverWait wait){super(wd, wait);}

  public static String firthElement = null;

  public void fillManufacturer() {
    click(By.id("glf-1801946-1870091"));
    click(By.id("glf-1801946-1871127"));
  }

  public void apply() {
    click(By.xpath("//div[@class='n-filter-panel-aside__apply']//button[.='Применить']"));
  }

  public void storFirthElement() {
    firthElement = wd.findElement
            (By.xpath("//div[2]/div[1]/div[1]/div[3]/div/div[1]/div/h3/a/span")).getText();
  }

  public void searchFirthElement() {
    type(By.id("header-search"), firthElement);
    click(By.xpath("html/body/div[1]/div[1]/noindex/div/div/div[2]/div/div[1]/form/span/button"));
  }

  public void find() {
  }

  public void fiilMaxPrice(String price) {
    type(By.id("glf-priceto-var"), price);
  }

  public int getElementsCount(){
    return wd.findElements(By.xpath("//div[@class='snippet-card clearfix i-bem snippet-card_js_inited']")).size();

  }

  public String getNameSearchResult() {
    return wd.findElement(By.cssSelector("h1.title")).getText();
  }
}
