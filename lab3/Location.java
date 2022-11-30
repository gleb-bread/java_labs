
import java.util.Objects;

/**
 * Этот класс представляет определенное местоположение на 2D-карте. Координаты
 * являются
 * целочисленные значения.
 **/
public class Location {
    /** X координата этого местоположения. **/
    public int xCoord;

    /** Y координата этого местоположения. **/
    public int yCoord;

    /** Создает новое местоположение с указанными целочисленными координатами. **/
    public Location(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    /** Создает новое местоположение с координатами (0, 0). **/
    public Location() {
        this(0, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location location = (Location) obj;
        return xCoord == location.xCoord && yCoord == location.yCoord;
    }

    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }
}