package br.com.introcdc.tests.password;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PasswordBatata {

    private String objective;

    private final char[] dictionary = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); // 62

    private final AtomicInteger generated = new AtomicInteger();
    private final AtomicBoolean resolved = new AtomicBoolean();

    protected void init(String objective, int maxLength) {
        this.objective = objective;

        //int threads = Runtime.getRuntime().availableProcessors() * 2;

        for (int length = 1; length <= maxLength; length++) {
            System.out.println(String.format("Thread %d: length %d", length, length));

            new WorkerThread(length).start();
        }
    }

    protected class WorkerThread extends Thread {
        private final int length;

        public WorkerThread(int length) {
            this.length = length;
        }

        @Override
        public void run() {
            long maxSize = maxSize();

            System.out.println(length + ": " + maxSize);

            int[] slots = new int[length];
            int current = 0;

            for (int s = 0; s < maxSize; s++) {
                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < length; i++) {
                    builder.append(dictionary[slots[i]]);
                }

                testPassword(builder.toString());

                int slot = slots[current];
                slots[current] = next(slot);
                if (slots[current] == 0) {
                    current++;
                }
            }
        }

        protected int next(int c) {
            int a = ++c;
            if (a == dictionary.length) {
                a = 0;
            }
            return a;
        }

        protected void testPassword(String password) {
            if (password.startsWith("z")) {
                System.out.println(password);
            }
            String hash = hashSha512(password);
            if (objective.equals(hash)) {
                System.out.println("Finalouz vaid: " + password + " " + hash);
                resolved.set(true);
                return;
            }
            int gen = generated.incrementAndGet();
            if (gen % 10000 == 0) {
                System.out.printf("#%d - %s: %s%n", gen, password, hash);
            }
        }

        protected long maxSize() {
            long matSize = 1;
            for (int i = 0; i < length; i++) {
                matSize *= dictionary.length;
            }
            return matSize;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tamanho máximo:");
        int length = scanner.nextInt();

        scanner.close();

        PasswordBatata batata = new PasswordBatata();
        //batata.init("7a6efee224d3dda9d8e31d8a3935616fd6718d111c577ab306240b28804245db2b197648603c31820adba0a00f9e57a3e3f56614092e8c1417ea507de0aafc5b", length);
        batata.init(hashSha512("z3"), length);
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

}
