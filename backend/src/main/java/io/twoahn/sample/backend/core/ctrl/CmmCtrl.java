package io.twoahn.sample.backend.core.ctrl;

import java.util.Objects;
import java.util.function.BiFunction;

/**
 * Created by rockoil@gmail.com on 23. 4. 5.
 * Blog : http://ioioi.dev
 * Github : http://github.com/ioioi-dev
 */
public class CmmCtrl {

    protected BiFunction<Object, Object, ?> isNil = (obj, init) -> Objects.isNull(obj) ? init : obj;
}
