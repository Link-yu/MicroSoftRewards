package com.example.microsoftrewards.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yulingkai
 * @since 2023-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MicrosoftAccountRewards implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账户id
     */
    private Integer accountId;

    /**
     * 累计积分
     */
    private Integer totalScore;

    /**
     * 更新状态
     */
    private Integer status;

    /**
     * 每日新增积分
     */
    private Integer dayScore;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
