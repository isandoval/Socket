/*
 * Creado por  .-  Ivan Marcelo Sandoval Quintanilla
 * Ejemplo     .-  Publicador Lector
 * Curso       .-  Integracion de Sistemas
 */

package lector;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Lector 
{
    public static void main(String[] args) 
    {
        try {
           Socket lector = new Socket("localhost",4500);
           ObjectInputStream mensaje = new ObjectInputStream(lector.getInputStream());
            String msn = (String) mensaje.readObject();
            JOptionPane.showMessageDialog(null, msn);
            lector.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
