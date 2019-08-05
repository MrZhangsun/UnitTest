package site.zhangsun.unit.basemock.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import site.zhangsun.unit.ApplicationTest;
import site.zhangsun.unit.basemock.pojo.TerminalEntity;
import site.zhangsun.unit.basemock.service.TerminalService;
import java.util.ArrayList;
import java.util.List;

/**
 * 单元测试的目的是为了测试本方法内部的业务逻辑，而不必考虑外部依赖的因素，因此，涉及到外部依赖的地方需要通过MOCK的方式进行模拟。
 * 这样做的好处有：
 *
 * 1. 单元测试的运行不会产生真正的业务数据，不会对真是的业务进行污染；
 * 2. 经过测试，对代码的业务逻辑进行检验，通过断言的方式可以判断预期的结果，一旦代码被别人修改，发生业务逻辑错误时，可以及时发现问题；
 * 3. 单元测试可以有效的理解业务，在TDD开发模式中，单元测试相当于业务文档，具有较强的业务约束力
 */
public class TerminalControllerTest extends ApplicationTest {

    /**
     * 该注解的作用是创建一个待测试类实例，如果该类在实例化的过程中需要依赖到外部的资源，则会从@Mock注解的对象中去加载
     */
    @InjectMocks
    private TerminalController terminalController;

    /**
     * Mock一个假的数据资源，用于后期的模拟操作
     */
    @Mock
    private TerminalService terminalService;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private String serial;

    @Before
    public void setup() {
        serial = "810000000000";
    }

    @Test
    public void findBindTerminalBySerial() {
        TerminalEntity entity = new TerminalEntity();
        Mockito.when(terminalService.findBindBySerialNum(Mockito.anyString())).thenReturn(entity);
        TerminalEntity terminal = terminalController.findBindTerminalBySerial(serial);
        Assert.assertEquals(entity, terminal);
    }

    @Test
    public void findTerminalBySerial() {
        TerminalEntity entity = new TerminalEntity();
        Mockito.when(terminalService.findBySerialNum(serial)).thenReturn(entity);
        TerminalEntity terminal = terminalController.findTerminalBySerial(serial);
        Assert.assertEquals(entity, terminal);
    }

    @Test
    public void findTerminalBySerialError() {
        TerminalEntity entity = new TerminalEntity();
        Mockito.when(terminalService.findBySerialNum(serial)).thenReturn(entity);

        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("终端序列号不要给我空值嘛！");
        terminalController.findTerminalBySerial("");
    }

    @Test
    public void findAll() {
        List<TerminalEntity> entities = new ArrayList<>(3);
        entities.add(new TerminalEntity());
        entities.add(new TerminalEntity());
        entities.add(new TerminalEntity());
        Mockito.when(terminalService.findAll()).thenReturn(entities);
        List<TerminalEntity> all = terminalController.findAll();
        Assert.assertEquals(all.size(), 3);
    }
}
