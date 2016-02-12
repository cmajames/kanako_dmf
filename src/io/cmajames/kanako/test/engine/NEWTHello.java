/**
 * @author CJ <cmajames@sdf.org>
 * @added 2016-02-10
 */

package io.cmajames.kanako.test.engine;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import io.cmajames.kanako.engine.control.NEWTKeyboard;
import io.cmajames.kanako.engine.model.IAction;
import io.cmajames.kanako.engine.model.IControllable;
import io.cmajames.kanako.engine.view.BlankGLRenderer;
import io.cmajames.kanako.engine.view.NEWTWindowManager;

import java.util.HashMap;
import java.util.Map;

public class NEWTHello {
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
        public ControllableSystemOut() { }

        @Override
        public void invoke(TypeAction a) {
            System.out.println(a.getData());
        }

        @Override
        public void release(TypeAction a) {  }
    }

    public static void main(String... args) {
        Map<Short, TypeAction> actionMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            actionMap.put(NEWTKeyboard.getShortForChar(c), new TypeAction(c));
        }

        NEWTWindowManager wm = new NEWTWindowManager(new BlankGLRenderer(),
                "NEWTHello");
        IControllable c = new ControllableSystemOut();
        NEWTKeyboard<TypeAction> kbd = new NEWTKeyboard<>(wm, actionMap, c);

        wm.attach(new WindowAdapter() {
            @Override
            public void windowDestroyNotify(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        wm.run();
    }
}
