package by.gapanovich.algorithms.Classes;

public class Edge {
    private Vertex fromVertex;
    private Vertex toVertex;

    public Edge(Vertex fromVertex, Vertex toVertex) {
        if(fromVertex.getName() != toVertex.getName()){
            this.fromVertex = fromVertex;
            this.toVertex = toVertex;
        }
    }

    public void setFromVertex(Vertex fromVertex) {
        if (fromVertex.getName() != this.toVertex.getName()) {
            this.fromVertex = fromVertex;
        }
    }

    public void setToVertex(Vertex toVertex) {
        if (toVertex.getName() != this.fromVertex.getName()) {
            this.toVertex = toVertex;
        }
    }

    public Vertex getFromVertex(){
        return fromVertex;
    }

    public Vertex getToVertex(){
        return toVertex;
    }
}
