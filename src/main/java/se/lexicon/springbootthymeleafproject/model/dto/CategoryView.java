package se.lexicon.springbootthymeleafproject.model.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryView {

    private int id;
    private String categoryName;
    private LocalDate createDate;

}
