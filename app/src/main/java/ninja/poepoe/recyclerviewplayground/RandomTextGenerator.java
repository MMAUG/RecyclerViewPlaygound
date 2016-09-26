package ninja.poepoe.recyclerviewplayground;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by poepoe on 26/9/16.
 */

public class RandomTextGenerator {

  private static final String string =
      "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  private static SecureRandom random = new SecureRandom();

  public static List<String> randomList(int length) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      list.add(randomString(5));
    }
    return list;
  }

  public static String randomString(int len) {
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++)
      sb.append(string.charAt(random.nextInt(string.length())));
    return sb.toString();
  }
}
