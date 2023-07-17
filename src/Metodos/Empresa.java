package Metodos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Empresa {

    ArrayList Datos;

    public Empresa() {
        this.Datos = new ArrayList();
    }

    public int getBuscarCel(String id) {
        int i;
        Persona temp = null;
        for (i = 0; i < Datos.size(); i++) {
            temp = (Persona) Datos.get(i);
            if ((temp.Cedula).equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public int BuscarIdCliente(int id) {
        int i;
        Persona Aux = null;
        Cliente temp = null;
        for (i = 0; i < Datos.size(); i++) {
            Aux = (Persona) Datos.get(i);
            if (Aux.TipPersona == 0) {
                temp = (Cliente) Datos.get(i);
                if (temp.Id_Cliente == id) {
                    return i;
                }
            }

        }
        return -1;
    }

    public int BuscarIdAdm(int id) {
        int i;
        Persona Aux = null;
        Administrador temp = null;
        for (i = 0; i < Datos.size(); i++) {
            Aux = (Persona) Datos.get(i);
            if (Aux.TipPersona == 1) {
                temp = (Administrador) Datos.get(i);
                if (temp.Id_Adm == id) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void setAddCliente(
            JTextField jtfNom,
            JTextField jtfcel,
            JTextField jtfedad,
            JTextField jtfid_Cliente) {

        int poscel = getBuscarCel(jtfcel.getText());
        Cliente inf = null;

        if (poscel != -1) {
            JOptionPane.showMessageDialog(null, " La Cedula que intenta ingresar ya"+"\n"
                    + "se encuentra registrada en la bases de datos! \n"
                    + "Intente nuevamente...");
            jtfcel.setText("");
            jtfcel.requestFocus();
        } else {
            int PosId = BuscarIdCliente(Integer.parseInt(jtfid_Cliente.getText()));

            if (PosId != -1) {
                JOptionPane.showMessageDialog(null, "El idCliente que trata de ingresar ya"+"\n"
                        + "se encuentra registrado en la bases de datos! \n"
                        + "Intente nuevamente...");
                jtfid_Cliente.setText("");
                jtfid_Cliente.requestFocus();
            } else {
                inf = new Cliente(
                        Integer.parseInt(jtfid_Cliente.getText()),
                        jtfNom.getText(),
                        jtfcel.getText(),
                        Integer.parseInt(jtfedad.getText()));
                Datos.add(inf);
            }
        }

    }

    public void setAddAdm(
            JTextField jtfNom,
            JTextField jtfcel,
            JTextField jtfedad,
            JTextField jtfid_Adm) {
        int Poscel = getBuscarCel(jtfcel.getText());
        Administrador inf = null;

        if (Poscel != -1) {
            JOptionPane.showMessageDialog(null, " La Cedula que intenta ingresar ya "
                    + "se encuentra registrada en la bases de datos! \n"
                    + "Intente nuevamente...");
            jtfcel.setText("");
            jtfcel.requestFocus();
        } else {
            int PosidAdm = BuscarIdAdm(
                    Integer.parseInt(jtfid_Adm.getText()));
            if (PosidAdm != -1) {
                JOptionPane.showMessageDialog(null, "El idAdm que trata de ingresar ya "+"\n"
                        + "se encuentra registrado en la bases de datos! \n"
                        + "Intente nuevamente...");
                jtfid_Adm.setText("");
                jtfid_Adm.requestFocus();
            } else {
                inf = new Administrador(
                        Integer.parseInt(jtfid_Adm.getText()),
                        jtfNom.getText(),
                        jtfcel.getText(),
                        Integer.parseInt(jtfedad.getText()));
                Datos.add(inf);
            }
        }
    }

    public void setRegistrarFilaJTable(DefaultTableModel miModelo, int Fila,
            int indiceArray) {
        Persona Aux = null;
        Cliente cl = null;
        Administrador adm = null;

        Aux = (Persona) Datos.get(indiceArray);

        if (Aux.TipPersona == 0) {
            cl = (Cliente) Datos.get(indiceArray);

            miModelo.setValueAt(cl.Nombre, Fila, 0);
            miModelo.setValueAt(cl.Cedula, Fila, 1);
            miModelo.setValueAt(cl.Edad, Fila, 2);
            miModelo.setValueAt(cl.Id_Cliente, Fila, 3);
            miModelo.setValueAt("", Fila, 4);

        } else {
            adm = (Administrador) Datos.get(indiceArray);

            miModelo.setValueAt(adm.Nombre, Fila, 0);
            miModelo.setValueAt(adm.Cedula, Fila, 1);
            miModelo.setValueAt(adm.Edad, Fila, 2);
            miModelo.setValueAt("", Fila, 3);
            miModelo.setValueAt(adm.Id_Adm, Fila, 4);

        }

    }

    public void setLlenarJTable(JTable tab) {
        int indice = 0;
        int i = 0;
        DefaultTableModel miModelo = new DefaultTableModel();
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Cedula");
        miModelo.addColumn("Edad");
        miModelo.addColumn("IdCliente");
        miModelo.addColumn("IdAdministrador");
        while (indice < Datos.size()) {
            miModelo.addRow(new Object[]{"", "", "", "", ""});
            setRegistrarFilaJTable(miModelo, i, indice);
            i++;
            indice++;
        }
        tab.setModel(miModelo);
    }

    public void getEstadoEdad(String id) {
        int PosP = getBuscarCel(id);
        if (PosP == -1) {
            JOptionPane.showMessageDialog(null, "La Cedula ingresada para eliminar"
                    + "no se encuentra registrada");
        } else {
            Persona Ptemp = (Persona) Datos.get(PosP);
            Ptemp.getMayorEdad();
        }
    }

    public void setElimCel(String id) {
        int PosP = getBuscarCel(id);
        if (PosP == -1) {
            JOptionPane.showMessageDialog(null, "La Cedula  ingresada para eliminar"
                    + "no se encuentra registrada !");
        } else {
            Datos.remove(PosP);
            JOptionPane.showMessageDialog(null, "Los datos de la persona con la cedula: "
                    + id + "fueron eliminado");
        }
    }

}
