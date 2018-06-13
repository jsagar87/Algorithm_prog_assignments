package graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Api to cover representation of the graph, and simple
 * set of methods for clients to process the graph.
 */
public class Graph {

    /**
     * Create an empty graph with V vertices
     */
    Graph(int V){}

    /**
     * Create a graph from input stream
     */
    Graph(In in){}

    /**
     * Add an edge v-w
     *
     * @param v
     * @param w
     */
    void addEdge(int v,int w){}

    /**
     * Vertices adjacent to v
     *
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v){return null;}

    /**
     * Number of vertices
     *
     * @return
     */
    int V(){
        return 0;
    }

    /**
     * Number of edges
     *
     * @return
     */
    int E(){
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /*
     Client program that prints out every edge in graph
     */
    public static void main(String[] args) {


        In in  =  new In(args[0]);
        Graph G = new Graph(in);               // Create graph from input stream

        // v = 0 to v-1
        for (int v = 0; v<G.V(); v++){
            for (int w  : G.adj(v)){
                StdOut.println(v + " - " + w); // Print out edge (twice)
            }
        }
    }
}
