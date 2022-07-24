package br.com.dio.banco;

import java.util.Optional;

public class AbreConta {
    public static void abreConta(Cliente cliente, Conta conta, Banco banco){
        cliente.vinculaConta(conta);
        conta.vinculaCliente(cliente.getCpf());
        banco.addCliente(cliente);
        banco.addConta(conta);
    }
}
