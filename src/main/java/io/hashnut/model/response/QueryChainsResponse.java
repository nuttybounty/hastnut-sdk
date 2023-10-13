package io.hashnut.model.response;

import java.util.List;
import io.hashnut.model.ChainInfo;

public class QueryChainsResponse {
    private List<ChainInfo> data;
    public List<ChainInfo> getData(){
        return data;
    }
}
