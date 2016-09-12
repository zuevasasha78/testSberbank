package ru.apache_maven.testSberbank.model;

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
