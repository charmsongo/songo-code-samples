package cn.songo.strategydemo.context;

/**
 * @Author SonGo
 * @Create 2020/10/12 11:05
 * @Description
 */
public enum AnimalEnum {

    CAT("01", "cat","猫"),
    DOG("02", "dog","狗");

    private String code;
    private String shortCode;
    private String msg;

    AnimalEnum(String code, String shortCode, String msg) {
        this.code = code;
        this.shortCode = shortCode;
        this.msg = msg;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "AnimalEnum{" +
                "code='" + code + '\'' +
                ", shortCode='" + shortCode + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public static boolean isValid(String code) {
        for (AnimalEnum value : AnimalEnum.values()) {
            if (value.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
}
