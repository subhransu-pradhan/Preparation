package HowToCrackCodingInterview.chapter4TreeAndGraph;

import HowToCrackCodingInterview.chapter4TreeAndGraph.util.Graph;
import HowToCrackCodingInterview.chapter4TreeAndGraph.util.Node;
import HowToCrackCodingInterview.chapter4TreeAndGraph.util.Path;

public class TreeTraversal {

    public String returnBFSPath(Graph graph){
        int noOfVertex = graph.getNoOfVertex();
        String string = " ";
        if(noOfVertex > 1) {
            boolean[] visited = new boolean[noOfVertex];
            Node<Integer> head = new Node(null, 1);
            Node<Integer> tail = head;
            visited[0] = true;
            while (head != null) {

                string = string + head.getData() + " ,";
                Path paths = graph.getPath(head.getData());

                while (paths != null) {
                    if (!visited[paths.getVertex() - 1]) {
                        visited[paths.getVertex() - 1] = true;
                        tail.setNext(new Node(null, paths.getVertex()));
                        tail = tail.next;
                    }
                    paths = paths.getPath();
                }
                head = head.getNext();
            }
        }
        return string + "\b";
    }

    public String returnDFSPath(Graph graph){
        int noOfVertex = graph.getNoOfVertex();
        String string = " ";
        if(noOfVertex > 1) {
            boolean[] visited = new boolean[noOfVertex];
            Node<Integer> node = new Node(null, 1);
            visited[0] = true;
            while (node != null) {

                string = string + node.getData() + " ,";
                Path paths = graph.getPath(node.getData());
                node = node.getNext();

                while (paths != null) {
                    if (!visited[paths.getVertex() - 1]) {
                        visited[paths.getVertex() - 1] = true;
                        node = new Node(node, paths.getVertex());
                    }
                    paths = paths.getPath();
                }
            }
        }
        return string + "\b";
    }

    public static void main(String args[]){
        Graph graph = Graph.getGraph();
        System.out.println(new TreeTraversal().returnDFSPath(graph));
        System.out.println(new TreeTraversal().returnBFSPath(graph));
    }
}
