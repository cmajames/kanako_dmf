/**
 * Base class for Keyboard objects
 * 
 * @author CJ <cmajames@sdf.org>
 * @since 2016-02-08
 */

package io.cmajames.kanako.engine.control;

import io.cmajames.kanako.engine.model.IAction;
import io.cmajames.kanako.engine.model.IControllable;

import java.util.Map;
import java.util.Set;

public abstract class AKeyboard<S, T extends IAction> extends AController<S, T> {
    public AKeyboard(Map<S, T> map, IControllable c) {
        super(map, c);
    }
}

