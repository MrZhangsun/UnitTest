package site.zhangsun.unit.basemock.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.zhangsun.unit.basemock.pojo.TerminalEntity;
import site.zhangsun.unit.basemock.service.TerminalService;

import java.util.List;

/**
 * Functions: Terminal Management Controller
 *
 * @author Murphy Zhang Sun
 * @date 2019-06-03 16:19
 * @since v4.0
 */
@Slf4j
@RestController
public class TerminalController {

    private final TerminalService terminalService;

    @Autowired
    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @GetMapping("/find/bind/serial")
    public TerminalEntity findBindTerminalBySerial(String serial) {
        if (StringUtils.isBlank(serial)) {
            throw new IllegalArgumentException("终端序列号不要给我空值嘛！");
        }
        return terminalService.findBindBySerialNum(serial);
    }

    @GetMapping("/find/serial")
    public TerminalEntity findTerminalBySerial(String serial) {
        if (StringUtils.isBlank(serial)) {
            throw new IllegalArgumentException("终端序列号不要给我空值嘛！");
        }
        return terminalService.findBySerialNum(serial);
    }

    @GetMapping("/find/all")
    public List<TerminalEntity> findAll() {
        return terminalService.findAll();
    }
}
