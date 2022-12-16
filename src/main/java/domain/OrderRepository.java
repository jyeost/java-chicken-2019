package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static List<Order> orders() {
        return Collections.unmodifiableList(orders);
    }

    public static boolean isOrderedTable(Table table) {
        for (Order order : orders){
            if(order.having(table)) return true;
        }
        return false;
    }

    /*public static boolean isOrderedTable(Table table) {
        return orders.contains(table);
    }*/

    public static void add(Order order) {
        orders.add(order);
    }

    public static Order getOrder(Table table) {
        for (Order order : orders){
            if(order.having(table)) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }
}
