/**
 * OpenGL Renderer for a blank screen
 *
 * @author CJ <cmajames@sdf.org>
 * @added 2016-02-11
 */

package io.cmajames.kanako.engine.view;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import io.cmajames.kanako.engine.model.IRenderable;

public class BlankGLRenderer extends AGLRenderer {
    @Override
    public void addRenderable(IRenderable o) {
        throw new IllegalArgumentException("Blank Renderer takes no renderables");
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) { }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) { }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2,
                        int i3) { }
}
