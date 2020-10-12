package cn.songo.strategydemo.context;

import java.io.Serializable;

/**
 * @Author SonGo
 * @Create 2020/10/12 20:56
 * @Description
 */
public class AnimalRequest implements Serializable {
    private static final long serialVersionUID = 3784925575397162170L;

    //@EnumV
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AnimalRequest{" +
                "code='" + code + '\'' +
                '}';
    }
}
