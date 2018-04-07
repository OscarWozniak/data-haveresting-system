package org.owozniak.datahaverestingsystem.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.owozniak.datahaverestingsystem.entities.HistoryTwitter;
import org.owozniak.datahaverestingsystem.exceptions.NoHistoryLogItemException;
import org.owozniak.datahaverestingsystem.repositories.HistoryTwitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TwitterHistoryController {

  @Autowired
  HistoryTwitterRepository repository;

  @GetMapping("history/twitter")
  public Iterable<HistoryTwitter> getLinkedInHistory() {
    return repository.findAll();
  }

  @GetMapping("history/twitter/{id}")
  public HistoryTwitter getHistoryLog(@PathVariable Long id) throws NoHistoryLogItemException {
    return repository.findById(id).orElseThrow(() -> new NoHistoryLogItemException(id));
  }

  @DeleteMapping("history/twitter/{id}")
  public void deleteHistory(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
