package graph;

/**
 * Simple and typical graph processing code that uses the API
 */
public class HelperFunctions {
    /**
     * Compute the degree of v
     *
     * @param G
     * @param v
     * @return
     */
    public static int degree(Graph G, int v)
    {
        int degree = 0;
        for (int w : G.adj(v) ) degree++;
        return degree;
    }

    /**
     * Compute maximum degree
     *
     * @param G
     * @return
     */
    public static int maxDegree(Graph G)
    {
        int max = 0;
        for (int v = 0; v < G.V(); v++)
            if (degree(G,v) > max)
                max = degree(G,v);
        return max;
    }

    /**
     * Compute average degree
     * @param G
     * @return
     */
    public static double averageDegree(Graph G)
    {
        return 2.0*G.E()/G.V();
    }

    /**
     * Count self-loops
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(Graph G)
    {
        int count = 0;
        for (int v = 0; v<G.V(); v++ )
            for(int w : G.adj(v))
                if (v == w) count++;
        return count/2; // each edge counted twice
    }
}
