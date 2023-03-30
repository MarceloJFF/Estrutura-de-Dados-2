/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_3;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author marce
 */
public class Dijkstra<T extends Comparable<T>> {
    
   public <T extends Comparable<T>> void Processamento(Grafo<T> grafo, Vertice<T> raiz, Vertice<T> fim){
       if(grafo!=null && raiz != null){
           this.Processamento(grafo, raiz);
           this.imprimirPercurso(this.organizandoMenorCaminho(fim));
       }else{
           System.out.println("Elementos inválidos");
       }
   }
   
   public <T extends Comparable<T>>void imprimirPercurso(List<Vertice<T>> res){
        for(int i= 0; i < res.size(); i++ ){
            //System.out.print( res.get(i).getDado().toString()+ " -> ");
            
        }
   }
    
    
    public  <T extends Comparable<T>> void Processamento(Grafo<T> grafo, Vertice<T> raiz) {
        for(Vertice<T> v: grafo.getVertices()){
            v.setPai(null);
            v.setD(Double.MAX_VALUE);
        }
        
        raiz.setD(0);// setando aqui a estimativa de distancia do elemento root como 0
        
        Queue<Vertice<T>> fp = new LinkedList<>();// instancia da fila de prioridade para armazenar os valores visitados
        
        fp.add(raiz);// adicionando na fila o elemento root
        
        
        //Percorremos a fila dos elementos para visita-los seguindo a ordem do algoritmo
        while (!fp.isEmpty()) {
            Vertice<T> u = fp.poll();// pegamos o topo da pilha pra fazer o estudo
            
            // estamos verificando aqui todas as arestas de saída para Relaxar elas
            for (Aresta a : u.getArestasSaida()) {
                Vertice<T> v = a.getFim();
                
                double peso = a.getPeso();
                    
                double menorDistancia = u.getD() + peso;
                //Relaxando o vértice
                if (v.getD() > menorDistancia){
                    fp.remove(u);
                    v.setPai(u);
                    v.setD(menorDistancia);
                    fp.add(v);
                }
            }
        }
    }

    public <T extends Comparable<T>> List<Vertice<T>> organizandoMenorCaminho(Vertice<T> targetVerte) {
        List<Vertice<T>> percurso = new ArrayList<>();// array em que vou guardar os elementos percorridos no menor caminho
       
        // nesse laço nós percorremos o grafo do elemento final para a raiz
        for (Vertice<T> atual = targetVerte; atual != null; atual = atual.getPai() ) {
            percurso.add(atual);
        }
        //Após percorrermos todos os elementos de trás pra frente
        // fazemos a reordenação da raiz pro elemento final com o comando abaixo
        Collections.reverse(percurso);
        System.out.println(percurso);
        return percurso;
    }
}
