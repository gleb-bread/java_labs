// package lab3;

// public class Waypoint {
// /** Локация этой путевой точки. **/
// Location loc;

// /**
// * Предыдущая путевая точка на этом пути или <code> null </code>, если это
// * начало поиска A*.
// **/
// Waypoint prevWaypoint;

// /**
// * В этом поле хранится общая предыдущая стоимость получения с начала
// * местоположения этой путевой точки через цепочку путевых точек. Это
// * фактическая стоимость следования по пути; он не включает никаких оценок.
// **/
// private float prevCost;

// /**
// * В этом поле хранится оценка оставшейся стоимости поездки из
// * эта путевая точка до конечного пункта назначения.
// **/
// private float remainingCost;

// /**
// * Конструктор для новой путевой точки для указанного местоположения.
// Предыдущая
// * путевая точка
// * можно указать или ссылка может быть <code> null </code> что
// * будет указывать, что путевая точка является началом пути.
// **/
// public Waypoint(Location loc, Waypoint prevWaypoint) {
// this.loc = loc;
// this.prevWaypoint = prevWaypoint;
// }

// /** Возвращает местоположение путевой точки. **/
// public Location getLocation() {
// return loc;
// }

// /**
// * Возвращает предыдущую путевую точку в пути или <code> null </code>, если
// это
// * - начало пути.
// **/
// public Waypoint getPrevious() {
// return prevWaypoint;
// }

// /**
// * Этот мутатор позволяет изменять как предыдущую, так и оставшуюся стоимость.
// * установить за один вызов метода. Обычно эти значения будут равны
// * в любом случае время.
// **/
// public void setCosts(float prevCost, float remainingCost) {
// this.prevCost = prevCost;
// this.remainingCost = remainingCost;
// }

// /**
// * Возвращает фактическую стоимость перехода к этой точке с самого начала.
// * местоположение, через серию путевых точек в этой цепочке.
// **/
// public float getPreviousCost() {
// return prevCost;
// }

// /**
// * Возвращает оценку оставшейся стоимости поездки из этого
// * указать конечный пункт назначения.
// **/
// public float getRemainingCost() {
// return remainingCost;
// }

// /**
// * Возвращает оценку общей стоимости данной путевой точки. Это включает
// * фактическая стоимость проезда к этой точке от места старта плюс
// * оценка оставшейся стоимости поездки от этой точки до
// * пункта назначения.
// **/
// public float getTotalCost() {
// return prevCost + remainingCost;
// }
// }
