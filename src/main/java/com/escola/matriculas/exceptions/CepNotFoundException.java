package com.escola.matriculas.exceptions;

public class CepNotFoundException extends RuntimeException{
    public CepNotFoundException(){super("CEP incorreto!");}

    public CepNotFoundException(String mensagem){super(mensagem);}
}
