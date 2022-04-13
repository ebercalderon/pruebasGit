package com.resolucion;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ejercicio2 {

    public static void main(String[] args) {
        //Ruta de archivo de entrada
        String inputFile = System.getProperty("user.dir") + "\\data\\input\\problema_01_input.txt";

        //Ruta de archivo de salida
        String outputFile = System.getProperty("user.dir") + "\\data\\output\\problema_01_output.txt";

        //Se valida el archivo de entrada
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            //Se crea el archivo de salida
            FileWriter fw = new FileWriter(outputFile);

            //Se iteran todas las lineas del archivo de entrada
            for (String line; (line = br.readLine()) != null; ) {

                //Se convierten las cantidades de String a Int
                int[] numbers = Arrays.stream(line.split(";")).mapToInt(Integer::parseInt).toArray();

                //Llamar a la función de cálculo
                int suma = calcularLote(numbers);

                //Se escribe la respuesta en el archivo de salida con un salto de linea para separar la respuesta de cada linea
                fw.write(suma + "\n");
            }
            //Cerramos el archivo
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int calcularLote(int[] arrCajas) {
        //Se suman las cantidades de cada caja
        return IntStream.of(arrCajas).sum();

    }
}