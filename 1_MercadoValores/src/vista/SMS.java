package vista;

import javax.swing.JOptionPane;

/**
 * @brief Clase concreta para un sistema de mensajes
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public class SMS extends SMS_System{
    
    public SMS(String numero){
        this.numero = numero;
    }
    
    //Verifica si el cambio en el precio de una accion supero alguno de los umbrales o no
    private boolean puedeEnviarMensaje(String estado){
        return estado.equals("UmbralAlcanzado");
    }
    
    @Override
    public void sendMessage(String message) {
        String[] mensaje = message.split(";");
        //Si el precio supero el umbral se manda el mensaje asociado a este
        if(puedeEnviarMensaje(mensaje[0])) JOptionPane.showMessageDialog(null, "Mandando mensaje a: " + numero + ". " + mensaje[1], "Notificación", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
