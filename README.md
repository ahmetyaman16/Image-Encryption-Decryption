
# OOP Project 2 – Image Encryption and Decryption

This project is part of the EE1004 & CSE2062 Object-Oriented Programming course (Spring 2024). The goal of the project is to implement an image encryption and decryption system using Java, based on object-oriented principles such as inheritance and encapsulation.

## 🔒 Project Description

This project allows encrypting a message into a selected image and decrypting it back. The encryption process modifies the RGB values of the image pixels to hide the message, while the decryption process reverses the changes using encoded clues.

- The image used must not exceed **128x128 pixels**.
- A custom logging system records user activity.
- Bubble Sort is used for sorting operations during encryption and decryption.

## 🧩 Features

- Encrypt text messages into image pixel data
- Decrypt messages from encoded images
- Command-line user interface
- Logging of user actions and system events
- Input validation (image dimension check)

## 🧱 Object-Oriented Concepts Used

- **Inheritance**: `Encryption` and `Decryption` classes inherit from `ImageProcess`.
- **Encapsulation**: All internal fields are accessed and modified via getter and setter methods.

## 📦 Structure Overview

The project is divided into two parts:

### Part 1 - Encryption
- Converts message into pixel modifications
- Utilizes randomization and sorting for obfuscation
- Writes encrypted image to disk

### Part 2 - Decryption
- Reads pixel data and reverses encryption
- Extracts message using RGB clues and sorted indices

## 🔁 Sorting Algorithm

**Bubble Sort** is implemented for sorting pixel-related data during encryption and decryption steps.

## 🖼️ Libraries Used

- `javax.imageio.ImageIO` – for reading/writing image files
- `java.awt.image.BufferedImage` – for low-level pixel manipulation
- `java.io.File` – for file handling and path resolution

## 📂 Sample Log Output

```
Sun May 26 13:20:27 TRT 2024   User 216 entered the system...
Sun May 26 13:20:28 TRT 2024   Option 1 selected...
Sun May 26 13:20:30 TRT 2024   Image Encrypted Successfully...
Sun May 26 13:20:30 TRT 2024   Option 2 selected...
Sun May 26 13:20:30 TRT 2024   Image Decrypted Successfully...
```

## 🖼️ Screenshots

**Before Encryption**

![Before Encryption](before_encryption.jpg)

**After Encryption**

![After Encryption](after_encryption.png)


## 📚 References

- [GeeksforGeeks - Bubble Sort](https://www.geeksforgeeks.org/bubble-sort/)
- [TutorialsPoint - Read Image Pixels in Java](https://www.tutorialspoint.com/how-to-get-pixels-rgb-values-of-an-image-using-java-opencv-library)
