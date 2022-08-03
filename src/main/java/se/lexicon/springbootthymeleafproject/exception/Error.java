package se.lexicon.springbootthymeleafproject.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Error {

    private String Code;
    private String Message;
    private final LocalDateTime dateTime;


    public Error() {

        dateTime = LocalDateTime.now();

    }

    public Error(String code, String message) {
        this();
        Code = code;
        Message = message;
    }


}
