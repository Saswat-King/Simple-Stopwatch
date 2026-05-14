# ⏱️ Simple Stopwatch
 
A simple Android practice app built to learn Kotlin Coroutines and View Binding through a working stopwatch with start, stop, and reset functionality.

---

## Concepts Practiced
 
- **Kotlin Coroutines** — used `CoroutineScope`, `Dispatchers.Main`, `Job`, and `delay()` to run the timer loop on the main thread without blocking the UI
- **View Binding** — accessed all UI elements through `ActivityMainBinding` instead of `findViewById()`
- **State Management** — tracked running state and elapsed seconds using Kotlin variables with proper start/stop/reset logic
- **Job Cancellation** — cancelled the coroutine `Job` on stop and reset to cleanly terminate the timer
