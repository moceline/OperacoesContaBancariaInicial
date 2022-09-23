import java.util.Scanner;
import java.util.ArrayList;

public class AgenciaBancaria {

    static ArrayList<ContaBancaria> contas;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        contas = new ArrayList<ContaBancaria>();
        principal();
    }

    public static void principal() {
        System.out.println("----------------------------------------------------------");
        System.out.println("--------------- Agência Bancária -------------------------");
        System.out.println("----------------------------------------------------------");
        System.out.println("-- Digite a operação que deseja utilizar -----------------");
        System.out.println("----------------------------------------------------------");
        System.out.println("|  Opção 1--> Criar Conta       |");
        System.out.println("|  Opção 2--> Depositar valor   |");
        System.out.println("|  Opção 3--> Sacar valor       |");
        System.out.println("|  Opção 4--> Transferir valor  |");
        System.out.println("|  Opção 5--> Listar Contas     |");
        System.out.println("|  Opção 6--> Sair              |");

        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;

            case 5:
                listar();
                break;

            case 6:
                System.out.println("Transação finalizada. Obrigado!");
                System.exit(0);

            default:
                System.out.println("Opção inválida.Tente novamente!");
                principal();
                break;

        }

    }

    public static void criarConta() {

        System.out.println("\nNome:");
        String nome = input.next();

        System.out.println("\nCPF:");
        String cpf = input.next();

        System.out.println("\nE-mail:");
        String email = input.next();

        Cliente cliente = new Cliente(nome, cpf, email);
        ContaBancaria conta = new ContaBancaria(cliente);

        contas.add(conta);
        System.out.println("Conta criada com sucesso!");

        principal();

    }

    public static ContaBancaria encontrarConta(int numeroConta) {
        ContaBancaria conta = null;
        if (contas.size() > 0) {
            for (ContaBancaria c : contas) {
                if (c.getnumeroConta() == numeroConta)
                    conta = c;

            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta:");
        int numeroConta = input.nextInt();

        ContaBancaria c = encontrarConta(numeroConta);
        if (c != null) {
            System.out.println("Valor:");
            Double valor = input.nextDouble();
            c.depositar(valor);
        } else {
            System.out.println("Conta não encontrada!");
        }
        principal();

    }

    public static void sacar() {
        System.out.println("Número da conta:");
        int numeroConta = input.nextInt();

        ContaBancaria c = encontrarConta(numeroConta);

        if (c != null) {
            System.out.println("Valor:");
            Double valor = input.nextDouble();
            c.sacar(valor);
        } else {
            System.out.println("Conta não encontrada!");
        }
        principal();
    }

    public static void transferir() {
        System.out.println("Número da conta origem: ");

        int numeroContaOrigem = input.nextInt();
        ContaBancaria contaOrigem = encontrarConta(numeroContaOrigem);

        if (contaOrigem != null) {
            System.out.println("Número da conta Destino: ");
            int numeroContaDestino = input.nextInt();

            ContaBancaria contaDestino = encontrarConta(numeroContaDestino);

            if (contaDestino != null) {
                System.out.println("Valor: ");
                Double valor = input.nextDouble();
                contaOrigem.transferir(valor, contaDestino);

            } else {
                System.out.println("Conta de Destino não encontrada!");
            }
        } else {
            System.out.println("Conta de Origem não encontrada!");
        }
        principal();
    }

    public static void listar() {

        if (contas.size() != 0) {
            for (ContaBancaria conta : contas) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas.");
        }
        principal();
    }

}
