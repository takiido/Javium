package com.javium.game;

public class Game {
    private boolean running = true;
    private final int TARGET_FPS = 60;
    private final long OPTIMAL_TIME = 1_000_000_000 / TARGET_FPS;
    
    public void Start() {
        long startTime = System.nanoTime();
    
        while (running) {
            long now = System.nanoTime();
            float deltaTime = (now - startTime) / 1_000_000_000.0f;
            startTime = now;
    
            Update(deltaTime);
            Render();
    
            long sleepTime = (startTime - System.nanoTime() + OPTIMAL_TIME) / 1_000_000;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        CleanUp();
    }

    private void Update(float deltaTime) {
        System.out.println("Updating: " + deltaTime);
    }

    public void Stop() {
        System.out.println("Stopping...");
        running = false;
    }

    private void Render() {
        System.out.println("Rendering...");
    }

    private void CleanUp() {
        System.out.println("Cleaning up...");
    }
}
