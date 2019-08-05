package site.zhangsun.unit.basemock.service.impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.zhangsun.unit.basemock.mapper.TerminalEntityMapper;
import site.zhangsun.unit.basemock.pojo.TerminalEntity;
import site.zhangsun.unit.basemock.pojo.TerminalEntityExample;
import site.zhangsun.unit.basemock.service.TerminalService;

import java.util.List;

/**
 * Functions: Terminal Status Information Service Implement
 *
 * @author Murphy Zhang Sun
 * @date 2019-06-03 16:22
 * @since v4.0
 */
@Slf4j
@Service
public class TerminalServiceImpl implements TerminalService {

    private final TerminalEntityMapper terminalEntityMapper;


    @Autowired
    public TerminalServiceImpl(TerminalEntityMapper terminalEntityMapper) {
        this.terminalEntityMapper = terminalEntityMapper;
    }

    /**
     * find terminal by serial number
     * <p>
     * NOTE: no matter the terminal bind vehicle or not
     *
     * @param serialNum serial number
     * @return terminal
     */
    @Override
    public TerminalEntity findBySerialNum(String serialNum) {
        TerminalEntityExample example = new TerminalEntityExample();
        example.createCriteria()
                .andSerialNumEqualTo(serialNum)
                .andIsDeletedEqualTo("0")
                .andIsDisabledEqualTo("0");
        List<TerminalEntity> entities = terminalEntityMapper.selectByExample(example);
        if (entities.isEmpty()) {
            return null;
        }
        return entities.get(0);
    }

    /**
     * find terminal by serial number
     * <p>
     * NOTE: the terminal has bind a certain vehicle
     *
     * @param serialNum serial number
     * @return terminal
     */
    @Override
    public TerminalEntity findBindBySerialNum(String serialNum) {
        TerminalEntityExample example = new TerminalEntityExample();
        example.createCriteria().andVehicleIdIsNotNull()
                .andSerialNumEqualTo(serialNum)
                .andIsDeletedEqualTo("0")
                .andIsDisabledEqualTo("0");
        List<TerminalEntity> entities = terminalEntityMapper.selectByExample(example);
        if (entities.isEmpty()) {
            return null;
        }
        return entities.get(0);
    }

    /**
     * find all
     *
     * @return all terminal entity
     */
    @Override
    public List<TerminalEntity> findAll() {
        TerminalEntityExample example = new TerminalEntityExample();
        example.createCriteria()
                .andIsDeletedEqualTo("0")
                .andIsDisabledEqualTo("0");
        return terminalEntityMapper.selectByExample(example);
    }
}
