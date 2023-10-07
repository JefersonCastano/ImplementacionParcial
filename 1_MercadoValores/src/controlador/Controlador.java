package controlador;

import modelo.AbstractModel;
import modelo.Accion;
import observer.iObservador;
import vista.iView;

/**
 * @brief Clase concreta para un controlador
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public class Controlador extends AbstractController{
    
    
    public Controlador (iView vista, AbstractModel modelo, iObservador obs){
        this.vista = vista;
        this.modelo = modelo;
        this.notificador = obs;
        //Añadir la vista como un observador del modelo
        modelo.addObservador(vista);
    }
  
    
    @Override
    public void seleccionarVista(){
        vista.mostrarVista();
    }
    
    @Override
    public void agregarAccion(Accion accion){
        modelo.addAccion(accion);
        
        //Agregar la vista y el notificador como observadores de la accion que sigue el usuario
        accion.addObservador(notificador);
        accion.addObservador(vista);
    }
    
    @Override
    public void eliminarAccion(Accion accion){
        modelo.removeAccion(accion);
    }
    
    @Override
    public void fijarUmbrales(Accion accion, float umbralInf, float umbralSup){
        modelo.setUmbrales(accion, umbralInf, umbralSup);
    }
}
