package com.example.ben.rocketship;

/**
 * Created by Ben on 14/03/2016.
 */
public class MainThread extends Thread

{
    private int FPS=30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;

    }

    @Override
    public void run()
    {
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int framecount =0;
        long targetTime = 1000/FPS;

        while(running)
            startTime = System.nanoTime();
            canvas = null;
//try locking the canvas for pixel editting
        try {
            canvas = this.surfaceHolder.lockCanvas();
            synchronized (surfaceHolder)

            {
                this.GamePanel.update();
                this.GamePanel.draw();

            }
        } catch(Exception_e){}
        timeMillis = (System.nanoTime()-startTime)/10000000;
         waitTime = targetTime-timeMillis;
    }
}
