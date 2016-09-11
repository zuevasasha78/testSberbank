package ru.apache_maven.testSberbank.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;
import ru.apache_maven.testSberbank.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {
  protected static final ApplicationManager app
          = new ApplicationManager( System.getProperty( "browser", BrowserType.FIREFOX ) );

  @Before
  public void setUp() throws Exception {
    app.init();
  }

  @After
  public void tearDown() {
    app.stop();
  }
}
