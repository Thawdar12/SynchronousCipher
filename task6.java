// Name: Thawdar Swe Zin
// ID: 8039276

public class task6 {

    public static void main(String[] args) {
        // Encrypt the message "I LOVE WOLLONGONG" with a key of 3
        String plaintext = "I LOVE WOLLONGONG";
        int encryptionKey = 3;
        String encryptedMessage = encrypt(plaintext, encryptionKey);
        System.out.println("Encrypted message '" + plaintext + "' with key = " + encryptionKey + ": " + encryptedMessage);

        // Test decryption on the encrypted message
        int decryptionKey = 3;
        String decryptedFirstMessage = decrypt(encryptedMessage, decryptionKey);
        System.out.println("Decrypted ciphertext '" + encryptedMessage + "' with key = " + decryptionKey + ": "+ decryptedFirstMessage);

        // Decrypt the ciphertext "MQJJ" with a key of 3
        String ciphertext = "MQJJ";
        String decryptedSecondMessage = decrypt(ciphertext, decryptionKey);
        System.out.println("Decrypted ciphertext '" + ciphertext + "' with key = " + decryptionKey + ": " + decryptedSecondMessage);
    }

    private static String encrypt(String plaintext, int key) {
        int[] keystream = generateKeystream(key, plaintext.length());
        // System.out.println(keystream + "keystream");
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char m = Character.toUpperCase(plaintext.charAt(i));
            if (!Character.isLetter(m)) {
                ciphertext.append(m);
                continue;
            }
            int mi = m - 'A';
            int ci = (mi + keystream[i]) % 26;
            //System.out.println(keystream[i] + "keystream encrypt "+ key );
            ciphertext.append((char) (ci + 'A'));
        }

        return ciphertext.toString();
    }

    private static String decrypt(String ciphertext, int key) {
        int[] keystream = generateKeystream(key, ciphertext.length());
        // System.out.println(keystream + "keystream");
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (!Character.isLetter(c)) {
                plaintext.append(c);
                continue;
            }
            int ci = c - 'A';
            int mi = (ci - keystream[i] + 26) % 26;
            //System.out.println(keystream[i] + "keystream "+ key );
            plaintext.append((char) (mi + 'A'));
        }

        return plaintext.toString();
    }

    private static int[] generateKeystream(int key, int length) {
        int[] keystream = new int[length];
        keystream[0] = (int) (Math.pow(key, 3) + 1) % 26;
        for (int i = 1; i < length; i++) {
            keystream[i] = (int) (Math.pow(keystream[i - 1], 2) + (i + 1)) % 26;
        }
        return keystream;
    }
}
