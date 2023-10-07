package modelo;


import observer.Observado;

/**
 * @brief Clase abstracta para un modelo
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public abstract class AbstractModel extends Observado implements iQueryEstado, iGestionEstado{
    //Usuario del cual se realiza la gestion de acciones
    protected Usuario usuario;
    
    
    @Override
    public abstract String getEstado();
}
