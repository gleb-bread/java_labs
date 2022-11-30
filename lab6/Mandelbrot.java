import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
	public void getInitialRange(Rectangle2D.Double range) {
		range.x = -2;
		range.y = -1.5;
		range.height = 3;
		range.width = 3;
	}

	public static final int MAX_ITERATIONS = 2000;

	@Override
	public int numIterations(double x, double y) {
		double i = y;
		double x1 = x;
		int count = 0;
		while (count < MAX_ITERATIONS) {
			count++;
			double a = x1 * x1 - i * i + x;
			double b = 2 * x1 * i + y;
			x1 = a;
			i = b;
			if (x1 * x1 + i * i > 4)
				break;
		}
		if (count == MAX_ITERATIONS)
			return -1;
		else
			return count;
	}

	@Override
	public String toString() {
		return "Mandelbrot";
	}
}
