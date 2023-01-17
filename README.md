< Graph Data Structure > <br>

- Graph = Non-linear aggregation of Nodes & Edges<br>
- Two types of Graphs = undirected graph(ex: Facebook) & directed graph (ex: travel app)<br>
- Directed Graph: Represented as Adjacency Matrix (2D Array to store 1's/0's to represent edges) or Adjacency List (by LinkedList)<br>
- Adjacency Matrix for Directed Graph: Run Time Complexity O(1) just to find two indices to find row and columns & Space Complexity (V^2) to store "V" numbers of vertices or node
<br>
<br>
< Binary_Search_Tree ><br>

- Tree Data Structure: Non-linear Data Structure<br>
- Root or Parent (No incoming Edge) → Branch (Incoming & outgoing edge) → Leaf (No outgoing edge)<br>
- Sub tree: Smaller Tree held within a Larger Tree<br>
- Size: # of nodes<br>
- Depth: # of edges below the root node<br>
- Height: # of edges above furthest leaf node<br>
- Binary Tree vs Binary Search Tree: A Binary Tree is a non-linear data structure in which a node can have 0, 1 or 2 nodes. Individually, each node consists of a left pointer, right pointer and data element. A Binary Search Tree is an organized binary tree with a structured organization of nodes<br>
- Benefit: Easy to locate a node when they're in the order<br>
- Time complexity: Best case O(log n) in case the tree is well-balanced & Worst case O(n)<br>
- Space complexity: Best case O(n)<br>

Search Algorithms for traversing a Tree or Graph data structure as below
<br>
<br>

< Depth First Search - DFS ><br>
     
- First, Pick a route<br>
- Then, Keep going till reach a dead end, or a previously visited node<br>
- And then, Backtrack to Last node that has unvisited adjacent neighbors<br>
- Stack data structure is utilized (FILO)<br>
- Child is visited first rather than Sibling<br>
- Better if the destination node on average is close<br>
<br>
<br>
< Breadth first search - BFS ><br>
- It's done one "Level" at a time rather than one "Branch" at a time<br>
- Queue data structure is utilized<br>
- Sibling is visited first rather than child<br>
- Better if the destination node on average is close<br>
 
