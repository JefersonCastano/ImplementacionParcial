package metodospago;

import metodospago.IPago;

/**
 *
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 *         David Santiago Giron Muñoz <davidgiron@unicauca.edu.co> 
 */
public class TarjetaCredito implements IPago{
    
    private long numero;
    private int cvv;
    private String fechaVencimiento;
    private int limite;

    public TarjetaCredito(long numero, int cvv, String fechaVencimiento) {
        this.numero = numero;
        this.cvv = cvv;
        this.fechaVencimiento = fechaVencimiento;
        this.limite = 100000;   //Logica para obtener el limite de la tarjeta
    }
    
    @Override
    public boolean pagar(float valor) {
        if(verificarLimite(valor)) {
            //Logica para realizar pago
            System.out.println("Pago con tarjeta de credito exitoso.");
            return true;
        } 
        System.out.println("Pago con tarjeta de credito fallido.");
        return false;
    }
    
    private boolean verificarLimite(float valor){
        return valor <= limite;
    }

    /**
     * @return the numero
     */
    public long getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(long numero) {
        this.numero = numero;
    }

    /**
     * @return the cvv
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * @return the fechaVencimiento
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the limite
     */
    public int getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(int limite) {
        this.limite = limite;
    }
    
}
