public class Edge<V,E>
{
	boolean isDirected, visited;
	V v0,v1;
	E label;
	
	public Edge(V vtx1, V vtx2, E label,
	boolean directed) {
		this.isDirected = directed;
		this.v0 = vtx1;
		this.v1 = vtx2;
		this.label = label;
		this.visited = false;
	}
	// post: edge associates vtx1 and vtx2; labeled with label
	// directed if "directed" set true
	
	public V here() {
		return this.v0;
	}
	// post: returns first node in edge
	
	public V there() {
		return this.v1;
	}
	// post: returns second node in edge
	
	public void setLabel(E label) {
		this.label = label;
	}
	// post: sets label of this edge to label
	
	public E label() {
		return this.label;
	}
	// post: returns label associated with this edge
	
	public boolean visit() {
		boolean isVisited = this.visited;
		this.visited = true;
		return isVisited;
	}
	// post: visits edge, returns whether previously visited
	
	public boolean isVisited() {
		return this.visited;
	}
	// post: returns true iff edge has been visited
	
	public boolean isDirected() {
		return this.isDirected;
	}
	// post: returns true iff edge is directed
	
	public void reset() {
		this.visited = false;
	}
	// post: resets edge's visited flag to initial state
	
	//{v1,v2}.equals({u1,u2})
	//u1.equals(v1) and u2.equals(v2)
	
	public boolean equals(Edge<V,E> e) {
		return e.here().equals(this.here()) && e.there().equals(this.there());
	}
	// post: returns true iff edges connect same vertices
}