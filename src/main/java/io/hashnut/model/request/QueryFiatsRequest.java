package io.hashnut.model.request;

import io.hashnut.model.response.QueryFiatsResponse;

public class QueryFiatsRequest extends GetRequest<QueryFiatsResponse>{

    public QueryFiatsRequest(Builder builder){}

    @Override
    public String getUri() {
        return "/mch/querySupportLegalTenders";
    }

    @Override
    public Class<QueryFiatsResponse> getResponseClass() {
        return QueryFiatsResponse.class;
    }

    public static class Builder{
        public Builder(){}
        public QueryFiatsRequest build(){
            return new QueryFiatsRequest(this);
        }
    }
}
