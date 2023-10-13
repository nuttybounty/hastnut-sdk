package io.hashnut.model.response;

import io.hashnut.model.FiatExchangeRate;

public class QueryFiatRateResponse {
    private FiatExchangeRate data;
    public FiatExchangeRate getData(){
        return data;
    }
}
