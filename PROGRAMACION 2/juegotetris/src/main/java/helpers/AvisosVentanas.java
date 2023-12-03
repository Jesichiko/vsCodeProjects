package helpers;

import javax.swing.JOptionPane;

//CLASE AYUDANTE PARA VENTANAS, NO INSTANCIABLE
public abstract class AvisosVentanas { 
    
    public static void error(String message){ //Mensajes de error que se envian al usuario
        JOptionPane.showMessageDialog(null, message, "Error :/", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void IngresoExitoso(){ //Mensaje dado si el registro fue hecho correctamente
        JOptionPane.showMessageDialog(null, "¡Ingreso exitoso! A jugar :)", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void registroExitoso(){ //Mensaje dado si el registro fue hecho correctamente
        JOptionPane.showMessageDialog(null, "¡Usuario agregado con exito! Ya puedes jugar :)", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
    
}