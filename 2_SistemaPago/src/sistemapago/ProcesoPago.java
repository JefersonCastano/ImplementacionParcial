package sistemapago;

import metodospago.IPago;

/**
 *
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 *         David Santiago Giron Muñoz <davidgiron@unicauca.edu.co> 
 */
public class ProcesoPago {
    
    private IPago formaPago;
    
    public ProcesoPago(IPago formaPago){
        this.formaPago = formaPago;
    }
    
    public void procesarPago(float valor){
        formaPago.pagar(valor);
    }
}
