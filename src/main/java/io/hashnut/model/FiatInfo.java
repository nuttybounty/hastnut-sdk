package io.hashnut.model;

import java.io.Serializable;
import java.util.Date;

public class FiatInfo {
    private String fiatCode;
    private String description;
    private Boolean enabled;
    private Date createTime;
    private Date updateTime;

    public FiatInfo() {}

    public String getFiatCode() {
        return fiatCode;
    }

    public void setFiatCode(String fiatCode) {
        this.fiatCode = fiatCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
