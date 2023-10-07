package modelo;

/**
 * @brief Interfaz con metodos para gestionar acciones seguidas por el usuario
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public interface iGestionEstado {
    //Agrega accion disponible a las acciones que sigue el usuario. La accion debe tener establecidos los umbrales
    public void addAccion(Accion accion);
    
    //Eliminar accion que sigue el usuario
    public void removeAccion(Accion accion);
    
    //Establecer los umbrales de una accion antes de agregarla a las acciones que sigue el usuario
    public void setUmbrales(Accion accion, float umbralInf, float umbralSup);
}
