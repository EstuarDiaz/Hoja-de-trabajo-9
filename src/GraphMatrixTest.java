import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphMatrixTest {

	@Test
	void testAdd() {
		GraphMatrix<String,Float> G = new GraphMatrixDirected<String,Float>(3);
		G.add("A");
	}

	@Test
	void testRemoveEdge() {
		GraphMatrix<String,Float> G = new GraphMatrixDirected<String,Float>(3);
		G.addEdge("A", "B", (float) 5);
		G.removeEdge("A", "B");
	}

	@Test
	void testFloyd() {
		GraphMatrix<String,Float> G = new GraphMatrixDirected<String,Float>(3);
		G.addEdge("A", "B", (float)3);
		G.addEdge("A", "C", (float)4);
		G.addEdge("C", "B", (float)5);
		G.Floyd();
		G.printMinimumMatrix();
	}

}
