package com.startdis.common.rfc.config;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-06-16 14:28
 * @desc IMultiStepJob JCO线程操作
 */
public interface IMultiStepJob {
    public boolean runNextStep();

    String getName();

    public void cleanUp();
}

