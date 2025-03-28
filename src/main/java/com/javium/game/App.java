package com.javium.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.javium.view.Renderer;
import com.javium.utils.FileManager;
import com.javium.utils.nodes.*;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws IOException {
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

		// Renderer window = new Renderer();
		// Node rootNode = NodeReader.ParseConfigFile("render.config");
        // NodeReader.PrintConfigTree(rootNode, "");
		// window.Run();

		NodeReader reader = new NodeReader();
		ArrayList<Node> config = reader.Parse("render.jec");
		Node gameWindow = config.get(0).GetChild("windows").GetChild("game");
		System.out.println("Game window config: " + gameWindow.FindInChildren("window_w"));
    }
}
