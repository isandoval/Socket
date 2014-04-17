/*
 * Creado por  .-  Ivan Marcelo Sandoval Quintanilla
 * Ejemplo     .-  Publicador Lector
 * Curso       .-  Integracion de Sistemas
 */

package servidor;

 import java.io.IOException;
 import java.net.ServerSocket;
 import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 import java.io.OutputStream;
 import java.net.Socket;
 import java.util.logging.Level;
 import java.util.logging.Logger;

/* import java.net.ServerSocket;
 import java.io.InputStream;
 import java.io.OutputStream;
   java.net.Server.Socket  .-  Es una clase ocupada por java para comunicaese
                               a travez de la red.
   java.io.InputStream     .-  Sirve para recivir objetos a travez de la red
   java.io.OutputStream    .-  Sirve para Enviar Objetos por la red

*/

public class Servidor 
{
    public static void main(String[] args) 
    {
        try 
        {
            ServerSocket servidor = new ServerSocket(4500);   // Iniciamos Servidor
            Socket publicador = servidor.accept();            // Aceptamos las entradas del publicador
            ObjectInputStream entrada = new ObjectInputStream(publicador.getInputStream());
            String msn = (String) entrada.readObject();
            Socket lector = servidor.accept();
            ObjectOutputStream publicar = new ObjectOutputStream(lector.getOutputStream());
            publicar.writeObject(msn);
            servidor.close();
            publicador.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
