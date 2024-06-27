package main.java.usp.mac321.ep2;

public class LeitorException extends RuntimeException {
    private String mensagem;

    LeitorException(String s) {
        this.mensagem = s;
    }

    public String toString() {
        return("LeitorException: " + mensagem);
    }
}
