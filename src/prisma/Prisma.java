package prisma;
import Modelos.Trabajadores;
import Modelos.Proyectos;
import java.util.Scanner;
public class Prisma {
    public static void main(String[] args) {
        String fechaI,fechaS,coment,nombreP,calificacion;
        int score;
        
        Scanner scan[] = new Scanner[5];
        scan[0]=new Scanner(System.in);
        scan[1]=new Scanner(System.in);
        scan[2]=new Scanner(System.in);
        scan[3]=new Scanner(System.in);
        scan[4]=new Scanner(System.in);
        Trabajadores workers[] = new Trabajadores[2];
        
        System.out.println("Digite la fecha de ingreso:");
        fechaI = scan[0].nextLine();
        System.out.println("Digite la fecha de salida:");
        fechaS = scan[1].nextLine();
        System.out.println("Digite los comentarios:");
        coment = scan[2].nextLine();
        System.out.println("Digite el nombre del proyecto: ");
        nombreP = scan[3].nextLine();
        System.out.println("Digite la calificacion: ");
        calificacion = scan[4].nextLine();
        score = Integer.parseInt(calificacion);
        
        
        workers[0].setNewProyect(fechaI, fechaS, score, coment, nombreP);
        Proyectos obj=workers[0].getProyecto(0);
        System.out.println("Comentarios: " + obj.getCometarios());
        System.out.println("Fecha de ingreso: " + obj.getFechaI());
        System.out.println("Fecha de salida: " + obj.getFechaS());
        System.out.println("Calificacion: " + obj.getScore());
        System.out.println("Nombre del proyecto: " + obj.getNombreProyecto());
        
    }
    
}
