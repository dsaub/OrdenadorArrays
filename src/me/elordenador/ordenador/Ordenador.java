package me.elordenador.ordenador;

import me.elordenador.BarUtils;
import me.elordenador.ScrUtils;

import java.io.IOException;
import java.util.Scanner;

public class Ordenador {

    private int[] array;
    private boolean showProgressBar = false;
    private BarUtils barUtils;

    public Ordenador(int[] array) {
        this.array = array;
        barUtils = new BarUtils(array.length);
    }

    public void enableProgressBar() {
        barUtils.enable();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Diga la cantidad de numeros a introducir: ");
        System.out.print("> ");
        int cantidad = sc.nextInt(); sc.nextLine();
        int[] array = new int[cantidad];
        BarUtils barUtils = new BarUtils(cantidad);
        barUtils.enable();
        System.out.println("Generando numeros aleatorios: ");
        for (int i = 0; i < cantidad; i++) {
            array[i] = (int)Math.floor(Math.random() * cantidad*10);
            barUtils.update(i);
        }
        barUtils.finish();

        Ordenador ordenador = new Ordenador(array);
        ordenador.enableProgressBar();
        System.out.println("Ordenando numeros...");
        array = ordenador.run();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public int[] run() throws IOException {
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if ((y+1) != array.length) {
                    if (array[y] > array[y+1]) {
                        int aux = array[y];
                        array[y] = array[y+1];
                        array[y+1] = aux;
                    }
                }

            }
            barUtils.update(x);
        }

        barUtils.finish();
        return array;

    }
}
