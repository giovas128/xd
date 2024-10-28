package EB;

import java.util.Random;

public class ExamenB {
    public static int[] pilaA;
    public static int[] pilaB;
    public static int[] pilaC;
    public static int topeA = -1;
    public static int topeB = -1;
    public static int topeC = -1;

    public static void llenarPilas(int tamanoPila) {
        pilaA = new int[tamanoPila];
        pilaB = new int[tamanoPila];
        pilaC = new int[tamanoPila];
        llenarPilaA();
        llenarPilaB();
        llenarPilaC();
    }

    public static void llenarPilaA() {
        topeA = -1;
        for (int i = 100; i <= 500 && topeA < pilaA.length - 1; i++) {
            if (i % 3 == 0) {
                pilaA[++topeA] = i;
            }
        }
    }

    public static void llenarPilaB() {
        topeB = -1;
        for (int i = 100; i <= 200 && topeB < pilaB.length - 1; i++) {
            if (i % 7 == 0) {
                pilaB[++topeB] = i;
            }
        }
    }

    public static void llenarPilaC() {
        topeC = -1;
        for (int i = 0; i <= 100 && topeC < pilaC.length - 1; i++) {
            if (i % 5 == 0) {
                pilaC[++topeC] = i;
            }
        }
    }

    // Mostrar pilas
    public static String mostrarPila(String nombre, int[] pila, int tope) {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(":\n");
        for (int i = 0; i <= tope; i++) {
            sb.append("Posición ").append(i + 1).append(" con el valor ").append(pila[i]).append("\n");
        }
        return sb.toString();
    }

    // Uniones
    public static int[] union1() {
        int[] union = new int[topeA + topeB + topeC + 3];
        int indice = 0;
        for (int i = 0; i <= topeA; i++) {
            union[indice++] = pilaA[i];
        }
        for (int i = 0; i <= topeB; i++) {
            union[indice++] = pilaB[i];
        }
        for (int i = 0; i <= topeC; i++) {
            union[indice++] = pilaC[i];
        }
        return union;
    }

    public static int[] union2() {
        int maxSize = Math.max(topeA + 1, Math.max(topeB + 1, topeC + 1));
        int[] union = new int[maxSize * 3];
        int indice = 0;
        for (int i = 0; i < maxSize; i++) {
            if (i <= topeA) {
                union[indice++] = pilaA[i];
            }
            if (i <= topeB) {
                union[indice++] = pilaB[i];
            }
            if (i <= topeC) {
                union[indice++] = pilaC[i];
            }
        }
        return union;
    }

    public static int[] union3() {
        int maxSize = Math.max(topeA + 1, Math.max(topeB + 1, topeC + 1));
        int[] union = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            int suma = 0;
            if (i <= topeA) {
                suma += pilaA[i];
            }
            if (i <= topeB) {
                suma += pilaB[i];
            }
            if (i <= topeC) {
                suma += pilaC[i];
            }
            union[i] = suma;
        }
        return union;
    }

    // Mostrar uniones
    public static String mostrarUnion(int[] union) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < union.length && union[i] != 0; i++) {
            sb.append("Posición ").append(i + 1).append(" con el valor ").append(union[i]).append("\n");
        }
        return sb.toString();
    }

    public static void agregarValor(int valor) {
        if (topeA < pilaA.length - 1) {
            pilaA[++topeA] = valor;
        }
        if (topeB < pilaB.length - 1) {
            pilaB[++topeB] = valor;
        }
        if (topeC < pilaC.length - 1) {
            pilaC[++topeC] = valor;
        }
    }

}
