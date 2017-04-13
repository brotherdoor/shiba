package shop.domain;


/**
 * PaymentMethod
 * 
 * @since 2016. 9. 28.
 * @author 吏꾧텒湲� (kwonkijin@nextree.co.kr)
 */
public enum PaymentMethod {

    CARD("C", "신용카드")
    ,RT("R", "실시간이체");
    
    private String code;
    private String name;
    
    private PaymentMethod(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    
    public static PaymentMethod findBy(String code) {
        //
        for (PaymentMethod value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
