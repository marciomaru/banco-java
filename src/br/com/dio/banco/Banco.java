package br.com.dio.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Banco {
    private static final String NOME = "BANCOSO";
    private static final String AGENCIA = "01";
    private List<Cliente> listaDeClientes;
    private List<Conta> listaDeContas;

    public Banco() {
        this.listaDeClientes = new ArrayList<Cliente>();
        this.listaDeContas = new ArrayList<Conta>();
    }

    public static String getNome() {
        return NOME;
    }

    public static String getAgencia() {
        return AGENCIA;
    }

    public List<Cliente> getListaDeClientes() {
        return this.listaDeClientes;
    }

    public List<Conta> getListaDeContas() {
        return this.listaDeContas;
    }

    public void addCliente(Cliente cliente) {
        this.listaDeClientes.add(cliente);
    }

    public void addConta(Conta conta) {
        this.listaDeContas.add(conta);
    }


    public Cliente perquisarCliente(String cpf) {
        for (Cliente cliente : this.listaDeClientes) {
            if (Objects.equals(cliente.getCpf(), cpf)) {
                System.out.println(cliente.getCpf());
                return cliente;
            }
        }
        return null;
    }
}