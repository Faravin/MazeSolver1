import java.util.LinkedList;

public class MazeSolver {

    static int[][] maze = {
            {2, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1}
    };
    //0=wall
    //1=path
    //2=goal

    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args) {
        Position p = new Position(4, 8);
        path.push(p); //use push it will make it go infront of the list add does not



        while (true) {
            int y = path.peek().y;
            int x = path.peek().x;

            maze[y][x] = 0;
            //down
            if (isValid(y + 1, x)) {
                if (maze[y + 1][x] == 2) {
                    System.out.println("Moved down. You've won!");
                    return;
                } else if (maze[y + 1][x] == 1) {
                    System.out.println("Moved down");
                    path.push(new Position(y + 1, x));
                    continue;

                }
            }
            //left
            if (isValid(y, x - 1)) {
                if (maze[y][x - 1] == 2) {
                    System.out.println("Moved left. You've won!");
                    return;
                } else if (maze[y][x - 1] == 1) {
                    System.out.println("Moved left");
                    path.push(new Position(y, x - 1));
                    continue;

                }
            }
            //up
            if (isValid(y-1, x)) {
                if (maze[y - 1][x] == 2) {
                    System.out.println("Moved up. You've won!");
                    return;
                } else if (maze[y - 1][x] == 1) {
                    System.out.println("Moved up");
                    path.push(new Position(y - 1, x));
                    continue;

                }
            }
            //right
            if (isValid(y, x+1)) {
                if (maze[y][x + 1] == 2) {
                    System.out.println("Moved right. You've won!");
                    return;
                } else if (maze[y][x + 1] == 1) {
                    System.out.println("Moved right");
                    path.push(new Position(y, x + 1));
                    continue;

                }
            }

            path.pop();
            System.out.println("Moved back");
            if (path.size() <= 0) {
                System.out.println("No path.");
                return;
            }

        }

    }

    public static boolean isValid ( int y, int x){
        if (y < 0 || y >= maze.length || x < 0 || x >= maze[y].length) {
            return false;
        }
        return true;
    }
}