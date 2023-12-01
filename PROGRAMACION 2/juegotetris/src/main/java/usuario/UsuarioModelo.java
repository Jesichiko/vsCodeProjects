package usuario;

import excepciones.CampoVacioException;

public class UsuarioModelo {
    
    private String user, password;
    private int index;
    private float puntaje;
    
    public UsuarioModelo(){
        user = "N/A";
        password = "N/A";
        puntaje = 0.F;
        index = 0;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) throws CampoVacioException{ //Cuando se registran
        if(user.equals("Ej: ElPro1234")){ //Cuando el usuario no ha escrito nada, el placeholder por defecto deja el nombre del campo 
            throw new CampoVacioException();
        }
        this.user = user;
    }

    public String getPassword() { 
        return password;
    }

    public void setPassword(String password) throws CampoVacioException{ //Cuando se registran
        if(password.equals("Ej: OmocatLLSPP")){ 
            throw new CampoVacioException();
        }
        this.password = password;
    }

    public void setPuntaje(int puntaje) { 
        this.puntaje = puntaje;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex() {
        this.index = getIndex();
    }
    
}
