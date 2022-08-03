package se.lexicon.springbootthymeleafproject.model.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryForm {

    @NotEmpty
    @Size(min = 2, max = 20)
    private String name;
}
