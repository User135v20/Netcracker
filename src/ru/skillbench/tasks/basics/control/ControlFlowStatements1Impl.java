package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements1Impl implements ControlFlowStatements1{

    public float getFunctionValue(float x){
        if (x > 0){
            return (float)(2*Math.sin(x));
        }else{
            return 6-x;
        }
    }

    public String decodeWeekday(int weekday){
        switch (weekday) {
            case (1):
                return "Monday";
            case (2):
                return "Tuesday";
            case (3):
                return "Wednesday";
            case (4):
                return "Thursday";
            case (5):
                return "Friday";
            case (6):
                return "Saturday";
            case (7):
                return "Sunday";
            default:
                return "error";
    }
}
    public int[][] initArray(){
        int [] [] array = new int[8][5];
        for (int i = 0; i<8; i++){
            for (int j = 0; j<5; j++){
                array[i][j]=i*j;
            }
        }
        return array;
    }

    public int getMinValue(int[][] array){
        int min = 2147483647;//максимальное значение int раз ответ в формате int -- больше этого значения быть не может
        int size1 = array.length;
        int size2 = array[0].length;

        for (int i=0;i<size1;i++){
            for (int j=0;j<size2-1;j++){
                if (array[i][j] < min){
                    min = array[i][j];
                }
            }
        }
      return min;
    }

    public ControlFlowStatements1.BankDeposit calculateBankDeposit(double P){
        BankDeposit B = new BankDeposit();
        B.amount = 1000;
        B.years = 0;
        while (B.amount <= 5000.0){
            B.years = B.years + 1;
            B.amount = B.amount * (1 + P*0.01);
        }
        return B;
    }
}
