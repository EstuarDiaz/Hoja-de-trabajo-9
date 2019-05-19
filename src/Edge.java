public class Edge<V,E>
{
	V v0,v1;
	E weight;
	
	public Edge(V vtx1, V vtx2, E weight) {
		this.v0 = vtx1;
		this.v1 = vtx2;
		this.weight = weight;
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
	
	public void setWeight(E weight) {
		this.weight = weight;
	}
	// post: sets label of this edge to label
	
	public E weight() {
		return this.weight;
	}
	// post: returns label associated with this edge
	
	public boolean equals(Edge<V,E> e) {
		return e.here().equals(this.here()) && e.there().equals(this.there());
	}
	// post: returns true iff edges connect same vertices
}