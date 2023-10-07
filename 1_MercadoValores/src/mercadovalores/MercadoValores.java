package mercadovalores;

import controlador.AbstractController;
import controlador.Controlador;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import modelo.AbstractModel;
import modelo.Accion;
import modelo.ServicioUsuario;
import modelo.Usuario;
import vista.SMS;
import vista.SMS_System;
import vista.SeguimientoAcciones;
import vista.iView;


/**
 *
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public class MercadoValores {

    public static void main(String[] args) {
        
        //Creación de acciones disponibles
        List<Accion> acciones = new ArrayList <>();
        acciones.add(new Accion("Apple", 12000.0f));
        acciones.add(new Accion("Microsoft", 27000.6f));
        acciones.add(new Accion("Facebook", 7000.0f));
        acciones.add(new Accion("Unicauca", 20000.0f));
        acciones.add(new Accion("Instagram", 13000.2f));
        acciones.add(new Accion("X", 70000.0f));
        acciones.add(new Accion("inDriver", 3000.1f));
        
        //Creacion de entidades
        Usuario user = new Usuario("123456789"); 
        AbstractModel modelo = new ServicioUsuario(user);
        iView vista = new SeguimientoAcciones(acciones);
        SMS_System sms = new SMS(user.getNumber());
        
        AbstractController controller = new Controlador(vista, modelo, sms);
        
        //Configuracion de vista
        vista.setController(controller);
        vista.setModel(modelo);
        
        //Agregar accion por defecto al usuario
        Accion google = new Accion("Google", 30000);
        controller.fijarUmbrales(google, 20000, 34000);
        controller.agregarAccion(google);
        
        Accion Linux = new Accion("Linux", 20000);
        controller.fijarUmbrales(Linux, 10000, 30000);
        controller.agregarAccion(Linux);
        
        Accion TikTok = new Accion("TikTok", 25000);
        controller.fijarUmbrales(TikTok, 20000, 30000);
        controller.agregarAccion(TikTok);
        
        
        //Activar vista
        controller.seleccionarVista();
        

        //Cambio del precio de la acciones a nivel de ejemplo para las notificaciones
        
        //Tarea 1 aunmenta el precio de la accion de google en 3000
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                google.setActPrecio(google.getActPrecio()+3000);
            }
        };

        long tiempoDeEspera1 = 5000; // 5 segundos
        
        Timer timer1 = new Timer();
        timer1.schedule(task1, tiempoDeEspera1);
        
        //Tarea 2 aunmenta el precio de la accion de google en otros 3000 y supera umbral superior
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                google.setActPrecio(google.getActPrecio()+3000);
            }
        };

        long tiempoDeEspera2 = 10000; // 10 segundos
        
        Timer timer2 = new Timer();
        timer2.schedule(task2, tiempoDeEspera2);
        
        //Tarea 3 disminuye el precio de la accion de tiktok en 60000 y supera umbral inferior
        TimerTask task3 = new TimerTask() {
            @Override
            public void run() {
                TikTok.setActPrecio(TikTok.getActPrecio()-6000);
            }
        };

        long tiempoDeEspera3 = 15000; // 15 segundos
        
        Timer timer3 = new Timer();
        timer3.schedule(task3, tiempoDeEspera3);
    }  
}
