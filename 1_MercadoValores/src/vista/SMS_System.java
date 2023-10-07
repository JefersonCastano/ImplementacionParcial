package vista;

import observer.iObservador;

/**
 * @brief Interfaz para un sistema de mensajes
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public abstract class SMS_System implements iObservador{
    
    //Numero a mandar el mensaje
    protected String numero;
    
    @Override
    public void actualizar(String estado) {
        //Si sucede un cambio, se manda mensaje
       sendMessage(estado);
    }
    //Mandar cierto mensaje al numero relacionado
    public abstract void sendMessage(String message);
    
}
