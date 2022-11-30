
import java.util.HashMap;

/**
 * Этот класс хранит базовое состояние, необходимое для алгоритма A* для
 * вычисления
 * путь по карте. Это состояние включает в себя коллекцию "открытых путевых
 * точек" и
 * другую коллекцию "закрытых путевых точек". Кроме того, этот класс
 * обеспечивает
 * основные операции, необходимые алгоритму поиска пути A* для выполнения его
 * обработка.
 **/
public class AStarState {
    /** Это ссылка на карту, по которой перемещается алгоритм A*. **/
    private Map2D map;
    private final HashMap<Location, Waypoint> closedWaypoints = new HashMap<>();
    private final HashMap<Location, Waypoint> openedWaypoints = new HashMap<>();

    /**
     * Инициализируйте новый объект состояния для использования алгоритма поиска
     * пути A*.
     **/
    public AStarState(Map2D map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Возвращает карту, по которой перемещается навигатор A*. **/
    public Map2D getMap() {
        return map;
    }

    /**
     * Этот метод сканирует все открытые путевые точки и возвращает путевую точку
     * с минимальной общей стоимостью. Если открытых путевых точек нет, этот метод
     * возвращает <код>null</code>.
     **/
    public Waypoint getMinOpenWaypoint() {
        Location minLocation = null;
        float minTotalCost = Float.MAX_VALUE;
        for (Location key : openedWaypoints.keySet()) {
            float totalCost = openedWaypoints.get(key).getTotalCost();
            if (totalCost < minTotalCost) {
                minTotalCost = totalCost;
                minLocation = key;
            }
        }
        return openedWaypoints.get(minLocation);
    }

    /**
     * Этот метод добавляет путевую точку к (или потенциально обновляет уже
     * имеющуюся путевую точку
     * в) коллекция "открытые путевые точки". Если еще не существует открытого
     * * путевая точка в новом местоположении путевых точек, тогда новая путевая
     * точка просто
     * добавлено в коллекцию. Однако, если в
     * местоположении * * new waypoints уже есть путевая точка, новая путевая точка
     * заменяет только старую <em>
     * * если</em> значение "предыдущей стоимости" новых путевых точек меньше
     * текущего
     * * значение путевых точек "предыдущая стоимость".
     **/
    public boolean addOpenWaypoint(Waypoint newWP) {
        Location location = newWP.getLocation();
        if (!openedWaypoints.containsKey(location)
                || newWP.getPreviousCost() < openedWaypoints.get(location).getPreviousCost()) {
            openedWaypoints.put(location, newWP);
            return true;
        }
        return false;
    }

    /** Возвращает текущее количество открытых путевых точек. **/
    public int numOpenWaypoints() {
        // TODO: Implement.
        return openedWaypoints.size();
    }

    /**
     * Этот метод перемещает путевую точку в указанном местоположении из
     * открытого списка в закрытый список.
     **/
    public void closeWaypoint(Location loc) {
        Waypoint wpToClose = openedWaypoints.remove(loc);
        if (wpToClose != null) {
            closedWaypoints.put(loc, wpToClose);
        }
    }

    /**
     * Возвращает значение true, если коллекция закрытых путевых точек содержит
     * путевую точку
     * для указанного местоположения.
     **/
    public boolean isLocationClosed(Location loc) {
        return closedWaypoints.containsKey(loc);
    }
}
