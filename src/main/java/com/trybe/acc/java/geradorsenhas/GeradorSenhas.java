package com.trybe.acc.java.geradorsenhas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GeradorSenhas {
  public static final Integer NUM_SENHAS = 10;

  // diretório para os arquivos criados
  public static final String DIRETORIO_DESTINO = "/";

  /** Método principal. */
  public static void main(String[] args) {
    GeradorSenhas gerador = new GeradorSenhas();

    for (int i = 0; i < NUM_SENHAS; i++) {

      File arquivo = new File(DIRETORIO_DESTINO + File.separator + "arquivo_" + i + ".txt");
      String senha = gerador.gerarSenhaCompleta(i);

      try {
        gerador.escreverSenhaNoArquivo(senha, arquivo);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /** Recebe uma senha e a escreve em arquivo. */
  public void escreverSenhaNoArquivo(String senha, File arquivo) throws IOException {
    FileWriter escritor = null;
    BufferedWriter bufferedEscritor = null;

    try {
      escritor = new FileWriter(arquivo);
      bufferedEscritor = new BufferedWriter(escritor); // Objeto com o conteudo escrito em um buffer
      bufferedEscritor.write(senha); // Insere o contéudo que será escrito ao buffer
      bufferedEscritor.flush(); // Obtem o conteudo do buffer e escreve no arquivo

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      this.fecharObjetos(escritor, bufferedEscritor);
    }
  }

  /** Gera senha completa a partir do índice. */
  public String gerarSenhaCompleta(int indice) {

    ArrayList<String> password = new ArrayList<String>();

    password.add("A5$2");
    password.add("B55S");
    password.add("CFFG");
    password.add("D&54");
    password.add("EEDF");
    password.add("FEGG");
    password.add("G15E");
    password.add("H123");
    password.add("I81F");
    password.add("JWEF");
    password.add("####");

    return password.get(indice) + password.get(indice + 1);
  }

  private void fecharObjetos(FileWriter escritorArquivo, BufferedWriter bufferedEscritor) {
    try {
      escritorArquivo.close();
      bufferedEscritor.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
