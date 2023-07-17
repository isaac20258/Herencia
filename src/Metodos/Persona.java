package Metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Persona {
    
    public String Nombre;
    public String Cedula;
    public int Edad;
    public int TipPersona;

    public Persona(String Nombre, String Cedula, int Edad, int TipPersona) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.Edad = Edad;
        this.TipPersona = TipPersona;
    }
    
   
    
    public void getMayorEdad(){
        if((Edad >= 0 ) &&(Edad <= 5))
            JOptionPane.showMessageDialog(null, "Primera Infancia !");
            else if((Edad >= 6)&& (Edad <= 11))
                JOptionPane.showMessageDialog(null, "Infancia !");
            else if((Edad >= 12)&& (Edad <= 18))
                JOptionPane.showMessageDialog(null, "Adolecencia !");
            else if((Edad >= 19)&&(Edad <= 26))
                JOptionPane.showMessageDialog(null, "Juventud !");
            else if((Edad >= 27)&& (Edad <= 59))
                JOptionPane.showMessageDialog(null, "Adulto !");
            else if((Edad >= 60)&&(Edad <= 70))
                JOptionPane.showMessageDialog(null, "Tercera edad: Senectud !");
            else if((Edad >= 71)&&(Edad <= 90))
                JOptionPane.showMessageDialog(null, "Tercera edad:  Vejes !");
        else
                JOptionPane.showMessageDialog(null,"Tercera edad: Gran anciano !");
        
    }
}
