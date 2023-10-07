package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief Clase abstracta para un observado
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public abstract class Observado {
    //Lista de observadores
    private List<iObservador> observadores;
    
    //Agregar un observador
    public void addObservador(iObservador Obs){
        if(observadores==null)
            observadores = new ArrayList<>();
        observadores.add(Obs);
    }
    
    //Eliminar un observador
    public void removeObservador(iObservador Obs){
        if(observadores!=null) observadores.remove(Obs);
    }
    
    //Se actualiza cada uno de los observadores con el estado del observado
    public void notificarTodos(){
        for(iObservador each:observadores){
            each.actualizar(getEstado());
        }
    }  
    //Metodo abstracta a implemetar por cada oservado que informa el estado cambiado
    public abstract String getEstado();
}
