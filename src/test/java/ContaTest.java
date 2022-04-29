import model.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ContaTest {

    private Conta conta;
    private double depositoInicial;
    private double saque;
    private double deposito;
    private boolean resultado;

    @Test
    @DisplayName("Deve depositar na conta com saldo zero!")
    public void  DeveDepositarNaContaSaldoZero() {


        conta = new Conta();
        conta.ativar();


        deposito = 100.00;
        resultado = conta.depositar(deposito);

        Assertions.assertEquals(100.00, conta.getSaldo(), 0.001);
        Assertions.assertTrue(resultado);


    }
    @DisplayName("Deve depositar na conta ativada com saldo existente positivo.")
    @Test
    public void DeveDepositarNaContaAtivadaComSaldoExistentePositivo() {


        conta = new Conta();
        conta.ativar();


        depositoInicial = 1.00;
        resultado = conta.depositar(depositoInicial);

        deposito = 100.00;
        resultado = conta.depositar(deposito);

        Assertions.assertEquals(101,conta.getSaldo(),0.001);
        Assertions.assertTrue(resultado);
    }

    @DisplayName("Deve sacar da conta com saldo positivo.")
    @Test
    public void DeveSacarDaContaAtivadaComSaldoPositivo() {


        conta = new Conta();
        conta.ativar();

        depositoInicial = 200.00;
        resultado = conta.depositar(depositoInicial);

        saque = 50.00;
        resultado = conta.sacar(saque);

        Assertions.assertEquals(150, conta.getSaldo(), 0.001);
        Assertions.assertFalse(resultado);
    }

    @DisplayName("Não deve sacar da conta ativada se o saldo ficar negativo.")
    @Test
    public void NaoDeveSacarDaContaAtivadaSeOSaldoFicarNegativo() {


        conta = new Conta();
        conta.ativar();

        depositoInicial = 100.00;
        conta.depositar(depositoInicial);


        saque = 150.00;
        resultado = conta.sacar(saque);

        Assertions.assertEquals(100,conta.getSaldo(),0.001);
        Assertions.assertFalse(resultado);

    }

    @DisplayName("Nao deve depositar na conta desativada")
    @Test
     public void NaoDeveDepositarNaContaDesativada(){


        conta = new Conta();
        conta.desativar();


        deposito = 100.00;
        resultado = conta.depositar(deposito);


        Assertions.assertEquals(0.00,conta.getSaldo(),0.001);
        Assertions.assertFalse(resultado);



    }
    @DisplayName("Não deve sacar da conta desativada.")
    @Test
    public void NaoDeveSacarDaContaDesativada() {


        conta = new Conta();
        conta.ativar();

        depositoInicial = 100.00;
        conta.depositar(depositoInicial);
        conta.desativar();

        saque = 50.00;
        resultado = conta.sacar(saque);

        Assertions.assertEquals(100, conta.getSaldo(), 0.001);
        Assertions.assertFalse(resultado);

    }
}


