/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_2;

import grafo.Grafo;
import grafo.Vertice;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author marce
 */
public class Teste {
    public static void main(String[] args) throws IOException {
        Grafo<String> grafo = new Grafo<String>();
        grafo.isDirected = true;
        /*grafo.adicionarVertice("Cueca");
        grafo.adicionarVertice("Calças");
        grafo.adicionarVertice("Cinto");
        grafo.adicionarVertice("Camisa");
        grafo.adicionarVertice("Gravata");
        grafo.adicionarVertice("Paleto");
        grafo.adicionarVertice("Sapatos");
        grafo.adicionarVertice("Meias");
        grafo.adicionarVertice("Relogio");
        */
        /*
        grafo.adicionarAresta("Cueca","Calças");
        grafo.adicionarAresta("Cueca","Sapatos");
        grafo.adicionarAresta("Meias","Sapatos");
        grafo.adicionarAresta("Calças","Cinto");
        grafo.adicionarAresta("Calças","Sapatos");
        grafo.adicionarAresta("Cinto","Paleto");
        grafo.adicionarAresta("Camisa","Cinto");
        grafo.adicionarAresta("Camisa","Gravata");
        grafo.adicionarAresta("Camisa","Paleto");
        */
        //grafo.adicionarAresta("Relogio","Relogio");
        util.ReadQuestao5.readVertices4(grafo);
        util.ReadQuestao5.readArestas4(grafo);
        
        
        System.out.println("=============== Busca em Largura ================");
        Vertice<String> inicial = grafo.getVertice("Gravata");
        ArrayList<Vertice<String>> visitados  = new ArrayList<Vertice<String>>();
        
        BuscaEmLargura b = new BuscaEmLargura();
        b.BFS(grafo, inicial, visitados);
        System.out.println(visitados);
        
        
        System.out.println("=============== Busca em Profundidade ================"); 
        BuscaEmProfundidade bep = new BuscaEmProfundidade();
        Vertice<String> root = grafo.getVertice("Camisa");
        ArrayList<Vertice<String>> res = bep.DFS(grafo, root);
        System.out.println(res);
       
        
        
        
        
    }
}
