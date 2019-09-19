package cn.itcast.mapper;

import cn.itcast.model.Inve;
import cn.itcast.model.InveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InveMapper {
    long countByExample(InveExample example);

    int deleteByExample(InveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Inve record);

    int insertSelective(Inve record);

    List<Inve> selectByExample(InveExample example);

    Inve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Inve record, @Param("example") InveExample example);

    int updateByExample(@Param("record") Inve record, @Param("example") InveExample example);

    int updateByPrimaryKeySelective(Inve record);

    int updateByPrimaryKey(Inve record);

    List<Inve> findAll();
}