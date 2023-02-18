package ru.vsu.cs.rode;

import java.util.HashMap;

import static ru.vsu.cs.rode.Test.printArray;

public class DataTable {
    int row;
    int col;
    int[][] table;

    HashMap<String, Integer> nameColumn = new HashMap<>();


    public void addTable(){ // создать массив со стандартными параметрами
        table = new int[5][5];
    }

    public DataTable addTable(int col, int row) { // создать массив с заданными параметрами
        table = new int[row][col];
        return this;
    }

    public DataTable cell(int col, int row){ // столбец - строка
        this.row = row;
        this.col = col;
        return this;
    }

    public DataTable cell(String col, int row){ // столбец именованный - строка
        this.col = nameColumn.get(col);
        this.row = row;
        return this;
    }

    public DataTable cell(int row, String col){ // строка - столбец именованный
        this.col = nameColumn.get(col);
        this.row = row;
        return this;
    }

    public DataTable cell(String col){ // столбец именованный
        this.col = nameColumn.get(col);
        return this;
    }

    public DataTable cell(int col){ // столбец
        this.col = col;
        return this;
    }

    public DataTable row(int row){ // строка
        this.row = row;
        return this;
    }

    public DataTable renameCol(String name){
        nameColumn.put(name, col);
        return this;
    }

    public DataTable setValue(int value){
        table[row][col] = value;
        return this;
    }

    public DataTable getValue(){
        System.out.println(table[row][col]);
        return this;
    }

    public int returnValue(){
        return table[row][col];
    }

    public DataTable addColumn(){
        int[][] newTable = new int[table.length][table[0].length + 1];
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(table[i], 0, newTable[i], 0, table[0].length);
        }
        table = newTable;
        return this;
    }

    public DataTable delColumn(){
        int[][] newTable = new int[table.length][table[0].length - 1];
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(table[i], 0, newTable[i], 0, newTable[0].length);
        }
        table = newTable;
        return this;
    }

    public DataTable addRow(){
        int[][] newTable = new int[table.length + 1][table[0].length];
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(table[i], 0, newTable[i], 0, table[0].length);
        }
        table = newTable;
        return this;
    }

    public DataTable delRow(){
        int[][] newTable = new int[table.length - 1][table[0].length];
        for (int i = 0; i < table.length - 1; i++) {
            System.arraycopy(table[i], 0, newTable[i], 0, table[0].length);
        }
        table = newTable;
        return this;
    }

    public void printTable(){
        printArray(table);
    }
}
