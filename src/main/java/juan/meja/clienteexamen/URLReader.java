/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juan.meja.clienteexamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 2108616
 */
public class URLReader extends Thread {

    public final static int NUMBER_OF_THREADS = 20;
    public final static String heroku = "https://arem-parcial2.herokuapp.com/";
    
    public static void main(String[] args){
        for(int i = 0; i<NUMBER_OF_THREADS; i++){
            Thread h = new URLReader();
            h.start();
        }
    }
    
    @Override
    public void run() {
        try {
            resultados("hello");

            resultados("");

            resultados("db");
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void resultados (String args) throws Exception {
        URL cuadrado = new URL(heroku+args);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(cuadrado.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
