package Metodos;

/**
 *
 * @author USER
 */
public class Administrador extends Persona {
    
    public int Id_Adm;

    public Administrador(int Id_Adm, String Nombre, String Cedula, int Edad) {
        super(Nombre, Cedula, Edad, 1);
       this.Id_Adm = Id_Adm;
    }
    
    
       
    
    
}
