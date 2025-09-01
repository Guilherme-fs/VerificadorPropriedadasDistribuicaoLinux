package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DistroController {
    public String so(){
        return System.getProperty("os.name");
    }

    public void exibeDistro(){
        if (so().toLowerCase().contains("linux")) {
            try {
                ProcessBuilder builder = new ProcessBuilder("cat", "/etc/os-release");
                Process processo = builder.start();
                BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));

                String linha;
                while ((linha = leitor.readLine()) != null) {
                        if (linha.contains("VERSION=") || linha.contains("NAME=")) {
                        System.out.println(linha);
                    }
                }
                leitor.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else{
            System.out.println("Não é um sistema operacional Linux");
        }
    }

}
