package com.startdis.common.web.service.soap.mdm8021;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author wws
 * Create by wws 2022-06-21 11:01
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "I_LFM1", namespace = "http://www.lgchem.com/PI/GMDM")
public class I_LFM1 {

    @XmlElement(name = "EKORG")
    private String EKORG;

    @XmlElement(name = "LFABC")
    private String LFABC;

    @XmlElement(name = "WAERS")
    private String WAERS;

    @XmlElement(name = "VERKF")
    private String VERKF;

    @XmlElement(name = "TELF1")
    private String TELF1;

    @XmlElement(name = "MINBW")
    private String MINBW;

    @XmlElement(name = "ZTERM")
    private String ZTERM;

    @XmlElement(name = "INCO1")
    private String INCO1;

    @XmlElement(name = "INCO2")
    private String INCO2;

    @XmlElement(name = "WEBRE")
    private String WEBRE;

    @XmlElement(name = "KZABS")
    private String KZABS;

    @XmlElement(name = "KALSK")
    private String KALSK;

    @XmlElement(name = "KZAUT")
    private String KZAUT;

    @XmlElement(name = "MEPRF")
    private String MEPRF;

    @XmlElement(name = "EKGRP")
    private String EKGRP;

    @XmlElement(name = "XERSY")
    private String XERSY;

    @XmlElement(name = "PLIFZ")
    private String PLIFZ;

    @XmlElement(name = "BSTAE")
    private String BSTAE;

    @XmlElement(name = "XERSR")
    private String XERSR;

    @XmlElement(name = "EIKTO")
    private String EIKTO;

    @XmlElement(name = "LEBRE")
    private String LEBRE;
}
