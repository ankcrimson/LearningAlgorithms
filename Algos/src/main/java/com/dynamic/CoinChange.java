package com.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

  static Map<String, Long> lookups = new HashMap<>();

  public static long solve(int n, int[] s, int i) {
    String key = n + "," + i;
    if (lookups.containsKey(key))
      return lookups.get(key);
    if (n == 0)
      return 1;
    if (n < 0)
      return 0;
    if (i == s.length)
      return 0;
    long ans = solve(n - s[i], s, i) + solve(n, s, i + 1);
    lookups.put(key, ans);
    return ans;
  }

  public static void main(String[] args) {
    try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);) {
      String[] nl = br.readLine().split(" ");
      int amount = Integer.parseInt(nl[0]);
      int l = Integer.parseInt(nl[1]);
      int[] coins = new int[l];
      String[] coinsStrArr = br.readLine().split(" ");

      for (int i = 0; i < l; i++) {
        coins[i] = Integer.parseInt(coinsStrArr[i]);
      }
      System.out.println(solve(amount, coins, 0));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
