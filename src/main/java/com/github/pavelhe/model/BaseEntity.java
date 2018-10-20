package com.github.pavelhe.model;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import lombok.*;

@MappedSuperclass
@Getter
public abstract class BaseEntity implements Serializable {

    private final String uuid = UUID.randomUUID().toString();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BaseEntity that = (BaseEntity) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public String toString() {
        return "[" + getClass().getCanonicalName() + ",ID=" + id + ",UUID=" + uuid + "]";
    }
}
