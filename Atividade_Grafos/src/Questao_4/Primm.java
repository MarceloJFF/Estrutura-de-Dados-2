/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_4;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class Primm {
    
    //Primm(Grafo, arestas, vertice root)
    public static <T extends Comparable<T>> void Primm(Grafo<T> grafo, ArrayList<Aresta<T>> arestas, Vertice<T> root ){
        
        if(grafo.getVertices() != null){
            for(Vertice<T> aux: grafo.getVertices()){
                aux.setPai(null);
                aux.setD(Double.MAX_VALUE);
            }
        }
        root.setD(0.0);
        
        List<Vertice<T>> visitados = new ArrayList<Vertice<T>>();
        
        
        
        for(Vertice<T> aux: grafo.getVertices()){
                visitados.add(aux);
        }
    
        while(!visitados.isEmpty()){
                        
            Vertice<T> u =  Primm.getVerticeMenorD(visitados);
            
            
            visitados.remove(u);       
           
           
           for(Vertice<T> adj: u.getAdj()){
                   Aresta<T> a = grafo.buscarAresta(u, adj);
                   double peso = a.getPeso();
                   if(visitados.contains(adj) && adj.getD() > peso){
                        adj.setPai(u);
                        adj.setD(peso);
                        
                   }
           }
           
        } 
        grafo.getArestas().clear();       
        //grafo.removerArestas();
        
        //System.out.println(grafo.getArestas());

        for(int i = grafo.getVertices().size() - 1; i > 0 ; i--){
            Vertice<T> atual = grafo.getVertices().get(i);
            if(atual.getDado() != null && atual.getPai().getDado() != null){
                grafo.adicionarAresta(atual.getD(),atual.getPai().getDado(), atual.getDado());
            }else {
                break;
            }
            
        }
        

        System.out.println("\n");
        System.out.println(grafo.getArestas());
        
    }

    public  static<T extends Comparable<T>> Vertice<T> getVerticeMenorD(List<Vertice<T>> visitados){
        Vertice<T> menor = null;
        int i = 0;
        for(i = 0 ; i < visitados.size(); i++){
           Vertice<T> atual = visitados.get(i);
           if( i == 0){
               menor = atual;
           }else{
               if(atual.getD() < menor.getD()){
                   menor = atual;
               }
           }
        }
        return menor;
    }
}
