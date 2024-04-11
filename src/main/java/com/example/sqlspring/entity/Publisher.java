package com.example.sqlspring.entity;

import jakarta.persistence.*;
import lombok.*;

//@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "publisher")
    private Book book;

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
