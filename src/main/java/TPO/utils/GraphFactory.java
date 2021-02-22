package TPO.utils;

import TPO.graphImpl.GrafoEstatico;
import TPO.graphImpl.GrafosTDA;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.Random;

public class GraphFactory {

    private static final int MAX_DIM = 10;
    private static final int MAX_WEIGTH = 100; // Binario, o se conecta o no
    private static final int RANDOMIZER_ITERATIONS = 50;

    /**
     * <a href="{@docRoot}/assets/graphs/Graph1.png"> Image </a>
     * @return Graph1
     */
    public static Graph<String, DefaultWeightedEdge> dijkstraGraph1() {
        Graph<String, DefaultWeightedEdge> g = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        // Define vertex as constants to avoid typos
        final String v1 = "v1";
        final String v2 = "v2";
        final String v3 = "v3";
        final String v4 = "v4";

        // Add the vertices to our graph
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);


        // Add edges and weights. Default weight is 1.0
        g.addEdge(v1,v2);
        g.setEdgeWeight(v1, v2, 10.0);

        g.addEdge(v2, v1);
        g.setEdgeWeight(v2, v1, 10.0);

        g.addEdge(v2, v3);
        g.setEdgeWeight(v2, v3, 10.0);

        g.addEdge(v3, v4);
        g.setEdgeWeight(v3, v4, 10.0);

        g.addEdge(v4, v1);
        g.setEdgeWeight(v4, v1, 10.0);


        return g;
    }

    public static Graph<String, DefaultWeightedEdge> dijkstraGraph2() {
        Graph<String, DefaultWeightedEdge> g = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        // Define vertex as constants to avoid typos
        final String v1 = "v1";
        final String v2 = "v2";
        final String v3 = "v3";
        final String v4 = "v4";
        final String v5 = "v5";
        final String v6 = "v6";
        final String v7 = "v7";
        final String v8 = "v8";

        // Add the vertices to our graph
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addVertex(v8);


        // Add edges and weights. Default weight is 1.0

        // v1 origin
        g.setEdgeWeight(g.addEdge(v1,v2), 2.0);
        g.setEdgeWeight(g.addEdge(v1,v3), 5.0);
        g.setEdgeWeight(g.addEdge(v1,v4), 1.0);

        // v2 origin
        g.setEdgeWeight(g.addEdge(v2,v7), 3.0);
        g.setEdgeWeight(g.addEdge(v2,v8), 7.0);
        g.setEdgeWeight(g.addEdge(v2,v1), 7.0);

        // v3 origin
        g.setEdgeWeight(g.addEdge(v3,v5), 3.0);
        g.setEdgeWeight(g.addEdge(v3,v6), 2.0);

        // v4 origin
        g.setEdgeWeight(g.addEdge(v4,v7), 7.0);
        g.setEdgeWeight(g.addEdge(v4,v8), 1.0);

        // v5 origin
        g.setEdgeWeight(g.addEdge(v5,v6), 3.0);

        // V6 origin
        g.setEdgeWeight(g.addEdge(v6,v4), 1.0);

        // v7 origin
        g.setEdgeWeight(g.addEdge(v7,v8), 2.0);
        g.setEdgeWeight(g.addEdge(v7,v2), 1.0);

        // v8 origin
        g.setEdgeWeight(g.addEdge(v8,v7), 10.0);

        return g;
    }

    public static GrafoEstatico generarGrafoTDA1() {
        final int dim = 4;
        GrafoEstatico g = new GrafoEstatico();
        g.inicializarGrafo(dim);

        for (int i = 0 ; i < dim; i++) {
            g.agregarVertice(i);
        }

        g.agregarArista(0,1,10);
        g.agregarArista(0,1,1);
        g.agregarArista(1,0,10);
        g.agregarArista(1,2,10);
        g.agregarArista(2,3,10);
        g.agregarArista(3,0,10);

        return g;
    }

    /**
     * Se numeran los vertices de 1 a MAX_DIM
     * @param g
     */
    public static void randomizeGraph(GrafosTDA g) {
        Random r = new Random();

        g.inicializarGrafo(MAX_DIM);
        for (int i = 0 ; i < MAX_DIM; i++) {
            g.agregarVertice(i);
        }

        for ( int i = 0; i < RANDOMIZER_ITERATIONS ; i++) {
            g.agregarArista(r.nextInt(MAX_DIM), r.nextInt(MAX_DIM),r.nextInt(MAX_WEIGTH));
        }
    }
}
