package org.androidtransfuse.integrationTest.aop;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.androidtransfuse.integrationTest.DelegateUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.*;

/**
 * @author John Ericksen
 */
@RunWith(RobolectricTestRunner.class)
public class AOPTest {

    private AOP aop;

    @Before
    public void setup() throws IllegalAccessException {
        InterceptorRecorder.reset();
        AOPActivity aopActivity = new AOPActivity();
        aopActivity.onCreate(null);

        aop = DelegateUtil.getDelegate(aopActivity, AOP.class);
    }

    @Test
    public void testNoReturnInterception() {
        assertFalse(InterceptorRecorder.isCalled());
        assertNull(InterceptorRecorder.getRetValue());
        aop.interceptMe();
        assertTrue(InterceptorRecorder.isCalled());
        assertNull(InterceptorRecorder.getRetValue());
    }

    @Test
    public void testReturnInterception() {
        assertFalse(InterceptorRecorder.isCalled());
        assertNull(InterceptorRecorder.getRetValue());
        aop.interceptMeWithReturn();
        assertTrue(InterceptorRecorder.isCalled());
        assertEquals(AOP.INTERCEPT_VALUE, InterceptorRecorder.getRetValue());
    }
}