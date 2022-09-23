public class ContaBancaria {

    private static int contadorConta = 1;

    private int numeroConta;
    private Cliente cliente;
    private double saldo = 0.0;

    public ContaBancaria(Cliente cliente) {
        this.numeroConta = contadorConta;
        this.cliente = cliente;

        contadorConta += 1;

    }

    public int getnumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNome:" + cliente.getNome() +
                "\nCPF:" + cliente.getCPF() +
                "\nE-mail:" + cliente.getEmail() +
                "\nNumero da Conta:" + this.getnumeroConta() +
                "\nSaldo:" + this.getSaldo();
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println("Não é possível fazer depósito!");
        }

    }

    public void sacar(Double valor) {
        if ((valor > 0) && (getSaldo() >= valor)) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não é possível fazer saque!");
        }
    }

    public void transferir(Double valor, ContaBancaria contaBancariaDestino) {
        if ((valor > 0) && (getSaldo() >= valor)) {
            setSaldo(getSaldo() - valor);
            contaBancariaDestino.setSaldo(contaBancariaDestino.getSaldo() + valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Transferência não permitida!");
        }
    }

}
