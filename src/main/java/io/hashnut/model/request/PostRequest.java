package io.hashnut.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class PostRequest<T> implements Request<T> {

    @Override
    @JsonIgnore
    public boolean needSign(){return false;}

    @Override
    @JsonIgnore
    public String getMethod() {
        return "POST";
    }

    @Override
    @JsonIgnore
    public String getPayload(ObjectMapper objectMapper) throws Exception {
        return objectMapper.writeValueAsString(this);
    }

    @Override
    @JsonIgnore
    public Class<T> getResponseClass(){
        Type superClass = getClass().getGenericSuperclass();

        if (superClass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) superClass;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();

            if (typeArguments.length > 0) {
                Type typeArgument = typeArguments[0];

                if (typeArgument instanceof Class) {
                    @SuppressWarnings("unchecked")
                    Class<T> type = (Class<T>) typeArgument;
                    return type;
                }
            }
        }
        return null;
    }
}
