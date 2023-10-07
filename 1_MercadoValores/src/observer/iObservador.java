package observer;

/**
 * @brief Interfaz para un observador
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public interface iObservador {
    
    //Accion a tomar si surge un cambio en el observado. Se informa ademas que cambio se realizo (estado).
    public void actualizar(String estado);
    
}
