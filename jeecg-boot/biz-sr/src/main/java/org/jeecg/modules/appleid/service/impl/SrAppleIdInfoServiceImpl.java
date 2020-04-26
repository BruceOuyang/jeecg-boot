package org.jeecg.modules.appleid.service.impl;

import org.jeecg.modules.appleid.entity.SrAppleIdInfo;
import org.jeecg.modules.appleid.mapper.SrAppleIdInfoMapper;
import org.jeecg.modules.appleid.service.ISrAppleIdInfoService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: Apple Id 管理
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Service
@DS("sr_boot")
public class SrAppleIdInfoServiceImpl extends ServiceImpl<SrAppleIdInfoMapper, SrAppleIdInfo> implements ISrAppleIdInfoService {

}
