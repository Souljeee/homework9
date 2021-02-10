import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] a = new String[4][4];

        for (int i = 0; i < a.length; i++) {
            Arrays.fill(a[i], "5");
        }
        //a[2][1] = "Exception";

        try {
            arraySizeCheck(a);
        }catch (MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();
        }
    }
    public static void arraySizeCheck(String[][] a) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (a.length != 4 || a[0].length != 4){
            throw new MyArraySizeException("Array size is incorrect");
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++){
                try {
                    sum += Integer.parseInt(a[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Ошибка в ячейке с адресом "+ i + " " + j);
                }
            }
        }
        System.out.println("Сумма элементов массива: "+sum);
    }
}
