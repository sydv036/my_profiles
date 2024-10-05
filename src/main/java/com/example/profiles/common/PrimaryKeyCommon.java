package com.example.profiles.common;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;

@Embeddable
public class PrimaryKeyCommon {
    private String id;
}
