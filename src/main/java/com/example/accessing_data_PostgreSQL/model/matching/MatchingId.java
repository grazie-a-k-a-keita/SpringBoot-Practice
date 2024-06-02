package com.example.accessing_data_PostgreSQL.model.matching;

import java.io.Serializable;

public class MatchingId implements Serializable {
  private Integer id;
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
