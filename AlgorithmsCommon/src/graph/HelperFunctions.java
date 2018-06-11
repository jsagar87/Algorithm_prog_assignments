package graph;

public class HelperFunctions {
    /**
     * Compute the degree of v
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

    public static int maxDegree(Graph G, int v)
    {
        int max = 0;
        
        return max;
    }
}
