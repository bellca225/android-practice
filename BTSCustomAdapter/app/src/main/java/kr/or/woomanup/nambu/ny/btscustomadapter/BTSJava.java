package kr.or.woomanup.nambu.ny.btscustomadapter;

import java.io.Serializable;

public class BTSJava implements Serializable { // implement Serialize 해주기

    String nick;
    String name;
    int image;

    public BTSJava(String nick, String name, int image) {
        this.nick = nick;
        this.name = name;
        this.image = image;
    }

}
