package model;

public class Conta {

    private boolean ativa;

    private double saldo;

    public boolean isAtiva() {
        return ativa;
    }

    public void ativar() {
        this.ativa = true;
    }

    public void desativar() {
        this.ativa = false;
    }

    public boolean depositar(double valor) {
        if (!isAtiva()) {
            return false;
        }
        saldo += valor;

        return true;
    }
    public boolean sacar(double valor){
        if (isAtiva()) {
            return false;
        }
        if(valor<=getSaldo()){
            saldo-=valor;
            return true;
        }else{
            return false;
        }


}
    public double getSaldo(){
        return saldo;
    }
}
