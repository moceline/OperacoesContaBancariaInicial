public class Cliente {

    private String nome;
    private String cpf;
    private String email;

    // private static int contadorCliente = 1;

    public Cliente(String nome, String cpf, String email) {

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;

        // contadorCliente += 1;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public String toString() {
        return "\nNome:" + this.getNome() + "\nCPF:" + this.getCPF() +
                "\nE-mail:" + this.getEmail();
    }

}
