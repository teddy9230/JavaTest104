package com.code.java104;

import javax.persistence.*;

@Entity
@Table(name = "Table1")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column(name = "c_aes256")
    private String cAes256;

    @Column(name = "c_base64", nullable = false)
    private String cBase64;

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getcAes256() {
        return cAes256;
    }

    public void setcAes256(String cAes256) {
        this.cAes256 = cAes256;
    }

    public String getcBase64() {
        return cBase64;
    }

    public void setcBase64(String cBase64) {
        this.cBase64 = cBase64;
    }

    @Override
    public String toString() {
        return "Data{" +
                "idx=" + idx +
                ", cAes256='" + cAes256 + '\'' +
                ", cBase64='" + cBase64 + '\'' +
                '}';
    }
}
