package bs.gsau.ssm.mapper;

import bs.gsau.ssm.pojo.BSell;
import bs.gsau.ssm.pojo.BSellExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BSellMapper {
    long countByExample(BSellExample example);

    int deleteByExample(BSellExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BSell record);

    int insertSelective(BSell record);

    List<BSell> selectByExample(BSellExample example);

    BSell selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BSell record, @Param("example") BSellExample example);

    int updateByExample(@Param("record") BSell record, @Param("example") BSellExample example);

    int updateByPrimaryKeySelective(BSell record);

    int updateByPrimaryKey(BSell record);
}