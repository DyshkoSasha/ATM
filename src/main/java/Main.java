import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> ATMCash = new TreeMap<>(Collections.reverseOrder());
        ATMCash.put(50, 5);
        ATMCash.put(10, 5);
        ATMCash.put(100, 5);

        int myCash = 320;

        while (true) {
            System.out.println("Здравствуйте введите операцию которую хотите выполнить");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String operation = reader.readLine().toLowerCase(Locale.ROOT);

            switch (operation) {
                case "снять" -> myCash = GetMoney.getMoney(ATMCash, myCash);
                case "пополнить" -> myCash = PutMoney.putMoney(ATMCash, myCash);
                case "баланс" -> System.out.println(myCash + "рублей!");
                case "банкомат" ->
                        System.out.println("максимальная сумма для снятия " + getSumCash(ATMCash) + " рублей! Купюры: " + ATMCash);
                case "выйти" -> System.exit(0);
                default -> System.out.println("нет такой операции!!!!!!!!!!");
            }
        }
    }

    public static int getSumCash(Map<Integer, Integer> myCash) {
        int sumCash = 0;

        for (Map.Entry<Integer, Integer> pair : myCash.entrySet()) {
            sumCash += pair.getValue() * pair.getKey();
        }
        return sumCash;
    }
}
