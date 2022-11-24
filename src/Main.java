import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> list = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1,3)),
                new ArrayList<>(List.of(0,2,3,4)),
                new ArrayList<>(List.of(1,4)),
                new ArrayList<>(List.of(0,1,4)),
                new ArrayList<>(List.of(1,2,3))
        ));

        File f = new File("D:\\Fac\\Analiza_si_proiectarea_algoritmilor\\Lab 4\\proiect\\resutlsMihai.csv");
        FileWriter fw = new FileWriter(f);

        Graf graf = new Graf(list);

        System.out.println(graf);
        System.out.println(graf.getListOfEdges());

        graf.setEdge(0,1,6);
        graf.setEdge(0,3,1);
        graf.setEdge(1,3,2);
        graf.setEdge(1,4,2);
        graf.setEdge(1,2,5);
        graf.setEdge(2,4,5);
        graf.setEdge(3,4,1);

        System.out.println(graf.getListOfEdges());

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graf);
        System.out.println(dijkstraAlgorithm.getListOfShortestDistances());

        FloydAlgorithm floydAlgorithm = new FloydAlgorithm(graf);

        System.out.println(floydAlgorithm.getListOfShortestDistances());



        String dijskstraDefav = "";
        String floydDefav="";
        for(int i = 5; i <= 100; i++){
            Graf gr = new Graf(i, 99999);
            gr.setRandomWeights();
            DijkstraAlgorithm dijkstraAlgorithm1 = new DijkstraAlgorithm(gr);
            FloydAlgorithm floydAlgorithm1 = new FloydAlgorithm(gr);
            dijskstraDefav += dijkstraAlgorithm1.getIt() + ",";
            floydDefav += floydAlgorithm1.getIt() + ",";
            System.out.println("\n\n---------- " + i + "----------");
            System.out.println("Dijkstra it = " + dijkstraAlgorithm1.getIt());
            System.out.println("Floyd it = " + floydAlgorithm1.getIt());
        }

        fw.write(dijskstraDefav);
        fw.write("\n");
        fw.write(floydDefav);
        fw.write("\n");


        String dijskstraFav = "";
        String floydFav="";
        for(int i = 5; i <= 100; i++){
            Graf gr = new Graf(i, 0);
            gr.setRandomWeights();
            DijkstraAlgorithm dijkstraAlgorithm1 = new DijkstraAlgorithm(gr);
            FloydAlgorithm floydAlgorithm1 = new FloydAlgorithm(gr);
            dijskstraFav += dijkstraAlgorithm1.getIt() + ",";
            floydFav += floydAlgorithm1.getIt() + ",";
            System.out.println("\n\n---------- " + i + "----------");
            System.out.println("Dijkstra it = " + dijkstraAlgorithm1.getIt());
            System.out.println("Floyd it = " + floydAlgorithm1.getIt());
        }

        fw.write(dijskstraFav);
        fw.write("\n");
        fw.write(floydFav);
        fw.write("\n");


        String dijskstraMediu = "";
        String floydMediu="";

        for(int i = 5; i <= 100; i++){
            Graf gr = new Graf(i, (i*i-i)/4);
            gr.setRandomWeights();
            DijkstraAlgorithm dijkstraAlgorithm1 = new DijkstraAlgorithm(gr);
            FloydAlgorithm floydAlgorithm1 = new FloydAlgorithm(gr);
            dijskstraMediu += dijkstraAlgorithm1.getIt() + ",";
            floydMediu += floydAlgorithm1.getIt() + ",";
            System.out.println("\n\n---------- " + i + "----------");
            System.out.println("Dijkstra it = " + dijkstraAlgorithm1.getIt());
            System.out.println("Floyd it = " + floydAlgorithm1.getIt());
        }

        fw.write(dijskstraMediu);
        fw.write("\n");
        fw.write(floydMediu);
        fw.write("\n");

        fw.close();
    }
}
