package bs.gsau.ssm.mapper;

import bs.gsau.ssm.pojo.BOrder;
import bs.gsau.ssm.pojo.BOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BOrderMapper {
    long countByExample(BOrderExample example);

    int deleteByExample(BOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BOrder record);

    int insertSelective(BOrder record);

    List<BOrder> selectByExample(BOrderExample example);

    BOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BOrder record, @Param("example") BOrderExample example);

    int updateByExample(@Param("record") BOrder record, @Param("example") BOrderExample example);

    int updateByPrimaryKeySelective(BOrder record);

    int updateByPrimaryKey(BOrder record);
}