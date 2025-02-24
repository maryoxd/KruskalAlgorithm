# 🔗 Kruskal's Algorithm – Java Implementation  

This project implements **Kruskal’s Algorithm** in **Java** to compute both the **Minimum Spanning Tree (MST)** and **Maximum Spanning Tree (MSTx)** of a weighted graph. It efficiently processes edges using **sorting, Union-Find operations, and cycle detection** to construct the optimal spanning tree.  

## 📌 Features  
- **Reads graph data from a file** – Dynamically detects vertices and edges.  
- **Sorting edges by weight** – Uses **Arrays.sort()** for efficient edge ordering.  
- **Union-Find data structure** – Prevents cycles while constructing the spanning tree.  
- **Supports both MST and MSTx calculations** – Allows selection between **minimum or maximum spanning tree**.  
- **Outputs final MST cost and edge selection** – Displays results in a structured format.  

## 🛠️ Technologies Used  
- **Java (Standard Library)**  
- **Union-Find Algorithm (Disjoint Set)**  
- **Sorting with Comparators**  
- **File Handling (Input Processing)**  

## 🚀 How to Install & Run  
1. **Clone the repository:**  
   ```bash
   git clone https://github.com/maryoxd/KruskalAlgorithm.git  
   cd KruskalAlgorithm
2. **Compile and run the program:**
   ```bash
   javac Kruskal.java  
   java Kruskal graph.txt 
