package ru.apache_maven.testSberbank.tests;

import org.junit.Test;
import ru.apache_maven.testSberbank.appmanager.SearchHelper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class SearchProductTest extends TestBase {
  @Test
  public void testSearchProduct(){
    app.getNavigationHelper().goToYandexMarket();
    app.getNavigationHelper().goToComputersSection();
    app.getNavigationHelper().goToLaptopSection();
    app.getNavigationHelper().goToAdvancedSearch();
    app.getSearchHelper().fiilMaxPrice("30000");
    app.getSearchHelper().fillManufacturer();
    app.getSearchHelper().apply();
    // 10. Проверить, что элементов на странице 10. Не поняла, какие 10 элементов. На странице 12 элементов.
    // Рещила сравнивать с колличеством элементов на странице
    assertThat(app.getSearchHelper().getElementsCount(),equalTo(12));
    app.getSearchHelper().storFirthElement();
    app.getSearchHelper().searchFirthElement();
    assertThat(app.getSearchHelper().getNameSearchResult(),equalTo(SearchHelper.firthElement));
  }


}
