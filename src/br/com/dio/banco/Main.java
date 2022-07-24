package br.com.dio.banco;

import javax.swing.*;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String escolha = "";
        Banco banco = new Banco();
        Boolean bancoOn = true;
        JOptionPane.showMessageDialog(null,"Você está no "+banco.getNome()+"!");
        while (bancoOn == true){
            String menu = "O que deseja fazer?\n"+
                    "1 - Abrir Conta Poupança\n" +
                    "2 - Abrir Conta Corrente\n"+
                    "3 - Entrar\n"+
                    "4 - Sair";
            escolha = JOptionPane.showInputDialog(menu);
            switch (escolha){
                case "1":
                    String nomeClienteP = JOptionPane.showInputDialog("Digite seu Nome");
                    String cpfClienteP = JOptionPane.showInputDialog("Digite seu cpf");
                    Optional<Cliente> ocP = Optional.ofNullable(banco.perquisarCliente(cpfClienteP));
                    if(ocP.isPresent()){
                        if(ocP.get().getContas().containsKey("Poupança")){
                            JOptionPane.showMessageDialog(null, "O cliente já possui conta Poupança");
                            break;
                        }else{
                            Conta contaPoupanca = new ContaPoupanca();
                            AbreConta.abreConta(ocP.get(), contaPoupanca, banco);
                            JOptionPane.showMessageDialog(null, "Parabéns "+ocP.get().getNome()+"!");
                            JOptionPane.showMessageDialog(null,"Agora você tem uma conta "+contaPoupanca.getTipo()+" no "+Banco.getNome());
                            break;
                        }
                    }
                    Cliente clienteP = new Cliente(nomeClienteP, cpfClienteP);
                    Conta contaPoupanca = new ContaPoupanca();
                    AbreConta.abreConta(clienteP, contaPoupanca, banco);
                    JOptionPane.showMessageDialog(null, "Parabéns "+clienteP.getNome()+"!");
                    JOptionPane.showMessageDialog(null,"Agora você tem uma conta "+contaPoupanca.getTipo()+" no "+Banco.getNome());
                    break;
                case "2":
                    String nomeClienteC = JOptionPane.showInputDialog("Digite seu Nome");
                    String cpfClienteC = JOptionPane.showInputDialog("Digite seu cpf");
                    Optional<Cliente> ocC = Optional.ofNullable(banco.perquisarCliente(cpfClienteC));
                    if(ocC.isPresent()){
                        if(ocC.get().getContas().containsKey("Corrente")){
                            JOptionPane.showMessageDialog(null, "O cliente já possui conta Corrente");
                            break;
                        }else{
                            Conta contaCorrente = new ContaCorrente();
                            AbreConta.abreConta(ocC.get(), contaCorrente, banco);
                            JOptionPane.showMessageDialog(null, "Parabéns "+ocC.get().getNome()+"!");
                            JOptionPane.showMessageDialog(null,"Agora você tem uma conta "+contaCorrente.getTipo()+" no "+Banco.getNome());
                            break;
                        }
                    }
                    Cliente clienteC = new Cliente(nomeClienteC, cpfClienteC);
                    Conta contaCorrente = new ContaCorrente();
                    AbreConta.abreConta(clienteC, contaCorrente, banco);
                    JOptionPane.showMessageDialog(null, "Parabéns "+clienteC.getNome()+"!");
                    JOptionPane.showMessageDialog(null,"Agora você tem uma conta "+contaCorrente.getTipo()+" no "+Banco.getNome());
                    break;
                case "3":
                    Atendimento atendimento = new Atendimento();
                    atendimento.iniciarAtendimento(banco);
                    break;
                case "4":
                    bancoOn = false;
                    JOptionPane.showMessageDialog(null, "Até logo!");
                    break;
                default:
                    System.out.println("Opcção inexistente!");
                    continue;
            }
            //System.out.println(escolha);

        }
    }
}
