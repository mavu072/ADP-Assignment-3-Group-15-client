package za.ac.cput.ADP3LabBookingSystem.View;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;

import java.io.IOException;

public class App {

    private static OkHttpClient client = new OkHttpClient();

    private static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().toString();
        }
    }

    public static void getAll() {
        final String URL = "http://localhost:8090/computerlab/getall";
        try {
            String responseBody = run(URL);
            JSONArray computerLabs = new JSONArray(responseBody);

            for (int i = 0; i < computerLabs.length(); i++) {
                JSONObject computerLab = computerLabs.getJSONObject(i);

                Gson g = new Gson();
                ComputerLab c =g.fromJson(computerLab.toString(), ComputerLab.class);
                System.out.println(c.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getAll();
    }
}
