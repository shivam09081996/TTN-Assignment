package com.TTN.AmazonWebsite.EnumOrderStatus;

public enum ToStatus {
    CLOSED,
    CANCELLED,
    ORDER_SHIPPED,
    DELIVERED,
    RETURN_REQUESTED,

    RETURN_REJECTED,
    RETURN_APPROVED,

    PICK_UP_INITIATED,
    PICK_UP_COMPLETED,
    REFUND_INITIATED,
    REFUND_COMPLETED
}
