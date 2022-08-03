package se.lexicon.springbootthymeleafproject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView illegalArgumentException(IllegalArgumentException exception){

        System.out.println("_________");

        Error customError = new Error("440", "Argument Exception");
        return new ModelAndView("custom-error", "error", customError);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception exception){
        return new ModelAndView("custom-error", "error", "UNEXPECTED ERROR");
    }

}
