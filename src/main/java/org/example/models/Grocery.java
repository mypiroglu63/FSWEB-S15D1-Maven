package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
   public static ArrayList<String> groceryList = new ArrayList<>();

   public static void main(String[] args) {
      startGrocery();
   }

   public static void startGrocery() {
      Scanner scanner = new Scanner(System.in);
      while (true) {
         System.out.println("Lütfen bir seçenek giriniz: (0: Uygulamayı durdur, 1: Eleman ekle, 2: Eleman çıkar)");
         int choice = scanner.nextInt();
         scanner.nextLine();

         if (choice == 0) {
            System.out.println("Uygulama durduruluyor.");
            break;
         } else if (choice == 1) {
            System.out.println("Eklemek istediğiniz elemanları giriniz (Tek eleman veya virgüllerle ayırarak):");
            String itemsToAdd = scanner.nextLine();
            addItems(itemsToAdd);
         } else if (choice == 2) {
            System.out.println("Çıkarmak istediğiniz elemanları giriniz (Tek eleman veya virgüllerle ayırarak):");
            String itemsToRemove = scanner.nextLine();
            removeItems(itemsToRemove);
         } else {
            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyiniz.");
         }

         printSorted();
      }
      scanner.close();
   }

   public static void addItems(String input) {
      String[] items = input.split(",\\s*");
      for (String item : items) {
         if (!checkItemIsInList(item)) {
            groceryList.add(item);
         }
      }
      Collections.sort(groceryList);
   }

   public static void removeItems(String input) {
      String[] items = input.split(",\\s*");
      for (String item : items) {
         if (checkItemIsInList(item)) {
            groceryList.remove(item);
         }
      }
      Collections.sort(groceryList);
   }

   public static boolean checkItemIsInList(String product) {
      for (String item : groceryList) {
         if (item.equals(product)) {
            return true;
         }
      }
      return false;
   }

   public static void printSorted() {
      Collections.sort(groceryList);
      System.out.println("Güncellenmiş Pazar Listesi: " + groceryList);
   }
}
