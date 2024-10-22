package hotel;

public class Hospede {
	String nome, checkIn, checkOut;

    public Hospede(String nome, String checkIn, String checkOut) {
        this.nome = nome;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getNome() {
        return nome;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }
}
