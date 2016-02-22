/**
 * Test class for JOGL
 * Adapted from: https://sites.google.com/site/justinscsstuff/jogl-tutorial-3
 * 
 * @author CJ <cmajames@sdf.org>
 * @added 2016-02-01
 */

package io.cmajames.kanako.test.engine;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import io.cmajames.kanako.test.engine.view.GLTriangleSpinRenderer;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GLHello {
    public static void main(String[] args) {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        Frame frame = new Frame("AWT Window Test");
        frame.setSize(300, 300);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addGLEventListener(new GLTriangleSpinRenderer());

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
    }
}
