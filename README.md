# Why Coroutines Feel "Safe" (But Aren't) 🏦

This repository contains the companion Android project for my article: **"Why Coroutines Feel 'Safe' (But Aren't)."** It demonstrates common pitfalls when dealing with shared mutable state in a concurrent environment and provides 9 different architectural solutions to solve them.

## 🚀 The Scenario
Imagine you have 1,000 friends, and each sends you $1. In a perfect world, you have $1,000. In a world with race conditions, you might end up with $972. This project shows you why that happens and how to fix it.

## 🛠 Features & Solutions
The app features several "Deposit" methods, each demonstrating a different concurrency strategy:

- **Unsafe Deposit:** Shows the race condition in action.
- **Blocking Sync:** The "Coroutine Sin" (Synchronized).
- **Atomics:** Using `AtomicInteger` for lock-free math.
- **Thread Confinement:** Using `limitedParallelism(1)`.
- **Mutex:** Using suspension-aware locking.
- **StateFlow.update:** The Android standard for reactive state.
- **Actor Pattern:** Communication-based state management.
- **Functional Approach:** Parallel processing without shared state.

## 📱 Tech Stack
- **Language:** Kotlin
- **Framework:** Jetpack Compose
- **Concurrency:** Kotlin Coroutines & Flow
- **Architecture:** MVVM (ViewModel & State management)

## 📸 Screenshots
<img width="347" height="596" alt="Screenshot 2026-01-31 at 17 39 34" src="https://github.com/user-attachments/assets/c98bee37-a399-4b2f-ab79-67cae0265fb2" />
<img width="414" height="794" alt="Screenshot 2026-01-31 at 17 39 46" src="https://github.com/user-attachments/assets/905cf1a0-be5d-4dfe-9d3f-d3cc285809dc" />
<img width="413" height="794" alt="Screenshot 2026-01-31 at 17 44 09" src="https://github.com/user-attachments/assets/c9955491-a791-428f-8cd8-99f1c473ab89" />
<img width="409" height="791" alt="Screenshot 2026-01-31 at 18 24 50" src="https://github.com/user-attachments/assets/6652da6f-340c-4a5a-9738-e5bcede9e9ad" />
<img width="407" height="797" alt="Screenshot 2026-01-31 at 19 46 35" src="https://github.com/user-attachments/assets/7e4eead0-5198-4a60-b15b-ad0891ed4b06" />
<img width="415" height="806" alt="Screenshot 2026-01-31 at 20 00 56" src="https://github.com/user-attachments/assets/b1517599-a17e-4f1a-b369-d8d37a9be6a5" />
<img width="414" height="804" alt="Screenshot 2026-01-31 at 20 06 52" src="https://github.com/user-attachments/assets/fbf174fb-3299-4420-8f87-8ed4a2c58dd7" />
<img width="414" height="802" alt="Screenshot 2026-01-31 at 20 23 37" src="https://github.com/user-attachments/assets/3213d9d6-3924-4ff9-a7ba-6633766a6b5d" />
<img width="413" height="801" alt="Screenshot 2026-01-31 at 20 41 28" src="https://github.com/user-attachments/assets/5769ae00-d26a-4b84-938e-1535d3aaf6ab" />
<img width="412" height="804" alt="Screenshot 2026-01-31 at 20 47 13" src="https://github.com/user-attachments/assets/a52c2d10-4213-4a41-a88d-502ca442c005" />


## 📖 Related Article
Read the full deep-dive explanation on Medium: [Link to your Article]

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
