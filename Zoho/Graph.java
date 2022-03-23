import java.util.*;

public class Graph
{
    //CREATING A GRAPH
	private int v;
    private ArrayList<Character>[] adjList;
    public Graph(int vertices)
    {
        this.v = vertices;
        initAdjList();
    }
    private void initAdjList()
    {
        adjList = new ArrayList[v];
 
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    // ADDING THE EDGES TO THE GRAPH
    public void addEdge(char u, char v)
    {
        adjList[u-'A'].add(v);
    }
    //FIRST SELECT THE POSIBLE PATH AND SELECT THE SHORTEST PATH IS IN BELOW FUNCTION
    public void getPaths(char s, char d)
    {
        boolean[] isVisited = new boolean[v];
        ArrayList<Character> pathList = new ArrayList<>();
        pathList.add(s);
        getPathsUtil(s, d, isVisited, pathList);
    }
    ArrayList<Character> best=new ArrayList<Character>();
    private void getPathsUtil(char u, char d,
                                   boolean[] isVisited,
                                   List<Character> localPathList)
    {
 
        if (u==d) {
        	if(best.size()==0||best.size()>localPathList.size()) {
        		best = new ArrayList<>(localPathList);
        	}
            return;
        }
 
        isVisited[u-'A'] = true;
        for (Character i : adjList[u-'A']) {
            if (!isVisited[i-'A']) {
                localPathList.add(i);
                getPathsUtil(i, d, isVisited, localPathList);
                localPathList.remove(i);
            }
        }
        isVisited[u-'A'] = false;
    }
}
