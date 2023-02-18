package ru.vsu.cs.rode;

// Task - 1; exercise - 12

public class Main {
    public static void main(String[] args){
        DataTable table = new DataTable();
        table.addTable();
        /*
        table.cell(0,0).setValue(1);
        table.cell(1,1).setValue(1);
        table.cell(2,2).setValue(1);
        table.cell(3,3).setValue(1);
        table.cell(4,4).setValue(1).printTable();

        table.cell(0,0).getValue();

        table.addColumn().cell(5,2).setValue(1).addRow().cell(2, 5).setValue(1).printTable();
        System.out.println();

        table.renameCol("mark").cell("mark", 5).setValue(1).printTable();
         */

        table.cell(3).renameCol("column_name");
        table.cell("column_name", 3).setValue(1).printTable();

        System.out.println();

        int value = table.row(3).cell("column_name").returnValue();
        table.cell("column_name", 3).setValue(value + 1).printTable();

        System.out.println();

        table.cell(3, "column_name").setValue(value + 2).printTable();
        System.out.println();

        table.addColumn().addColumn().delRow().delRow().delRow().printTable();


    }
}
