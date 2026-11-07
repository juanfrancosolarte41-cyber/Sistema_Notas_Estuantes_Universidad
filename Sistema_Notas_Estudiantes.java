/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sistema_notas_estudiantes;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author JuanPabloFrancoSolar
 */
public class Sistema_Notas_Estudiantes {

    public static void main(String[] args) {
        List<Estudiantes> estudiantes = Arrays.asList(
                new Estudiantes("Juan", "Ingenieria", 4.5),
                new Estudiantes("Maria", "Ingenieria", 3.8),
                new Estudiantes("Carlos", "Derecho", 2.9),
                new Estudiantes("Ana", "Medicina", 5.0),
                new Estudiantes("Pedro", "Ingenieria", 4.1),
                new Estudiantes("Laura", "Derecho", 2.5),
                new Estudiantes("Sofia", "Medicina", 4.6),
                new Estudiantes("Andres", "Ingenieria", 3.0),
                new Estudiantes("Camila", "Derecho", 4.3),
                new Estudiantes("Daniel", "Medicina", 2.7)
        );

        Scanner tecla = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("  Sistema de notas de los estudiantes  ");
            System.out.println("1. Mostrar los aprobados");
            System.out.println("2. Mostrar ordenadamente");
            System.out.println("3. Mostrar los mejores 3 estudiantes");
            System.out.println("4. Promedio general");
            System.out.println("5. Promedio por programa");
            System.out.println("6. Particionar aprobados y reprobados");
            System.out.println("7. Mostrar nombre del estudiante con su nota");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = tecla.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println(" Los estudiantes aprobados son:");
                    estudiantes.stream()
                            .filter(e -> e.getnota() >= 3.0)
                            .forEach(e -> System.out.println(
                            e.getnombre() + " - " + e.getnota()));
                    break;

                case 2:
                    System.out.println(" La organizacion es:");
                    estudiantes.stream()
                            .sorted(Comparator
                                    .comparingDouble(Estudiantes::getnota)
                                    .reversed()
                                    .thenComparing(Estudiantes::getnombre))
                            .forEach(e -> System.out.println(
                            e.getnombre() + " - " + e.getnota()));
                    break;

                case 3:
                    System.out.println("\nTOP 3");
                    estudiantes.stream()
                            .sorted(Comparator
                                    .comparingDouble(Estudiantes::getnota)
                                    .reversed())
                            .limit(3)
                            .forEach(e -> System.out.println(
                            e.getnombre() + " - " + e.getnota()));
                    break;

                case 4:
                    double promedio = estudiantes.stream()
                            .mapToDouble(Estudiantes::getnota)
                            .average()
                            .orElse(0);
                    System.out.println(" El promedio general es: " + promedio);
                    break;

                case 5:
                    System.out.println(" El promedio por programa es:");
                    Map<String, Double> programas = estudiantes.stream()
                            .collect(Collectors.groupingBy(
                                    Estudiantes::getprograma,
                                    Collectors.averagingDouble(
                                            Estudiantes::getnota)));
                    programas.forEach((programa, prom)
                            -> System.out.println(programa + ": " + prom));
                    break;

                case 6:
                    System.out.println(" La lista de los aprobados y reprobados:");
                    Map<Boolean, List<Estudiantes>> particion
                            = estudiantes.stream()
                                    .collect(Collectors.partitioningBy(
                                            e -> e.getnota() >= 3.0));

                    System.out.println(" Aprobados:");
                    particion.get(true)
                            .forEach(e -> System.out.println(e.getnombre()));

                    System.out.println(" Reprobados:");
                    particion.get(false)
                            .forEach(e -> System.out.println(e.getnombre()));
                    break;

                case 7:
                    System.out.println(" MAPA NOMBRE -> NOTA");
                    Map<String, Double> mapa = estudiantes.stream()
                            .collect(Collectors.toMap(
                                    Estudiantes::getnombre,
                                    Estudiantes::getnota));
                    mapa.forEach((nombre, nota)
                            -> System.out.println(nombre + " = " + nota));
                    break;

                case 0:
                    System.out.println(" Gracis por utilizar nuestro sistema");
                    break;

                default:
                    System.out.println(" ERROR: La opcion que ingresaste es invalida");
            }
        } while (opcion != 0);

        tecla.close();
    }
}