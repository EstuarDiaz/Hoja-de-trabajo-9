import java.util.LinkedList;

public class GraphMatrix<V,E>
	implements Graph<V,E>
{
	protected int size; // allocation size for graph
	protected LinkedList<V> vertices;
	protected LinkedList<Edge<V,E>> edges;
	protected Float[][] AdjMatrix;
	protected Float[][] AdjMatrixMinimum;
	protected Integer[][] AdjMatrixPaths;
	protected Float[] excentricities;
	protected int center;
	
	protected GraphMatrix(int size, boolean dir)
	{
		this.size = size; // set maximum size
		this.center = -1;
		this.vertices = new LinkedList<V>();
		this.edges = new LinkedList<Edge<V,E>>();
		this.AdjMatrix = new Float[size][size];
		this.AdjMatrixMinimum = new Float[size][size];
		this.AdjMatrixPaths = new Integer[size][size];
		this.excentricities = new Float[size];
		for(int i = 0; i < size; i++) {
			this.excentricities[i] = Float.POSITIVE_INFINITY;
			for(int j = 0; j < size; j++) {
				this.AdjMatrixPaths[i][j] = -1;
				if(i == j) {
					this.AdjMatrix[i][j] = (float) 0;
				}
				else {
					this.AdjMatrix[i][j] = Float.POSITIVE_INFINITY;
				}
				this.AdjMatrixMinimum[i][j] = this.AdjMatrix[i][j];
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


	public void removeEdge(V v1, V v2) {
		Edge<V,E> e = new Edge<V,E>(v1,v2, null);
		int index = this.edges.indexOf(e);
		if(index >= 0) {
			for(int i = 0; i < this.size; i++) {
				if(i != index) {
					this.AdjMatrix[i][index] = Float.POSITIVE_INFINITY;
					this.AdjMatrix[index][i] = Float.POSITIVE_INFINITY;	
				}
			}
			this.calculateCenter();
		}
	}
	
	public int size() {
		return this.size;
	}

	@Override
	public void addEdge(V vtx1, V vtx2, E label) {
		// TODO Auto-generated method stub
	}
	
	public void printMatrix() {
		System.out.println("Matriz de adyacencia:");
		for(int i = 0; i < this.size(); i++) {
			String row = this.vertices.get(i)+": [";
			for(int j = 0; j < this.size(); j++) {
				row += this.AdjMatrix[i][j]+", ";
			}
			System.out.println(row.substring(0, row.length()-2)+"]");
		}
	}
	
	public void printMinimumMatrix() {
		System.out.println("Matriz de adyacencia con los caminos mas cortos:");
		for(int i = 0; i < this.size(); i++) {
			String row = this.vertices.get(i)+": [";
			for(int j = 0; j < this.size(); j++) {
				row += this.AdjMatrixMinimum[i][j]+", ";
			}
			System.out.println(row.substring(0, row.length()-2)+"]");
		}
	}
	
	public void resetPaths() {
		this.center = -1;
		for(int i = 0; i < this.size(); i++) {
			this.excentricities[i] = Float.POSITIVE_INFINITY;
			for(int j = 0; j < this.size(); j++) {
				this.AdjMatrixMinimum[i][j] = this.AdjMatrix[i][j];
				this.AdjMatrixPaths[i][j] = -1;
			}
		}
	}
	
	public void Floyd() {
		this.resetPaths();
		for(int k = 0; k < this.size(); k++) {
			for(int i = 0; i < this.size(); i++) {
				for(int j = 0; j < this.size(); j++) {
					if(this.AdjMatrixMinimum[i][j] > this.AdjMatrixMinimum[i][k] + this.AdjMatrixMinimum[k][j]) {
						this.AdjMatrixMinimum[i][j] = this.AdjMatrixMinimum[i][k] + this.AdjMatrixMinimum[k][j];
						this.AdjMatrixPaths[i][j] = k;
					}
				}
			}
		}
	}
	
	private void P(int q, int r) {
		if(this.AdjMatrixPaths[q][r] != -1) {
			this.P(q,this.AdjMatrixPaths[q][r]);
			System.out.println(this.vertices.get(this.AdjMatrixPaths[q][r]));
			this.P(this.AdjMatrixPaths[q][r],r);
			return;	
		}
		else {
			return;
		}
	}
	
	public void printShortestPath(V partida, V llegada) {
		int q = this.vertices.indexOf(partida);
		int r = this.vertices.indexOf(llegada);
		System.out.println("Camino mas corto de "+this.vertices.get(q)+" a "+this.vertices.get(r)+":");
		System.out.println(this.vertices.get(q));
		this.P(q, r);
		System.out.println(this.vertices.get(r));
		System.out.println("Total: "+this.AdjMatrixMinimum[q][r]);
	}
	
	protected void calculateExcentricities() {
		this.Floyd();
		for(int i = 0; i < this.size(); i++) {
			Float max = Float.NEGATIVE_INFINITY;
			for(int j = 0; j < this.size(); j++) {
				if(this.AdjMatrixMinimum[i][j] > max) {
					max = this.AdjMatrixMinimum[i][j];
				}
			}
			this.excentricities[i] = max;
		}
	}
	
	protected void calculateCenter() {
		this.calculateExcentricities();
		Float minimum = Float.POSITIVE_INFINITY;
		for(int i = 0; i < this.size(); i++) {
			if(this.excentricities[i] < minimum) {
				minimum = this.excentricities[i];
				this.center = i;
			}
		}
	}
	
	public V getCenter() {
		return this.vertices.get(this.center);
	}
}