import java.util.ArrayList;
import java.util.List;

class Cliente {
   private String nome;
   private String cpf;
   private int saldo;
   private int numConta;

    Cliente(String nome, String cpf, int saldo, int numConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
        this.numConta = numConta;
    }

    Cliente(String nome, String cpf, int numConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.numConta = numConta;
    }

     public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getCpf () {
        return cpf;
    }

    public void setCpf (String cpf) {
        this.cpf = cpf;
    }

    public int getSaldo () {
        return saldo;
    }

    public void setSaldo (int saldo) {
        this.saldo = saldo;
    }

    public int getNumConta () {
        return numConta;
    }

    public void setNumConta (int numConta) {
        this.numConta = numConta;
    }

    public int Extrato() {
        return this.saldo;
    }

    public void Saque(int val) {
       if (val > 0 && val <= this.saldo) {
        this.saldo -= val;
        System.out.println("Saque de R$ " + val + " realizado");
       }
       else{
        System.out.println("Saldo insuficiente!");
       }
    }

    public void Deposito(int val) {
        if(val > 0) {
            this.saldo += val;
            System.out.println("Depósito de R$" + val + " realizado");
        }
        else{
            System.out.println("Depósito deve ser positivo!");
        }
    }

    public String toString() {
        return "\nNome do cliente: " + nome + 
        "\nCPF: " + cpf + 
        "\nConta: " + numConta + 
        "\nSaldo: " + saldo;
    }
}

class Banco {
    private Cliente[] clientes = new Cliente[2];

    public Cliente[] getClientes() {
        return clientes;
    }

    public Cliente[] cadastraClientes() {
        Cliente c1 = new Cliente("Alan Turing", "1289", 1500, 25896);
        Cliente c2 = new Cliente("Ada Love", "98765431", 12345);

        clientes[0] = c1;
        clientes[1] = c2;

        return clientes;
    }

     public String operacoes() {
            clientes[0].Saque(100);
            clientes[1].Saque(100);

            clientes[0].Deposito(50);
            clientes[1].Deposito(50);

            for (Cliente c : clientes) {
                if(c.Extrato() < 0){
                    c.setSaldo(0);
                }
            }

            clientes[0].setCpf("12345689");
            clientes[1].setNome("Ada Lovelace");

            String resultado = ""; 
            for (int i = 0; i < clientes.length; i++) {
                resultado += clientes[i].toString();

                if(i < clientes.length - 1) {
                    resultado += "\n";
                }
            }

            return resultado;
        }

        public static void main(String[] args) {
            Banco meuBanco = new Banco();
            meuBanco.cadastraClientes();

            String relatorioFinal = meuBanco.operacoes();
            System.out.println(relatorioFinal);
        }
}