package br.com.dio.banco;

public class ContaCorrente extends Conta {
        private static int SEQUENCIAL;
    public ContaCorrente(){
         this.tipo = "Corrente";
         this.agencia = Banco.getAgencia();
         SEQUENCIAL++;
         this.numero = String.format("%s%s%d",Banco.getNome(),this.getAgencia(),SEQUENCIAL);
    }

    public boolean transferir(double valor, Conta contaDestino){
        boolean saqueOn = this.sacar(valor);
        if(saqueOn){
            contaDestino.depositar(valor);
            return true;
        }else {
            return false;
        }
    }


}
