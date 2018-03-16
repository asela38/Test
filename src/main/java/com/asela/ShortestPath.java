package com.asela;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ShortestPath {

    private static class Record {
        String      destination;
        Integer     cost = Integer.MAX_VALUE;
        Set<String> path = new LinkedHashSet<>();

        @Override
        public String toString() {
            return "Record [destination=" + destination + ", cost=" + cost + ", path=" + path + "]";
        }

    }

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new File("./shortest_path_inputs.txt"))) {

            Map<String, Map<String, Integer>> graph = readGraph(scanner);

            System.out.println(graph);

            String start = scanner.next();
            String end = scanner.next();

            Queue<Record> records = new PriorityQueue<>((r1, r2) -> r1.cost - r2.cost);
            Map<String, Record> distMap = new HashMap<>();
            for (String node : graph.keySet()) {
                Record record = new Record();
                record.destination = node;
                if (record.destination.equals(start))
                    record.cost = 0;
                records.offer(record);
                distMap.put(node, record);
            }

            while (!records.isEmpty()) {
                Record record = records.poll();
                Map<String, Integer> possibleRoutes = graph.get(record.destination);
                
                if(record.cost == Integer.MAX_VALUE) break;
           //     System.out.printf("%n OP: %s  %n", record);
                for (Map.Entry<String, Integer> entry : possibleRoutes.entrySet()) {
                    Record destRecord = distMap.get(entry.getKey());
                    int costViaDest = entry.getValue() + record.cost;
                    if(destRecord.cost > costViaDest ) {
                        records.remove(destRecord);
                        destRecord.cost =  costViaDest ;
                        Set<String> newPath = new LinkedHashSet<>();
                        newPath.addAll(record.path);
                        newPath.add(record.destination);
                        newPath.add(destRecord.destination);
                        destRecord.path = newPath;
                        records.offer(destRecord);
                    }
                }
            }
            
         //   System.out.println(distMap.values());
            Record endRecord = distMap.get(end);
            System.out.printf("%n Minimum Path to %s-%s is %d through %s %n", start, end, endRecord.cost , endRecord.path );

        }

    }

    private static Map<String, Map<String, Integer>> readGraph(Scanner scanner) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        int numberOfLines = scanner.nextInt();
        for (int i = 0; i < numberOfLines; i++) {
            String node1 = scanner.next();
            String node2 = scanner.next();
            Integer cost = scanner.nextInt();

            addToGraph(graph, node1, node2, cost);
            addToGraph(graph, node2, node1, cost);
        }
        return graph;

    }

    private static void addToGraph(Map<String, Map<String, Integer>> graph, String node1, String node2, Integer cost) {
        Map<String, Integer> map = graph.get(node1);
        if (map == null) {
            map = new HashMap<>();
            graph.put(node1, map);
        }
        map.put(node2, cost);

    }
}
