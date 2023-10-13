package io.hashnut.model.response;

import io.hashnut.model.CoinInfo;

import java.util.List;

public class QueryCoinsResponse extends PageResponse {
    private List<CoinInfo> data;
    public List<CoinInfo> getData(){
        return data;
    }
}
