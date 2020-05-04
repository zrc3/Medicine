package bs.gsau.ssm.mapper;

import bs.gsau.ssm.pojo.BCategory;
import bs.gsau.ssm.pojo.BCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BCategoryMapper {
    long countByExample(BCategoryExample example);

    int deleteByExample(BCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BCategory record);

    int insertSelective(BCategory record);

    List<BCategory> selectByExample(BCategoryExample example);

    BCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BCategory record, @Param("example") BCategoryExample example);

    int updateByExample(@Param("record") BCategory record, @Param("example") BCategoryExample example);

    int updateByPrimaryKeySelective(BCategory record);

    int updateByPrimaryKey(BCategory record);
}