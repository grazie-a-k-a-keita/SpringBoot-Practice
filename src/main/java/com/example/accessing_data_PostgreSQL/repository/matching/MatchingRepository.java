package com.example.accessing_data_PostgreSQL.repository.matching;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.accessing_data_PostgreSQL.model.matching.Matching;
import com.example.accessing_data_PostgreSQL.model.matching.MatchingId;

public interface MatchingRepository extends CrudRepository<Matching, MatchingId> {

  @Query(value = "SELECT * FROM Matching WHERE id = :id", nativeQuery = true)
  List<Matching> findByMatching(Integer id);
}
