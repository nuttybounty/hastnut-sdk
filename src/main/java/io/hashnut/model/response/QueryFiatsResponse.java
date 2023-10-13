package io.hashnut.model.response;

import io.hashnut.model.FiatInfo;

import java.util.List;

public class QueryFiatsResponse {
    private List<FiatInfo> data;

    public List<FiatInfo> getData(){
        return data;
    }
}
