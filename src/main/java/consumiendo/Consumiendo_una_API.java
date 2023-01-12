package consumiendo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Consumiendo_una_API {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
            try {
        
            //solicitar una peticion
            //https://pokeapi.co/api/v2/pokemon/ditto
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/ditto");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            //Si la peticion a sido correcta
            int responseCode = conn.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException("Ocurrió un error: "+ responseCode);
            }else {
                //Abrir un scanner que lea el flujo de datos
                 StringBuilder informationString = new StringBuilder();
                 Scanner scanner = new Scanner(url.openStream());

                 while(scanner.hasNext()){
                    informationString.append(scanner.nextLine());
                 }
                 
                 scanner.close();
            
                //pintar la informacion obtenida por consola
                System.out.print(informationString);
            }
            } catch(Exception e){
                e.printStackTrace();
            }
            }
            
    }

