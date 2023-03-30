/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_4;

import grafo.Grafo;
import grafo.Vertice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class Teste1 {
    public static void main(String[] args) throws IOException {
        List<Vertice<String>> vertice = new ArrayList<>();
	
        /*g.adicionarVertice("A");//1
        g.adicionarVertice("B");//2
        g.adicionarVertice("C");//3
        g.adicionarVertice("D");//4
        g.adicionarVertice("E");//5
        g.adicionarVertice("F");//6
        
        //System.out.println(g.getVertices());
        
        g.adicionarAresta(1100.0, "A", "B");
        g.adicionarAresta(1800.0, "A", "C");
        g.adicionarAresta(2000.0, "A", "D");
        g.adicionarAresta(1200.0, "A", "F");
        

        g.adicionarAresta(900.0, "B", "C");
        g.adicionarAresta(800.0, "B", "D");
        g.adicionarAresta(750.0, "B", "E");
        
        
        g.adicionarAresta(700.0, "C", "D");
        g.adicionarAresta(850.0, "C", "F");
        
        g.adicionarAresta(1100.0, "D", "E");
        
        g.adicionarAresta(500.0, "E", "F");
        	
               */
            /*
              Grafo<String> g = new Grafo<String>();
        
              util.ReadQuestao4.readVertices4(g);
              System.out.println(g.getVertices());
              util.ReadQuestao4.readArestas4(g);
              
              Vertice<String> aux = g.getVertice("A"); 
              
              Primm.Primm(g, g.getArestas(), aux);*/
               
        Grafo<String> graph = new Grafo<String>(); 
        util.ReadQuestao4.readVertices4(graph);
        //System.out.println(graph.getVertices());
        util.ReadQuestao4.readArestas4(graph);
       
        

	Kruskal kruskalAlgorithm = new Kruskal();
	System.out.println("======= Com Kruscal ===============");
        kruskalAlgorithm.spanningTree(graph.getVertices(), graph.getArestas());
        
        System.out.println("======== Com Primm =============");
         Vertice<String> aux = graph.getVertice("A"); 
        Primm.Primm(graph, graph.getArestas(), aux);
        
    }
}
