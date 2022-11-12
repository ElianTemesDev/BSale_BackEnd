package com.bsale.store.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@Entity(name="product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private int discount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category")
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
