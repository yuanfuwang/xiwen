package com.xiwen_common.util.service;

import java.io.Serializable;
import java.util.List;
import com.xiwen_common.util.model.TokenModel;


/**
 * 对token进行操作的管理接口
 * 
 * @author shenjian
 */
public interface TokenService {

    /**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     */
    public TokenModel createToken(String userId, String userType) throws Exception;

    /**
     * 获取token模型对象
     * @param token
     * @return 是否有效
     */
    public TokenModel getTokenModel(String token);
    
    /**
     * 根据用户编号查询token模型
     * @param userId 用户编号
     * @return
     */
    public TokenModel getTokenModelByUserId(String userId);
    
    /**
     * 检查token是否有效
     * @param tokenModel 
     * @return 是否有效
     */
    public boolean checkToken(TokenModel tokenModel);

    /**
     * 清除token
     * @param token
     */
    public void clearToken(String token);
    
    /**
     * 清除token
     * @param tokenModel token模型对象
     */
    public void clearToken(TokenModel tokenModel);
}