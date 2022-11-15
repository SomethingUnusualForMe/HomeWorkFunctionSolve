package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Calc
{
    private final double _min_X = 0.0;
    private final double _max_X = 3.0;
    private final double _stepIncrement = 0.004;

    private double _a = 0.0;
    private double _b = 0.0;

    private double[][] _CalcArray = new double[0][3];    //step, y, x

    public Calc(double a, double b)
    {
        _a = a;
        _b = b;
    }

    /*
        3. У головному класі описати метод, що обчислює значення функції, яка задана у таблиці і у тестовому класі - тестові
        методи для нього. Діяти у такій послідовності: спочатку створити один тестовий метод, згенерувати метод обчислення
        функції. Виконати тестування та пересвідчитись, що тест працює, тобто тестування згенерованого метода повинно
        завершитися «помилкою». Реалізувати метод. Виконати тестування. Пересвідчившись, що тест проходить, створити ще
        декілька тестових методів для метода обчислення функції. Виконати тестування.
     */
    private double calcFunctionFor(double x)
    {
        double y = 0.0;
        if (x <= 0.7)
            y = 1.0;
        else if (x > 1.4)
            y = Math.exp(_a*x)*Math.cos(_b*x);
        else
            y = _a*Math.pow(x, 2)*Math.log(x);

        return y;
    }

    /*
        4. Розробити метод, що за вказаними значеннями кроку, початку та кінця інтервалу обчислює кількість кроків для
        табулювання
    */
    public int calcSteps()
    {
        int maxSteps = (int) ((_max_X - _min_X) / _stepIncrement);
        return maxSteps;
    }

    /*
        5. Створити методи, що створюють масиви значень функції (y) та її аргументу (x) в усіх точках вказаного інтервалу із
        заданим кроком. (розмір масивів обчислити програмно за допомогою метода з п.4). Створити тестові методи для них і
        виконати тестування (порядок дій – см п.3)
     */
    public double[][] calculateArray()
    {
        int maxSteps = calcSteps();
        _CalcArray   = new double[maxSteps][3];
        double x = _min_X;
        for (int step = 0; step < maxSteps; step++)
        {
            double y = calcFunctionFor(x);
            _CalcArray[step][0] = step;
            _CalcArray[step][1] = y;
            _CalcArray[step][2] = x;
            x+=_stepIncrement;
        }
        return _CalcArray;
    }

    /*
        6. Створити методи, які після формування масивів, знаходять номери найбільшого та найменшого елементів масиву
        значень функції, та методи, що обчислюють та суму та середнє арифметичне елементів масиву значень функції. Методи
        створювати разом з тестами та постійно виконувати тестування.
     */

    private double[][] sortArray()
    {
        double[][] tempArray = Arrays.copyOf(_CalcArray, _CalcArray.length);

        Arrays.sort(tempArray, Comparator.comparing(y -> y[1]));
        return tempArray;
    }

    public int getIdxOfHighestY()
    {
        double[][] sortedArray = sortArray();
        int idx = (int) sortedArray[sortedArray.length-1][0];
        return idx;
    }

    public int getIdxOfLowestY()
    {
        double[][] sortedArray = sortArray();
        int idx = (int) sortedArray[0][0];
        return idx;
    }

    public void printInfoAll()
    {
        System.out.println("=========================================");
        System.out.println("All elements in array: ");
        for (double[] element : _CalcArray)
            System.out.println(getInfoOf(element));
        System.out.println("=========================================");
    }

    public String getInfoOf(int idx)
    {
        if (idx >= _CalcArray.length)
            return "Idx not found!";

        return getInfoOf(_CalcArray[idx]);
    }

    public String getInfoOf(double[] element)
    {
        return "# in array: " + (int)(element[0]+1) + ", Y="+ element[1]+" X="+element[2];
    }

}
