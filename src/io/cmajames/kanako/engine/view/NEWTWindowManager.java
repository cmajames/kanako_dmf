/**
 * NEWT Window Manager
 *
 * @author CJ <cmajames@sdf.org>
 * @since 2016-02-09
 */

package io.cmajames.kanako.engine.view;

import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.WindowListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLCapabilitiesImmutable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.AnimatorBase;
import com.jogamp.opengl.util.FPSAnimator;

public class NEWTWindowManager implements IWindowManager, Runnable {
    private static final GLProfile prof = GLProfile.getDefault();
    private static final GLCapabilitiesImmutable caps = new GLCapabilities(prof);

    private GLWindow mWindow;
    private AnimatorBase mAnimator;

    public NEWTWindowManager(AGLRenderer r, String title, int w, int h) {
        this.mWindow = GLWindow.create(caps);
        this.mAnimator = new FPSAnimator(this.mWindow, 60);

        this.mWindow.setSize(w, h);
        this.mWindow.setTitle(title);

        this.attach(r);
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

