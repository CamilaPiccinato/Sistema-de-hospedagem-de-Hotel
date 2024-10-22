package hotel;

public class Reserva {
	Quarto quarto;
    Hospede hospede;

    public Reserva(Quarto quarto, Hospede hospede) {
        this.quarto = quarto;
        this.hospede = hospede;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public String getCheckIn() {
        return hospede.getCheckIn();
    }

    public String getCheckOut() {
        return hospede.getCheckOut();
    }
}
