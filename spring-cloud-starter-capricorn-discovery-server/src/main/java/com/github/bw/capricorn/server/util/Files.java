package com.github.bw.capricorn.server.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

public final class Files {

  private Files() {
  }

  public static BufferedReader newReader(File file, Charset charset) throws FileNotFoundException {
    return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
  }

  public static String readAsString(File file, Charset charset) throws IOException {
    BufferedReader reader = newReader(file, charset);
    return reader.lines().collect(Collectors.joining("\n"));
  }

  public static String readAsString(String filePath, Charset charset) throws IOException {
    File file = new File(filePath);
    return readAsString(file, charset);
  }
}
