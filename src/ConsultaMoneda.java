import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscaMoneda(String codigo) {
        URI direccion = URI
                .create("https://v6.exchangerate-api.com/v6/993e03301ff3ef64aa15a8bd/latest/"+codigo);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontre esa moneda"+e);
        }

    };
}
