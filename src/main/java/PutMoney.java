import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class PutMoney {
    public static int putMoney(Map<Integer, Integer> ATMCash, int myCash) throws IOException {
        System.out.println("Введите купюру и их колличество(штук) которые хотите пополнить");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String put = reader.readLine();
        String[] splitPut = put.split(" ");
        int count = Integer.parseInt(splitPut[1]);
        int banknotes = Integer.parseInt(splitPut[0]);


        myCash += count * banknotes;
        ATMCash.put(banknotes, ATMCash.get(banknotes) + count);
        System.out.println("Операция проведена успешно! Ваш остаток " + myCash + "рублей! Купюры банкомата: " + ATMCash);
        return myCash;
    }
}
