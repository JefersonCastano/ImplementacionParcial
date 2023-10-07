package modelo;

import java.util.List;


/**
 * @brief Clase concreta para un modelo (ServicioUsuario)
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public class ServicioUsuario extends AbstractModel{
       
    public ServicioUsuario (Usuario usuario){
        this.usuario = usuario;
    }
    
    @Override
    public void addAccion(Accion accion){
        //Validacion de que la accion debe tener establecidos sus umbrales inferior y superior
        if(accion.getUmbralInf() != 0.0 && accion.getUmbralSup() != 0.0) usuario.getAcciones().add(accion);
        notificarTodos();
    }
    @Override
    public void removeAccion(Accion accion){
        usuario.getAcciones().remove(accion);
        notificarTodos();
    }
    @Override
    public void setUmbrales(Accion accion, float umbralInf, float umbralSup){
        accion.setUmbralInf(umbralInf);
        accion.setUmbralSup(umbralSup);
    } 

    @Override
    public List<Accion> getAcciones() {
        return usuario.getAcciones();
    }
    
    @Override
    public String getEstado() {
        return "Se ha producido un cambio en el modelo.";
    }

}
