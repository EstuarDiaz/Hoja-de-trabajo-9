public interface Graph<V,E> 
{
	public void add(V label);
	// pre: label is a non-null label for vertex
	// post: a vertex with label is added to graph
	// if vertex with label is already in graph, no action
	
	public void addEdge(V vtx1, V vtx2, E label);
	// pre: vtx1 and vtx2 are labels of existing vertices
	// post: an edge (possibly directed) is inserted between
	// vtx1 and vtx2.
	
	public void removeEdge(V v1, V v2);
	// pre: vLabel1 and vLabel2 are labels of existing vertices
	// post: edge is removed, its label is returned
	
	public int size();
	// post: returns the number of vertices in graph
	
}