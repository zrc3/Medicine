package bs.gsau.ssm.mapper;

import bs.gsau.ssm.pojo.BMedicine;
import bs.gsau.ssm.pojo.BMedicineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BMedicineMapper {
    long countByExample(BMedicineExample example);

    int deleteByExample(BMedicineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BMedicine record);

    int insertSelective(BMedicine record);

    List<BMedicine> selectByExample(BMedicineExample example);

    BMedicine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BMedicine record, @Param("example") BMedicineExample example);

    int updateByExample(@Param("record") BMedicine record, @Param("example") BMedicineExample example);

    int updateByPrimaryKeySelective(BMedicine record);

    int updateByPrimaryKey(BMedicine record);
}