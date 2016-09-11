package ru.apache_maven.testSberbank.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationManager {

  WebDriver wd;
  WebDriverWait wait;

  private NavigationHelper navigationHelper;
  private SearchHelper searchHelper;
  public String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() throws IOException {

    if (browser.equals(BrowserType.FIREFOX)) {
      FirefoxProfile profile = new ProfilesIni().getProfile("UserForTest");
      wd = new FirefoxDriver(profile);
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wait = new WebDriverWait(wd, 20);
    wd.get("https://yandex.ru/");
    wd.manage().window().maximize();
    navigationHelper = new NavigationHelper(wd, wait);
    searchHelper = new SearchHelper(wd, wait);
  }

  public void stop() {
    wd.quit();
  }

  public SearchHelper getSearchHelper(){return searchHelper;}

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
