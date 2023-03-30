package Questao_1;



import grafo.Grafo;
import grafo.Vertice;
import java.io.*; 
import java.util.*; 
import java.util.LinkedList; 
  
 
public class Welsh_Powell  {    
    
    public <T extends Comparable<T> > void Colorir(Grafo<T> g) { 
        
        int result[] = new int[g.getVertices().size()]; 

        Arrays.fill(result, -1); 
  
         
        result[0]  = 0; 
  
        
        boolean disponivel[] = new boolean[g.getVertices().size()]; 
          
         
        Arrays.fill(disponivel, true); 
  
        for (Vertice<T> u : g.getVertices()) { 
            
            Iterator<Vertice<T>> it = u.getAdj().iterator();
          
            while (it.hasNext()) { 
                Vertice<T> aux = it.next();

                int i = g.buscarPosicao(aux);

                if (result[i] != -1) 
                    disponivel[result[i]] = false; 
            } 
  
            // Encontrar a primeira cor livre
            int cr; 
            for (cr = 0; cr < g.getVertices().size(); cr++){ 
                if (disponivel[cr]) 
                    break; 
            } 
  
            result[g.buscarPosicao(u) ] = cr; 
  
            
            Arrays.fill(disponivel, true); 
        } 
  
        Set<Integer> auxiliar = new HashSet<>();
        //printando o resultado 
        for (int u = 0; u < g.getVertices().size(); u++){ 
            /*System.out.println("Vertice: " + g.getVertices().get(u).toString() + " --->  Cor " + result[u]); */
            System.out.println("Vertice: " + g.getVertices().get(u).getDado().toString() + " --->  Cor "+ result[u]); 
            
            for (Integer b: result){
                auxiliar.add(b);
            }
        }
        
        int k = 0;
        /*
        while(result[k] != -1 && k < result.length){
            k++;
        }*/
        System.out.println("Numero cromatico: " + auxiliar.size() + " Pois sao " + auxiliar.size() + " cores" );
    }
        
   /*
    public static void main(String args[]) 
    {   

        Grafo<Integer> g = new Grafo<>();
        g.adicionarVertice(1);
        g.adicionarVertice(2);
        g.adicionarVertice(3);
        g.adicionarVertice(4);
        g.adicionarVertice(5);

        
        g.adicionarAresta(1, 4);
        g.adicionarAresta(1, 5);
        g.adicionarAresta(1, 2);
        g.adicionarAresta(4, 3);
        g.adicionarAresta(4, 5);
        g.adicionarAresta(3, 2);
        g.adicionarAresta(3, 5);
        g.adicionarAresta(2, 5);

        
        Welsh_Powell aux = new Welsh_Powell();

       aux.Colorir(g);
    } */
} 