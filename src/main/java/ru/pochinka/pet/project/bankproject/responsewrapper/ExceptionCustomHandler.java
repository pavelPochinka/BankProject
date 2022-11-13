package ru.pochinka.pet.project.bankproject.responsewrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.pochinka.pet.project.bankproject.exception.NotFoundException;
import ru.pochinka.pet.project.bankproject.exception.NotValidCurrencyException;
import ru.pochinka.pet.project.bankproject.exception.NotValidInputValueException;
import ru.pochinka.pet.project.bankproject.responsewrapper.view.ErrorView;

@RestControllerAdvice
@Slf4j
public class ExceptionCustomHandler {


    @ExceptionHandler({NotFoundException.class, NotValidCurrencyException.class, NotValidInputValueException.class,
            HttpMessageNotReadableException.class, HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorView exceptionHandler(RuntimeException e) {
        return new ErrorView(e.getLocalizedMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorView unexpectedExceptionHandler(Exception e) {
        Long numberError = getRandomIdError();
        log.error("Error's number: {}. Error's message: {}",
                numberError, e.getLocalizedMessage());
        return new ErrorView("An server error has occurred. Error's number: " + numberError);
    }

    private Long getRandomIdError() {
        return Math.round(Math.random()*100);
    }
}
