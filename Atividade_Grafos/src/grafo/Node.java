package grafo;

public class Node {

        private int h; // quantidades de nodos abaixo desse nodo
	private int id; // um identificador único e não nulo para cada elemento da árvore
	private Node pai; //nodo pai

	public Node(int r, int id, Node pai) {
		this.h = r;
		this.id = id;
		this.pai = pai;
	}

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Node getPai() {
            return pai;
        }

        public void setPai(Node pai) {
            this.pai = pai;
        }

}
