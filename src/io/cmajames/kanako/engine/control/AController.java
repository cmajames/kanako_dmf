/**
 * Base interface for controller objects
 * 
 * @author CJ <cmajames@sdf.org> 
 * @since 2016-02-08
 */ 

package io.cmajames.kanako.engine.control;

import io.cmajames.kanako.engine.model.IAction;
import io.cmajames.kanako.engine.model.IControllable;

import java.util.Map;

public abstract class AController<S, T extends IAction> {
    private Map<S, T> mMapping;
    private IControllable<T> mControllable;

    public AController(Map<S, T> s, IControllable<T> c) {
        setMapping(s);
        this.mControllable = c;
    }

    public void setMapping(Map<S, T> s) {
        if (s == null) {
            throw new IllegalArgumentException("Requires Definite Mapping",
                    new NullPointerException());
        }
        this.mMapping = s;
    }

    public void press(S c) {
        if (this.mMapping.containsKey(c)) {
            this.mControllable.invoke(this.mMapping.get(c));
        }
    }

    public void release(S c) {
        if (this.mMapping.containsKey(c)) {
            this.mControllable.release(this.mMapping.get(c));
        }
    }

    public Map<S, T> getMapping() {
        return this.mMapping;
    }
}

