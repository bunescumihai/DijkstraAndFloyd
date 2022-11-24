import java.util.ArrayList;
import java.util.List;

public class FloydAlgorithm {
    private Graf graf;
    private int it = 0;
    private List<Integer> listOfShortestDistances = new ArrayList<>();
    public FloydAlgorithm(Graf graf){
        this.graf = graf;
        int[][] list = new int[graf.getNumberOfVertices()][graf.getNumberOfVertices()];

        for(int i = 0; i < graf.getNumberOfVertices(); i++)
            for(int j = 0; j < graf.getNumberOfVertices(); j++)
                list[i][j] = 0;

        for (int i = 0; i < graf.getNumberOfVertices(); i++)
            for (Integer j : graf.getAdjacencyList().get(i))
                list[i][j] = graf.getWeight(i,j);



        for(int i = 0; i < graf.getNumberOfVertices(); i++)
            for(int j = 0; j < graf.getNumberOfVertices(); j++)
                if(i != j && list[i][j] == 0)
                    list[i][j] = 999999;

        alg(list);
    }

    public int getIt() {
        return it;
    }

    public List<Integer> getListOfShortestDistances() {
        return this.listOfShortestDistances;
    }

    private void alg(int[][] list) {
        for (int k = 0; k < graf.getNumberOfVertices(); k++) {
            this.it+=3;
            for (int i = 0; i < graf.getNumberOfVertices(); i++) {
                this.it+=3;
                for (int j = 0; j < graf.getNumberOfVertices(); j++){
                    this.it+=5;
                    if (list[i][j] > list[i][k] + list[k][j]) {
                        list[i][j] = list[i][k] + list[k][j];
                        this.it+=3;
                    }
                }
            }
        }

        for(int i = 0; i < graf.getNumberOfVertices(); i++)
            listOfShortestDistances.add(list[0][i]);
    }
}
