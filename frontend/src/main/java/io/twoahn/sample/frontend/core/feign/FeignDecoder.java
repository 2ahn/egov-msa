package io.twoahn.sample.frontend.core.feign;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.gson.GsonDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by rockoil@gmail.com on 23. 4. 5.
 * Blog : http://ioioi.dev
 * Github : http://github.com/ioioi-dev
 */
public class FeignDecoder implements Decoder {

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        return new GsonDecoder().decode(response, type);
    }
}
