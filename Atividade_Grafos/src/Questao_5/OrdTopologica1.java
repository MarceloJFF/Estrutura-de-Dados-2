/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_5;

import grafo.Grafo;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author marce
 */
public class OrdTopologica1 {
    public <T extends Comparable<T>> void OrdenarTopol(Grafo<T> g, String inicio){
        BuscaEmProfundidade1 b = new BuscaEmProfundidade1();
        
        //verificar quem nao tem arestas entrando+
        Vertice<T> root;
        root = OrdTopologica1.pegarRoot(g,inicio);
        //ArrayList <Vertice<T> > visita;
        ArrayList<Vertice<T> > aux = b.DFS(g, root);
        
        //OrdTopologica.sort(aux);
        Collections.reverse(aux);
        System.out.println(aux);
    }
    
    public static <T extends Comparable<T>> Vertice<T> pegarRoot(Grafo<T> g, String root){
        
        for(Vertice<T> v: g.getVertices()){
            if(v.getDado().equals(root)){
                return v;
            }
        }
        return null;
    }
    
    
         /* abaixo segue o algoritmo Comb Sort utilizado para ordenar as arestas pelo peso*/
        public static <T extends Comparable<T>> void sort (ArrayList<Vertice<T>> v){

            int n = v.size();


            int gap = n;

            boolean swapped = true;// troca


            while (gap != 1 || swapped == true){

                gap = getNextGap(gap);        
                swapped = false;
                for (int i=0; i<n-gap; i++){
                    if( v.get(i).compareTo((v.get(i+gap)), true) > 0 ){
                        Collections.swap(v, i, i+gap);
                        swapped = true;
                    }
                }
            }       
        }
        
        public static int getNextGap(int gap){

            gap = (gap*10)/13;
            if (gap < 1)
                return 1;
            return gap;
        }
}
