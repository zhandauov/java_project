package user_classes;

import ostalnoe.*;
import java.lang.*;
import java.util.*;
public class Executor extends User{

    private Vector<Order> functions = new Vector<Order>();
    private Vector<Order> orders = new Vector<Order>();
    public Executor(Vector<Order> order,String log,String pas,String id,String fn, String ln) {
        super(log,pas,id,fn,ln);
        functions = order;
    }

    public void getOrder(Order order){
        orders.add(order);
    }

    public Vector<Order> getOrders() {
        return orders;
    }

    public void setOrders(Vector<Order> orders) {
        this.orders = orders;
    }

    public void setFunctions(Vector<Order> functions) {
        this.functions = functions;
    }

    public Vector<Order> getFunctions() {
        return functions;
    }
}