package controlador;

import modelo.AbstractModel;
import modelo.Accion;
import observer.iObservador;
import vista.iView;

/**
 * @brief Clase abstracta para un controlador
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public abstract class AbstractController{
    
    //Objetos abstractos de modelo, vista y un notificador
    protected AbstractModel modelo;
    protected iView vista;
    protected iObservador notificador;
    
    //Activa la vista 
    public abstract void seleccionarVista();  
    
    //Agrega accion disponible a las acciones que sigue el usuario. La accion debe tener establecidos los umbrales
    public abstract void agregarAccion(Accion accion);
    
    //Eliminar accion que sigue el usuario
    public abstract void eliminarAccion(Accion accion);
    
    //Establecer los umbrales de una accion antes de agregarla a las acciones que sigue el usuario
    public abstract void fijarUmbrales(Accion accion, float umbralInf, float umbralSup);
    
}
