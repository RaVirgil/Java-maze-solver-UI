import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        //reading and initializing values
        Scanner file = new Scanner(new File("maze.txt"));
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        int lines = file.nextInt();
        int columns = file.nextInt();
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < lines; i++) {
            ArrayList<Integer> nr = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                nr.add(file.nextInt());
                if (nr.get(j) == 2) {
                    startX = i;
                    startY = j;
                }

            }
            maze.add(nr);
        }

        //maze solver
        Nod startNode = new Nod(startX, startY, null);
        Queue<Nod> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(startNode);
        HashSet<Nod> visitedNodes = new HashSet<>();
        LinkedList<Nod> path = new LinkedList<>();
        MazeSolver solver = new MazeSolver();
        solver.Solve(maze, startNode, nodesToVisit, visitedNodes, path);

        //panel generate
        JFrame frame = new JFrame("Maze Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        JPanel temp = new JPanel();
        GridLayout mazeGrid = new GridLayout(lines, columns);
        panel.setLayout(mazeGrid);
        for(int i = 0;i<lines;i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (maze.get(i).get(j) == 1)
                {
                    temp = new JPanel();
                    temp.setBackground(Color.BLACK);
                    panel.add(temp);
                }

                if (maze.get(i).get(j) == 0)
                {
                    if (path.contains(new Nod(i, j,null)))
                    {
                        temp = new JPanel();
                        temp.setBackground(Color.YELLOW);
                        panel.add(temp);
                    }
                    else
                    {
                        temp = new JPanel();
                        temp.setBackground(Color.WHITE);
                        panel.add(temp);
                    }
                }

                if (maze.get(i).get(j) == 2)
                {
                    temp = new JPanel();
                    temp.setBackground(Color.GREEN);
                    panel.add(temp);

                }

                if (maze.get(i).get(j) == 3)
                {
                    temp = new JPanel();
                    temp.setBackground(Color.RED);
                    panel.add(temp);
                }


            }
        }
        frame.add(panel);
}
}
