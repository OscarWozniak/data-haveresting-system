package org.owozniak.datahaverestingsystem.repositories;

import org.owozniak.datahaverestingsystem.entities.HistoryLinkedId;
import org.owozniak.datahaverestingsystem.entities.HistoryLogItem;
import org.springframework.data.repository.CrudRepository;

public interface HistoryLinkedInRepository extends CrudRepository<HistoryLinkedId, Long> {
}
