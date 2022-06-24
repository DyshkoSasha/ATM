import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class GetMoney {
    public static int getMoney(Map<Integer, Integer> ATMCash, int myCash) throws IOException {

        System.out.println("Введите сумму которую хотите снять");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(reader.readLine());

        if (myCash < sum) {
            throw new SumException("Извините, на счете недостаточно средств");
        } else {
            int result = sum;

            for (Map.Entry<Integer, Integer> pair : ATMCash.entrySet()) {

                while (result > 0) {

                    if (pair.getValue() == 0) {
                        throw new SumException("В банкомате недостаточно купюр номиналом " + pair.getKey()
                                + "!!! для проведения данной операции! Попробуйте округлить сумму");
                    }

                    if (pair.getKey() > result) {
                        break;
                    } else {
                        result -= pair.getKey();
                        myCash -= pair.getKey();
                        ATMCash.put(pair.getKey(), pair.getValue() - 1);
                    }
                }
            }
        }

        System.out.println("Операция проведена успешно! Ваш остаток " + myCash);
        System.out.println("Максимальная сумма для снятия " + Main.getSumCash(ATMCash) + "! купюры : " + ATMCash);
        return myCash;
    }
}
