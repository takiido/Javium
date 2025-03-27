package com.javium.game;

import com.javium.view.Renderer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Game game = new Game();
        // Thread gameThread = new Thread(game::Start);
        // gameThread.start();

        // try {
        //     Thread.sleep(5000);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // game.Stop();
        // System.out.println("Goodbye!");

		Renderer window = new Renderer();
		window.Run();
    }
}
