package modelo;

import java.util.List;

/**
 * @brief Interfaz para consultas de las acciones seguidas por el usuario
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public interface iQueryEstado {
    //Obtener las acciones que sigue el usuario
    public List<Accion> getAcciones();
}
