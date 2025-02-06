package com.example.profiles.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sortable {
    @Id
    @OneToOne(mappedBy = "sortable", orphanRemoval = true)
    private Account account;

    private String value;

    @Column(nullable = false)
    private Integer sorterIndex;
}
