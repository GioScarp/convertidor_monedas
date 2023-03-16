package Gio_Challenge.Controladores.ControladorMoneda;
import java.io.*;
import java.util.Objects;

import Gio_Challenge.config.PropertiesFile;
import okhttp3.*;
import org.json.JSONObject;

import javax.swing.*;

public class MonedaBase extends Moneda implements InterfaceMoneda{

    public MonedaBase(String nombre, String simbolo, ImageIcon icono) {
        super(nombre, simbolo, icono);
    }

    @Override
    public double convertirToDestino(Double cantidad, String simboloDestino) throws IOException {
        //Creación instancia OkHttp
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        //Lemos archivo config
        PropertiesFile.readPropertiesFile();

        //creación nueva solicitud HTTP
        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to="+simboloDestino+"&from="+this.getSimbolo()+"&amount="+cantidad)//Establcemos el endpoint
                .addHeader("apikey", PropertiesFile.getApiKey()) //Se Agrega cabecera con el apikey
                .method("GET", null) //Establecemos el metodo htttp de la solicitud
                .build(); // se contruye la solicitud http

        //Se envia la solicitud y se recibe una respuesta
        Response response = client.newCall(request).execute();


        //Guardamos la respuesta en una cadena de texto
        String responseBody = Objects.requireNonNull(response.body()).string();
        //System.out.println(responseBody);

        // analiza la cadena de respuesta como un objeto JSONObject
        JSONObject jsonObject = new JSONObject(responseBody);

        //Patron para formatear el resutltado
        //DecimalFormat df = new DecimalFormat("#.##");

        return jsonObject.getDouble("result");
    }


}
