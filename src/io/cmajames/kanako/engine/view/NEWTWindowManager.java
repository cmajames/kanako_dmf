/**
 * NEWT Window Manager
 *
 * @author CJ <cmajames@sdf.org>
 * @since 2016-02-09
 */

package io.cmajames.kanako.engine.view;

import com.jogamp.newt.event.*;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.*;
import com.jogamp.opengl.util.AnimatorBase;
import com.jogamp.opengl.util.FPSAnimator;

public class NEWTWindowManager implements IWindowManager, Runnable {
    private static final GLProfile prof = GLProfile.getDefault();
    private static final GLCapabilitiesImmutable caps = new GLCapabilities(prof);

    private AGLRenderer mRenderer;
    private GLWindow mWindow;
    private AnimatorBase mAnimator;

    public NEWTWindowManager(AGLRenderer r, String title) {
        this.mRenderer = r;
        this.mWindow = GLWindow.create(caps);
        this.mAnimator = new FPSAnimator(this.mWindow, 60);

        this.mWindow.setPosition(100, 100);
        this.mWindow.setSize(100, 100);
        this.mWindow.setTitle(title);

        this.attach(this.mRenderer);
    }

    public void attach(KeyListener l) {
        this.mWindow.addKeyListener(l);
    }

    public void attach(WindowListener l) {
        this.mWindow.addWindowListener(l);
    }

    public void attach(GLEventListener l) {
        this.mWindow.addGLEventListener(l);
    }

    @Override
    public void run() {
        this.mWindow.setVisible(true);
        this.mAnimator.start();
    }
}

