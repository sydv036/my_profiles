package com.example.profiles.base;

import com.example.profiles.common.GenPrimaryKey;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(columnDefinition = "varchar(13)", nullable = false)
    private String id;

    public BaseEntity(String keyID) {
        this.id = GenPrimaryKey.getPrimaryKey(keyID);
    }

}
