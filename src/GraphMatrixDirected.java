import com.sun.xml.internal.ws.util.StringUtils;

public class GraphMatrixDirected<V,E> extends GraphMatrix<V,E>{
	GraphMatrixDirected(int size)
	
// pre: size > 0
// post: constructs an empty graph that may be expanded to
// at most size vertices. Graph is directed if dir true
// and undirected otherwise
{
	super(size,true);
}

	public void addEdge(V v1, V v2, E weight) {
		if(!this.vertices.contains(v1)) {
			this.vertices.add(v1);
		}
		if(!this.vertices.contains(v2)) {
			this.vertices.add(v2);
		}
		int index1 = this.vertices.indexOf(v1);
		int index2 = this.vertices.indexOf(v2);
		Edge<V,E> e = new Edge<V,E>(v1,v2,weight);
		if(!this.edges.contains(e)) {
			this.edges.add(e);	
		}
		this.AdjMatrix[index1][index2] = (Float) weight;
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
	
	public void Floyd() {
		
	}
}