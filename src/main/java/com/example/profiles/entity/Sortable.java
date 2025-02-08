package com.example.profiles.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Sortable {
    @Id
    private String id;

    private String value;

    @Column(nullable = false)
    private Integer flag;

}
