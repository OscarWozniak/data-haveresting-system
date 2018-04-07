package org.owozniak.datahaverestingsystem.utils;

import org.openqa.selenium.WebElement;

import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class OptionalUtils {

  public static <T> Optional<T> get(Supplier<T> supplier) {
    try {
      return ofNullable(supplier.get());
    } catch (Exception e) {
      return empty();
    }
  }

  public static <T> T get(Supplier<T> supplier, T defaultValue) {
    try {
      return supplier.get();
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static String text(Supplier<WebElement> supplier) {
    return get(() -> supplier.get().getText(), "");
  }

}
