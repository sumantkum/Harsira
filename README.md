# 📘 CatalogSecret

This Java project reads a JSON file containing coordinate points and calculates a "secret value" based on a custom algorithm. It demonstrates basic JSON parsing and algorithmic processing in Java.

---

## 📌 Project Structure



CatalogSecret/
├── src/
│ └── SecretFinder.java
├── testcase1.json
├── README.md

---

## 🛠 Requirements

- Java JDK 17 or above (tested on JDK 23)
- IntelliJ IDEA or any Java IDE
- [JSON.simple](https://code.google.com/archive/p/json-simple/) library or manual parser (if not using any library)

---

## 🚀 How to Run

1. **Clone or download this repository.**

2. **Place `testcase1.json`** in the root folder (same level as `.java` file or update the path in code).

3. **Compile and Run in IntelliJ:**
   - Open the project.
   - Make sure the path to `testcase1.json` is correct in `SecretFinder.java`.
   - Run `SecretFinder` from your IDE.

   Or using terminal:
   ```bash
   javac SecretFinder.java
   java SecretFinder
