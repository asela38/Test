package com.asela;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static class Record {
        Integer      destination;
        Integer     cost = Integer.MAX_VALUE;

        @Override
        public String toString() {
            return "Record [destination=" + destination + ", cost=" + cost + "]";
        }

    }
    
    
    static int beautifulPath(int[][] edges, int A, int B) {
      Map<Integer, Map<Integer, Integer>> graph = readGraph(edges);
 
        Queue<Record> records = new PriorityQueue<>((r1, r2) -> r1.cost - r2.cost);
        Map<Integer, Record> distMap = new HashMap<>();
        for (Integer node : graph.keySet()) {
            Record record = new Record();
            record.destination = node;
            if (record.destination.equals(A))
                record.cost = 0;
            records.offer(record);
            distMap.put(node, record);
        }
        
        while (!records.isEmpty()) {
            Record record = records.poll();
            
            if(record.cost == Integer.MAX_VALUE) break;
            
            Map<Integer, Integer> possibleRoutes = graph.get(record.destination);
            for (Map.Entry<Integer, Integer> entry : possibleRoutes.entrySet()) {
                Record destRecord = distMap.get(entry.getKey());
                int costViaDest = entry.getValue() | record.cost;
                if(destRecord.cost > costViaDest ) {
                    records.remove(destRecord);
                    destRecord.cost =  costViaDest ;
                    records.offer(destRecord);
                }
            }
        }
        
        Record endRecord = distMap.get(B);

      return endRecord.cost == Integer.MIN_VALUE ? -1 : endRecord.cost;
    }
    
    private static Map<Integer, Map<Integer, Integer>> readGraph(int[][] edges) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
     
        for (int i = 0; i < edges.length ; i++) {
            Integer node1 = edges[i][0];
            Integer node2 = edges[i][1];
            Integer cost = edges[i][2];

            addToGraph(graph, node1, node2, cost);
            addToGraph(graph, node2, node1, cost);
        }
        return graph;

    }

    private static void addToGraph(Map<Integer, Map<Integer, Integer>> graph, Integer node1, Integer node2, Integer cost) {
        Map<Integer, Integer> map = graph.get(node1);
        if (map == null) {
            map = new HashMap<>();
            graph.put(node1, map);
        }
        Integer _cost = map.get(node2);
        if(_cost == null)
            _cost = cost;
        else
            _cost = cost > _cost ? _cost : cost;
            
        map.put(node2, _cost);

    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("hk_less_costly_path.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] edges = new int[m][3];
        for(int edges_i = 0; edges_i < m; edges_i++){
            for(int edges_j = 0; edges_j < 3; edges_j++){
                edges[edges_i][edges_j] = in.nextInt();
            }
        }
        int A = in.nextInt();
        int B = in.nextInt();
        int result = beautifulPath(edges, A, B);
        System.out.println(result);
        in.close();
    }
}