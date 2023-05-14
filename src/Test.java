import java.util.Scanner;// Для теста 12.05.2023
public class Test {
    public static void main(String[] args) throws RuntimeException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числа римские или арабские от 1 до 10 в формате:\nчисло1 пробел оперант пробел число2: ");
        String str1 = scanner.nextLine();
        String[] strings = str1.split(" ");
        int size = strings.length;

        if (size==1|size==2){
            throw new ArithmeticException("Строка не является математической операцией!");
        }
        if (size>3){
            throw new ArithmeticException("В операции должно быть два операнда и один оператор (+, -, /, *)");
        }
        String arab1 = strings[0];
        String arab2 = strings[2];
        String proverka = (strings[2]+strings[0]);

        if (proverka.matches("(([a-zA-Z].*[0-9])|([0-9].*[a-zA-Z]))")){
            throw new ArithmeticException("Используются одновременно разные системы счисления");
        }
        if (proverka.matches("^[0-9]*$")) {
            int ar1=Integer.parseInt(arab1);
            int ar2=Integer.parseInt(arab2);
            if (ar1>10 ||ar2>10) {
                throw new ArithmeticException("Введённое число больше допустимого!!!\nДиапазон чисел от 1 до 10");
            }

           if (strings[1].hashCode() == 42) System.out.println(ar1 * ar2);
           if (strings[1].hashCode() == 47) System.out.println(ar1 / ar2);
           if (strings[1].hashCode() == 43) System.out.println(ar1 + ar2);
           if (strings[1].hashCode() == 45) System.out.println(ar1 - ar2);
           System.exit(0);
            }
        String a = strings[0];
        String b = strings[2];
            Roma perevod1 = Roma.valueOf(a);
            Roma perevod2 = Roma.valueOf(b);
            int num1=perevod1.getTranslation();
            int num2=perevod2.getTranslation();
            int hesh=strings[1].hashCode();
            int otvet;
          if  (num1<=10 && num2<=10 && hesh == 42) {
              otvet = num1 * num2;
              Roma[] romas = Roma.values();
              Roma found = null;
              for (Roma roma : romas) {
                  if (roma.getTranslation() == otvet) {
                      found = roma;
                  }
              }
              System.out.println(found);
              System.exit(0);
          }
          else if (num1 <= 10 && num2<= 10 && hesh == 43) {
                  otvet = num1 + num2;
              Roma[] romas = Roma.values();
              Roma found = null;
              for (Roma roma : romas) {
                  if (roma.getTranslation() == otvet) {
                      found = roma;
                  }
              }
              System.out.println(found);
              System.exit(0);
          }
          else if (num1<=10 && num2<=10 && hesh==45) {
               if (num1 < num2){
                   throw new ArithmeticException("В римскиих числах нет отрицательного знака!");
               }
                      otvet = num1 - num2;
              if (otvet==0){
                  throw new ArithmeticException("В римских цифрах нет нулевого значения!");
              }
              Roma[] romas = Roma.values();
              Roma found = null;
              for (Roma roma : romas) {
                  if (roma.getTranslation() == otvet) {
                      found = roma;
                  }
              }
              System.out.println(found);
              System.exit(0);
          }
          else if (num1 <= 10 && num2 <= 10 && hesh == 47) {
              otvet = num1 / num2;
              Roma[] romas = Roma.values();
              Roma found = null;
              for (Roma roma : romas) {
                  if (roma.getTranslation() == otvet) {
                      found = roma;
                  }
              }
              if (otvet<1){
                  throw new ArithmeticException("В римских цифрах нет нулевого значения!");
              }
              System.out.println(found);
              System.exit(0);
          }
          else if ((num1 > 10 | num2 > 10)) {
              throw new ArithmeticException("Введённое число больше допустимого!!!\nДиапазон чисел от 1 до 10");
          }
    }
}