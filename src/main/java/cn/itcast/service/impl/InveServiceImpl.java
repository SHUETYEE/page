package cn.itcast.service.impl;

import cn.itcast.mapper.InveMapper;
import cn.itcast.model.Inve;
import cn.itcast.service.InveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijingyu
 * @date 2019/9/14 14:05
 */
@Service
public class InveServiceImpl implements InveService {
    @Autowired
    private InveMapper inveMapper;
    @Override
    public List<Inve> findAll() {
        return inveMapper.findAll();
    }
}
