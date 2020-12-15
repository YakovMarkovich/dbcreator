package io.shelfy.db_creator_appl.repository;

import io.shelfy.db_creator_appl.entities.Call;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallRepository extends JpaRepository<Call, Long> {

}

