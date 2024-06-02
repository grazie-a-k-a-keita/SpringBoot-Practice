package com.example.accessing_data_PostgreSQL.model.matching;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(MatchingId.class)
public class Matching {
  @Id
  private Integer id;
  @Id
  private Integer subId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSubId() {
    return subId;
  }

  public void setSubId(Integer subId) {
    this.subId = subId;
  }

}
