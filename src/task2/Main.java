package task2;

public class Main {

    public static void main(String[] args) {
        try {
            String[][] arr = parse("10 3 1 2\n2 3 ю 2\n5 6 7 1\n300 3 1 0");
            int sum = sum(arr);
            System.out.println(sum);
        } catch (BadSizeException e) {
            System.out.println("Неверный размер входных данных");
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат входных данных");
        }
    }
    public static String[][] parse(String string) throws BadSizeException {
        String[] parsed = string.split("\n");
        if(parsed.length != 4){
            throw new BadSizeException();
        }

        String[][] result = new String[parsed.length][];
        for(int i = 0; i < parsed.length; i++){
            String[] s = parsed[i].split(" ");
            if(s.length != 4){
                throw new BadSizeException();
            }
            result[i] = s;
        }
        return result;
    }

    public static int sum(String[][] arr){
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                int number = Integer.parseInt(arr[i][j]);
                result += number;
            }
        }
        result /= 2;
        return result;
    }
}
class BadSizeException extends Exception{

}
