package Gio_Challenge.Controlador;
import java.io.*;
import java.text.DecimalFormat;
import okhttp3.*;
import org.json.JSONObject;

public class MonedaBase extends Moneda implements InterfaceMoneda{

    public MonedaBase(String nombre, String simbolo) {
        super(nombre, simbolo);
    }

    @Override
    public double convertirToDestino(Double cantidad, String simboloDestino) throws IOException {
        //Creación instancia OkHttp
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        //creación nueva solicitud HTTP
        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to="+simboloDestino+"&from="+this.getSimbolo()+"&amount="+cantidad)//Establcemos el endpoint
                .addHeader("apikey", "CvlQa4JfWtGIeWUk6VhDZCEpJZhJClOX") //Se Agrega cabecera con el apikey
                .method("GET", null) //Establecemos el metodo htttp de la solicitud
                .build(); // se contruye la solicitud http

        //Se envia la spoicitud y se recibe una respuesta
        Response response = client.newCall(request).execute();

        //Guardamos la respuesta en una cadena de texto
        String responseBody = response.body().string();
        System.out.println(responseBody);

        // analiza la cadena de respuesta como un objeto JSONObject
        JSONObject jsonObject = new JSONObject(responseBody);

        //Patron para formatear el resutltado
        DecimalFormat df = new DecimalFormat("#.##");


        return Double.parseDouble(df.format(jsonObject.getDouble("result")));
    }
}
