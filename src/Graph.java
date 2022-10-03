public class Graph {
    int [][]adjMatrix;

    public Graph(int node){
        this.adjMatrix = new int [node][node];
    }
    public void addEdge(int u , int v){
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1;
    }

    public void display(){
        for (int[] matrix : this.adjMatrix) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.display();
    }
}
