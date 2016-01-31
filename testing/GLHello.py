#!/usr/bin/python2

import sys, time
try:
    import OpenGL
    from OpenGL.GL import *
    from OpenGL.GLU import *
    from OpenGL.GLUT import *
except:
    print 'PyOpenGL not installed properly'
    sys.exit()

def reshape(w, h):
    if h == 0:
        h = 1.0
    aspect = 1.0 * w / h
    
    glViewport(0, 0, w, h)
    
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    if w >= h:
        gluOrtho2D(-aspect, aspect, -1.0, 1.0)
    else:
        gluOrtho2D(-1.0, 1.0, -1.0 / aspect, 1.0 / aspect)

def draw():
    glClearColor(0, 0, 0, 1)
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    
    glBegin(GL_QUADS)
    glColor3f(1, 0, 0)
    glVertex2f(-0.8, -0.1)
    glVertex2f( 0.0, -0.1)
    glVertex2f( 0.0,  0.7)
    glVertex2f(-0.8,  0.7)
    
    glColor3f(0, 1, 0)
    glVertex2f(-0.1, -0.7)
    glVertex2f( 0.7, -0.7)
    glVertex2f( 0.7,  0.1)
    glVertex2f(-0.1,  0.1)
    glEnd()
    
    glFlush()

if __name__ == '__main__':
    glutInit(sys.argv)
    
    glutCreateWindow("Kanako DNH Hello")
    glutInitWindowSize(300, 300)
    glutInitWindowPosition(50, 50)
    
    glutReshapeFunc(reshape)
    glutDisplayFunc(draw)
    glutMainLoop()
