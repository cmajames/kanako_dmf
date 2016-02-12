/**
 * Base class for controllable objects
 *
 * @author CJ <cmajames@sdf.org>
 * @since 2016-02-09
 */

package io.cmajames.kanako.engine.model;

public interface IControllable<T extends IAction> {
    void invoke(T a);
    void release(T a);
}

