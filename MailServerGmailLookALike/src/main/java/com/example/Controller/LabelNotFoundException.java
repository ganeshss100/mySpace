package com.example.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class LabelNotFoundException extends RuntimeException{


public LabelNotFoundException() {
super(String.format(" Label name cannot be empty"));

}

}
