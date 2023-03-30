/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_3;

import grafo.Grafo;
import grafo.Vertice;
import java.io.IOException;

/**
 *
 * @author marce
 */
public class Teste {
    
    public static void main(String[] args) throws IOException {
       
        Grafo<String> g = new Grafo<String>();
        g.isDirected = true;
        
        util.ReadQuestao3.readVertices2(g);
        
        util.ReadQuestao3.readArestas2(g);
        
        //System.out.println(g.getVertices());
        
        Vertice<String> inicio = g.getVertice("São Luís"); 
        Vertice<String> fim = g.getVertice("Rio Branco");
        
        Dijkstra dijkstra = new Dijkstra();
        
        System.out.println("Menor caminho de "+ inicio.getDado().toString() + " ate "+ fim.getDado().toString() + " Pelo menor caminho");
        System.out.println("Passa pelas cidades abaixo: ");
        dijkstra.Processamento(g, inicio, fim);
        
        //System.out.println(g.getArestas());
        
       

    }
}
