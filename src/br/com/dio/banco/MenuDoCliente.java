package br.com.dio.banco;

import java.util.Map;
import java.util.Set;

public class MenuDoCliente {
    public String menuDeContas(Cliente cliente){
        Map<String, String> contasDoCliente = cliente.getContas();
        String menu = "Qual conta deseja acessar?\n";
        Set<String> tipos =  contasDoCliente.keySet();
        int aux = 0;
        for (String tipo: tipos) {
            aux++;
            menu = menu+aux+" - "+tipo+"\n";

        }
        return menu;
    }
}
