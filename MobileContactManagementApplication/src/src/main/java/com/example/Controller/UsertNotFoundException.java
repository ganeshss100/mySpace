package com.example.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UsertNotFoundException extends RuntimeException{

private String id;

public UsertNotFoundException(String id) {
super(String.format(" not found name : '%s'",id));
this.id=id;

}

public String getId() {
return this.id;
}

}
