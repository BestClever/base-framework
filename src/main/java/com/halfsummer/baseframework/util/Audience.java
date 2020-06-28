package com.halfsummer.baseframework.util;

/**
 * @author BestClever
 * @title: Audience
 * @projectName kaoqin
 * @description: TODO
 * @date 2020-05-29 19:14
 */
public class Audience {
    private static Audience audience = null;

    private Audience() {
    }

    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBase64Secret() {
        return base64Secret;
    }

    public void setBase64Secret(String base64Secret) {
        this.base64Secret = base64Secret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(int expiresSecond) {
        this.expiresSecond = expiresSecond;
    }

    public static Audience getAudience() {
        if (audience == null) {
            audience = new Audience();
            audience.setClientId("098f6bcd4621d373cade4e832627b4f6");
            audience.setExpiresSecond(86400000);
            audience.setBase64Secret("MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY");
            audience.setName("restapiuser");
        }
        return audience;
    }
}
