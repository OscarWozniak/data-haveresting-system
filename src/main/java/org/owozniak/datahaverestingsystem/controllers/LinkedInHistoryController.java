package org.owozniak.datahaverestingsystem.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.owozniak.datahaverestingsystem.entities.HistoryLinkedId;
import org.owozniak.datahaverestingsystem.exceptions.NoHistoryLogItemException;
import org.owozniak.datahaverestingsystem.repositories.HistoryLinkedInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LinkedInHistoryController {

  @Autowired
  HistoryLinkedInRepository repository;

  @GetMapping("history/linked-in")
  public Iterable<HistoryLinkedId> getLinkedInHistory() {
    return repository.findAll();
  }

  @GetMapping("history/linked-in/{id}")
  public HistoryLinkedId getHistoryLog(@PathVariable Long id) throws NoHistoryLogItemException {
    return repository
            .findById(id)
            .orElseThrow(() -> new NoHistoryLogItemException(id));
  }

  @DeleteMapping("history/linked-in/{id}")
  public void deleteHistory(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
