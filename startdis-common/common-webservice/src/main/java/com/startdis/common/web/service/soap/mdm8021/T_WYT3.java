package com.startdis.common.web.service.soap.mdm8021;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author wws
 * Create by wws 2022-06-21 11:03
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "T_WYT3", namespace = "http://www.lgchem.com/PI/GMDM")
public class T_WYT3 {
    @XmlElement(name = "PARVW")
    private String PARVW;

    @XmlElement(name = "PARTNER")
    private String PARTNER;

    @XmlElement(name = "DEL_FLAG")
    private String DEL_FLAG;

    public String getPARVW() {
        return PARVW;
    }

    public void setPARVW(String PARVW) {
        this.PARVW = PARVW;
    }

    public String getPARTNER() {
        return PARTNER;
    }

    public void setPARTNER(String PARTNER) {
        this.PARTNER = PARTNER;
    }

    public String getDEL_FLAG() {
        return DEL_FLAG;
    }

    public void setDEL_FLAG(String DEL_FLAG) {
        this.DEL_FLAG = DEL_FLAG;
    }
}
