package me.elordenador;

import java.io.IOException;

/**
 * Used for managing a simple Progress Bar
 * @version 1.0
 * @author Daniel Sánchez
 */
public class BarUtils {
    private int maxLength;
    private boolean enabled;


    /**
     * Defines the Maximum Number
     * @param maxLength Maximum Number
     */
    public BarUtils(int maxLength) {
        this.maxLength = maxLength;
        enabled = false;
    }

    public void enable() {
        enabled = true;
    }

    /**
     * Prints the progress bar
     * @param i The actual number of progress
     * @throws IOException if you're running old Windows Terminal
     */
    public void update(int i) throws IOException {
        if (enabled) {
            int[] screenSize = ScrUtils.getScreenSize();
            int y = screenSize[1];
            int maxWidth = screenSize[0];
            int barWidth = maxWidth / 2;

            ScrUtils.go(1,y);

            int chunkPrint = (i*barWidth) / maxLength;
            int percentage = (i*100) / maxLength;
            System.out.print(" " + percentage + "% [");
            for (int r = 0; r < chunkPrint; r++) {
                System.out.print("█");
            }
            for (int r = 0; r < barWidth-chunkPrint; r++) {
                System.out.print(" ");
            }
            System.out.print("]");
        }

    }
    public void finish() throws IOException {
        if (enabled) {
            int[] screenSize = ScrUtils.getScreenSize();
            int y = screenSize[1];
            int maxWidth = screenSize[0];
            int barWidth = maxWidth / 2;

            ScrUtils.go(1,y);
            System.out.print(" FINISHED [");
            for (int r = 0; r < barWidth; r++)
            {
                System.out.print("█");
            }
            System.out.print("]");
            System.out.println();
        }



    }
}
