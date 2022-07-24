package br.com.dio.banco;

import javax.swing.*;
import java.util.Map;
import java.util.Optional;

public class Atendimento {
    private Cliente cliente;
    private MenuDoCliente menuDoCliente = new MenuDoCliente();
    public void iniciarAtendimento(Banco banco){
        boolean atendimentoON = true;
        while (atendimentoON){
            String cpf = JOptionPane.showInputDialog(null,"Insira seu cpf");
            Optional<Cliente> oc = Optional.ofNullable(banco.perquisarCliente(cpf));
            if(oc.isPresent()){
                this.cliente = oc.get();
                JOptionPane.showMessageDialog(null, "Olá "+this.cliente.getNome());
                String s = menuDoCliente.menuDeContas(this.cliente);
                System.out.println(s);
                JOptionPane.showInputDialog(null, s);

            }else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                atendimentoON = false;
            }

        }
    }
}
