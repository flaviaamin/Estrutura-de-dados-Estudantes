/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.lista;

import modelo.Estudante;

/**
 *
 * @author Usuário
 */
public class Programa {

    public static void main(String[] args) {
        int n = 3;
        ListaDupla lista = new ListaDupla();
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            Estudante estudante = new Estudante();
            lista.put(estudante.getMatricula(), estudante);

        }
        long tempoFinal = System.nanoTime();
        long tempoInsere = tempoFinal - tempoInicial;

        tempoInicial = System.nanoTime();
        lista.imprimirLista();
        tempoFinal = System.nanoTime();

        System.out.println("Inserir: " + tempoInsere);

        System.out.println("Exibir: " + (tempoFinal - tempoInicial));

        tempoInicial = System.nanoTime();
        lista.pesquisaES();
        tempoFinal = System.nanoTime();
        System.out.println("Pesquisar ES: " + (tempoFinal - tempoInicial));

        tempoInicial = System.nanoTime();
        lista.remove202050000();
        tempoFinal = System.nanoTime();
        System.out.println("Remover: " + (tempoFinal - tempoInicial));

    }

}
