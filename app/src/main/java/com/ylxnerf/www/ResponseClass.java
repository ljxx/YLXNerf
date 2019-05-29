package com.ylxnerf.www;

/**
 * ========================================
 * <p>
 * 版 权：赵涌优选
 * <p>
 * 作 者：杨理想
 * <p>
 * 创建日期：2019-05-28  22:35
 * <p>
 * 描 述：
 * <p>
 * ========================================
 */
public class ResponseClass {

    private Integer resultCode;
    private String reason;

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResponseClass(Integer resultCode, String reason) {
        this.resultCode = resultCode;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ResponseClass{" +
                "resultCode=" + resultCode +
                ", reason='" + reason + '\'' +
                '}';
    }
}
