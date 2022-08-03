package se.lexicon.springbootthymeleafproject.model.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(nullable = false, unique = true)
    private String name;


    public Category(String name) {
        this.name = name;
    }
}
