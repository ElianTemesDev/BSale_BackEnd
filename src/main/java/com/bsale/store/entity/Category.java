package com.bsale.store.entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name="category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
