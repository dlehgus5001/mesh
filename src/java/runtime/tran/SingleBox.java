/**
 * ADOBE SYSTEMS INCORPORATED
 * Copyright 2009-2013 Adobe Systems Incorporated
 * All Rights Reserved.
 *
 * NOTICE: Adobe permits you to use, modify, and distribute
 * this file in accordance with the terms of the MIT license,
 * a copy of which can be found in the LICENSE.txt file or at
 * http://opensource.org/licenses/MIT.
 */
package runtime.tran;

import runtime.rep.Tuple;

import java.util.Map;

/**
 * A singleton implementation of the Boxes class.
 *
 * @author Keith McGuigan
 */
public class SingleBox extends Boxes
{
    private Box box;

    public SingleBox(final Box box)
    {
        super();
        this.box = box;
    }

    public Box get(final int index)
    {
        assert index == 0 : "Invalid index for Boxes.get()";
        return box;
    }

    public int size()
    {
        return 1;
    }

    public Object getValues()
    {
        return box.getValue();
    }

    public Tuple applyUpdates(
        final Object currentValue, final Map<Box,Object> updates)
    {
        final Object newValue = updates.get(box);
        assert newValue != null : "Can't update a box with no value";
        return Tuple.from(currentValue, newValue);
    }
}
