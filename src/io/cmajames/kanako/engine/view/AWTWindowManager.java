/**
 * AWT Window Manager
 * Note: Very heavy -- only use as fallback / for compatibility
 *
 * @author CJ <cmajames@sdf.org>
 * @since 2016-02-09
 */

package io.cmajames.kanako.engine.view;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLCapabilitiesImmutable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.AnimatorBase;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

public class AWTWindowManager implements IWindowManager, Runnable {
    private static final GLProfile prof = GLProfile.getDefault();
    private static final GLCapabilitiesImmutable caps = new GLCapabilities(prof);

    private Frame mFrame;
    private GLCanvas mCanvas;
    private AnimatorBase mAnimator;

    public AWTWindowManager(AGLRenderer r, String title, int w, int h) {
        this.mFrame = new Frame(title);
        this.mCanvas = new GLCanvas(caps);
        this.mAnimator = new FPSAnimator(this.mCanvas, 60);

        this.mFrame.setSize(w, h);
        this.mFrame.add(this.mCanvas);

        this.attach(r);
    }

    public void attach(KeyListener l) {
        this.mCanvas.addKeyListener(l);
    }

    public void attach(WindowListener l) {
        this.mFrame.addWindowListener(l);
    }

    public void attach(GLEventListener l) {
        this.mCanvas.addGLEventListener(l);
    }

    @Override
    public void run() {
        this.mFrame.setVisible(true);
        this.mAnimator.start();
    }
}

