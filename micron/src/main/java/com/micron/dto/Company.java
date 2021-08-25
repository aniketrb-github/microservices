
package com.micron.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "catchPhrase",
    "bs"
})
@Generated("jsonschema2pojo")
public class Company implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("catchPhrase")
    private String catchPhrase;
    @JsonProperty("bs")
    private String bs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3085450116210809047L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Company() {
    }

    /**
     * 
     * @param bs
     * @param catchPhrase
     * @param name
     */
    public Company(String name, String catchPhrase, String bs) {
        super();
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("catchPhrase")
    public String getCatchPhrase() {
        return catchPhrase;
    }

    @JsonProperty("catchPhrase")
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    @JsonProperty("bs")
    public String getBs() {
        return bs;
    }

    @JsonProperty("bs")
    public void setBs(String bs) {
        this.bs = bs;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Company.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("catchPhrase");
        sb.append('=');
        sb.append(((this.catchPhrase == null)?"<null>":this.catchPhrase));
        sb.append(',');
        sb.append("bs");
        sb.append('=');
        sb.append(((this.bs == null)?"<null>":this.bs));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.bs == null)? 0 :this.bs.hashCode()));
        result = ((result* 31)+((this.catchPhrase == null)? 0 :this.catchPhrase.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Company) == false) {
            return false;
        }
        Company rhs = ((Company) other);
        return (((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.bs == rhs.bs)||((this.bs!= null)&&this.bs.equals(rhs.bs))))&&((this.catchPhrase == rhs.catchPhrase)||((this.catchPhrase!= null)&&this.catchPhrase.equals(rhs.catchPhrase))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
