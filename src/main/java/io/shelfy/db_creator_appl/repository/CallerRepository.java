package io.shelfy.db_creator_appl.repository;

import io.shelfy.db_creator_appl.entities.Caller;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CallerRepository extends JpaRepository<Caller, Long> {

}

