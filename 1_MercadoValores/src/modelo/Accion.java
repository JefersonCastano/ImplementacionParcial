package modelo;

import observer.Observado;

/**
 * @brief Accion
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public class Accion extends Observado{
    private String nombre;
    private float actPrecio;
    private float oldPrecio;
    private float umbralInf;
    private float umbralSup;
    
    //Brinda informacion si la accion ha superado umbrales o no.
    private String estado;
    
    public Accion(String nombre, float actPrecio) {
        this.nombre = nombre;
        this.actPrecio = actPrecio;
        this.oldPrecio = this.actPrecio;
    }
    
    public void setActPrecio(float actPrecio) {
        //Actualizar el precio viejo y actual
        this.oldPrecio = this.actPrecio;
        this.actPrecio = actPrecio;
        
        //Estado por defecto
        estado = "PrecioModificado;La accion "+this.nombre+" ha cambiado de precio.";
        
        //Verificar si ha sobrepasado alguno de los umbrales y cambiar el estado
        if(this.actPrecio > this.umbralSup) {
            estado = "UmbralAlcanzado;La accion "+this.nombre+" ha superado el umbral de "+umbralSup+".";
        }
        if(this.actPrecio < this.umbralInf){
            estado = "UmbralAlcanzado;La accion "+this.nombre+" ha disminuido del umbral de "+umbralInf+".";
        }
        notificarTodos(); //Notificar a los interesados                               
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getActPrecio() {
        return actPrecio;
    }

    public float getOldPrecio() {
        return oldPrecio;
    }

    public void setOldPrecio(float oldPrecio) {
        this.oldPrecio = oldPrecio;
    }

    public float getUmbralInf() {
        return umbralInf;
    }

    public void setUmbralInf(float umbralInf) {
        this.umbralInf = umbralInf;
    }

    public float getUmbralSup() {
        return umbralSup;
    }

    public void setUmbralSup(float umbralSup) {
        this.umbralSup = umbralSup;
    }

    @Override
    public String getEstado() {
        return estado;
    }   
}
