import CITS2200.Graph;
import CITS2200.Search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
        return parents;
    }

    @Override
    public int[] getDistances(Graph graph, int i) {
        int[] distances = new int[graph.getNumberOfVertices()];
        Arrays.fill(distances, -1);
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        distances[i] = 0;
        int[] edges = graph.getEdgeMatrix()[i];
        for (int j = 0; j < edges.length; j++) {
            if(edges[j] == 1 & !visited[j]){
                visited[j] = true;
                int dist= distances[i] + 1;
                if(dist < distances[j]) distances[j] = dist;
                DFS(graph, j);
            }
        }
        return distances;
    }
    public void DFS(Graph graph, int vertex){
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        int[] edges = graph.getEdgeMatrix()[vertex];
        for (int i = 0; i < edges.length; i++) {
            if(edges[i] == 1 & !visited[i]){
                visited[i] = true;
                DFS(graph, i);
            }
        }
    }
}