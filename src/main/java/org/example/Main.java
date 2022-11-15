package org.example;

public class Main
{
    public static void main(String[] args)
    {
        Calc        calc  = new Calc(-0.5, 2);

        int         steps = calc.calcSteps();         //кількість кроків
        double[][]  array = calc.calculateArray();    //масиви значень функції (y) та її аргументу (x) в усіх точках вказаного інтервалу

        int idxOfHighestY = calc.getIdxOfHighestY();  // номер найбільшого Y в массиві
        int idxOfLowestY  = calc.getIdxOfLowestY();   // номер найменшого Y в массиві

        System.out.println("Highest Y: " + calc.getInfoOf(idxOfHighestY));
        System.out.println("Lowest Y: " + calc.getInfoOf(idxOfLowestY));

        System.out.println("TEST #175: " + calc.getInfoOf(174));
        System.out.println("TEST #350: " + calc.getInfoOf(349));
        System.out.println("TEST #750: " + calc.getInfoOf(749));

        System.out.println();

    }
}