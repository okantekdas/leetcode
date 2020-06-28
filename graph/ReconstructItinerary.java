package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* https://leetcode.com/problems/reconstruct-itinerary/ */
public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {

        // constuct graph

        HashMap<String, List<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            List<String> destinations = graph.get(from);
            if (destinations == null) {
                destinations = new ArrayList<>();
                graph.put(from, destinations);
            }
            destinations.add(to);

        }

        for (List<String> curr : graph.values()) {
            Collections.sort(curr);
        }

        List<String> itinerary = new ArrayList<>();
        visitGraph(graph, "JFK", itinerary, tickets.size() + 1);

        return itinerary;

    }

    public boolean visitGraph(HashMap<String, List<String>> graph, String from, List<String> itinerary, int dstCount) {
        itinerary.add(from);
        if (itinerary.size() == dstCount) {
            return true;
        }

        if (graph.get(itinerary.get(itinerary.size() - 1)) == null
                || graph.get(itinerary.get(itinerary.size() - 1)).isEmpty()) {
            return false;
        }

        List<String> destinations = graph.get(from);

        for (int i = 0; i < destinations.size(); i++) {
            String to = destinations.get(i);
            destinations.remove(i);
            if (visitGraph(graph, to, itinerary, dstCount)) {
                return true;
            }
            itinerary.remove(itinerary.size() - 1);
            destinations.add(i, to);
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        // List<String> ticket1 = new ArrayList<>();
        // ticket1.add("JFK");
        // ticket1.add("SFO");
        // List<String> ticket2 = new ArrayList<>();
        // ticket2.add("JFK");
        // ticket2.add("ATL");
        // List<String> ticket3 = new ArrayList<>();
        // ticket3.add("SFO");
        // ticket3.add("ATL");
        // List<String> ticket4 = new ArrayList<>();
        // ticket4.add("ATL");
        // ticket4.add("JFK");
        // List<String> ticket5 = new ArrayList<>();
        // ticket5.add("ATL");
        // ticket5.add("SFO");

        // List<String> ticket1 = new ArrayList<>();
        // ticket1.add("MUC");
        // ticket1.add("LHR");
        // List<String> ticket2 = new ArrayList<>();
        // ticket2.add("JFK");
        // ticket2.add("MUC");
        // List<String> ticket3 = new ArrayList<>();
        // ticket3.add("SFO");
        // ticket3.add("SJC");
        // List<String> ticket4 = new ArrayList<>();
        // ticket4.add("LHR");
        // ticket4.add("SFO");

        // List<String> ticket1 = new ArrayList<>();
        // ticket1.add("JFK");
        // ticket1.add("KUL");
        // List<String> ticket2 = new ArrayList<>();
        // ticket2.add("JFK");
        // ticket2.add("NRT");
        // List<String> ticket3 = new ArrayList<>();
        // ticket3.add("NRT");
        // ticket3.add("JFK");

        List<String> ticket1 = new ArrayList<>();
        ticket1.add("EZE");
        ticket1.add("TIA");
        List<String> ticket2 = new ArrayList<>();
        ticket2.add("EZE");
        ticket2.add("HBA");
        List<String> ticket3 = new ArrayList<>();
        ticket3.add("AXA");
        ticket3.add("TIA");
        List<String> ticket4 = new ArrayList<>();
        ticket4.add("JFK");
        ticket4.add("AXA");
        List<String> ticket5 = new ArrayList<>();
        ticket5.add("ANU");
        ticket5.add("JFK");
        List<String> ticket6 = new ArrayList<>();
        ticket6.add("ADL");
        ticket6.add("ANU");
        List<String> ticket7 = new ArrayList<>();
        ticket7.add("TIA");
        ticket7.add("AUA");
        List<String> ticket8 = new ArrayList<>();
        ticket8.add("ANU");
        ticket8.add("AUA");
        List<String> ticket9 = new ArrayList<>();
        ticket9.add("ADL");
        ticket9.add("EZE");
        List<String> ticket10 = new ArrayList<>();
        ticket10.add("ADL");
        ticket10.add("EZE");
        List<String> ticket11 = new ArrayList<>();
        ticket11.add("EZE");
        ticket11.add("ADL");
        List<String> ticket12 = new ArrayList<>();
        ticket12.add("AXA");
        ticket12.add("EZE");

        List<String> ticket13 = new ArrayList<>();
        ticket13.add("AUA");
        ticket13.add("AXA");
        List<String> ticket14 = new ArrayList<>();
        ticket14.add("JFK");
        ticket14.add("AXA");
        List<String> ticket15 = new ArrayList<>();
        ticket15.add("AXA");
        ticket15.add("AUA");
        List<String> ticket16 = new ArrayList<>();
        ticket16.add("AUA");
        ticket16.add("ADL");
        List<String> ticket17 = new ArrayList<>();
        ticket17.add("ANU");
        ticket17.add("EZE");
        List<String> ticket18 = new ArrayList<>();
        ticket18.add("TIA");
        ticket18.add("ADL");

        List<String> ticket19 = new ArrayList<>();
        ticket19.add("EZE");
        ticket19.add("ANU");
        List<String> ticket20 = new ArrayList<>();
        ticket20.add("AUA");
        ticket20.add("ANU");

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);
        tickets.add(ticket11);
        tickets.add(ticket12);
        tickets.add(ticket13);
        tickets.add(ticket14);
        tickets.add(ticket15);
        tickets.add(ticket16);
        tickets.add(ticket17);
        tickets.add(ticket18);
        tickets.add(ticket19);
        tickets.add(ticket20);

        List<String> itinerary = new ReconstructItinerary().findItinerary(tickets);
        System.out.println(Arrays.deepToString(itinerary.toArray()));

    }

}