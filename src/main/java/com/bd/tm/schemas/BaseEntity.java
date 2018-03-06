package com.bd.tm.schemas;

import java.io.Serializable;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

  private static final long serialVersionUID = 913906791104768399L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Override
  public String toString() {
    return String.format("id=%s", id);
  }
}
