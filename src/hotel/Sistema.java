package hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private ArrayList<Quarto> listaQuartos = new ArrayList<>();
    private ArrayList<Hospede> listaHospedes = new ArrayList<>();
    private ArrayList<Reserva> listaReservas = new ArrayList<>();
    
    public static void main(String[] args) {
        Sistema hotel = new Sistema();
        hotel.menuPrincipal();
    }

    private void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu do Hotel ===");
            System.out.println("[1] Cadastrar Quarto");
            System.out.println("[2] Cadastrar Hóspede");
            System.out.println("[3] Realizar Check-in");
            System.out.println("[4] Realizar Check-out");
            System.out.println("[5] Gerar Relatório de Ocupação");
            System.out.println("[6] Gerar Histórico de Reservas");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarQuarto(scanner);
                    break;
                case 2:
                    cadastrarHospede(scanner);
                    break;
                case 3:
                    realizarCheckIn(scanner);
                    break;
                case 4:
                    realizarCheckOut(scanner);
                    break;
                case 5:
                    relatorioOcupacao();
                    break;
                case 6:
                    historicoReservas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

    }

    private void cadastrarQuarto(Scanner scanner) {
        System.out.println("[Cadastro de Quarto]");
        System.out.print("Número do quarto: ");
        int numero = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Tipo do quarto: ");
        String tipo = scanner.nextLine();

        System.out.print("Preço diário: R$ ");
        double preco = scanner.nextDouble();

        System.out.print("Disponibilidade (1 - Disponível, 2 - Ocupado): ");
        int disponibilidade = scanner.nextInt();

        Quarto quarto = new Quarto(numero, tipo, preco, disponibilidade);
        listaQuartos.add(quarto);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    private void cadastrarHospede(Scanner scanner) {
        System.out.println("[Cadastro de Hóspede]");
        scanner.nextLine();
        System.out.print("Nome do hóspede: ");
        String nome = scanner.nextLine();

        System.out.print("Data de Check-in: ");
        String checkIn = scanner.nextLine();

        System.out.print("Data de Check-out: ");
        String checkOut = scanner.nextLine();

        Hospede hospede = new Hospede(nome, checkIn, checkOut);
        listaHospedes.add(hospede);
        System.out.println("Hóspede cadastrado com sucesso!");
    }

    private void realizarCheckIn(Scanner scanner) {
        System.out.println("[Check-in]");
        System.out.print("Número do quarto: ");
        int numeroQuarto = scanner.nextInt();

        for (Quarto quarto : listaQuartos) {
            if (quarto.getNumero() == numeroQuarto && quarto.isDisponivel()) {
                quarto.setDisponibilidade(2);
                Reserva reserva = new Reserva(quarto, listaHospedes.get(listaHospedes.size() - 1));
                listaReservas.add(reserva);
                System.out.println("Check-in realizado!");
                return;
            }
        }
        System.out.println("Quarto não está disponível.");
    }

    private void realizarCheckOut(Scanner scanner) {
        System.out.println("[Check-out]");
        System.out.print("Número do quarto: ");
        int numeroQuarto = scanner.nextInt();

        for (Quarto quarto : listaQuartos) {
            if (quarto.getNumero() == numeroQuarto && !quarto.isDisponivel()) {
                quarto.setDisponibilidade(1);
                System.out.println("Check-out realizado!");
                return;
            }
        }
        System.out.println("Quarto não está ocupado.");
    }

    private void relatorioOcupacao() {
        System.out.println("\nRelatório de Ocupação");
        for (Quarto quarto : listaQuartos) {
            if (!quarto.isDisponivel()) {
                System.out.println("Quarto N°" + quarto.getNumero() + " - Tipo: " + quarto.getTipo());
            }
        }
    }

    private void historicoReservas() {
        System.out.println("\nHistórico de Reservas");
        for (Reserva reserva : listaReservas) {
            System.out.println("Hóspede: " + reserva.getHospede().getNome() + 
                               ", Check-in: " + reserva.getCheckIn() + 
                               ", Check-out: " + reserva.getCheckOut());
        }
    }
}
