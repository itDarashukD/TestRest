package com.darashuk.spring.rest.exeption_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    //метод обработчик исключений  - если нет такого id
    //при срабатывании Exception - оно передается в параметры метода, дальше в объект нами созданного класса,
    // дальше в объект класса ResponseEntity

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handlException(Exception exception){

        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(exception.getMessage());

        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);

    }
}
