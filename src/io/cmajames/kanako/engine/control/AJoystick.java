/** 
 * Base class for Joystick objects
 * 
 * @author CJ <cmajames@sdf.org>
 * @since 2016-02-08
 */

package io.cmajames.kanako.engine.control;

import io.cmajames.kanako.engine.model.IAction;
import io.cmajames.kanako.engine.model.IControllable;

import java.util.Map;

public abstract class AJoystick<S, T extends IAction> extends AController<S, T>
    implements IUSBDevice {
    public AJoystick(Map<S, T> map, IControllable c) {
        super(map, c);
    }
}

