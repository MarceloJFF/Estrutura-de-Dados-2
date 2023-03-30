/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_2;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author marce
 */
public class BuscaEmLargura {
    public <T extends Comparable<T>> void BFS(Grafo<T> g, Vertice<T> s, ArrayList<Vertice<T>> visitados){
        Queue<Vertice<T>> queue = new LinkedList<Vertice<T>>();
       
        for(Vertice<T> u: g.getVertices()){
            if(u.equals(s)){
                break;
            }else{
                u.setCor("Branco");
                u.setD(Double.MAX_VALUE);
                u.setPai(null);
            }
        }
        s.setCor("Cinza");
        s.setD(0);
        s.setPai(null);
        queue.add(s);
        
        while(!queue.isEmpty()){
            
            Vertice<T> u;
            
            u = queue.poll();
             if(!visitados.contains(u)){
                visitados.add(u);
            }
            //System.out.println(u.toString());
            
            for(Aresta<T> a: u.getArestasSaida()){
                
                Vertice<T> v = a.getFim();
                        
                    if(v.getCor() == "Branco"){
                       v.setCor("Cinza");
                       v.setD(u.getD()+1);
                       v.setPai(u);
                       queue.add(v);
                    }
            
            
            }
            u.setCor("Preto");
        }
        
        for(Vertice<T> v : g.getVertices() ){
            if(v.getCor() != "Preto"){
                this.BFS(g, v, visitados);
            }
        }
        
        //System.out.println(visitados);
    }
}
