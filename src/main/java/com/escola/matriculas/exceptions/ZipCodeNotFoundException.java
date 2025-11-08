package com.escola.matriculas.exceptions;

public class ZipCodeNotFoundException extends RuntimeException{
    public ZipCodeNotFoundException(){super("Invalid ZIP code.!");}

    public ZipCodeNotFoundException(String message){super(message);}
}
