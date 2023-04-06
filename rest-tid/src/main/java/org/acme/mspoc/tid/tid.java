package org.acme.mspoc.tid;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;

@Schema(description = "TId schema")
public class tid {

    @JsonbProperty("tid")
    @Schema(required = true)
    private String tid;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "tid{" +
                "tid='" + tid + '\'' +
                '}';
    }
}
