class Vertex<E>
{
	protected E label;
	protected boolean visited;
	public Vertex(E label) {
		this.label = label;
		this.visited = false;
	}
	// post: constructs unvisited vertex with label
	
	public E label() {
		return this.label;
	}
	// post: returns user label associated w/vertex
	
	public boolean visit() {
		boolean isVisited = this.isVisited();
		this.visited = true;
		return isVisited;
	}
	// post: returns, then marks vertex as being visited
	
	public boolean isVisited() {
		return this.visited;
	}
	// post: returns true iff vertex has been visited
	
	public void reset() {
		this.visited = false;
	}
	// post: marks vertex unvisited
	
	public boolean equals(Object o) {
		return o.equals(this.label());
	}
	// post: returns true iff vertex labels are equal
}