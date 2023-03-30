/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_1;

import grafo.Grafo;
import java.io.IOException;

/**
 *
 * @author marce
 */
public class Teste {
    public static void main(String[] args) throws IOException {
        Grafo<Integer> g = new Grafo<>();
        
        //Lendo os dados da questao 1
        util.ReadQuestao1.readVertices(g);
        util.ReadQuestao1.readArestas(g);
        //System.out.println(g.getArestas());
        
        Welsh_Powell aux = new Welsh_Powell();
        //Colorindo o grafo 1
        aux.Colorir(g);
        
        Grafo<String> g1 = new Grafo<>();
        util.ReadQuestao1.readVertices2(g1);
        util.ReadQuestao1.readArestas2(g1);
        Welsh_Powell aux2 = new Welsh_Powell();
        //Colorindo o grafo 1
        aux2.Colorir(g1);
    }
}
