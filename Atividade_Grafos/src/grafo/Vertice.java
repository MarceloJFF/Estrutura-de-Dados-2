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
public class Vertice<T extends Comparable<T>>  {
    private T dado;
    
    private ArrayList<Aresta<T>> arestasSaida;
    private ArrayList<Aresta<T>> arestasEntrada;
    private ArrayList<Vertice<T>> adj;// elementos adjacente, ou seja, que saem desse vertice para outro
    private boolean visitado;
    private Node node;
    private Vertice<T> pai;
    private double d; // estimativa de distancia, utilizamos Double.getMax para considerar como se fosse infinito
    private String cor;
    public double time;
    public double FINAL;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
    public ArrayList<Vertice<T>> getAdj() {
        return adj;
    }

    public void setAdj(ArrayList<Vertice<T>> adj) {
        this.adj = adj;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Vertice<T> getPai() {
        return pai;
    }

    public void setPai(Vertice<T> pai) {
        this.pai = pai;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }
    
   
    public Vertice(T valor){
        this.dado = valor;
        
        this.arestasSaida = new ArrayList<Aresta<T> >();
        this.arestasEntrada = new ArrayList<Aresta<T>>();
        this.adj = new ArrayList<Vertice<T>>();
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }
 
    
    public void adicionarArestaEntrada(Aresta<T> aresta){
        this.arestasEntrada.add(aresta);
        adj.add(aresta.getInicio());
    }
    
    public void adicionarArestaSaida(Aresta<T> aresta){
        this.arestasSaida.add(aresta);
        adj.add(aresta.getFim());
    }

    public ArrayList<Aresta<T>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<T>> getArestasSaida() {
        return arestasSaida;
    }
    
    

    @Override
    public String toString() {
        return "Vertice{"+" time: " + this.time + " estimativa d: "  + this.d + " dado = " + this.dado.toString() + '}';
    }

     
    public  int compareTo(Vertice<T> otherVertex) {
        
        //return Double.compare(this.minimaDistancia, otherVertex.minimaDistancia);
        return Double.compare(this.d, otherVertex.d);
    }
    public int compareTo(Vertice<T> aux, boolean t) { 
       return Double.compare(this.time, aux.time);
   }
}
