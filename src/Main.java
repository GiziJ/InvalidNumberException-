import java.util.Scanner;
// 10 ციფრის დაწერა და კალკულაცია.
public class Main {
    public static void main(String[] args) {
        try {
            int[] numbers = readNumbers();
            int sum = calculateSum(numbers);
            System.out.println("ციფრების ჯამი არის: " + sum);
        } catch (InvalidNumberException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: ფორმატი არასწორია.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
//მომხმარებელს აწერინებს 10 მთელ ციფრს და აბრუნებს მასივად
//აგდებს თუ უარყოფითი ციფრი ჩაწერეს და თუ ფორმატი არ იყო სწორი.
    private static int[] readNumbers() throws InvalidNumberException, NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        for (int i = 0; i < 10; i++) {
            try {
                System.out.print("შემოიტანე ციფრი " + (i + 1) + ": ");
                int number = Integer.parseInt(scanner.nextLine());

                if (number < 0) {
                    throw new InvalidNumberException("ციფრი უარყოფითია.");
                }

                numbers[i] = number;
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }

        return numbers;
    }
// აბრუნებს მასივის ჯამს და თუ ზედმეტად დიდია პასუხი ამბობს რომ მასივი ზედმეტად დიდია.
    private static int calculateSum(int[] numbers) throws ArithmeticException {
        int sum = 0;

        for (int number : numbers) {
            try {
                sum = Math.addExact(sum, number);
            } catch (ArithmeticException e) {
                throw new ArithmeticException("ჯამი ზედმეტად დიდია.");
            }
        }

        return sum;
    }
}
