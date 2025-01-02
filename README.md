# Synchronous Cipher Implementation

## Overview
This project implements a Synchronous Cipher (a type of stream cipher) in Java. In this cipher, each character (A-Z) is mapped to numbers in the range Z26 = {0, 1, 2, ..., 25}. The cipher uses a key `k ∈ Z26` to generate a keystream, where each character of the plaintext is encrypted by adding the corresponding key value (mod 26). The same key is used for both encryption and decryption, and the keystream is generated dynamically from the key.

## What I Learned

- **Stream Ciphers**: I learned how stream ciphers work, where encryption and decryption are performed one character at a time by using a key stream that is generated based on the given key.  
- **Modular Arithmetic**: I gained experience in using modular arithmetic (mod 26) to handle the encryption and decryption processes. This is important when working with ciphers in a limited alphabet like A-Z.
- **Encryption and Decryption**: Implemented both the encryption and decryption processes using the synchronous cipher. For encryption, the formula is `ci = mi + ki (mod 26)` and for decryption, it is `mi = ci - ki (mod 26)`. The decryption process essentially reverses the encryption by subtracting the key stream from the ciphertext.
- **Keystream Generation**: Learned how to generate a dynamic keystream based on an initial key. The keystream is crucial for both encryption and decryption and needs to be generated in sync for both processes.
- **Character Mapping**: Explored how to map characters to their corresponding numbers (A = 0, B = 1, ..., Z = 25) and then map numbers back to characters after encryption or decryption.
- **Handling Non-Alphabetic Characters**: Implemented the handling of non-alphabetic characters (such as spaces) by keeping them unchanged in both encryption and decryption, which makes the algorithm flexible for text with spaces or punctuation.

## Program Features

- **Encryption**: The program encrypts a plaintext message by generating a keystream using the given key and then adding the keystream values to the corresponding message characters (mod 26).
- **Decryption**: The program decrypts the ciphertext by subtracting the keystream values (mod 26) from the corresponding ciphertext characters to recover the original message.
- **Keystream Generation**: The keystream is dynamically generated using the given key. It is generated based on a formula that ensures the keystream values are synchronized between encryption and decryption.

## Commands

This program works with a fixed key to encrypt and decrypt messages. There are no specific command-line options for this program as it is designed to work with hardcoded inputs for simplicity.

### Example Encryption and Decryption

1. **Encrypt the message "I LOVE WOLLONGONG" with a key of 3**:
   ```java
   String plaintext = "I LOVE WOLLONGONG";
   int encryptionKey = 3;
   String encryptedMessage = encrypt(plaintext, encryptionKey);
   System.out.println("Encrypted message: " + encryptedMessage);
