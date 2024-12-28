package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SysParam extends BaseEntity {
    public SysParam() {
        super("SYS");
    }

    @Column(unique = true)
    private String functionName;
    private String type;
    @Column(nullable = false)
    private String value;
    @Column(nullable = false)
    private String citizenCard;

    public SysParam(String functionName, String type, String value, String citizenCard) {
        super("SYS");
        this.functionName = functionName;
        this.type = type;
        this.value = value;
        this.citizenCard = citizenCard;
    }
}
