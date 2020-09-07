package leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DisplayTableOfFoodOrdersInRestaurant {

    TreeMap<Integer, TreeMap<String, Integer>> tableToOrder = new TreeMap<>();

    public List<List<String>> displayTable(List<List<String>> orders) {

        List<List<String>> solutions = new ArrayList<>();

        Set<String> foods = new TreeSet<>();
        // foods.add("Table");

        for (List<String> order : orders) {
            foods.add(order.get(2));
            TreeMap<String, Integer> foodToCount = tableToOrder.get(Integer.valueOf(order.get(1)));
            if (foodToCount == null) {
                foodToCount = new TreeMap<>();
            }
            Integer foodCount = foodToCount.get(order.get(2));
            if (foodCount == null) {
                foodCount = 0;
            }
            foodToCount.put(order.get(2), ++foodCount);
            tableToOrder.put(Integer.valueOf(order.get(1)), foodToCount);
        }
        List<String> foodsTemp = new ArrayList<>();
        foodsTemp.add("Table");
        foodsTemp.addAll(foods);

        solutions.add(new ArrayList<>(foodsTemp));

        for (Integer table : tableToOrder.keySet()) {
            ArrayList<String> solution = new ArrayList<>();

            for (String food : foodsTemp) {
                if (food.equals("Table")) {
                    solution.add(String.valueOf(table));
                } else {
                    Integer count = tableToOrder.get(table).get(food);
                    if (count == null) {
                        solution.add("0");
                    } else {
                        solution.add(String.valueOf(count));
                    }
                }
            }
            solutions.add(solution);
        }

        return solutions;
    }

    public static void main(String[] args) {

        List<String> o1 = new ArrayList<>();

        o1.add("David");
        o1.add("3");
        o1.add("Ceviche");
        List<String> o2 = new ArrayList<>();

        o2.add("Corina");
        o2.add("10");
        o2.add("Beef Burrito");
        List<String> o3 = new ArrayList<>();

        o3.add("David");
        o3.add("3");
        o3.add("Fried Chicken");
        List<String> o4 = new ArrayList<>();

        o4.add("Carla");
        o4.add("5");
        o4.add("Water");
        List<String> o5 = new ArrayList<>();

        o5.add("Carla");
        o5.add("5");
        o5.add("Ceviche");
        List<String> o6 = new ArrayList<>();

        o6.add("Rous");
        o6.add("3");
        o6.add("Ceviche");

        List<List<String>> orders = new ArrayList<>();
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        orders.add(o4);
        orders.add(o5);
        orders.add(o6);

        new DisplayTableOfFoodOrdersInRestaurant().displayTable(orders);

    }

}