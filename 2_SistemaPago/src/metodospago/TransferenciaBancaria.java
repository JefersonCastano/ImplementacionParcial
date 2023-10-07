package metodospago;

/**
 *
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 *         David Santiago Giron Mu�oz <davidgiron@unicauca.edu.co> 
 */
public class TransferenciaBancaria implements IPago{

    long numeroCuenta;
    
    public TransferenciaBancaria(long numeroCuenta){
        this.numeroCuenta = numeroCuenta;
    }
    
    @Override
    public boolean pagar(float valor) {
        System.out.println("Pago con transferencia bancaria exitoso.");
        return true;
    }
    
}
