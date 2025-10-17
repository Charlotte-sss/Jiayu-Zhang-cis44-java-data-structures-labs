import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    // The maximum recursion depth controls how detailed the tree is
    private final int MAX_DEPTH = 9;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Starting position: bottom center of the panel
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;

        // Start drawing the tree upward (-90 degrees = straight up)
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    /**
     * Recursively draws a fractal tree.
     * @param g The graphics object to draw on.
     * @param x1 The starting x-coordinate of the branch.
     * @param y1 The starting y-coordinate of the branch.
     * @param angle The current angle (in degrees).
     * @param depth The current recursion depth.
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        // 1️⃣ Base Case — stop when depth reaches 0
        if (depth == 0) return;

        // 2️⃣ Determine the branch length (shorter each level)
        int length = depth * 10;

        // 3️⃣ Calculate end coordinates using trigonometry
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * length);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * length);

        // 4️⃣ Set branch color based on depth (optional: gradient effect)
        g.setColor(new Color(34, 139, 34)); // default green for branches
        if (depth < 3) {
            g.setColor(new Color(139, 69, 19)); // brown for leaves near end
        }

        // 5️⃣ Draw the branch (line from start to end)
        g.drawLine(x1, y1, x2, y2);

        // 6️⃣ Recursive calls for left and right sub-branches
        // Left branch: angle - 20°
        drawTree(g, x2, y2, angle - 20, depth - 1);

        // Right branch: angle + 20°
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
