package com.startdis.comm.jdbc.handler;

import com.startdis.comm.jdbc.config.FieldFillConfig;
import com.startdis.comm.jdbc.enums.FieldFillStrategyEnum;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.TimestampValue;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 创建时间字段填充拦截器
 */
public class CreatedAtHandler extends AbstractFieldFillHandler {

    public CreatedAtHandler(FieldFillConfig fieldFillConfig) {
        super(FieldFillStrategyEnum.INSERT, fieldFillConfig.getUpdateAtIntercept());
    }


    @Override
    protected Expression doGetFieldFillValue() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        return new TimestampValue(date);
    }

    @Override
    protected String getDefaultColumn() {
        return "created_at";
    }

}
