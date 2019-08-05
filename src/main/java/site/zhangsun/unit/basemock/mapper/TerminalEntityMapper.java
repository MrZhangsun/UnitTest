package site.zhangsun.unit.basemock.mapper;

import org.apache.ibatis.annotations.Param;
import site.zhangsun.unit.basemock.pojo.TerminalEntity;
import site.zhangsun.unit.basemock.pojo.TerminalEntityExample;
import site.zhangsun.unit.basemock.pojo.TerminalEntityKey;

import java.util.List;

public interface TerminalEntityMapper {
    int countByExample(TerminalEntityExample example);

    int deleteByExample(TerminalEntityExample example);

    int deleteByPrimaryKey(TerminalEntityKey key);

    int insert(TerminalEntity record);

    int insertSelective(TerminalEntity record);

    List<TerminalEntity> selectByExample(TerminalEntityExample example);

    TerminalEntity selectByPrimaryKey(TerminalEntityKey key);

    int updateByExampleSelective(@Param("record") TerminalEntity record, @Param("example") TerminalEntityExample example);

    int updateByExample(@Param("record") TerminalEntity record, @Param("example") TerminalEntityExample example);

    int updateByPrimaryKeySelective(TerminalEntity record);

    int updateByPrimaryKey(TerminalEntity record);
}
