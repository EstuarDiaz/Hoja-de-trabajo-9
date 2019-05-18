import java.util.Iterator;

public class GraphMatrixDirected<V,E> extends GraphMatrix<V,E>{
	GraphMatrixDirected(int size)
// pre: size > 0
// post: constructs an empty graph that may be expanded to
// at most size vertices. Graph is directed if dir true
// and undirected otherwise
{
	super(size,true);
}

public void addEdge(V vLabel1, V vLabel2, E label)
// pre: vLabel1 and vLabel2 are labels of existing vertices
// post: an edge is inserted between vLabel1 and vLabel2;
// if edge is new, it is labeled with label (can be null)
{
	GraphMatrixVertex<V> vtx1,vtx2;
	// get vertices
	vtx1 = dict.get(vLabel1);
	vtx2 = dict.get(vLabel2);
	// update matrix with new edge
	Edge<V,E> e = new Edge<V,E>(vtx1.label(),vtx2.label(),label,true);
	data[vtx1.index()][vtx2.index()] = e;
}

@Override
public E removeEdge(V vLabel1, V vLabel2) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public V get(V label) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Edge<V, E> getEdge(V label1, V label2) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean contains(V label) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean containsEdge(V vLabel1, V vLabel2) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean visit(V label) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean visitEdge(Edge<V, E> e) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isVisited(V label) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isVisitedEdge(Edge<V, E> e) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void reset() {
	// TODO Auto-generated method stub
	
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int degree(V label) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int edgeCount() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public Iterator<V> iterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Iterator<V> neighbors(V label) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Iterator<Edge<V, E>> edges() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	
}

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isDirected() {
	// TODO Auto-generated method stub
	return false;
}
}