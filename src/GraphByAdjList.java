import java.util.ArrayList;

public class GraphByAdjList {
   ArrayList<ArrayList<Integer>> adj;

   public GraphByAdjList(int nodes){
       this.adj = new ArrayList<>();
       for (int i = 0; i < nodes; i++) {
           this.adj.add(new ArrayList<Integer>());
       }
   }

   public void addEdge(int u , int v){
       this.adj.get(u).add(v);
       this.adj.get(v).add(u);
   }

   public void display(){
       System.out.println("The Adjacency List :-");
       for (ArrayList<Integer> integers : this.adj) {
           System.out.print(integers);
           for (Integer integer : integers) {
               System.out.print("--> " +integer);
           }
           System.out.println();
       }
   }
    public static void main(String[] args) {
        GraphByAdjList g = new GraphByAdjList(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.display();
    }
}