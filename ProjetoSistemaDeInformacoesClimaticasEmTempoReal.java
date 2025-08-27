import org.json.JSONObject;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProjetoSistemaDeInformacoesClimaticasEmTempoReal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome da cidade: ");
        String cidade = sc.nextLine();

        try {
            String dadosClimaticos = getDadosClimaticos(cidade);

            // Código 1006 significa localização não encontrada.
            if (dadosClimaticos.contains("\"code\":1006")) {
                System.out.println("Localização não encontrada. Por favor, tente novamente.");
            } else {
                imprimirDadosClimaticos(dadosClimaticos);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }

    public static String getDadosClimaticos(String cidade) throws Exception {
        String apiKey = Files.readString(Paths.get("api-key.txt")).trim();

        String formataNomeCidade = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + formataNomeCidade;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static void imprimirDadosClimaticos(String dados) {
        JSONObject dadosJson = new JSONObject(dados);

        // Localização
        String cidade = dadosJson.getJSONObject("location").getString("name");
        String pais = dadosJson.getJSONObject("location").getString("country");
        String dataHoraString = dadosJson.getJSONObject("location").getString("localtime");

        // Informações meteorológicas
        JSONObject informacoesMeteorologicas = dadosJson.getJSONObject("current");

        String condicaoTempo = informacoesMeteorologicas.getJSONObject("condition").getString("text");
        int umidade = informacoesMeteorologicas.getInt("humidity");
        double velocidadeVento = informacoesMeteorologicas.getDouble("wind_kph");
        double pressaoAtmosferica = informacoesMeteorologicas.getDouble("pressure_mb");
        double sensacaoTermica = informacoesMeteorologicas.getDouble("feelslike_c");
        double temperaturaAtual = informacoesMeteorologicas.getDouble("temp_c");

        // Imprime as informações
        System.out.println("Informações Meteorológicas para " + cidade + ", " + pais);
        System.out.println("Data e Hora Local: " + dataHoraString);
        System.out.println("Temperatura Atual: " + temperaturaAtual + "ºC");
        System.out.println("Sensação Térmica: " + sensacaoTermica + "ºC");
        System.out.println("Condição do Tempo: " + condicaoTempo);
        System.out.println("Umidade: " + umidade + "%");
        System.out.println("Velocidade do Vento: " + velocidadeVento + " km/h");
        System.out.println("Pressão Atmosférica: " + pressaoAtmosferica + " mb");
    }
}
