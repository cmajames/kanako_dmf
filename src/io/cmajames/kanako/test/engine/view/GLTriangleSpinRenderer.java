/**
 * TODO: STUB
 *
 * @author
 * @added 2016-02-17
 */

package io.cmajames.kanako.test.engine.view;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import io.cmajames.kanako.engine.model.IRenderable;
import io.cmajames.kanako.engine.view.AGLRenderer;

public class GLTriangleSpinRenderer extends AGLRenderer {
    private double theta = 0;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        theta += 0.01;
        double s = Math.sin(theta);
        double c = Math.cos(theta);

        GL2 gl = glAutoDrawable.getGL().getGL2();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        // draw a triangle filling the window
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(1, 0, 0);
        gl.glVertex2d(-c, -c);
        gl.glColor3f(0, 1, 0);
        gl.glVertex2d(0, c);
        gl.glColor3f(0, 0, 1);
        gl.glVertex2d(s, -s);
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
    }

    @Override
    public void addRenderable(IRenderable o) {
        throw new IllegalArgumentException("TriangleSpin Renderer doesn't take Renderables");
    }
}
