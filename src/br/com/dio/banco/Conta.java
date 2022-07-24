package br.com.dio.banco;

import java.util.List;

public abstract class Conta {
    protected String numero;
    protected String agencia;
    protected String tipo;
    private String clienteDaConta;
    private double saldo = 0;

    public String getNumero() {
        return this.numero;
    }

    public String getAgencia() {
        return this.agencia;
    }


    public String getClienteDaConta() {
        return this.clienteDaConta;
    }

    public String getTipo() {
        return this.tipo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void vinculaCliente(String cpfCliente){
        this.clienteDaConta = cpfCliente;
    }

    public boolean depositar(double valor){
        this.saldo += valor;
        return true;
    }

    public boolean sacar(double valor){
        if(this.verificarSaldo(valor)){
            this.saldo -= valor;
            return true;
        }else {
            return false;
        }
    }

    private boolean verificarSaldo(double valor){
        return this.saldo >= valor;
    }
}
