package org.owozniak.datahaverestingsystem.services;

import org.owozniak.datahaverestingsystem.entities.HistoryLogItem;
import org.owozniak.datahaverestingsystem.exceptions.NoHistoryLogItemException;
import org.owozniak.datahaverestingsystem.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
  @Autowired
  HistoryRepository repository;


  public HistoryLogItem get(long id) throws NoHistoryLogItemException {
    return repository
            .findById(id)
            .orElseThrow(() -> new NoHistoryLogItemException(id));
  }

  public void delete(long id) throws NoHistoryLogItemException {
    repository.delete(get(id));
  }
}
