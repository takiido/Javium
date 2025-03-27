// package com.javium.view;

// import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
// import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
// import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
// import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
// import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
// import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
// import static org.lwjgl.glfw.GLFW.glfwInit;
// import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
// import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
// import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
// import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
// import static org.lwjgl.glfw.GLFW.glfwShowWindow;
// import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
// import static org.lwjgl.glfw.GLFW.glfwWindowHint;
// import static org.lwjgl.system.MemoryStack.stackPush;
// import static org.lwjgl.system.MemoryUtil.NULL;

// import java.nio.IntBuffer;

// import org.lwjgl.glfw.GLFWErrorCallback;
// import org.lwjgl.glfw.GLFWVidMode;
// import org.lwjgl.system.MemoryStack;

// public class Window {
//     private long window;
//     private boolean isEditor = false;

//     public Window(int width, int height, String title, boolean isEditor) {
//         this.isEditor = isEditor;
//         Run();
//     }

//     public void Run() {
//         Init();
//         Loop();
//     }

//     private void Init() {
//         ReadRenderConfig();

//         GLFWErrorCallback.createPrint(System.err).set();

// 		if ( !glfwInit() )
// 			throw new IllegalStateException("Unable to initialize GLFW");

//         glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE);
//         glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

//         window = glfwCreateWindow(width, height, "Javium", 0, 0);

//         if ( window == NULL )
// 			throw new RuntimeException("Failed to create the GLFW window");

//     	glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
//             if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
//                 glfwSetWindowShouldClose(window, true);
//             });

//     	try ( MemoryStack stack = stackPush() ) {
// 			IntBuffer pWidth = stack.mallocInt(1);
// 			IntBuffer pHeight = stack.mallocInt(1);

// 			glfwGetWindowSize(window, pWidth, pHeight);

// 			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

// 			glfwSetWindowPos(
// 				window,
// 				(vidmode.width() - pWidth.get(0)) / 2,
// 				(vidmode.height() - pHeight.get(0)) / 2
//             );
//         }

//         glfwMakeContextCurrent(window);
//         glfwSwapInterval(1);
//         glfwShowWindow(window);
//     }

// 	private void Loop() {
// }
