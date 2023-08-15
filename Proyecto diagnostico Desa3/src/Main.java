import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    public static final String ruta = "src\\Recursos\\codigos_postales_hmo.txt"; //ruta archivo texto
    static String linea;
    static List<String> guardarCp; //lista de los codigos postales
    static int numRepeticiones;
    public static void main(String[] args) throws IOException {
        guardarCp = new ArrayList<>();
        File f=new File(ruta);
        BufferedReader br = new BufferedReader(new FileReader(f));
        while ((linea = br.readLine()) != null) {          //obtener los codigos postales puros y meterlos a una lista
            String[] codigos = linea.split("\\t");
            if (codigos.length >= 5) {
                String cP = codigos[0].trim();
                //System.out.println("CP: " + cP);
                guardarCp.add(cP);
            }
        }
        try{
            String pedirNumero = JOptionPane.showInputDialog("Escribe el número postal que quieras saber su número de repeticiones: ");
            Set<String> valoresCp = new HashSet<>(guardarCp); //hashset
            numRepeticiones = Collections.frequency(guardarCp, pedirNumero);
            System.out.println("Codigo postal: " + pedirNumero + ". El numero de asentamientos con este Cp son: " + numRepeticiones);
        }catch (Exception e){
            System.out.println("Bye");
        }
    }//end main
}

