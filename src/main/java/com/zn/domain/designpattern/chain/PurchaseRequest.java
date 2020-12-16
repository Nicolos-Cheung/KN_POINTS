package com.zn.domain.designpattern.chain;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/10/15
 */
public class PurchaseRequest {

    private Double price;

    public PurchaseRequest(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
