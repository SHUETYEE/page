package cn.itcast.service;

import cn.itcast.model.Inve;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijingyu
 * @date 2019/9/14 14:05
 */
@Service
public interface InveService {
    List<Inve> findAll();
}
