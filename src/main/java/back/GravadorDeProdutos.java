package back;

import java.io.*;
import java.util.*;
public class GravadorDeProdutos {

    public Map<Integer,Product> leProdutos() throws IOException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("produtos.txt"));
            return (Map<Integer,Product>) in.readObject(); 
        } catch (FileNotFoundException e) {
            throw new IOException("");
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw new IOException("", e);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public void gravaProdutos(Map<Integer, Product> produtos) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("produtos.txt"));
            out.writeObject(produtos);
        } catch (FileNotFoundException e) {
            throw new IOException("");
        } catch (IOException e) {
            throw e;
        } finally {
            if(out != null) {
                out.close();
            }
        }
    }

    //############################################

    public List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException {
        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();

        try{
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto = null;

            do{
                texto = leitor.readLine();
                if(texto != null) {
                    textoLido.add(texto);
                }

            } while (texto != null);

        } finally {
            if (leitor != null) {
                leitor.close();

            }
        }
        return textoLido;

    }

    public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo) throws IOException{
        BufferedWriter gravador = null;

        try{
           gravador = new BufferedWriter(new FileWriter(nomeArquivo));
           for(String s: texto) {
               gravador.write(s + "\n");

           }
        } finally {
            if (gravador != null) {
                gravador.close();
            }
        }
    }

}
