import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> myCash = new HashMap<>();
        myCash.put(Currency.BYN.name(), 500);
        myCash.put(Currency.RUB.name(), 500);
        myCash.put(Currency.USD.name(), 500);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        String[] splitStrings = str.split(" ");

        if (myCash.containsKey(splitStrings[0])) {
            int cashSum = myCash.get(splitStrings[0]);
            int withdrawSum = Integer.parseInt(splitStrings[1]);

            if (withdrawSum > cashSum) {
                throw new SumException("Извините у Вас недостаточно средств для выполнения данной операции");
            } else {
                myCash.put(splitStrings[0], cashSum - withdrawSum);
            }
        } else {
            throw new SumException("Извините данная валюта отсутствует");
        }

        System.out.println(myCash);
    }
}
