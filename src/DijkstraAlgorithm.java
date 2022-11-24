
import java.util.ArrayList;
import java.util.List;

public class DijkstraAlgorithm {
    private Graf graf;
    private int it = 0;
    private List<Integer> listOfShortestDistances;

    public DijkstraAlgorithm(Graf graf){
        this.graf = graf;
        alg();
    }

    private void alg(){
        List<Integer> listOfVisitedVertices = new ArrayList<>();
        List<Integer> listOfShortestDistances = new ArrayList<>();
        List<Integer> listOfPreviousVertices = new ArrayList<>();
        this.it +=3;

        for(int i = 0; i < graf.getNumberOfVertices(); i++){
            listOfShortestDistances.add(999999);
            this.it +=4;
        }
        listOfShortestDistances.set(0,0);
        this.it +=3;

        while (listOfVisitedVertices.size() != graf.getNumberOfVertices()){

            int edge = getShortestDistance(listOfShortestDistances, listOfVisitedVertices);
            this.it+=2;
            listOfVisitedVertices.add(edge);
                for (Integer i : graf.getAdjacencyList().get(edge)){
                    this.it+=5;
                    if(!listOfVisitedVertices.contains(i)){
                        this.it+=5;
                        if(graf.getWeight(edge,i) + listOfShortestDistances.get(edge) < listOfShortestDistances.get(i)){
                            this.it+=4;
                            listOfShortestDistances.set(i,listOfShortestDistances.get(edge) + graf.getWeight(edge,i));
                        }
                    }
                }

        }

        this.listOfShortestDistances = listOfShortestDistances;
    }

    public List<Integer> getListOfShortestDistances() {
        return this.listOfShortestDistances;
    }

    private int getShortestDistance(List<Integer> listOfShortestDistances, List<Integer> listOfVisitedVertices){
        int m = 999999;
        int index = 0;
        this.it +=2;
        for (int i = 0; i < listOfShortestDistances.size(); i++){
            this.it +=5;
            if(m > listOfShortestDistances.get(i) && !listOfVisitedVertices.contains(i)){
                this.it+=3;
                m = listOfShortestDistances.get(i);
                index = i;
            }
        }
        return index;
    }

    public int getIt() {
        return this.it;
    }
}
