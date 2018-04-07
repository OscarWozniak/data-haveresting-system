package org.owozniak.datahaverestingsystem.controllers;

import org.owozniak.datahaverestingsystem.entities.HistoryLogItem;
import org.owozniak.datahaverestingsystem.exceptions.NoHistoryLogItemException;
import org.owozniak.datahaverestingsystem.repositories.HistoryRepository;
import org.owozniak.datahaverestingsystem.services.HistoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class HistoryController {

  @Autowired
  HistoryRepository repository;
  @Autowired
  HistoryService service;

  @GetMapping("history/linked-in")
  public List<HistoryLogItem> getLinkedInHistory() {
    return Collections.emptyList();

//    return repository.findAllLinkedIn();
  }

  @GetMapping("history/twitter")
  public List<HistoryLogItem> getTwitterHistory() {
    return Collections.emptyList();
//    return repository.findAllTwitter();
  }

  @GetMapping("history/{id}")
  public HistoryLogItem getHistoryLog(@PathVariable Long id) throws NoHistoryLogItemException {
    return service.get(id);
  }

  @DeleteMapping("history/{id}")
  public void deleteHistory(@PathVariable Long id) throws NoHistoryLogItemException {
    service.delete(id);
  }
}
