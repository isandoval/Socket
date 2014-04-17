/*
 * Creado por  .-  Ivan Marcelo Sandoval Quintanilla
 * Ejemplo     .-  Publicador Lector
 * Curso       .-  Integracion de Sistemas
 */

package publicador;

 import java.io.IOException;
import java.io.ObjectOutputStream;
 import java.io.OutputStream;
 import java.net.Socket;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javax.swing.JOptionPane;

public class Publicador 
{

    public static void main(String[] args) 
    {
        try 
        {
            Socket publicador = new Socket("localhost",4500);
            ObjectOutputStream mensaje = new ObjectOutputStream(publicador.getOutputStream());
            /*   envia un mensaje a travez del outputstream del publicador   */
            String msn = JOptionPane.showInputDialog("Publique su opinion sobre la Universidad");
            mensaje.writeObject(msn);
        } 
        
        catch (IOException ex) 
        {
            Logger.getLogger(Publicador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
