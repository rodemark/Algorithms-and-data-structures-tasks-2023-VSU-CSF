package ru.vsu.cs.rode;

// command + N

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args){

        int[][] table = new int[5][5];
        table[4][4] = 1;
        table[0][0] = 1;
        printArray(table);

        System.out.println();
        renameCol("mark",1);

    }

    public static void printArray(int[][] table){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void renameCol(String name, int col){
        Map<String, Integer> nameColumn = new HashMap<>();
        nameColumn.put(name, col);

        System.out.println(nameColumn.get(name));
    }


    public static void addColumn(int[][] table){
        int[][] newTable = new int[table.length][table[0].length + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                newTable[i][j] = table[i][j];
            }
        }
        table = newTable;
    }

}
