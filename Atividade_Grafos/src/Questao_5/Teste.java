/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_5;

import grafo.Grafo;
import grafo.Vertice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
        
        
        OrdTopologica1 ot = new OrdTopologica1();
        /* Só pode escolher como root os elementos que não tem arestas entrando*/
        /* Cueca, Camisa, meis, relogio*/
        
        Teste.EscolherCandidatos(grafo);
        ot.OrdenarTopol(grafo,"Camisa");
    }
    
    public static<T extends Comparable<T>> void EscolherCandidatos(Grafo<T> g){
        ArrayList<Vertice<T>> candidatos = new ArrayList<Vertice<T>>();
        System.out.println("Esses vertices nao tem arestas entrando e podem ser utilizados como root");
        
        for(Vertice<T> v: g.getVertices()){
            
            if(v.getArestasEntrada().isEmpty()){
                candidatos.add(v);
            }
        }
        System.out.println(candidatos);
        
        System.out.println("");
        
    }
            
    
}
