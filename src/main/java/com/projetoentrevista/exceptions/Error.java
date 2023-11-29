package com.projetoentrevista.exceptions;

public class Error {

    private String mensagem;

    public Error() {
    }

    public Error(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
