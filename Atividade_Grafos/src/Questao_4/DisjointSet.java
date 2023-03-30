package Questao_4;

import grafo.Node;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.List;

public class DisjointSet <T extends Comparable<T>> {

	private int qtdNodes = 0;
	private int c = 0;
	private List<Node> Nodes;

	public DisjointSet(ArrayList<Vertice<T>> vertices) {
		this.Nodes = new ArrayList<Node>(vertices.size());
		makeSets(vertices); /* essa funcao faz com que todos os vertices fiquem separados cada um sendo 
                elemento de um conjunto distinto*/
	}

        
        /* Essa funcao retorna o indice do conjunto em que N está, ou seja, percorremos todos os nodes 
        pelos pais até encontrar o primeiro node (raiz). Ao encontrarmos ele, o mesmo tem um id.
        Elementos em que o root raiz tem o mesmo id estão no mesmo conjunto.
        */
	public int Encontrar(Node n) {
		
		
                Node atual = n;
		
		/* Encontrando o primeiro elemento do conjunto em que n está*/
                
                while(atual.getPai() != null){
                    atual = atual.getPai();
                }
                Node raiz = atual;
                
                
		
                /* aqui nós basicamente estamos setando o nó raiz como pai diretamente de todos os elementos do conjunto, ou seja, o primeiro elemento do conjunto que n faz parte 
                como pai de todos os elementos que estão nele. Para otimizar as buscas no conjunto.
                */
		atual  = n;
                
                while (atual != raiz){
                    Node aux = atual.getPai();
                    atual.setPai(raiz);
                    atual = aux;
                }

		return raiz.getId();// aqui retornamos o id do elemento root do conjunto em que o node n está
	}

	
        
        /* Uniao dos conjuntos que estao contidos os vertices u e v*/
	public void union(Node node1, Node node2) {
		int pos1 = Encontrar(node1);
		int pos2 = Encontrar(node2);

		
		/*  se eles estão no msm conjunto não fazemos nada*/
                if (pos1 == pos2)
			return;

                /* recuperando os nodes raiz de cada conjunto*/
                Node raiz1 = this.Nodes.get(pos1);
                Node raiz2 = this.Nodes.get(pos2);
                
		
		// o menor conjunto passa a ter como nó root o root do maior
                if(raiz1.getH() < raiz2.getH() ){
                    raiz1.setPai(raiz2);
                } else if(raiz1.getH() > raiz2.getH()){
                    raiz2.setPai(raiz1);
		} else{
                    raiz2.setPai(raiz1);
                    raiz1.setH(raiz1.getH() + 1);
                }
                
                this.c++;
		
	}

	
	public void makeSets(ArrayList<Vertice<T>> vertices) {
		for (Vertice<T> v : vertices)
			makeSet(v);
	}

	
        /* Aqui nós instanciamos os nodes que estao dentro dos vertices e colocamos neles
        Além disso, colocamos o nodo dentro da Classe disjoin para fazermos as operacoes com conjuntos
        */
	public void makeSet(Vertice<T> vertice) {
		Node n = new Node(0, Nodes.size(), null);
                
                vertice.setNode(n);
		this.Nodes.add(n);
		
                
		//this.setCount++;
                this.c++;
                this.qtdNodes++;
		//this.nodeCount++;
	}
}
