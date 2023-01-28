package com.example.microsoftrewards.service.impl;

import com.example.microsoftrewards.entity.MicrosoftAccount;
import com.example.microsoftrewards.mapper.MicrosoftAccountMapper;
import com.example.microsoftrewards.service.IMicrosoftAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yulingkai
 * @since 2023-01-22
 */
@Service("microsoftAccountServiceImpl")
public class MicrosoftAccountServiceImpl extends ServiceImpl<MicrosoftAccountMapper, MicrosoftAccount> implements IMicrosoftAccountService {

}
