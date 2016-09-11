package ru.apache_maven.testSberbank.tests;

import org.junit.Test;
import ru.apache_maven.testSberbank.appmanager.SearchHelper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by azueva on 09.09.2016.
 */
public class SearchProductTest extends TestBase {
  @Test
  public void testSearchProduct(){
    //1. Открыть браузер и развернуть на весь экран.
    app.getNavigationHelper().goToYandexMarket();
    app.getNavigationHelper().goToComputersSection();
    app.getNavigationHelper().goToLaptopSection();
    app.getNavigationHelper().goToAdvancedSearch();
    app.getSearchHelper().fiilMaxPrice("30000");
    app.getSearchHelper().fillManufacturer();
    app.getSearchHelper().apply();
   // 10. Проверить, что элементов на странице 10.
    assertThat(app.getSearchHelper().getElementsList().size(),equalTo(12));
    //11. Запомнить первый элемент в списке.
    app.getSearchHelper().storFirthElement();
   // 12. В поисковую строку ввести запомненное значение. переименовать
    app.getSearchHelper().fillSearch();
  //  13. Найти и проверить, что наименование товара соответствует запомненному значению.
    assertThat(app.getSearchHelper().getNameSearchResult(),equalTo(SearchHelper.firthElement));
  }


}
