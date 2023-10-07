package vista;

import controlador.AbstractController;
import modelo.iQueryEstado;
import observer.iObservador;

/**
 * @brief Interfaz para una vista
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public interface iView extends iObservador{
    //Inicializa la vista, colocandola visible
    public void mostrarVista();
    
    //Le asigna un controlador a la vista a quien mandar solicitudes del usuario
    public void setController(AbstractController controlador);
    
    //Le asigna un modelo a la vista a quien consultar estado
    public void setModel(iQueryEstado modelo);
}