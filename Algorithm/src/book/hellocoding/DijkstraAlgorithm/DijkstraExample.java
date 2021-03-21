package book.hellocoding.DijkstraAlgorithm;

public class DijkstraExample {
    public static void main(String[] args) {
        GraphTest g = new GraphTest(5);
        g.inputRelation(1,2,10);
        g.inputRelation(3,2,1);
        g.inputRelation(2,4,20);
        g.inputRelation(4,3,1);
        g.inputRelation(4,5,30);
        g.dijkstra(1);
    }
}

class GraphTest{
    private int n;
    private int[][] maps;

    public GraphTest(int n){
        this.n = n;
        this.maps = new int[n+1][n+1];
    }

    public void inputRelation(int i, int j, int w){
        maps[i][j] = w;
        // maps[j][i] = w;
    }

    public void dijkstra(int v){
        int[] distance = new int[n+1];
        boolean[] nodeCheck = new boolean[n+1];

        for(int i=1; i<n+1; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[v] = 0;
        nodeCheck[v] = true;

        for(int i=1; i<n+1; i++){
            if(!nodeCheck[i] && maps[v][i] != 0){
                distance[i] = maps[v][i];
            }
        }

        for(int a=0; a<n-1;a++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for(int i=1; i<n+1;i++){
                if(!nodeCheck[i] && distance[i] != Integer.MAX_VALUE){
                    if(distance[i] < min) {
                        min = distance[i];
                        minIndex = i;
                    }
                }
            }

            nodeCheck[minIndex] = true;
            for(int i=1; i<n+1; i++){
                if(!nodeCheck[i] && maps[minIndex][i] != 0){
                    if(distance[i] > maps[minIndex][i] + distance[minIndex]){
                        distance[i] = maps[minIndex][i] + distance[minIndex];
                    }
                }
            }
        }

        for(int i=1; i<n+1; i++){
            System.out.print(distance[i] + " ");
        }
    }
}
