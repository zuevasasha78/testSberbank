package ru.apache_maven.testSberbank.model;

/**
 * Created by azueva on 09.09.2016.
 */
public class PriceData {
  private String price;

  public String getPrice() {
    return price;
  }

  public PriceData withMaxPrice(String price) {
    this.price = price;
    return this;
  }
}
