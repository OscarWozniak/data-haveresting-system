package org.owozniak.datahaverestingsystem.repositories;

import org.owozniak.datahaverestingsystem.entities.HistoryLogItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoryRepository extends CrudRepository<HistoryLogItem, Long> {

//  List<HistoryLogItem> findAllTwitter();
//
//  List<HistoryLogItem> findAllLinkedIn();


}
