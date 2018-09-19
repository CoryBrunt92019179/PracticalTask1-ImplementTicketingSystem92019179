/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*Cory
 */
package ticketingSystem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Ticketingsystem {

    public static Queue<Integer> Queue = new LinkedList();
// here are the different functions for the project.

    public static void noCustomers() {
        System.out.println("There are no customers to see.");
    }
// this adds tickets and shows who will be seen next

    public static void ticketAdded() {
        System.out.println("Customer with ticket " + Queue.peek() + " will be seen.");
        Queue.poll();
    }
// this adds a customer to the queue.

    public static void addCustomer() {
        Queue.add(1);
        System.out.println("The customer with ticket number " + Queue.peek() + " is added to the queue.");

    }
// this shows who has been added to the queue 

    public static void extraTicket() {

        int Tickets = Queue.size() + Queue.peek();
        Queue.add(Tickets);
        System.out.println("The customer with ticket number " + Tickets + " is added to the queue.");

    }
// this shows in console who is left in the queue.

    public static void nextCustomer() {
        System.out.println("The customers with the following tickets are in the queue:" + Queue);

    }

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new SalesAssisstantTask(), 0, 5000); //run code in the SalesAssistantTask run() method every 5 seconds
        timer.schedule(new NewTicketTask(), 0, 3000); //run code in the NewTicketTask run() method every 3 seconds
    }
// this is the main if statement that runs the functions and repets every 5 secs.

    public static class SalesAssisstantTask extends TimerTask { //inner class

        @Override
        public void run() {

            System.out.println("Sales Assistant is ready to see the next customer.");

            if (Queue.isEmpty()) {
                noCustomers();
            } else {
                ticketAdded();
                nextCustomer();
            }
        }
    }
// this is the main if statement that runs the functions and repets every 3 secs.

    public static class NewTicketTask extends TimerTask { //inner class

        @Override
        public void run() {
            if (Queue.isEmpty()) {
                addCustomer();
            } else {
                extraTicket();
            }

        }
    }
}
