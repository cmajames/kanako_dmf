/**
 * AWT Keyboard Implementation
 *
 * @author CJ <cmajames@sdf.org>
 * @added 2016-02-18
 */

package io.cmajames.kanako.engine.control;

import io.cmajames.kanako.engine.model.IAction;
import io.cmajames.kanako.engine.model.IControllable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

public class AWTKeyboard<T extends IAction> extends AKeyboard<Character, T>
        implements KeyListener {

    public AWTKeyboard(Map<Character, T> map, IControllable c) {
        super(map, c);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        super.press(keyEvent.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        super.release(keyEvent.getKeyChar());
    }
}
