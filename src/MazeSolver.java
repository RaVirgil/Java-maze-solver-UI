import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MazeSolver {
    public void Solve(ArrayList<ArrayList<Integer>> maze, Nod current, Queue<Nod> nodesToVisit, HashSet<Nod> visitedNodes,LinkedList<Nod>path)
    {

            if (!(visitedNodes.contains(current)))
            {
                if (HasUp(maze, current)) nodesToVisit.add(new Nod(current.x - 1, current.y,current));
                if (HasDown(maze, current)) nodesToVisit.add(new Nod(current.x + 1, current.y,current));
                if (HasLeft(maze, current)) nodesToVisit.add(new Nod(current.x, current.y - 1,current));
                if (HasRight(maze, current)) nodesToVisit.add(new Nod(current.x, current.y + 1,current));
                visitedNodes.add(current);
                nodesToVisit.poll();
                if(maze.get(current.x).get(current.y)!=3)
                Solve(maze, nodesToVisit.peek(), nodesToVisit, visitedNodes,path);
                else
                    RemakePath(current,path);
            }
            else
            {
                if(maze.get(current.x).get(current.y)!=3)
                {
                    nodesToVisit.poll();
                    Solve(maze, nodesToVisit.peek(),  nodesToVisit, visitedNodes,path);
                }
                else
                    RemakePath(current,path);
            }



    }
    public boolean HasUp(ArrayList<ArrayList<Integer>> maze,Nod current)
    {
        if((current.x-1>=0 && current.x+1<maze.size()) && (current.y>=0 &&current.y<maze.size()))
        {
        return maze.get(current.x-1).get(current.y)!=1;

        }
        return false;
    }
    public boolean HasDown(ArrayList<ArrayList<Integer>> maze,Nod current)
    {
        if((current.x+1>=0 && current.x+1<maze.size()) && (current.y>=0 &&current.y<maze.size()))
        return maze.get(current.x+1).get(current.y)!=1;
        return false;
    }
    public boolean HasLeft(ArrayList<ArrayList<Integer>> maze,Nod current)
    {
        if((current.x>=0 && current.x<maze.get(0).size()) && (current.y-1>=0 &&current.y-1<maze.get(0).size()))
        return maze.get(current.x).get(current.y-1)!=1;
        return false;
    }
    public boolean HasRight(ArrayList<ArrayList<Integer>> maze,Nod current)
    {
        if((current.x>=0 && current.x<maze.get(0).size()) && (current.y+1>=0 &&current.y+1<maze.get(0).size()))
        return maze.get(current.x).get(current.y+1)!=1;
        return false;
    }
    public void RemakePath(Nod curent,LinkedList<Nod>path)
    {if(curent.parinte!=null)
       { path.add(curent);
     RemakePath(curent.parinte,path);}


    }
}
