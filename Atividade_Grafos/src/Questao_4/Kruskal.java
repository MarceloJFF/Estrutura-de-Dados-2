package Questao_4;

import grafo.Aresta;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal<T extends Comparable<T>> {

	 public void spanningTree(ArrayList<Vertice<T>> vertices, ArrayList<Aresta<T>> arestas){
		
                    DisjointSet disjointSet = new DisjointSet(vertices);

		    
		    ArrayList<Aresta<T>> tree = new ArrayList<Aresta<T>>();// instanciacao da Arv geradora minima
		    
                    Kruskal.sort(arestas); // Ordenando pelo peso das arestas
		    
                    for (Aresta<T> e : arestas) {
		      Vertice<T> u = e.getInicio();
		      Vertice<T> v = e.getFim();
                      
                      
                      //Verificamos abaixo se u e v pertencem ao mesmo conjunto 
		      if (disjointSet.Encontrar(u.getNode()) != disjointSet.Encontrar(v.getNode())) {
		        
		        tree.add(e);// se não pertencerem ao msm conjuntos adicionamos nessa árvore    
		        
                        disjointSet.union(u.getNode(), v.getNode()); // fazemos a união dos conjuntos nessa operação
		      }
		    }
                    
                    //printando a arvore geradora minima
		    for(Aresta<T> a : tree){
                       
                        System.out.println(" Inicio: "+a.getInicio() + " Fim " + a.getFim()+ " Peso "+ a.getPeso() );
		    }
	 }
         
         /* abaixo segue o algoritmo Comb Sort utilizado para ordenar as arestas pelo peso*/
        public static <T extends Comparable<T>> void sort (ArrayList<Aresta<T>> a){

            int n = a.size();


            int gap = n;

            boolean swapped = true;// troca


            while (gap != 1 || swapped == true){

                gap = getNextGap(gap);        
                swapped = false;
                for (int i=0; i<n-gap; i++){
                    if(a.get(i).compareTo(a.get(i+gap))>0){
                        Collections.swap(a, i, i+gap);
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
