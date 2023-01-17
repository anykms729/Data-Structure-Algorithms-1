import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    // Graph = Non-linear aggregation of Nodes & Edges
    // Two types of Graphs = undirected graph(ex: Facebook) & directed graph (ex: travel app)
    // Directed Graph: Represented as Adjacency Matrix (2D Array to store 1's/0's to represent edges) or Adjacency List (by LinkedList)

    // Adjacency Matrix for Directed Graph: Run Time Complexity O(1) just to find two indices to find row and columns & Space Complexity (V^2) to store "V" number of vertices or node
    ArrayList<Node_Graph> nodes;
    int[][] matrix;

    Graph(int size) {
        nodes = new ArrayList<>();
        matrix = new int[size][size];
    }

    // By using "nodes" ArrayList, node is automatically stored whenever it's newly created
    public void addNode_for_Graph_Matrix(Node_Graph node_graph) {
        nodes.add(node_graph);
    }

    public void addEdge_for_Graph_Matrix(int src, int dest) {
        matrix[src][dest] = 1;
    }

    public boolean checkEdge_for_Graph_Matrix(int src, int dest) {
        if (matrix[src][dest] == 1)
            return true;
        else return false;
    }

    public void print_for_Graph_Matrix() {
        System.out.print("  ");
        for (Node_Graph node_graph : nodes) {
            System.out.print(node_graph.data + " ");
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).data + " ");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Adjacency List for Directed Graph: Run Time Complexity O(V) to traverse each linked-list which is separated based on each vertices & Space Complexity (V+E) and V represents nodes or vertices and E represents Edge
    ArrayList<LinkedList<Node_Graph>> arrayList;

    Graph() {
        arrayList = new ArrayList<>();
    }

    public void addNode_for_Graph_LinkedList(Node_Graph node_graph) {
        // To add node, Linked-list should be created first
        LinkedList<Node_Graph> currentList = new LinkedList<>();
        // Whenever node is added, linked-list is created and new node is at the head of the linked-list
        currentList.add(node_graph);

        // And then add linked-list created from above to Array List
        arrayList.add(currentList);
    }

    public void addEdge_for_Graph_LinkedList(int src, int dest) {
        // currentList should access the adjacency list which is separated based on each node created
        LinkedList<Node_Graph> currentList = arrayList.get(src);

        // And then to find Destination node to be connected, access adjacency list and get first element of the adjacency list which represents the destination node!
        Node_Graph destNode = arrayList.get(dest).get(0);

        // Once the destination node is added from above, add the destination node to the linked-list which includes source node
        currentList.add(destNode);
    }

    public boolean checkEdge_for_Graph_LinkedList(int src, int dest) {
        LinkedList<Node_Graph> currentList = arrayList.get(src);
        Node_Graph destNode = arrayList.get(dest).get(0);

        // Check Linked-list which stores node(s) in it, and if the linked-list has specified destination node, that means it has edge between source & destination Nodes
        for (Node_Graph node_graph : currentList) {
            if (node_graph == destNode) return true;
        }
        return false;
    }

    public void print_for_Graph_LinkedList() {
        // Loop through Linked-list(s) which is included in arrayList as "single-separated-line" format
        for (LinkedList<Node_Graph> currentList: arrayList){
            // Then Loop Through each node which is included in each Linked-list and print nodes in the same linked-list in a row!
            for (Node_Graph node_graph:currentList){
                System.out.print(node_graph.data+" → ");
            }
            System.out.println();
        }
    }

    // DFS = Search Algorithm for traversing a tree or graph data structure
    // 1) Pick a route
    // 2) Keep going till reach a dead end, or a previously visited node
    // 3) Backtrack to Last node that has unvisited adjacent neighbors
    // 4) Stack data structure is utilized (FILO)
    // 5) Child is visited first rather than Sibling
    // 6) Better if the destination node on average is close

    public void depthFirstSearch(int src){
        boolean[] visited = new boolean[matrix.length];
        depthFirstSearchLogic(src, visited);
    }

    private void depthFirstSearchLogic(int src, boolean[] visited){
         // If the node is already visited, returns nothing (Base condition)
        if (visited[src] == true){
            return;
        }
        else {
            // If not visited from the first place, make it as "Visited" Status
            // So, even if the specified source node has no edge connected to other nodes (= not visited by other nodes), at least it's visited by itself
            visited[src] = true;
            System.out.println(nodes.get(src).data+" = visited");
        }

        for (int i=0; i<matrix[src].length; i++){
            // if the specified source node has edge connected to other nodes, value of that specific Matrix's index has "1(true)", thus it is iterated as recursive manner
            if (matrix[src][i] == 1){
                // Recursive
                depthFirstSearchLogic(i,visited);
            }
        }
        return;
    }

    // BFS = Search Algorithm for traversing a tree or graph data structure
    // 1) It's done one "Level" at a time rather than one "Branch" at a time.
    // 2) Queue data structure is utilized.
    // 3) Sibling is visited first rather than child
    // 4) Better if the destination node on average is close

    public void breadthFirstSearch(int src){
        // Queue Interface is implemented by LinkedList and PriorityQueue class
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        // Add Source node to the queue as the first element (visited by itself at first)
        queue.offer(src);
        visited[src] = true;

        while (queue.size() !=0){
            // Source node is visited by itself, so removed from the Queue at first
            src = queue.poll();
            System.out.println(nodes.get(src).data+" = visited");

            for (int i=0; i<matrix[src].length;i++){
                // "matrix[src][i] ==1" means node which has edge connected to source node, "!visited[i]" meanwhile has false boolean value in the boolean list as it's not yet visited
                if(matrix[src][i] ==1 && !visited[i]){
                    queue.offer(i);
                    visited[i] =true;
                }
        }
    }
}

}

