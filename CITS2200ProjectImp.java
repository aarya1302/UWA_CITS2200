import java.util.*;
public class CITS2200ProjectImp {



    // Map storing all of the vertices ID mapped to the URL
    public Map<Integer, String> idToURLMap = new HashMap<>();
    // Map storing all of the vertices URL mapped to the ID
    public Map<String, Integer> urlToIdMap = new HashMap<>();

    public ArrayList<List<Integer>> adjacencyList = new ArrayList<>();

    /**
     * Adds an edge to the Wikipedia page graph. If the pages do not
     * already exist in the graph, they will be added to the graph.
     *
     * @param urlFrom the URL which has a link to urlTo.
     * @param urlTo the URL which urlFrom has a link to.
     */

    /* adding vertex to both maps if it does not exist
     *and creating new entry in adjacency list
     */
    private void addNewVertex(String url){

        if (!urlToIdMap.containsKey(url)){

            urlToIdMap.put(url, urlToIdMap.size());
            idToURLMap.put(urlToIdMap.size(), url);


            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(String urlFrom, String urlTo){
        //adds vertices to both maps if they do not exist
        addNewVertex(urlFrom);
        addNewVertex(urlTo);
        // finds id of the urls
        int sourceId = urlToIdMap.get(urlFrom);
        int destId = urlToIdMap.get(urlTo);
        // adds destination to sources array list
        adjacencyList.get(sourceId).add(destId);
    };


    /**
     * Finds the shorest path in number of links between two pages.
     * If there is no path, returns -1.
     *
     * @param urlFrom the URL where the path should start.
     * @param urlTo the URL where the path should end.
     * @return the legnth of the shorest path in number of links followed.
     */

    public int getShortestPath(String urlFrom, String urlTo){
        int pathLength = 0;
        /* Queue containing nodes being explored
            array list storing information about visited vertices where if visited[vertex] contains the shortest path from source to the vertex
            array list storing parent node of a certain node where parent[node] stores its parent node in the spanning tree
         */
        Queue<Integer> queue = new LinkedList<>();


        int[] visited = new int[urlToIdMap.size()];
        Arrays.fill(visited, -1);

        int[] parent = new int[urlToIdMap.size()];

        //get id of the source node and destination node
        int source = urlToIdMap.get(urlFrom);
        int dest = urlToIdMap.get(urlTo);

        /* adding source to queue
            incrementing path to node to zero
            note : parent[source] will be undefined since the source has no parent

         */

        queue.add(source);
        visited[source]++;

        while(!queue.isEmpty()){
            int currVertex = queue.poll();
            if (currVertex == dest){
                break;
            }

            /* exploring each neighbour of the current vertex through a for loop
                if neighbouring vertex has not been visited
                    adding each the vertex to the queue
                    and defining the parent node of the element to be the current vertex being explored
                    changeing distance of the neighbour to source vertex
                    */

            for(int elem : adjacencyList.get(currVertex)){
                if(visited[elem] == -1){
                    queue.add(elem);
                    parent[elem] = currVertex;
                    visited[elem] = visited[currVertex] + 1;
                }

            }


        }

        return visited[dest];


    }

    /**
     * Finds all the centers of the page graph. The order of pages
     * in the output does not matter. Any order is correct as long as
     * all the centers are in the array, and no pages that aren't centers
     * are in the array.
     *
     * @return an array containing all the URLs that correspond to pages that are centers.
     */
    public String[] getCenters(){

    }
    /**
     * Finds all the strongly connected components of the page graph.
     * Every strongly connected component can be represented as an array
     * containing the page URLs in the component. The return value is thus an array
     * of strongly connected components. The order of elements in these arrays
     * does not matter. Any output that contains all the strongly connected
     * components is considered correct.
     *
     * @return an array containing every strongly connected component.
     */

    /**
     * Finds a Hamiltonian path in the page graph. There may be many
     * possible Hamiltonian paths. Any of these paths is a correct output.
     * This method should never be called on a graph with more than 20
     * vertices. If there is no Hamiltonian path, this method will
     * return an empty array. The output array should contain the URLs of pages
     * in a Hamiltonian path. The order matters, as the elements of the
     * array represent this path in sequence. So the element [0] is the start
     * of the path, and [1] is the next page, and so on.
     *
     * @return a Hamiltonian path of the page graph.
     */
    public static void main(String[] args){
        CITS2200ProjectImp proj = new CITS2200ProjectImp();
        proj.addEdge("0", "1");
        proj.addEdge("0", "2");
        proj.addEdge("1", "3");
        proj.addEdge("2", "3");
        proj.addEdge("2", "4");
        proj.addEdge("3", "4");
        proj.addEdge("4", "5");

        System.out.print(""+proj.getShortestPath("0", "5"));

    }
}
