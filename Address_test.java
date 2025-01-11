//********************************************************************
//  Address_test.java       Author: Tien Nghiem
//
//  Date: 12/12/24
//  Tests the address class.
//********************************************************************
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.*;
import java.util.*;

public class Address_test {
    public static void main(String[] args) {

        Address home = new Address("456 Elm st", "Naperville", "IL", 60565);
        Address home1 = new Address("23 Maple st", "Naperville", "IL", 60565);
        Address home2 = new Address("12 Grace st", "Naperville", "IL", 60565);
        Address home3 = new Address("4 Stewert st", "Naperville", "IL", 60565);
        Address home4 = new Address("1874 Allen st", "Naperville", "IL", 60565);
        Address home5 = new Address("4500 Wilson st", "Naperville", "IL", 60565);
        Address home6 = new Address("62 Allen st", "Naperville", "IL", 60565);
        Address home7 = new Address("1111 Elm st", "Naperville", "IL", 60565);
        Address home8 = new Address("8 Grace st", "Naperville", "IL", 60565);
        Address home9 = new Address("005 St. Charles st", "Naperville", "IL", 60565);

        Address[] myAddresses = {home, home1, home2, home3, home4, home5, home6, home7, home8, home9};
        System.out.println("Unsorted addresses:");
        for (Address a : myAddresses) {
            System.out.println(a);
        }
        System.out.println();
        Sorts.insertionSort(myAddresses);

        System.out.println("Sorted addresses:");
        for (Address a : myAddresses) {
            System.out.println(a);
        }

        System.out.println();
        System.out.println("Comparing home to home1:");
        System.out.println(home.compareTo(home1));//neg value

        System.out.println("Comparing home1 to home:");
        System.out.println(home1.compareTo(home));//pos value

    }
}