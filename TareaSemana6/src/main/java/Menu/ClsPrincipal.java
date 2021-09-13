/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;


import Objetos.Funcion;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author HP
 */
public class ClsPrincipal {

   
    public static void main(String[] args) {
         File archivo;
    try{
    archivo= new File ("C:\\Users\\HP\\Desktop\\Archivos\\familia.txt");
    if (archivo.createNewFile())
    {
        System.out.println("Se ha creado el archivo");
        
    }
                   }catch(IOException e)
                   {
                       System.err.println("No se ha podido crear el archivo"+ e);
}
       
        Funcion clase = new Funcion();
        clase.main();
    
    }
   
    
            
    
}
