# Vigenère Cipher

This repository contains a Java implementation of the Vigenère Cipher. The program allows the user to either encrypt or decrypt a text file using a provided key.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You will need Java installed on your machine to run this program.

## Usage

You will be prompted to enter the following:

- A choice: 'e' to encrypt a file or 'd' to decrypt a file.
- The name of the file to be read (encrypted or decrypted).
- The name of the output file where the encrypted or decrypted content will be stored.
- A key that will be used for the encryption or decryption process.

Please note that the input and output files should be in the "res" folder.

### Example

If you want to encrypt the "example.txt" file with the key "mykey", you would do the following:

    ```
    java src/Controller/AppManager
    e
    res/example.txt
    res/encrypted.txt
    mykey
    ```

This will create an encrypted version of "example.txt" called "encrypted.txt" using the key "mykey".

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
