package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief Usuario que tiene una lista de acciones las cuales sigue
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public class Usuario {
    
    private List <Accion> acciones;
    
    //Numero telefonico del usuario
    private String number;
    
    public Usuario(String number){
        acciones = new ArrayList <>();
        this.number = number;
    }

    public List<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
