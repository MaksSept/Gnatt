package com.example.gantt.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Gantt {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long iud;
    private String type ;
    private String  startDate;
    private String  endDate;
    private String  parentUid ;

    public Gantt() {
    }
}
