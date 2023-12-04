package usuario;

import excepciones.CampoVacioException;

public class UsuarioModelo {
    
    private static UsuarioModelo instance;
    private String user, password;
    private int puntuacionU;
    
    public UsuarioModelo(){
        user = "N/A";
        password = "N/A";
        puntuacionU=0;
    }
    
    public static synchronized UsuarioModelo getInstance() {
        if (instance == null) {
            instance = new UsuarioModelo();
        }
        return instance;
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
    
   public int getPuntuacionU() {
        return puntuacionU;
    }
    public void setPuntuacionU(int puntuacionU) {
        this.puntuacionU = puntuacionU;
    }
}  