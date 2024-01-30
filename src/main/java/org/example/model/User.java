package org.example.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class User {
    String id;
    String name;
    int credit;
}
