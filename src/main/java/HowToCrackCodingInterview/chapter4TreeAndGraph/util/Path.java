package HowToCrackCodingInterview.chapter4TreeAndGraph.util;

public class Path{
    int vertex;
    int weight;
    Path path;

    public int getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }

    public Path getPath() {
        return path;
    }

    public Path(int vertex, int weight, Path path) {
        this.vertex = vertex;
        this.weight = weight;
        this.path = path;
    }

    public Path(int vertex, Path path) {
        this.vertex = vertex;
        this.path = path;
    }
}