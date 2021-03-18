package book.hellocoding.DijkstraAlgorithm;

import jdk.nashorn.internal.ir.SplitNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dijkstra {
    public static List<String> proceed = new ArrayList<String>();

    public static void main(String[] args) {
        HashMap<String, HashMap<String,Object>> graph = new HashMap<>();
        HashMap<String, Object> sGraph = new HashMap<>();
        HashMap<String, Object> aGraph = new HashMap<>();
        HashMap<String, Object> bGraph = new HashMap<>();
        sGraph.put("a",6);
        sGraph.put("b",2);
        graph.put("start",sGraph);
        aGraph.put("fin",1);
        graph.put("a",aGraph);
        bGraph.put("a",3);
        bGraph.put("fin",5);
        graph.put("b",bGraph);

        double x = Double.POSITIVE_INFINITY;
        HashMap<String, Object> costs = new HashMap<>();
        costs.put("a",6);
        costs.put("b",2);
        costs.put("fin",x);

        HashMap<String, Object> parents = new HashMap<>();
        parents.put("a","start");
        parents.put("b","start");
        parents.put("fin",null);

        dijkstraFunc(costs,graph,parents,"start");

        for(String node : costs.keySet()){
            System.out.println(node + " : " + costs.get(node));
        }
        System.out.println();
        for(String node:parents.keySet())
            System.out.println(node + " : "+parents.get(node));

    }

    public static void dijkstraFunc(HashMap<String, Object> costs, HashMap<String, HashMap<String,Object>> graph, HashMap<String,Object> parents ,String node){
        node = findLowestCostNode(costs);
        while(!node.equals("fin")){
            double cost = Double.parseDouble(costs.get(node)+"");
            HashMap<String,Object> neighbors = graph.get(node);
            for(String n : neighbors.keySet()){
                double newCost = cost + Double.parseDouble(neighbors.get(n)+"");
                if(Double.parseDouble(costs.get(n)+"") > newCost){
                    costs.put(n,newCost);
                    parents.put(n,node);
                }
            }
            proceed.add(node);
            node = findLowestCostNode(costs);
        }

    }

    public static String findLowestCostNode(HashMap<String, Object> costs){
        double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;
        for(String node : costs.keySet()){
            double cost = Double.parseDouble(costs.get(node)+"");
            if(cost < lowestCost && !proceed.contains(node)){
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }
}
