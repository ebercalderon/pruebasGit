package com.resolucion;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ejercicio3 {

    public static void main(String[] args) {
        //Ruta de archivo de entrada
        String inputFile = System.getProperty("user.dir") + "\\data\\input\\problema_03_input.txt";

        //Ruta de archivo de salida
        String outputFile = System.getProperty("user.dir") + "\\data\\output\\problema_03_output.txt";

        //Se valida el archivo de entrada
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            //Se crea el archivo de salida
            FileWriter fw = new FileWriter(outputFile);

            //Se iteran todas las lineas del archivo de entrada
            for (String line; (line = br.readLine()) != null; ) {

                //Se convierten las cantidades de String a Int
                int[] numbers = Arrays.stream(line.split(";")).mapToInt(Integer::parseInt).toArray();

                //Llamar a la función de cálculo
                String descanso = calcularDescanso(numbers);

                //Se escribe la respuesta en el archivo de salida con un salto de linea para separar la respuesta de cada linea.
                fw.write(descanso + "\n");
            }
            //Cerramos el archivo
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String calcularDescanso(int[] arrEntrada) {
        int diagnostico, diaMes, aux;
        String diaSemana;

        // Obtenemos el resultado del combinado
        diagnostico = (arrEntrada[3] == 0) ? (arrEntrada[4] == 0) ? 0 : 10 : (arrEntrada[4] == 0) ? 2 : 5;

        // Obtenemos descanso
        aux = diagnostico - (arrEntrada[2] - arrEntrada[0]);

        // Obtenemos el dias del mes de retorno
        diaMes = (aux < 0) ? arrEntrada[0] + abs(aux) + 1 :arrEntrada[0] + diagnostico + 1;

        // Obtenemos el dia de la semana de retorno
        diaSemana = diaCalculado (diagnostico, aux, arrEntrada[1]);

        System.out.println(Integer.toString(aux) + ";" + diaMes + ";" + diaSemana);

        return Integer.toString(aux) + ";" + Integer.toString(diaMes) + ";" + diaSemana;

    }

    public static String diaCalculado (int a, int b, int c) {
        String dia = "";

        c = (b > 0) ? c + 1 + ((a <= 7) ? a : a % 7) : c + 1 + ((abs(b) <= 7) ? abs(b) : abs(b) % 7);

        switch(c % 7) {
            case 1:
                dia = "L";
                break;
            case 2:
                dia = "M";
                break;
            case 3:
                dia = "X";
                break;
            case 4:
                dia = "J";
                break;
            case 5:
                dia = "V";
                break;
            case 6:
                dia = "S";
                break;
            default:
                dia = "D";
        }
        return dia;
    }

    public static int abs (int numero) { return numero > 0 ? numero : -numero; }
}