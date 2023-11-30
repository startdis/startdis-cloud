package com.startdis.comm.jdbc.handler;

import com.startdis.comm.jdbc.config.FieldFillConfig;
import com.startdis.comm.jdbc.enums.FieldFillStrategyEnum;
import com.startdis.comm.util.auth.AuthInfo;
import com.startdis.comm.util.auth.AuthInfoUtils;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;

import java.util.Optional;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 更新人字段填充拦截器
 */
public class UpdatedByHandler extends AbstractFieldFillHandler {

    public UpdatedByHandler(FieldFillConfig fieldFillConfig) {
        super(FieldFillStrategyEnum.INSERT_UPDATE, fieldFillConfig.getUpdateByIntercept());
    }


    @Override
    protected Expression doGetFieldFillValue() {
        AuthInfo authInfo = AuthInfoUtils.getAuthInfo();
        String uniqueId =  Optional.ofNullable(authInfo)
            .map(AuthInfo::getUniqueId).orElse("系统创建");
        return new StringValue(uniqueId);
    }

    @Override
    protected String getDefaultColumn() {
        return "updated_by";
    }

}
