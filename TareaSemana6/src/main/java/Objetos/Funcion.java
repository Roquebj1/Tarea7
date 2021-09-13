/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;


import Clases.CalculoMes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class Funcion {
     
    public static ArrayList<CalculoMes> list = new ArrayList();

    public static Scanner t = new Scanner(System.in);

    public static void GuardarNombre() {
        String actual = "";
        String nuevo = "";

        System.out.println("Ingrese el nombre actual: ");
        actual = t.nextLine();
        System.out.println("Ingrese el nombre modificado: ");
        nuevo = t.nextLine();

        for (int x = 0; x < list.size(); x++) {
            if (list.get(x).getNombre().equals(actual)) {
                list.get(x).setNombre(nuevo);

            }

        }

        System.out.println("Cambio exitoso de : " + actual + " por: " + nuevo);

    }

    public static void cargaInfo(int filas) {

        for (int x = 0; x < filas; x++) {

            System.out.println("Ingrese su nombre: ");
            String nombre = t.nextLine();
            System.out.println("Ingrese informacion de enero");
            String enero = t.nextLine();
            System.out.println("Ingrese informacion de febrero");
            String febrero = t.nextLine();
            System.out.println("Ingrese informacion de marzo");
            String marzo = t.nextLine();

            CalculoMes cls = new CalculoMes(nombre, Integer.parseInt(enero), Integer.parseInt(febrero), Integer.parseInt(marzo), 0, 0);
            list.add(cls);
        }

    }
    public static void calcTotalMes() {
        Double acumuladorMes;

        acumuladorMes = 0.0;

        for (int fila = 0; fila < list.size(); fila++) {

            acumuladorMes += list.get(fila).getEnero();
        }
        System.out.println("El total de la columna enero es " + acumuladorMes);
        acumuladorMes = 0.0;

        for (int fila = 0; fila < list.size(); fila++) {

            acumuladorMes += list.get(fila).getFebrero();
        }
        System.out.println("El total de la columna febrero es " + acumuladorMes);
        acumuladorMes = 0.0;
        for (int fila = 0; fila < list.size(); fila++) {

            acumuladorMes += list.get(fila).getMarzo();
        }

        System.out.println("El total de la columna marzo es " + acumuladorMes);
        acumuladorMes = 0.0;
    }

    public static void imprimirDecorado(ArrayList<CalculoMes> array) {
        System.out.println("Nombre \t| Enero \t| Febrero \t| Marzo \t| Total \t| Promedio");

        for (int x = 0; x < list.size(); x++) {

            System.out.print(list.get(x).getNombre());
            System.out.print(" \t|");
            System.out.print(list.get(x).getEnero());
            System.out.print(" \t|");
            System.out.print(list.get(x).getFebrero());
            System.out.print(" \t|");
            System.out.print(list.get(x).getMarzo());
            System.out.print(" \t|");
            System.out.print(list.get(x).getTotal());

            System.out.print(" \t|");
            System.out.print(list.get(x).getPromedio());

            System.out.print(" \t|");
            System.out.print(" \n");

        }

    }
    public static void GuardarInfo() {
        String nombre = "";
        int mes = 0;
        String valor = "";

        System.out.println("Ingrese su nombre: ");
        nombre = t.nextLine();
        System.out.println("Ingrese el numero de mes: ");
        mes = Integer.parseInt(t.nextLine());
        System.out.println("Ingrese el nuevo valor: ");
        valor = t.nextLine();

        for (int x = 0; x < list.size(); x++) {
            if (list.get(x).getNombre().equals(nombre)) {
                list.get(x).setMes(mes, Integer.parseInt(valor));
                break;

            }

        }

        System.out.println("Cambio exitoso del valor de: " + mes + " de la persona: " + nombre + " por el valor de: " + valor);
        calcTotalMeses();
        imprimirDecorado(list);
        calcTotalMes();
    }


    public static void mayormenor() {

        Double numeroMayor = 0.0;
        Double numeroMenor = 0.0;

        String nombreMayor = "";
        String nombreMenor = "";
        for (int x = 0; x < list.size(); x++) {
            if (list.get(x).getEnero() > numeroMayor) {
                numeroMayor = list.get(x).getEnero();
                nombreMayor = list.get(x).getNombre();
            }

            if (list.get(x).getFebrero() > numeroMayor) {
                numeroMayor = list.get(x).getFebrero();
                nombreMayor = list.get(x).getNombre();
            }
            if (list.get(x).getMarzo() > numeroMayor) {
                numeroMayor = list.get(x).getMarzo();
                nombreMayor = list.get(x).getNombre();
            }
            if (x == 0) {
                numeroMenor = list.get(x).getEnero();
                nombreMenor = list.get(x).getNombre();
            }

            if (list.get(x).getEnero() < numeroMenor) {
                numeroMenor = list.get(x).getEnero();
                nombreMenor = list.get(x).getNombre();
            }

            if (list.get(x).getFebrero() < numeroMenor) {
                numeroMenor = list.get(x).getFebrero();
                nombreMenor = list.get(x).getNombre();
            }
            if (list.get(x).getMarzo() < numeroMenor) {
                numeroMenor = list.get(x).getMarzo();
                nombreMenor = list.get(x).getNombre();
            }

        }

        System.out.println("La venta mayor por mes es: " + numeroMayor + " de: " + nombreMayor);
        System.out.println("La venta menor por mes es: " + numeroMenor + " de: " + nombreMenor);
    }

    public static void busqueda() {

        String valor = "";
        String nombre = "";
        int mes = 0;
        System.out.println("Ingrese el valor a buscar: ");
        valor = t.nextLine();
        for (int x = 0; x < list.size(); x++) {
            if (list.get(x).getEnero() == Double.parseDouble(valor)) {
                nombre = (list.get(x).getNombre());
                mes = 1;
            }
            if (list.get(x).getFebrero() == Double.parseDouble(valor)) {
                nombre = (list.get(x).getNombre());
                mes = 1;
            }
            if (list.get(x).getMarzo() == Double.parseDouble(valor)) {
                nombre = (list.get(x).getNombre());
                mes = 1;
            }
        }
        if (nombre.equals("")) {
            System.out.println("No se ha encontrado el valor");

        } else {
            System.out.println("La venta pertenece a: " + nombre );

        }
    }
public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
        
    }
        
 

    public void escribir(String nombreArchivo) {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            
            for(CalculoMes centinela : list){
        salida.println( centinela.nom +";" + centinela.enero +";" + centinela.febrero +";" + centinela.marzo +";" );
            }
            
            salida.close();
            System.out.println("Se ha escrito el registro en el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
        
    }
    
    
     
    public void buscarPeliculas(String nombreArchivo, String buscar) {
        String resultado = null;
        resultado = buscar(nombreArchivo, buscar);
         System.out.println("Resultado Busqueda:"+resultado);
    
    }
    public String buscar(String nombreArchivo, String buscar) {
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);
            
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i=0;
            linea = entrada.readLine();
            while (linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula: "+ linea + " encontrada en el indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }   entrada.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                 ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }
    
    

    public void crear(String nombreArchivo) {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
          } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    

    public void borrar(String nombreArchivo) {
       File archivo = new File(nombreArchivo);
    archivo.delete();
    System.out.println("Se ha borrado el archivo");
    }
    
    
    
    
    public void cargar(String nombre){
        File archivo = new File(nombre);

        try {
            
            
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            int num = 0;
            
            while (linea != null){
 
  
                String [] array = linea.split(";");
                String nom = array[0] + "";
                int enero = Integer.parseInt(array[1]);
                int febrero = Integer.parseInt(array[2]);
                int marzo=Integer.parseInt(array[3]);
                
           CalculoMes cls = new CalculoMes(nombre, (enero), (febrero), (marzo), 0, 0);
                list.add(cls);
                


                
  
                num++;
                System.out.println("Linea" + num + "= " + linea);
                linea = entrada.readLine(); 
            }
                 
                
                          
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            System.out.println("Lo lamento el archivo esta ocupado");
            ex.printStackTrace(System.out);
        }
    }//fin

    public static void quienvendio() {
        double numeroMayor = 0.0;
        String nombreMayor = "";

        double enero = 0.0;
        double febrero = 0.0;
        double marzo = 0.0;

        for (int x = 0; x < list.size(); x++) {
            if (list.get(x).getEnero() > numeroMayor) {
                numeroMayor = +list.get(x).getEnero();
                nombreMayor = list.get(x).getNombre();
            }

            if (list.get(x).getFebrero() > numeroMayor) {
                numeroMayor = +list.get(x).getFebrero();
                nombreMayor = list.get(x).getNombre();

            }
            if (list.get(x).getMarzo() > numeroMayor) {
                numeroMayor = +list.get(x).getMarzo();
                nombreMayor = list.get(x).getNombre();

            }

        }

        System.out.println("La venta mayor por mes es : " + numeroMayor + " de: " + nombreMayor);
    }

    public static void calcTotalMeses() {

        String nombrePersona = "";
        Double acumuladorMes;
        int cantMeses;
        double promedio;

        for (int fila = 0; fila < list.size(); fila++) {
            cantMeses = 0;
            acumuladorMes = 0.0;
            promedio = 0;


            acumuladorMes += list.get(fila).getEnero();
            acumuladorMes += list.get(fila).getFebrero();
            acumuladorMes += list.get(fila).getMarzo();

            promedio = acumuladorMes / 3;

            list.get(fila).setTotal(acumuladorMes);
            list.get(fila).setPromedio(promedio);

            nombrePersona = list.get(fila).getNombre();

            System.out.println("Total de " + nombrePersona + " es de : " + acumuladorMes);
        }

    }
 

    public void main() {

        boolean salir = false;
        String opcion = ""; 

        while (!salir) {

            System.out.println("1. Cargar informacion:");
            System.out.println("2. Venta maxima y venta minima:");
            System.out.println("3. Venta maxima en los 3 meses:");
            System.out.println("4. Modificar nombre");
            System.out.println("5. Modificar valor");
            System.out.println("6. Buscar cantidad:");
            System.out.println("7. Desplegar ArrayList:");
            System.out.println("8. Salir");

            try {

                System.out.println("Escribe el numero de la opción deseada:");
                opcion = t.nextLine();

                switch (opcion) {
                    case "1":

                        cargaInfo(3);
                        break;
                    case "2":
                        mayormenor();
                        break;
                    case "3":
                        quienvendio();

                        break;
                    case "4":
                        GuardarNombre();
                        break;
                    case "5":
                        GuardarInfo();
                        break;
                    case "6":
                        busqueda();
                        break;
                    case "7":
                        calcTotalMeses();
                        imprimirDecorado(list);
                        calcTotalMes();
                        break;
                    case "8":
                        salir = true;
                        break;
                    default:
                        System.out.println("Por favor, ingrese el numero correcto de las opciones");
                }
            } catch (InputMismatchException e) {
                System.out.println("Upsss, debes insertar un número");
                t.next();
            }

        }

    }
}
