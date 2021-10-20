package za.ac.cput.ADP3LabBookingSystem.View;

import com.google.gson.Gson;
import okhttp3.*;

import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;

import java.io.IOException;

public class App {

    private static OkHttpClient createAuthenticatedClient(final String username, final String password) {

        // create client with authentication info
        OkHttpClient httpClient = new OkHttpClient.Builder().authenticator(new Authenticator() {

            public Request authenticate(Route route, Response response) throws IOException {
                String credential = Credentials.basic(username, password);
                return response
                        .request()
                        .newBuilder()
                        .header("Authorization", credential)
                        .build();
            }
        }).build();

        return httpClient;
    }

    private static OkHttpClient client = createAuthenticatedClient("admin", "admin1234");

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
            System.out.println(responseBody);
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
