package metodospago;

import metodospago.IPago;

/**
 *
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 *         David Santiago Giron Muñoz <davidgiron@unicauca.edu.co> 
 */
public class PayPal implements IPago{
    
    String usuario;
    String contrasena;
    
    public PayPal(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public boolean pagar(float valor) {
        if(autenticarCredenciales()){
            //Logica para realizar pago
            System.out.println("Pago con PayPal exitoso.");
            return true;
        }
        System.out.println("Pago con PayPal fallido.");
        return false;
    }
    
    private boolean autenticarCredenciales (){
        //Logica de autenticación de credenciales
        return usuario.equals("Santiago") && contrasena.equals("123"); 
    }  
}
