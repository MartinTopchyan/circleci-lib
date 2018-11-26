package edu.cognaize.circleci;

import java.lang.reflect.Field;
import java.util.Map;

public class Main {
  private static String  AWS_ACCESS_KEY_ID_KEY = "AWS_ACCESS_KEY_ID";
  private static String  AWS_SECRET_ACCESS_KEY_KEY = "AWS_SECRET_ACCESS_KEY";
  private static String  AWS_ACCESS_KEY_ID_VALUE = "AKIAJYOCIKDEKPMIAAGA";
  private static String  AWS_SECRET_ACCESS_KEY_VALUE = "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";

  public static void main(String[] args) {
    setEnvironmentVariable(AWS_ACCESS_KEY_ID_KEY, AWS_ACCESS_KEY_ID_VALUE);
    setEnvironmentVariable(AWS_SECRET_ACCESS_KEY_KEY, AWS_SECRET_ACCESS_KEY_VALUE);
    System.getenv();

  }
  private static void setEnvironmentVariable(String name, String value) {
    try {
      Map<String, String> env = System.getenv();
      Class<?> cl = env.getClass();
      Field field = cl.getDeclaredField("m");
      field.setAccessible(true);
      Map<String, String> writableEnv = (Map<String, String>) field.get(env);
      writableEnv.put(name, value);
    } catch (Exception e) {
      throw new IllegalStateException("Failed to set environment variable", e);
    }
  }
}
