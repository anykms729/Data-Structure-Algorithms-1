public class Code_Implementation {
    public static void main(String[] args) {
        // Create object to call each function defined in the class itself
        Code_Implementation code_implementation = new Code_Implementation();
        
        code_implementation.graph_Matrix();
        code_implementation.graph_LinkedList();
        code_implementation.binary_Search_Tree();
    }

    public void graph_Matrix(){
        // Add node by creating object of Node class each time
        Graph graph = new Graph(5);
        graph.addNode_for_Graph_Matrix(new Node_Graph('A'));
        graph.addNode_for_Graph_Matrix(new Node_Graph('B'));
        graph.addNode_for_Graph_Matrix(new Node_Graph('C'));
        graph.addNode_for_Graph_Matrix(new Node_Graph('D'));
        graph.addNode_for_Graph_Matrix(new Node_Graph('E'));

        graph.addEdge_for_Graph_Matrix(0, 1);
        graph.addEdge_for_Graph_Matrix(1, 2);
        graph.addEdge_for_Graph_Matrix(1, 4);
        graph.addEdge_for_Graph_Matrix(2, 3);
        graph.addEdge_for_Graph_Matrix(2, 4); // Node "D" doesn't have edge
        graph.addEdge_for_Graph_Matrix(4, 0);
        graph.addEdge_for_Graph_Matrix(4, 2);

        graph.print_for_Graph_Matrix();
        System.out.println(graph.checkEdge_for_Graph_Matrix(1, 0));

        graph.depthFirstSearch(1); // Represent nodes visited by "Node B"
        System.out.println();
        graph.depthFirstSearch(4);
        System.out.println();
        graph.breadthFirstSearch(1);
    }
    public void graph_LinkedList(){
        Graph graph = new Graph();
        graph.addNode_for_Graph_LinkedList(new Node_Graph('A'));
        graph.addNode_for_Graph_LinkedList(new Node_Graph('B'));
        graph.addNode_for_Graph_LinkedList(new Node_Graph('C'));
        graph.addNode_for_Graph_LinkedList(new Node_Graph('D'));
        graph.addNode_for_Graph_LinkedList(new Node_Graph('E'));

        graph.addEdge_for_Graph_LinkedList(0,1 );
        graph.addEdge_for_Graph_LinkedList(1,2 );
        graph.addEdge_for_Graph_LinkedList(1,4);
        graph.addEdge_for_Graph_LinkedList(2,3 );
        graph.addEdge_for_Graph_LinkedList(2,4 );
        graph.addEdge_for_Graph_LinkedList(4,0 );

        graph.print_for_Graph_LinkedList();
        System.out.println(graph.checkEdge_for_Graph_LinkedList(1, 3));
    }

    public void binary_Search_Tree(){
        Binary_Search_Tree binary_search_tree = new Binary_Search_Tree();
        binary_search_tree.insert(new Node_Tree(5));
        binary_search_tree.insert(new Node_Tree(1));
        binary_search_tree.insert(new Node_Tree(9));
        binary_search_tree.insert(new Node_Tree(2));
        binary_search_tree.insert(new Node_Tree(3));
        binary_search_tree.insert(new Node_Tree(4));
        binary_search_tree.insert(new Node_Tree(12));
        binary_search_tree.insert(new Node_Tree(68));
        binary_search_tree.insert(new Node_Tree(5));

        System.out.println("Binary_search_tree Search Function Test: "+binary_search_tree.search(0));
        System.out.println("Binary_search_tree Search Function Test: "+binary_search_tree.search(68));
        binary_search_tree.remove(68);
        binary_search_tree.display();

    }
}
