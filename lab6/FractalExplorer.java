import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class FractalExplorer {
    private int sizeDisplay;
    private JImageDisplay imageDisplay;
    private FractalGenerator fractalGenerator;
    private Rectangle2D.Double range;
    private JComboBox comboBox;
    private int rowsRemaining;
    private JButton buttonReset;
    private JButton buttonSave;

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
        JFrame frame = new JFrame("Fractal Explorer");
        buttonReset = new JButton("Reset Display");
        buttonSave = new JButton("Save Image");
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JLabel label = new JLabel("Fractal:");
        imageDisplay = new JImageDisplay(sizeDisplay, sizeDisplay);
        imageDisplay.addMouseListener(new MouseListener());

        comboBox = new JComboBox();
        comboBox.addItem(new Mandelbrot());
        comboBox.addItem(new Tricorn());
        comboBox.addItem(new BurningShip());
        comboBox.addActionListener(new ActionHandler());

        buttonReset.setActionCommand("Reset Display");
        buttonReset.addActionListener(new ActionHandler());

        buttonSave.setActionCommand("Save Image");
        buttonSave.addActionListener(new ActionHandler());

        jPanel1.add(label, BorderLayout.CENTER);
        jPanel1.add(comboBox, BorderLayout.CENTER);
        jPanel2.add(buttonReset, BorderLayout.CENTER);
        jPanel2.add(buttonSave, BorderLayout.CENTER);

        frame.setLayout(new BorderLayout());
        frame.add(imageDisplay, BorderLayout.CENTER);
        frame.add(jPanel1, BorderLayout.NORTH);
        frame.add(jPanel2, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal() {
        enableUI(false);
        rowsRemaining = sizeDisplay;
        for (int i = 0; i < sizeDisplay; i++) {
            FractalWorker drawRow = new FractalWorker(i);
            drawRow.execute();
        }
    }

    public class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Reset Display")) {
                fractalGenerator.getInitialRange(range);
                drawFractal();
            } else if (e.getActionCommand().equals("Save Image")) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("PNG Images", "png");
                fileChooser.setFileFilter(fileFilter);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int t = fileChooser.showSaveDialog(imageDisplay);
                if (t == JFileChooser.APPROVE_OPTION) {
                    try {
                        ImageIO.write(imageDisplay.getPicture(), "png", fileChooser.getSelectedFile());
                    } catch (NullPointerException | IOException ee) {
                        JOptionPane.showMessageDialog(imageDisplay, ee.getMessage(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                fractalGenerator = (FractalGenerator) comboBox.getSelectedItem();
                range = new Rectangle2D.Double(0, 0, 0, 0);
                fractalGenerator.getInitialRange(range);
                drawFractal();
            }
        }
    }

    public class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (rowsRemaining == 0) {
                double x = FractalGenerator.getCoord(range.x, range.x + range.width, sizeDisplay, e.getX());
                double y = FractalGenerator.getCoord(range.y, range.y + range.width, sizeDisplay, e.getY());
                fractalGenerator.recenterAndZoomRange(range, x, y, 0.5);
                drawFractal();
            }
        }
    }

    public class FractalWorker extends SwingWorker<Object, Object> {
        private int coordY;
        private int[] RGB;

        public FractalWorker(int coordY) {
            this.coordY = coordY;
        }

        @Override
        public Object doInBackground() throws Exception {
            RGB = new int[sizeDisplay];

            for (int x = 0; x < sizeDisplay; x++) {
                int count = fractalGenerator.numIterations(
                        FractalGenerator.getCoord(range.x, range.x + range.width, sizeDisplay, x),
                        FractalGenerator.getCoord(range.y, range.y + range.width, sizeDisplay, coordY));
                if (count == -1) {
                    RGB[x] = 0;
                } else {
                    float hue = 0.7f + (float) count / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    RGB[x] = rgbColor;
                }
            }
            return null;
        }

        @Override
        public void done() {
            for (int x = 0; x < sizeDisplay; x++) {
                imageDisplay.drawPixel(x, coordY, RGB[x]);
            }
            imageDisplay.repaint(0, 0, coordY, sizeDisplay, 1);
            rowsRemaining--;
            if (rowsRemaining == 0)
                enableUI(true);
        }
    }

    public void enableUI(boolean val) {
        buttonSave.setEnabled(val);
        buttonReset.setEnabled(val);
        comboBox.setEnabled(val);
    }
}
