package p06_TirePressureMonitoringSystem;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {

    @Test
    public void test_check_When_Pressure_Is_Normal_AlarmOn_Should_Return_False(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19.00);

        Alarm alarm = new Alarm(sensor);
        alarm.check();

        boolean alarmIsOn = alarm.getAlarmOn();
        assertFalse(alarmIsOn);
    }

    @Test
    public void test_check_When_Pressure_Is_HigherThan_HighTHRESHOLD_AlarmOn_Should_Return_True(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(27.00);

        Alarm alarm = new Alarm(sensor);
        alarm.check();

        boolean alarmIsOn = alarm.getAlarmOn();
        assertTrue(alarmIsOn);
    }

    @Test
    public void test_check_When_Pressure_Is_LowerThan_LowTHRESHOLD_AlarmOn_Should_Return_True(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(5.00);

        Alarm alarm = new Alarm(sensor);
        alarm.check();

        boolean alarmIsOn = alarm.getAlarmOn();
        assertTrue(alarmIsOn);
    }

}