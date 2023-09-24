package mivotito;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class Ejecutable {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Connection con = SqlConnection.getConnection();
        Partido p = new Partido("Unión por la Patria");
        Partido p2 = new Partido("La libertad avanza");
        Partido p3 = new Partido("Juntos por el Cambio");
        ArrayList<Candidato> presidentes = new ArrayList();
        ArrayList<Candidato> jefes = new ArrayList();

        presidentes.add(new Presidente("Javier Milei", Presidentes.MILEI, p2, 0));
        jefes.add(new JefeDeGobierno("Ramiro Marra", Jefes.MARRA, p2, 0));

        presidentes.add(new Presidente("Sergio Massa", Presidentes.MASSA, p, 0));
        presidentes.add(new Presidente("Juan Grabois", Presidentes.GRABOIS, p, 0));
        jefes.add(new JefeDeGobierno("Leandro Santoro", Jefes.SANTORO, p, 0));

        presidentes.add(new Presidente("Horacio Larreta", Presidentes.LARRETA, p3, 0));
        presidentes.add(new Presidente("Patricia Bullrich", Presidentes.BULLRICH, p3, 0));
        jefes.add(new JefeDeGobierno("Jorge Macri", Jefes.MACRI, p3, 0));
        jefes.add(new JefeDeGobierno("Martín Lousteau", Jefes.LOUSTEAU, p3, 0));
        Votante v1 = new Votante("julieta", "corti", 47070937);
        v1.votoUnico();
        Administrador a = new Administrador("Julieta", 12345);
        boolean inicio = true;
        while (inicio) {
            System.out.println("1- Sector Admin ");
            System.out.println("2- Sector Votante ");
            int iniciarS = Integer.parseInt(teclado.nextLine());
            if (iniciarS == 1) {
                System.out.println("Ingrese el nombre: ");
                String usuario = teclado.nextLine();
                System.out.println("Ingrese la contraseña: ");
                int contraseña = teclado.nextInt();
                boolean seguir = true;
                while (seguir) {
                    if ("julieta".equals(usuario) && contraseña == 12345) {
                        System.out.println("");
                        System.out.println("--------------");
                        System.out.println("Bienvenida/o " + usuario);
                        System.out.println("--------------");
                        a.estadoDeVotos();
                        break;

                    } else {
                        System.out.println("Datos incorrectos");
                        System.out.println("Ingrese el nombre: ");
                        usuario = teclado.nextLine();
                        System.out.println("Ingrese la contraseña: ");
                        contraseña = teclado.nextInt();

                    }
                }

            } else if (iniciarS == 2) {
                Votante v = crearV();
                if (v.votoUnico()) {
                    System.out.println("ya votaste");
                    break;
                } else {
                    menu(presidentes).votar();
                    menu(jefes).votar();
                    v.votar();
                }

                v.informe();
            }

        }
    }

    public static Candidato menu(ArrayList<Candidato> candidatos) {
        String text = "------Menu------\n";

        int index = 0;
        for (Candidato c : candidatos) {

            text += index + ": " + c.toString() + "\n";
            index++;

        }

        System.out.println(text);
        System.out.println("Seleccione la opcion que desee:  ");
        int opc = Integer.parseInt(teclado.nextLine());
        return candidatos.get(opc);

    }

    public static Votante crearV() {

        System.out.println("Ingrese su nombre: ");
        String n = teclado.nextLine();
        System.out.println("Ingrese su apellido: ");
        String a = teclado.nextLine();
        System.out.println("Ingrese su dni: ");
        int d = Integer.parseInt(teclado.nextLine());
        
        return new Votante(n, a, d);
    }

}
