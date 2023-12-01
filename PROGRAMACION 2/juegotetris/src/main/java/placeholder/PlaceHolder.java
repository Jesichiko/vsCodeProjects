package placeholder;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

public class PlaceHolder{
   
            
    public PlaceHolder(JTextField campo, String placeHolder){
        campo.setForeground(Color.GRAY); // Color de texto del placeholder
        campo.setText(placeHolder);

        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                
                if (campo.getText().equals(placeHolder)) { //Si el usuario da click en la JTextField y todavia no ha escrito nada, se borra el texto original de instruccion (el placeHolder)
                    campo.setText("");
                    campo.setForeground(Color.BLACK); // Se cambia el color de la letra a negro para cuando el usuario escribe
                }
            }

            @Override
            public void focusLost(FocusEvent e) { //Si el usuario deja de dar click en la JTextField
                if (campo.getText().isEmpty()) { //Si se ha borrado lo que estaba en la JTextField, se vuelve a escribir el placeHolder
                    campo.setForeground(Color.GRAY);
                    campo.setText(placeHolder); // Se cambia el color de la letra a gris para el placeHolder
                }
            }
        });
    }    
}