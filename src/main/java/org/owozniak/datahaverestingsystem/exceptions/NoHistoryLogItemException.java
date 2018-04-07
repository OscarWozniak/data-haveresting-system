package org.owozniak.datahaverestingsystem.exceptions;

public class NoHistoryLogItemException extends Exception {

  public NoHistoryLogItemException(long id) {
    super("No user found with id: " + id);
  }
}
