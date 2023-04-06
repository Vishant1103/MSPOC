package org.acme.mspoc.emp;

import javax.json.bind.annotation.JsonbProperty;

public class TId {
    private String tid;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "TId{" +
                "tid='" + tid + '\'' +
                '}';
    }
}
