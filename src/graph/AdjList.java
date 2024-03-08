package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AdjList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int vertexs = Integer.parseInt(info[0]);
        int edges = Integer.parseInt(info[1]);
        // 인접리스트 : 각 정점이 도달할 수 있는 정점들을 리스트로 저장하는 방식
        List<List<Integer>> adjList = new ArrayList<>();
        // 내부에 빈 리스트를 먼저 만들어준다.
        for (int i = 0; i < vertexs ; i++) {
            adjList.add(new ArrayList<>());
        }

        // 간선의 정보를 입력받는다.
        for (int i = 0; i < edges; i++) {
            String[] edgeInfo = reader.readLine().split(" ");
            int leftVertex = Integer.parseInt(edgeInfo[0]);
            int rightVertex = Integer.parseInt(edgeInfo[1]);
            adjList.get(leftVertex).add(rightVertex);
            adjList.get(rightVertex).add(leftVertex);

        }

        // 결과를 출력한다.
        for (int i = 0; i < vertexs; i++) {
            System.out.println(String.format("%d: %s", i, adjList.get(i)));

        }
    }
}
