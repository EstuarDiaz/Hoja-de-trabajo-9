class Vertex<E>
{
	protected E label;
	public Vertex(E label) {
		this.label = label;
	}
	// post: constructs unvisited vertex with label
	
	public E label() {
		return this.label;
	}
	// post: returns user label associated w/vertex
	
	public boolean equals(Vertex<E> v) {
		return this.label().equals(v.label());
	}
	// post: returns true iff vertex labels are equal
}