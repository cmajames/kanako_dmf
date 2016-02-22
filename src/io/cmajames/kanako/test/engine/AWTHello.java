/**
 * @author CJ <cmajames@sdf.org>
 * @added 2016-02-10
 */

package io.cmajames.kanako.test.engine;

import io.cmajames.kanako.engine.control.AWTKeyboard;
import io.cmajames.kanako.engine.model.IAction;
import io.cmajames.kanako.engine.model.IControllable;
import io.cmajames.kanako.engine.view.AWTWindowManager;
import io.cmajames.kanako.test.engine.view.GLTriangleSpinRenderer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

public class AWTHello {
    public static void main(String... args) {
        Map<Character, TypeAction> actionMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            actionMap.put(c, new TypeAction(c));
        }

        AWTWindowManager wm = new AWTWindowManager(new GLTriangleSpinRenderer(),
                "AWTHello", 300, 300);
        IControllable c = new ControllableSystemOut();
        AWTKeyboard<TypeAction> kbd = new AWTKeyboard<>(actionMap, c);

        wm.attach(kbd);
        wm.attach(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        wm.run();
    }

    public static class TypeAction implements IAction {
        private char data;

        public TypeAction(char c) {
            this.data = c;
        }

        public char getData() {
            return this.data;
        }
    }

    public static class ControllableSystemOut implements IControllable<TypeAction> {
        public ControllableSystemOut() {
        }

        @Override
        public void invoke(TypeAction a) {
            System.out.println(a.getData());
        }

        @Override
        public void release(TypeAction a) {
        }
    }
}
