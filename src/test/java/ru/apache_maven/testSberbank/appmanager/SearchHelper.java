package ru.apache_maven.testSberbank.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by azueva on 09.09.2016.
 */
public class SearchHelper extends HelperBase {
  public SearchHelper (WebDriver wd, WebDriverWait wait){super(wd, wait);}

  public static String firthElement;

  public void fillManufacturer() {
    click(By.id("glf-1801946-1870091"));
    click(By.id("glf-1801946-1871127"));
  }

  public void apply() {
    click(By.xpath("//div[@class='n-filter-panel-aside__apply']//button[.='Применить']"));
  }

  public void storFirthElement() {
    try {
      wd.findElement(By.xpath("//div[@class='serp-empty__wrapper']//div[.='Нет подходящих товаров']"));
    } catch (NoAlertPresentException e){
      System.out.println("Ничего не нравиться");
    }
    firthElement = wd.findElement(By.cssSelector("span.snippet-card__header-text.firepath-matching-node")).getText();
  }

  public void fillSearch() {
    type(By.id("header-search"), firthElement);
    click(By.className("button button_size_m button_side_right button_focus_thin button_theme_normal i-bem button_js_inited button_focused_yes"));
  }

  public void find() {
  }

  public void fiilMaxPrice(String price) {
    type(By.id("glf-priceto-var"), price);
  }

  public List<WebElement> getElementsList(){
    List<WebElement> elements =  wd.findElements(By.className("snippet-card clearfix i-bem snippet-card_js_inited"));
    return elements;
  }

  public String getNameSearchResult() {
    return wd.findElement(By.cssSelector("h1.title")).getText();
  }
}
