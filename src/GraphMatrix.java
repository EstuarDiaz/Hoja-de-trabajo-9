import java.util.LinkedList;

public class GraphMatrix<V,E>
	implements Graph<V,E>
{
	protected int size; // allocation size for graph
	protected LinkedList<V> vertices;
	protected LinkedList<Edge<V,E>> edges;
	protected Float[][] AdjMatrix;
	
	protected GraphMatrix(int size, boolean dir)
	{
		this.size = size; // set maximum size
		this.vertices = new LinkedList<V>();
		this.edges = new LinkedList<Edge<V,E>>();
		this.AdjMatrix = new Float[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				this.AdjMatrix[i][j] = Float.POSITIVE_INFINITY;
				if(i == j) {
					this.AdjMatrix[i][j] = (float) 0;
				}
			}
		}
	}

	public void add(V vertex)
	// pre: label is a non-null label for vertex
	// post: a vertex with label is added to graph;
	// if vertex with label is already in graph, no action
	{
		this.vertices.add(vertex);
	}


	public E removeEdge(E edge) {
		int index = this.edges.indexOf(edge);
		for(int i = 0; i < this.size; i++) {
			if(i != index) {
				this.AdjMatrix[i][index] = Float.POSITIVE_INFINITY;
				this.AdjMatrix[index][i] = Float.POSITIVE_INFINITY;	
			}
		}
		return edge;
	}
	
	public int size() {
		return this.size;
	}

	@Override
	public void addEdge(V vtx1, V vtx2, E label) {
		// TODO Auto-generated method stub
	}
	
	public void printMatrix() {}
}