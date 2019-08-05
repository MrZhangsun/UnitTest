package site.zhangsun.unit.basemock.service;
import site.zhangsun.unit.basemock.pojo.TerminalEntity;

import java.util.List;

/**
 * Functions: Terminal Status Information Service Implement
 *
 * @author Murphy Zhang Sun
 * @date 2019-06-03 16:22
 * @since v4.0
 */
public interface TerminalService {

    /**
     * find terminal by serial number
     *
     * NOTE: no matter the terminal bind vehicle or not
     *
     * @param serialNum serial number
     * @return terminal
     */
    TerminalEntity findBySerialNum(String serialNum);

    /**
     * find terminal by serial number
     *
     * NOTE: the terminal has bind a certain vehicle
     *
     * @param serialNum serial number
     * @return terminal
     */
    TerminalEntity findBindBySerialNum(String serialNum);

    /**
     * find all
     *
     * @return all terminal entity
     */
    List<TerminalEntity> findAll();
}
