package Metodos;

/**
 *
 * @author USER
 */
public class Cliente extends Persona {

 int Id_Cliente;    

    public Cliente(int Id_Cliente, String Nombre, String Cedula, int Edad) {
        super(Nombre, Cedula, Edad, 0);
        this.Id_Cliente = Id_Cliente;
    }


}
