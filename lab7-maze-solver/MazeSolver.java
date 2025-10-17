public class MazeSolver {

    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    /**
     * Prints the current state of the maze.
     */
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    /**
     * Public wrapper method to start the maze-solving process.
     */
    public boolean solve() {
        int startRow = -1;
        int startCol = -1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        if (startRow != -1) {
            return solve(startRow, startCol);
        }
        return false;
    }

    /**
     * Recursive backtracking method.
     */
    private boolean solve(int row, int col) {
        // 1️⃣ Base Cases
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
            return false; // Out of bounds
        }
        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false; // Wall or already visited
        }
        if (maze[row][col] == 'F') {
            return true; // Found the finish
        }

        // 2️⃣ Mark as visited (part of current path)
        maze[row][col] = '.';
        printMaze(); // optional: shows step-by-step exploration

        // 3️⃣ Recursive exploration in 4 directions
        if (solve(row - 1, col) || // North
                solve(row, col + 1) || // East
                solve(row + 1, col) || // South
                solve(row, col - 1)) { // West
            return true;
        }

        // 4️⃣ Backtrack — unmark if no path found
        maze[row][col] = ' ';
        return false;
    }

    public static void main(String[] args) {
        char[][] mazeToSolve = {
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', ' ', '#', ' ', '#', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', 'F', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver = new MazeSolver(mazeToSolve);

        System.out.println("Original Maze:");
        solver.printMaze();

        if (solver.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver.printMaze();
    }
}
