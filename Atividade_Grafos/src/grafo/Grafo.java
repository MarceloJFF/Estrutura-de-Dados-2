/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;


/**
 *
 * @author marce
 */
public class Grafo<T extends Comparable<T>> {
    public boolean isDirected;
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;

    public ArrayList<Vertice<T>> getVertices() {
        return vertices;
    }
    
    public void setVertices(ArrayList<Vertice<T>> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Aresta<T>> getArestas() {
        return arestas;
    }
    
    public int buscarPosicao(Vertice<T> v){
        for(int i = 0; i < this.getVertices().size(); i++){
            if(this.getVertices().get(i).getDado().equals(v.getDado())){
                return i;
            }
        }
        return - 2;
    }
    
    public void removerArestas(){
        
        this.arestas.clear();
        System.out.println(arestas);      
    }

    public Aresta<T> buscarAresta(Vertice<T> ini, Vertice<T> fin){
        for(Aresta<T> a: this.getArestas()){
            if(a.getInicio().equals(ini) && a.getFim().equals(fin)){
                return a;
            }else if(a.getInicio().equals(fin) && a.getFim().equals(ini)){
                return a;
            }
        }
        return null;
    }
    public void setArestas(ArrayList<Aresta<T>> arestas) {
        this.arestas = arestas;
    }
    
    public Grafo(){
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
    }
    
    public void adicionarVertice(T dado){
        Vertice<T> novoVertice = new Vertice<T>(dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarVertice(Vertice<T> v){
        vertices.add(v);
        
    }
    
    public void adicionarAresta(Double peso, T dadoInicio, T dadoFim){
        Vertice<T> inicio = this.getVertice(dadoInicio);
        Vertice<T> fim = this.getVertice(dadoFim);
        Aresta<T> aresta = new Aresta<T>(peso, inicio, fim);
        
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        
        inicio.getAdj().add(fim);
        fim.getAdj().add(inicio);
        this.arestas.add(aresta);
    }
    public void adicionarAresta( T dadoInicio, T dadoFim){
        Vertice<T> inicio = this.getVertice(dadoInicio);
        Vertice<T> fim = this.getVertice(dadoFim);
        Aresta<T> aresta = new Aresta<T>(inicio, fim);
        
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        
        inicio.getAdj().add(fim);
        fim.getAdj().add(inicio);
        this.arestas.add(aresta);
    }
    
    public Vertice<T> getVertice(T dado){
        Vertice<T> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    
    
    
    
}