package hotel;

public class Quarto {
	int numero, disponibilidade;
    String tipo;
    double preco;

    public Quarto(int numero, String tipo, double preco, int disponibilidade) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponibilidade == 1;
    }

    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
