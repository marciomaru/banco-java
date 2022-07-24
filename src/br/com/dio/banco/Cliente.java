package br.com.dio.banco;

import java.util.HashMap;
import java.util.Map;

public class Cliente {
    private String cpf;
    private String nome;
    private Map<String, String> ContasDoCliente;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.ContasDoCliente = new HashMap<String, String>();
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public Map<String, String> getContas(){
        return this.ContasDoCliente;
    }

    public void vinculaConta(Conta conta){

        this.ContasDoCliente.put(conta.getTipo(), conta.getNumero());
    }

}
