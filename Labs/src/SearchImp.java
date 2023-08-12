import CITS2200.Graph;
import CITS2200.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SearchImp implements Search{
    @Override
    public int[] getConnectedTree(Graph graph, int i) {
        int[] parents = new int[graph.getNumberOfVertices()];
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = undefined;

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            int[] edges = graph.getEdgeMatrix()[i];

            for(int j = 0; j < edges.length; j++){
                if(!visited[j] && edges[j] == 1){
                    parents[j] = vertex;
                    queue.add(j);
                    visited[j] = true;
                    
                }
            }


        }
        return new int[0];
    }
}