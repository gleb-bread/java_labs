import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
    private int sizeDisplay;
    private JImageDisplay imageDisplay;
    private FractalGenerator fractalGenerator;
    private Rectangle2D.Double range;

    public static void main(String[] args) {
        FractalExplorer fractalExplorer = new FractalExplorer(600);
        fractalExplorer.createAndShowGUI();
        fractalExplorer.drawFractal();
    }

    private FractalExplorer(int sizeDisplay) {
        this.sizeDisplay = sizeDisplay;
        this.fractalGenerator = new Mandelbrot();
        this.range = new Rectangle2D.Double(0, 0, 0, 0);
        fractalGenerator.getInitialRange(this.range);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Fractal Exploerer");
        JButton button = new JButton("Reset display");
        imageDisplay = new JImageDisplay(sizeDisplay, sizeDisplay);
        button.addActionListener(new ActionHandler());
        imageDisplay.addMouseListener(new MouseListener());

        frame.setLayout(new java.awt.BorderLayout());
        frame.add(imageDisplay, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal() {
        for (int x = 0; x < sizeDisplay; x++) {
            for (int y = 0; y < sizeDisplay; y++) {
                int count = fractalGenerator.numIterations(
                        FractalGenerator.getCoord(range.x, range.x + range.width, sizeDisplay, x),
                        FractalGenerator.getCoord(range.y, range.y + range.width, sizeDisplay, y));
                if (count == -1) {
                    imageDisplay.drawPixel(x, y, 0);
                } else {
                    float hue = 0.7f + (float) count / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    imageDisplay.drawPixel(x, y, rgbColor);
                }
            }
        }
        imageDisplay.repaint();
    }

    public class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            fractalGenerator.getInitialRange(range);
            drawFractal();
        }
    }

    public class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            double x = FractalGenerator.getCoord(range.x, range.x + range.width, sizeDisplay, e.getX());
            double y = FractalGenerator.getCoord(range.y, range.y + range.width, sizeDisplay, e.getY());
            fractalGenerator.recenterAndZoomRange(range, x, y, 0.5);
            drawFractal();
        }
    }
}