package com.github.pavelhe.model;

import java.math.*;
import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    private BigDecimal amount;
    private String description;
}
