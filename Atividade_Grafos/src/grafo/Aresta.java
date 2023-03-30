/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;



/**
 *
 * @author marce
 */
public class Aresta<T extends Comparable<T>> {
    private Double peso;
    private Vertice<T> inicio; // de onde parte
    private Vertice<T> fim; // onde chega

    public Aresta(Double peso, Vertice<T> inicio, Vertice<T> fim) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }
    public Aresta( Vertice<T> inicio, Vertice<T> fim) {
        
        this.inicio = inicio;
        this.fim = fim;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Vertice<T> getInicio() {
        return inicio;
    }
     public int compareTo(Aresta<T> aux) { 
       return Double.compare(this.peso, aux.getPeso());
   }

    public void setInicio(Vertice<T> inicio) {
        this.inicio = inicio;
    }

    public Vertice<T> getFim() {
        return fim;
    }

    public void setFim(Vertice<T> fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return "Aresta [inicio=" + inicio.toString() + ", fim=" + fim.toString() + ", peso =" + peso + "]"+"\n";

    }

}
