//Напишите код программы получение АПИ котировок с биржы бинанс
package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BinanceAPI {
    public static void main(String[] args) {
        //выбор катировки
        String symbol = "ETHUSDT";

        try {
            String apiUrl = "https://api.binance.com/api/v3/ticker/price?symbol=" + symbol;

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    System.out.println("Ответ от Binance API: " + responseData);
                } else {
                    System.out.println("Не удалось получить котировки. Код ошибки: " + response.code());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}