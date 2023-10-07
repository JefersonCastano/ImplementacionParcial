package sistemapago;

import metodospago.*;

/**
 *
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 *         David Santiago Giron Muñoz <davidgiron@unicauca.edu.co> 
 */
public class SistemaPago {

    public static void main(String[] args) {
        //Proceso de pago con tarjeta de credito
        ProcesoPago pagoTC = new ProcesoPago(new TarjetaCredito(384238924, 123, "11/2023"));
        pagoTC.procesarPago(50000);
        
        
        //Proceso de pago con PayPal
        ProcesoPago pagoPayPal = new ProcesoPago(new PayPal("Santiago", "123"));       
        pagoPayPal.procesarPago(50000);
        
        
        //Proceso de pago con transferencia bancaria
        ProcesoPago pagoTB = new ProcesoPago(new TransferenciaBancaria(23952384112l));       
        pagoTB.procesarPago(50000);    
    }
    
}
