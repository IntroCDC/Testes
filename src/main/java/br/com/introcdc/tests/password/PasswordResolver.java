package br.com.introcdc.tests.password;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class PasswordResolver {

    public static String passwordToResolvee = hashSha512("123");
    // 10be32831031cd47283154cb1e6a899eaeacebb42466dc288c7c59ecb8a1b1b1b1dcc7d3702f88094ec4bdf219464d1d6ad1f50f83889ecb7212d2103a6a0bad
    public static long startTime = System.currentTimeMillis();

    static String sToTimeComplete(long totalTime) {
        long years = totalTime / 32140800;
        long months = totalTime % 32140800 / 2678400;
        long days = totalTime % 2678400 / 86400;
        long hours = totalTime % 86400 / 3600;
        long minutes = totalTime % 3600 / 60;
        long seconds = totalTime % 60;
        if (totalTime > 0) {
            String result = "";
            if (years > 0) {
                result += years + " ano" + (years == 1 ? "" : "s");
                if (months > 0 || days > 0 || hours > 0 || minutes > 0) {
                    result += ", ";
                } else if (seconds > 0) {
                    result += " e ";
                }
            }
            if (months > 0) {
                result += months + " " + (months == 1 ? "mês" : "meses");
                if (days > 0 || hours > 0 || minutes > 0) {
                    result += ", ";
                } else if (seconds > 0) {
                    result += " e ";
                }
            }
            if (days > 0) {
                result += days + " dia" + (days == 1 ? "" : "s");
                if (hours > 0 || minutes > 0) {
                    result += ", ";
                } else if (seconds > 0) {
                    result += " e ";
                }
            }
            if (hours > 0) {
                result += hours + " hora" + (hours == 1 ? "" : "s");
                if (minutes > 0) {
                    result += ", ";
                } else if (seconds > 0) {
                    result += " e ";
                }
            }
            if (minutes > 0) {
                result += minutes + " minuto" + (minutes == 1 ? "" : "s");
                if (seconds > 0) {
                    result += " e ";
                }
            }
            if (seconds > 0) {
                result += seconds + " segundo" + (seconds == 1 ? "" : "s");
            }
            return result;
        }
        return "0 segundos";
    }

    public static void main(String[] args) {
		/*if(Boolean.TRUE) {
			System.out.println(hashSha512("NB1020").equals("7a6efee224d3dda9d8e31d8a3935616fd6718d111c577ab306240b28804245db2b197648603c31820adba0a00f9e57a3e3f56614092e8c1417ea507de0aafc5b"));
			return;
		}*/
        System.out.println("Iniciando...");
		/*chars.addAll(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
				"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "0"));*/

        System.out.println("Pronto!");
        System.out.println("Começando...");

        int threads = 5;

        for (int i = 1; i <= threads; i++) {
            Random random = new Random();
            List<String> chars = new ArrayList<>();
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("a");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("b");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("c");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("d");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("e");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("f");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("g");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("h");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("i");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("j");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("k");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("l");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("m");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("n");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("o");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("p");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("q");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("r");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("s");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("t");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("u");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("v");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("w");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("x");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("y");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("z");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("0");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("1");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("2");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("3");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("4");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("5");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("6");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("7");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("8");
            if ((random.nextInt(threads) + 1) <= i)
                chars.add("9");

            int I = i;
            Thread thread = new Thread(() -> {
                System.out.println("Iniciando thread #" + I + " com " + chars.size() + " letras!");
                test(I, chars);
            });
            thread.setName("Thread #" + i);
            thread.start();
        }

    }

    public static boolean firstTeste(int thread, String... args) {
        String result;
        if ((result = test(thread, args)) != null) {
            System.out.println(Thread.currentThread().getName() + ": Senha encontrada em " + sToTimeComplete((System.currentTimeMillis() - startTime) / 1000) + "! Senha: " + result);
            System.exit(0);
            return true;
        }
        return false;
    }

    public static long total = 0;
    public static Map<Integer, Long> tests = new HashMap<>();

    public static String test(int thread, String... args) {
        StringBuilder result = new StringBuilder();
        for (String arg : args) {
            result.append(arg);
        }
        if (!PasswordResolver.tests.containsKey(thread)) {
            PasswordResolver.tests.put(thread, 0L);
        }
        PasswordResolver.tests.put(thread, PasswordResolver.tests.getOrDefault(thread, 0L) + 1);
        long tests = PasswordResolver.tests.get(thread);
        total++;
        if (tests % 1000000 == 0) {
            System.out.println(Thread.currentThread().getName() + ": Testes: " + tests + " (" + result + " - " + total + ") - " +
                    sToTimeComplete((System.currentTimeMillis() - startTime) / 1000));
        }
        if (hashSha512(result.toString()).equals(hashSha512("12345"))) {
            return result.toString();
        }
        return null;
    }

    public static String hashSha512(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(String.valueOf(passwordToHash.hashCode()).getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        return generatedPassword;
    }

    public static void test(int thread, List<String> chars) {
        boolean order = new Random(thread).nextBoolean();

        for (String char1 : chars) {
            if (firstTeste(thread, char1)) {
                return;
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                if (order) {
                    if (firstTeste(thread, char1, char2)) {
                        return;
                    }
                } else {
                    if (firstTeste(thread, char2, char1)) {
                        return;
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    if (order) {
                        if (firstTeste(thread, char1, char2, char3)) {
                            return;
                        }
                    } else {
                        if (firstTeste(thread, char3, char2, char1)) {
                            return;
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        if (order) {
                            if (firstTeste(thread, char1, char2, char3, char4)) {
                                return;
                            }
                        } else {
                            if (firstTeste(thread, char4, char3, char2, char1)) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            if (order) {
                                if (firstTeste(thread, char1, char2, char3, char4, char5)) {
                                    return;
                                }
                            } else {
                                if (firstTeste(thread, char5, char4, char3, char2, char1)) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                if (order) {
                                    if (firstTeste(thread, char1, char2, char3, char4, char5, char6)) {
                                        return;
                                    }
                                } else {
                                    if (firstTeste(thread, char6, char5, char4, char3, char2, char1)) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    if (order) {
                                        if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7)) {
                                            return;
                                        }
                                    } else {
                                        if (firstTeste(thread, char7, char6, char5, char4, char3, char2, char1)) {
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        if (order) {
                                            if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8)) {
                                                return;
                                            }
                                        } else {
                                            if (firstTeste(thread, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            if (order) {
                                                if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9)) {
                                                    return;
                                                }
                                            } else {
                                                if (firstTeste(thread, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                if (order) {
                                                    if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10)) {
                                                        return;
                                                    }
                                                } else {
                                                    if (firstTeste(thread, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    if (order) {
                                                        if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11)) {
                                                            return;
                                                        }
                                                    } else {
                                                        if (firstTeste(thread, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        if (order) {
                                                            if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12)) {
                                                                return;
                                                            }
                                                        } else {
                                                            if (firstTeste(thread, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            if (order) {
                                                                if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13)) {
                                                                    return;
                                                                }
                                                            } else {
                                                                if (firstTeste(thread, char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                if (order) {
                                                                    if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                            char14)) {
                                                                        return;
                                                                    }
                                                                } else {
                                                                    if (firstTeste(thread, char14,
                                                                            char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                        return;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    if (order) {
                                                                        if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                char14, char15)) {
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        if (firstTeste(thread, char15, char14,
                                                                                char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        if (order) {
                                                                            if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                    char14, char15, char16)) {
                                                                                return;
                                                                            }
                                                                        } else {
                                                                            if (firstTeste(thread, char16, char15, char14,
                                                                                    char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            if (order) {
                                                                                if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                        char14, char15, char16, char17)) {
                                                                                    return;
                                                                                }
                                                                            } else {
                                                                                if (firstTeste(thread, char17, char16, char15, char14,
                                                                                        char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                if (order) {
                                                                                    if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                            char14, char15, char16, char17, char18)) {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    if (firstTeste(thread, char18, char17, char16, char15, char14,
                                                                                            char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    if (order) {
                                                                                        if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                char14, char15, char16, char17, char18, char19)) {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        if (firstTeste(thread, char19, char18, char17, char16, char15, char14,
                                                                                                char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        if (order) {
                                                                                            if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                    char14, char15, char16, char17, char18, char19, char20)) {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            if (firstTeste(thread, char20, char19, char18, char17, char16, char15, char14,
                                                                                                    char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        for (String char21 : chars) {
                                                                                            if (order) {
                                                                                                if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                        char14, char15, char16, char17, char18, char19, char20, char21)) {
                                                                                                    return;
                                                                                                }
                                                                                            } else {
                                                                                                if (firstTeste(thread, char21, char20, char19, char18, char17, char16, char15, char14,
                                                                                                        char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        for (String char21 : chars) {
                                                                                            for (String char22 : chars) {
                                                                                                if (order) {
                                                                                                    if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                            char14, char15, char16, char17, char18, char19, char20, char21, char22)) {
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    if (firstTeste(thread, char22, char21, char20, char19, char18, char17, char16, char15, char14,
                                                                                                            char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        for (String char21 : chars) {
                                                                                            for (String char22 : chars) {
                                                                                                for (String char23 : chars) {
                                                                                                    if (order) {
                                                                                                        if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                                char14, char15, char16, char17, char18, char19, char20, char21, char22, char23)) {
                                                                                                            return;
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (firstTeste(thread, char23, char22, char21, char20, char19, char18, char17, char16, char15, char14,
                                                                                                                char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        for (String char21 : chars) {
                                                                                            for (String char22 : chars) {
                                                                                                for (String char23 : chars) {
                                                                                                    for (String char24 : chars) {
                                                                                                        if (order) {
                                                                                                            if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                                    char14, char15, char16, char17, char18, char19, char20, char21, char22, char23, char24)) {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (firstTeste(thread, char24, char23, char22, char21, char20, char19, char18, char17, char16, char15, char14,
                                                                                                                    char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                                return;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        for (String char21 : chars) {
                                                                                            for (String char22 : chars) {
                                                                                                for (String char23 : chars) {
                                                                                                    for (String char24 : chars) {
                                                                                                        for (String char25 : chars) {
                                                                                                            if (order) {
                                                                                                                if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                                        char14, char15, char16, char17, char18, char19, char20, char21, char22, char23, char24, char25)) {
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (firstTeste(thread, char25, char24, char23, char22, char21, char20, char19, char18, char17, char16, char15, char14,
                                                                                                                        char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                                    return;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        for (String char21 : chars) {
                                                                                            for (String char22 : chars) {
                                                                                                for (String char23 : chars) {
                                                                                                    for (String char24 : chars) {
                                                                                                        for (String char25 : chars) {
                                                                                                            for (String char26 : chars) {
                                                                                                                if (order) {
                                                                                                                    if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                                            char14, char15, char16, char17, char18, char19, char20, char21, char22, char23, char24, char25, char26)) {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if (firstTeste(thread, char26, char25, char24, char23, char22, char21, char20, char19, char18, char17, char16, char15, char14,
                                                                                                                            char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        for (String char21 : chars) {
                                                                                            for (String char22 : chars) {
                                                                                                for (String char23 : chars) {
                                                                                                    for (String char24 : chars) {
                                                                                                        for (String char25 : chars) {
                                                                                                            for (String char26 : chars) {
                                                                                                                for (String char27 : chars) {
                                                                                                                    if (order) {
                                                                                                                        if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                                                char14, char15, char16, char17, char18, char19, char20, char21, char22, char23, char24, char25, char26, char27)) {
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (firstTeste(thread, char27, char26, char25, char24, char23, char22, char21, char20, char19, char18, char17, char16, char15, char14,
                                                                                                                                char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        for (String char21 : chars) {
                                                                                            for (String char22 : chars) {
                                                                                                for (String char23 : chars) {
                                                                                                    for (String char24 : chars) {
                                                                                                        for (String char25 : chars) {
                                                                                                            for (String char26 : chars) {
                                                                                                                for (String char27 : chars) {
                                                                                                                    for (String char28 : chars) {
                                                                                                                        if (order) {
                                                                                                                            if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                                                    char14, char15, char16, char17, char18, char19, char20, char21, char22, char23, char24, char25, char26, char27, char28)) {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            if (firstTeste(thread, char28, char27, char26, char25, char24, char23, char22, char21, char20, char19, char18, char17, char16, char15, char14,
                                                                                                                                    char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        for (String char21 : chars) {
                                                                                            for (String char22 : chars) {
                                                                                                for (String char23 : chars) {
                                                                                                    for (String char24 : chars) {
                                                                                                        for (String char25 : chars) {
                                                                                                            for (String char26 : chars) {
                                                                                                                for (String char27 : chars) {
                                                                                                                    for (String char28 : chars) {
                                                                                                                        for (String char29 : chars) {
                                                                                                                            if (order) {
                                                                                                                                if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                                                        char14, char15, char16, char17, char18, char19, char20, char21, char22, char23, char24, char25, char26, char27, char28, char29)) {
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                if (firstTeste(thread, char29, char28, char27, char26, char25, char24, char23, char22, char21, char20, char19, char18, char17, char16, char15, char14,
                                                                                                                                        char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String char1 : chars) {
            for (String char2 : chars) {
                for (String char3 : chars) {
                    for (String char4 : chars) {
                        for (String char5 : chars) {
                            for (String char6 : chars) {
                                for (String char7 : chars) {
                                    for (String char8 : chars) {
                                        for (String char9 : chars) {
                                            for (String char10 : chars) {
                                                for (String char11 : chars) {
                                                    for (String char12 : chars) {
                                                        for (String char13 : chars) {
                                                            for (String char14 : chars) {
                                                                for (String char15 : chars) {
                                                                    for (String char16 : chars) {
                                                                        for (String char17 : chars) {
                                                                            for (String char18 : chars) {
                                                                                for (String char19 : chars) {
                                                                                    for (String char20 : chars) {
                                                                                        for (String char21 : chars) {
                                                                                            for (String char22 : chars) {
                                                                                                for (String char23 : chars) {
                                                                                                    for (String char24 : chars) {
                                                                                                        for (String char25 : chars) {
                                                                                                            for (String char26 : chars) {
                                                                                                                for (String char27 : chars) {
                                                                                                                    for (String char28 : chars) {
                                                                                                                        for (String char29 : chars) {
                                                                                                                            for (String char30 : chars) {
                                                                                                                                if (order) {
                                                                                                                                    if (firstTeste(thread, char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13,
                                                                                                                                            char14, char15, char16, char17, char18, char19, char20, char21, char22, char23, char24, char25, char26, char27, char28, char29, char30)) {
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    if (firstTeste(thread, char30, char29, char28, char27, char26, char25, char24, char23, char22, char21, char20, char19, char18, char17, char16, char15, char14,
                                                                                                                                            char13, char12, char11, char10, char9, char8, char7, char6, char5, char4, char3, char2, char1)) {
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("THREAD #" + thread + " PAROU POR COMPLETO!");
    }

}
