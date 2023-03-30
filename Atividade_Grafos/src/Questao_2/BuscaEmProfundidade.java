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
import java.util.Collections;
import java.util.List;
;

/**
 *
 * @author marce
 */
public class BuscaEmProfundidade<T extends Comparable<T>>  {
    static double temp;
   
    public <T extends Comparable<T>>  ArrayList<Vertice<T>> DFS(Grafo<T> grafo,  Vertice<T> root){
        
        ArrayList<Vertice<T>> res = new ArrayList<Vertice<T>>();
        ArrayList<Vertice<T>> subArv = new ArrayList<Vertice<T>>();
        
        for(Vertice<T> u : grafo.getVertices()){
            u.setCor("Branco");
            u.setPai(null);
        }
        
        if(root.getDado().equals("Camisa")){
            DFSBusca(grafo,root,subArv,res);
           /* Collections.reverse(subArv);
                for(int i = 0; i < subArv.size(); i++){
                    res.add(subArv.get(i));
                   
                }
                for(int i = 0; i < subArv.size(); i++){
                    subArv.clear();
                }
        */}
            
        for(Vertice<T> u : grafo.getVertices()){
            if(u.getCor().equals("Branco")){
                /*Collections.reverse(subArv);
                for(int i = 0; i < subArv.size(); i++){
                    res.add(subArv.get(i));
                   
                }
                for(int i = 0; i < subArv.size(); i++){
                    subArv.clear();
                }*/
                DFSBusca(grafo,u,subArv,res);
            }
        }
        //System.out.println(res);
        return res;
    }
    
    public <T extends Comparable<T>> void DFSBusca(Grafo<T> g, Vertice<T> u, ArrayList<Vertice<T>> subArv,ArrayList<Vertice<T>> res){
        temp++;
        
        u.time = temp;
        u.setCor("Cinzento");
        
        for(Aresta<T> a: u.getArestasSaida()){
            Vertice<T> v = a.getFim();
            if(v.getCor().equals("Branco")){
                v.setPai(u);
                this.DFSBusca(g, v,subArv,res);
            }
            
            
            
        }
        u.setCor("Preto");
        temp++;
        u.time = temp;
        //System.out.println(u.toString() + "Acessado");
        res.add(u);
        /*
        if( !res.contains(u)){
            subArv.add(u);
        }*/
//        
        //System.out.println(""+subArv.get(0).getCor());
        //System.out.println("" + u.getDado().toString());
       
    }
   
    
}
