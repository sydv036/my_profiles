package com.example.profiles.entity;


import com.example.profiles.common.PrimaryKeyCommon;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Table(name = "Accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
//    @EmbeddedId
//    private PrimaryKeyCommon
}
