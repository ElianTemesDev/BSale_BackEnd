package com.bsale.store.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;
}
