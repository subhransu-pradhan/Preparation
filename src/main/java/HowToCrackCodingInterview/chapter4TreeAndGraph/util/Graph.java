package HowToCrackCodingInterview.chapter4TreeAndGraph.util;

public class Graph {
    int noOfVertex;
    Path[] paths;

    public int getNoOfVertex() {
        return noOfVertex;
    }

    public Graph(int noOfVertex){
        this.noOfVertex = noOfVertex;
        paths = new Path[noOfVertex];
    }

    public void addPath(int startVertex, int endVertex, int weight){
        startVertex--;
        paths[startVertex] = new Path(endVertex, weight, paths[startVertex]);
    }

    public void addPath(int startVertex, int endVertex){
        startVertex--;
        paths[startVertex] = new Path(endVertex, paths[startVertex]);
    }

    public Path getPath(int startVertex){
        startVertex--;
        return paths[startVertex];
    }

    /*


                         1
                        /|
                       / |
                      /  |
                     /   |
                    2    3
                   /|   /
                  / |  /
                 /  | /
                /   |/
               4----5
               |   /
               |  /
               | /
               |/
               6

    */
    public static Graph getGraph(){
        Graph graph = new Graph(6);
        graph.addPath(1,2);
        graph.addPath(1,3);
        graph.addPath(2,4);
        graph.addPath(2,5);
        graph.addPath(3,5);
        graph.addPath(4,5);
        graph.addPath(4,6);
        graph.addPath(5,6);
        return graph;
    }
}
