package com.diagnisis.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class DiagnosedIssues {

    @Id
    private Long id;


}
