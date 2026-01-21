---
# Album Picker

A lightweight, modular Java utility that scans a directory of music albums, calculates the size of each album folder, and selects a random subset for display. Designed with clean architecture principles, the project separates scanning, size calculation, data modeling, and random selection into focused components.
This makes the tool easy to extend — whether you want playlist generation, filtering, metadata extraction, or a GUI later.

---

## Features

- Scans a root directory for album folders
- Calculates folder sizes recursively
- Picks a random set of unique albums
- Clean, testable, modular architecture
- Zero external dependencies — pure Java

---

## Project Structure

```
src/
 └── musicpicker/
      ├── Main.java
      ├── Album.java
      ├── AlbumScanner.java
      ├── AlbumSizeCalculator.java
      └── RandomAlbumPicker.java
```

Each class has a single responsibility:

| File | Responsibility |
|------|----------------|
| **Main.java** | Orchestrates scanning, size calculation, and random selection |
| **Album.java** | Represents an album with path + size metadata |
| **AlbumScanner.java** | Finds album folders inside a root directory |
| **AlbumSizeCalculator.java** | Computes folder sizes recursively |
| **RandomAlbumPicker.java** | Selects a random subset of albums |

---

## Getting Started

### **Prerequisites**
- Java 17+ recommended
- A directory containing album folders (each album = one folder)

### **Running the Program**

1. Clone or download the project
2. Update the root music directory in `Main.java`:

```java
Path root = Path.of("D:/Music");
```

3. Compile and run:

```bash
javac -d out src/musicpicker/*.java
java -cp out musicpicker.Main
```

---

## How It Works

1. **AlbumScanner** finds all subdirectories inside the root folder.
2. **AlbumSizeCalculator** walks each folder and sums file sizes.
3. **Album** objects are created to store metadata.
4. **RandomAlbumPicker** shuffles the list and returns the first N albums.
5. **Main** prints the results.

---

## Example Output

```
The Dark Side of the Moon        43 MB
Kind of Blue                     55 MB
Abbey Road                       87 MB
...
```

---

## Technologies Used

- Java NIO (`Files`, `Path`, `DirectoryStream`)
- Java Streams
- Collections API

No external libraries required.

---

## License

This project is free to use, modify, and extend. Add your preferred license here.

---
