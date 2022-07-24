package br.com.dio.banco;

public class ContaPoupanca extends Conta {
        private static int SEQUENCIAL;
    public ContaPoupanca(){
        this.tipo = "Poupança";
        this.agencia = Banco.getAgencia();
        SEQUENCIAL++;
        this.numero = String.format("%s%s%d",Banco.getNome(),this.getAgencia(),SEQUENCIAL);
    }
}
