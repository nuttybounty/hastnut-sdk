package io.hashnut.model;

import java.util.Date;

public class FiatInfo {
    private String currency;
    private String description;
    private Boolean enabled;
    private Date createTime;
    private Date updateTime;
    private static final long serialVersionUID = 1L;

    public FiatInfo() {

    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", currency=").append(this.currency);
        sb.append(", description=").append(this.description);
        sb.append(", enabled=").append(this.enabled);
        sb.append(", createTime=").append(this.createTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append("]");
        return sb.toString();
    }
}
